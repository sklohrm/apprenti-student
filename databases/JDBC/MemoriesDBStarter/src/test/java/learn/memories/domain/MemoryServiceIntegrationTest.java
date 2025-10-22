package learn.memories.domain;

import learn.memories.data.DataAccessException;
import learn.memories.models.Memory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
@ContextConfiguration(locations = {"classpath:dependency-configuration.xml"})
public class MemoryServiceIntegrationTest {

    @Autowired
    MemoryService service;

    @Test
    void shouldFindall() throws DataAccessException {
        List<Memory> memories = service.findAllMemories();
        assertEquals(10, memories.size());
    }

    @Test
    void shouldFindShareable() throws DataAccessException {
        List<Memory> memories = service.findShareableMemories();
    }

    @Test
    void shouldUpdate() throws DataAccessException {
        Memory memory = service.findMemoryById(1);
        memory.setContent("Updated Content");
        MemoryResult result = service.update(memory);
        assertTrue(result.isSuccess());
    }

    @Test
    void shouldDeleteById() throws DataAccessException {
        assertTrue(service.deleteById(1).isSuccess());
    }
}
