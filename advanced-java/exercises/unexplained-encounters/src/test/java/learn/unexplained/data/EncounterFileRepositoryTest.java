package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncounterFileRepositoryTest {

    static final String TEST_PATH = "./data/encounters-test.csv";
    static final String SEED_PATH = "./data/encounters-seed.csv";

    EncounterRepository repository;
    Encounter testEncounter;


    @BeforeEach
    void setup() throws IOException {
        repository = new EncounterFileRepository(TEST_PATH);
        Path seedPath = Paths.get(SEED_PATH);
        Path testPath = Paths.get(TEST_PATH);
        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);

        testEncounter = new Encounter();
        testEncounter.setType(EncounterType.UFO);
        testEncounter.setWhen("Jan 15, 2005");
        testEncounter.setDescription("moving pinpoint of light." +
                "seemed to move with me along the highway. " +
                "then suddenly reversed direction without slowing down. it just reversed.");
        testEncounter.setOccurrences(1);
    }

    @Test
    void shouldFindAll() throws DataAccessException {
        List<Encounter> encounters = repository.findAll();
        assertEquals(10, encounters.size());
    }

    @Test
    void shouldAdd() throws DataAccessException {
        Encounter encounter = testEncounter;

        Encounter actual = repository.add(encounter);

        assertNotNull(actual);
        assertEquals(11, actual.getEncounterId());
    }

    // New Tests
    @Test
    void testFindByType() throws DataAccessException {
        // Arrange/Act
        List<Encounter> actual = repository.findByType(EncounterType.UFO);

        // Assert
        assertEquals(2, actual.size());

        // Arrange/Act
        actual = repository.findByType(EncounterType.VISION);

        // Assert
        assertEquals(0, actual.size());
    }

    @Test
    void testUpdate() throws DataAccessException {
        // Arrange
        List<Encounter> encounters = repository.findAll();
        Encounter encounter = testEncounter;

        // Act
        encounter.setEncounterId(encounters.get(0).getEncounterId());

        // Assert
        assertTrue(repository.update(encounter));

        // Arrange
        encounters = repository.findAll();
        encounter = encounters.get(0);

        // Assert
        assertEquals(encounter.getType(), testEncounter.getType());
        assertEquals(encounter.getWhen(), testEncounter.getWhen());
        assertEquals(encounter.getDescription(), testEncounter.getDescription());
        assertEquals(encounter.getOccurrences(), testEncounter.getOccurrences());

        // Arrange
        encounter = testEncounter;
        encounter.setEncounterId(-1);

        // Assert
        assertFalse(repository.update(encounter));
    }

    @Test
    void testDelete() throws DataAccessException {
        // Arrange
        int count = repository.findAll().size();

        // Act/Assert
        assertTrue(repository.deleteById(1));
        assertFalse(repository.deleteById(-1));
        assertEquals(count - 1, repository.findAll().size());
        assertEquals(1, repository.findByType(EncounterType.UFO).size());
    }

}