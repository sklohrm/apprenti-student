package learn.memories.domain;

import learn.memories.data.DataAccessException;
import learn.memories.data.MemoryRepository;
import learn.memories.data.MemoryRepositoryDouble;
import learn.memories.models.Memory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryServiceTest {

    MemoryService service;
    MemoryRepository repository;

    @BeforeEach
    void setUp() {
        repository = new MemoryRepositoryDouble();
        service = new MemoryService(repository);
    }

    @Test
    void shouldFindTwoPublicMemories() throws DataAccessException {
        List<Memory> memories = service.findShareableMemories();
        assertEquals(2, memories.size());
    }

    @Test
    void shouldFindOnePrivateMemory() throws DataAccessException {
        List<Memory> memories = service.findPrivateMemories();
        assertEquals(1, memories.size());
    }

    @Test
    void addNotAddNullFrom() throws DataAccessException {
        Memory memory = new Memory();
        memory.setContent("Remember?");

        MemoryResult result = service.add(memory);
        assertFalse(result.isSuccess());
        assertEquals(1, result.getMessages().size());
        assertTrue(result.getMessages().getFirst().contains("From"));
    }

    @Test
    void shouldNotAddEmptyContent() throws DataAccessException {
        Memory memory = new Memory();
        memory.setFrom("Memory Man");

        MemoryResult result = service.add(memory);
        assertFalse(result.isSuccess());
        assertEquals(1, result.getMessages().size());
        assertTrue(result.getMessages().getFirst().contains("Content"));
    }

    @Test
    void shouldNotAddPositiveId() throws DataAccessException {
        Memory memory = new Memory(12, "From12", "Content12", true);

        MemoryResult result = service.add(memory);
        assertFalse(result.isSuccess());
        assertEquals(1, result.getMessages().size());
        assertTrue(result.getMessages().getFirst().contains("Memory ID"));
    }

    @Test
    void shouldAdd() throws DataAccessException {
        Memory memory = new Memory(0, "From", "Content", true);

        MemoryResult result = service.add(memory);
        assertTrue(result.isSuccess());
    }

    @Test
    void shouldNotUpdateEmpty() throws DataAccessException {
        Memory memory = new Memory(1, "From", null, true);

        MemoryResult result = service.update(memory);
        assertFalse(result.isSuccess());
        assertEquals(1, result.getMessages().size());
        assertTrue(result.getMessages().getFirst().contains("Content"));
    }

    @Test
    void shouldUpdate() throws DataAccessException {
        Memory memory = service.findShareableMemories().getFirst();
        memory.setContent("Updated Content");

        MemoryResult result = service.update(memory);
        assertTrue(result.isSuccess());
    }

}