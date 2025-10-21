package learn.memories.data;

import learn.memories.models.Memory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
@ContextConfiguration(locations = {"classpath:dependency-configuration.xml"})
class MemoryJdbcRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    MemoryJdbcRepository repo;

    @Test
    void shouldFindAll() throws DataAccessException {
        List<Memory> memories = repo.findAll();
        for (Memory m : memories) {
            System.out.println(m + "\n");
        }
    }

}