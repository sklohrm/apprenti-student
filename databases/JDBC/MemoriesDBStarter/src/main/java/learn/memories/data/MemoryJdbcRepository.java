package learn.memories.data;

import learn.memories.data.mappers.MemoryMapper;
import learn.memories.models.Memory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class MemoryJdbcRepository implements MemoryRepository {

    private final JdbcTemplate jdbcTemplate;

    public MemoryJdbcRepository (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Memory> findAll() throws DataAccessException {
        final String sql = getSelectQuery() + ";";
        return jdbcTemplate.query(sql, new MemoryMapper());
    }

    @Override
    public Memory findById(int memoryId) throws DataAccessException {
        final String sql = getSelectQuery() + " WHERE memory.memory_id = ?;";
        try {
            return jdbcTemplate.queryForObject(sql, new MemoryMapper(), memoryId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Memory> findShareable(boolean shareable) throws DataAccessException {
        final String sql = getSelectQuery() + " WHERE memory.is_public = true;";

        return jdbcTemplate.query(sql, new MemoryMapper());
    }

    @Override
    public Memory add(Memory memory) throws DataAccessException {
        final String sql = "INSERT INTO `memories`.`memory`\n" +
                "(`user_id_created`,\n" +
                "`date_time_created`,\n" +
                "`memory_text,\n" +
                "`is_public`)\n" +
                "VALUES\n" +
                "(?, NOW(), ?, ?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, memory.getUserId());
            ps.setString(2, memory.getContent());
            ps.setBoolean(3, memory.isShareable());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        memory.setId(keyHolder.getKey().intValue());

        return memory;
    }

    @Override
    public boolean update(Memory memory) throws DataAccessException {
        final String sql = "UPDATE memory SET " +
                "memory_text = ?, " +
                "is_public = ?, " +
                "WHERE memory_id = ?;";

        int rowsAffected = jdbcTemplate.update(
                sql,
                memory.getContent(),
                memory.isShareable(),
                memory.getId()
        );

        return rowsAffected > 0;
    }

    @Override
    public boolean deleteById(int memoryId) throws DataAccessException {
        final String sql = "DELETE FROM memory WHERE memory_id = ?;";
        int rowsAffected = jdbcTemplate.update(sql, memoryId);
        return rowsAffected > 0;
    }

    // Private helper methods
    private String getSelectQuery() {
        return "SELECT " +
                "memory.memory_id, " +
                "user.user_name, " +
                "memory.date_time_created, " +
                "memory.memory_text, " +
                "memory.is_public " +
                "FROM memory " +
                "INNER JOIN user ON memory.user_id_created = user.user_id";
    }
}
