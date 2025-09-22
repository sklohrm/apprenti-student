package learn.memories.data;

import learn.memories.models.Memory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryFileRepositoryTest {
    static final String SEED_FILE_PATH = "data/memories-seed.txt";
    static final String TEST_FILE_PATH = "data/memories-test.txt";

    MemoryFileRepository repository;
    Memory mayaGreen;

    @BeforeEach
    void setUpTest() throws IOException {
        repository = new MemoryFileRepository(TEST_FILE_PATH);
        Path seedPath = Paths.get(SEED_FILE_PATH);
        Path testPath = Paths.get(TEST_FILE_PATH);
        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
        mayaGreen = new Memory(
                2,
                "Maya Green",
                "That road trip with you was unforgettable.",
                true
        );
    }

    @Test
    void testFindAllThrows() throws DataAccessException {
        repository = new MemoryFileRepository("FAILURE");
        List<Memory> result = repository.findAll();
        assertTrue(result.isEmpty());
    }

    @Test
    void testFindAll() throws DataAccessException {
        List<Memory> actual = repository.findAll();
        assertEquals(15, actual.size());
    }

    @Test
    void testFindShareable() throws DataAccessException {
        List<Memory> actual = repository.findShareable(true);
        assertEquals(8, actual.size());
        actual = repository.findShareable(false);
        assertEquals(7, actual.size());
    }

    @Test
    void testFindById() throws DataAccessException {
        Memory actual = repository.findById(mayaGreen.getId());
        assertNotNull(actual);
        assertEquals(mayaGreen.getFrom(), actual.getFrom());
        assertTrue(actual.isShareable());
        actual = repository.findById(-1);
        assertNull(actual);
    }

    @Test
    void testAdd() throws DataAccessException {
        Memory memory = new Memory();
        memory.setFrom("Albert Friend");
        memory.setContent("Remember you did that thing that one time?");
        memory.setShareable(true);
        Memory actual = repository.add(memory);
        assertEquals(16, actual.getId());

        List<Memory> all = repository.findAll();
        assertEquals(16, all.size());

        actual = all.get(15);
        assertEquals(16, actual.getId());
        assertEquals("Albert Friend", actual.getFrom());
        assertEquals("Remember you did that thing that one time?", actual.getContent());
        assertTrue(actual.isShareable());
    }

    @Test
    void testUpdate() throws DataAccessException {
        Memory memory = repository.findById(3);
        memory.setFrom("William Murderface");
        memory.setShareable(true);
        assertTrue(repository.update(memory));

        memory = repository.findById(3);
        assertNotNull(memory);
        assertEquals("William Murderface", memory.getFrom());
        assertTrue(memory.isShareable());

        Memory falseMemory = new Memory();
        falseMemory.setId(-1);
        falseMemory.setFrom("Mr. Blue Sku");
        falseMemory.setContent("Remember your fully formed memory?");
        falseMemory.setShareable(true);

        assertFalse(repository.update(falseMemory));
    }

    @Test
    void deleteById() throws DataAccessException {
        int count = repository.findAll().size();
        assertTrue(repository.deleteById(1));
        assertFalse(repository.deleteById(-1));
        assertEquals(repository.findAll().size(), 14);
        assertNull(repository.findById(1));
    }
}
