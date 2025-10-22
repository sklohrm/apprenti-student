package learn.memories.data.mappers;

import learn.memories.models.Memory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemoryMapper implements RowMapper<Memory> {

    @Override
    public Memory mapRow(ResultSet resultSet, int i) throws SQLException {
        Memory memory = new Memory();

        memory.setId(resultSet.getInt("memory_id"));
        memory.setFrom(resultSet.getString("user_name"));
        memory.setContent(resultSet.getString("memory_text"));
        memory.setShareable(resultSet.getBoolean("is_public"));

        return memory;
    }

}
