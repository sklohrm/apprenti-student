package learn.unexplained.domain;

import learn.unexplained.data.DataAccessException;
import learn.unexplained.data.EncounterRepositoryDouble;
import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncounterServiceTest {

    EncounterService service = new EncounterService(new EncounterRepositoryDouble());

    @Test
    void shouldNotAddNull() throws DataAccessException {
        EncounterResult expected = makeResult("encounter cannot be null");
        EncounterResult actual = service.add(null);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddEmptyWhen() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, " ", "test desc", 1);
        EncounterResult expected = makeResult("when is required");
        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }


    @Test
    void shouldNotAddEmptyDescription() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, "2/2/2019", "  ", 1);
        EncounterResult expected = makeResult("description is required");
        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddNullDescription() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, "2/2/2019", null, 1);
        EncounterResult expected = makeResult("description is required");
        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddZeroOccurrences() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, "2/2/2019", "test description", 0);
        EncounterResult expected = makeResult("occurrences must be greater than 0");
        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddDuplicate() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, "1/1/2015", "test description", 1);
        EncounterResult expected = makeResult("duplicate encounter is not allowed");
        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }

    @Test
    void shouldAdd() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, "2/2/2019", "test description", 1);
        EncounterResult expected = new EncounterResult();
        expected.setPayload(encounter);

        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }

    @Test
    void testShouldUpdate() throws DataAccessException {
        Encounter encounter = new Encounter(2, EncounterType.CREATURE, "2/2/2019", "test description", 1);
        EncounterResult expected = new EncounterResult();
        expected.setPayload(encounter);

        EncounterResult actual = service.update(encounter);
        assertEquals(actual, expected);
    }

    @Test
    void testShouldNotUpdateEmpty() throws DataAccessException {
        Encounter encounter = new Encounter(2, EncounterType.CREATURE, null, "test description", 1);

        EncounterResult actual = service.update(encounter);
        assertFalse(actual.isSuccess());
        assertTrue(actual.getMessages().getFirst().contains("when"));

    }

    @Test
    void testShouldNotUpdateInvalidID() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, "1-1-1901", "test description", 1);

        EncounterResult actual = service.update(encounter);
        assertFalse(actual.isSuccess());
        assertTrue(actual.getMessages().getFirst().contains("Encounter ID is required."));

        encounter.setEncounterId(3);

        actual = service.update(encounter);
        assertFalse(actual.isSuccess());
        assertTrue(actual.getMessages().getFirst().contains("not found"));
    }

    @Test
    void testFindByType() throws DataAccessException {
        List<Encounter> actual = service.findByType(EncounterType.UFO);
        for (Encounter encounter : actual) {
            assertEquals(EncounterType.UFO, encounter.getType());
        }
    }

    @Test
    void testDelete() throws DataAccessException {
        EncounterResult actual = service.deleteById(2);
        assertTrue(actual.isSuccess());

        actual = service.deleteById(3);
        assertFalse(actual.isSuccess());
        assertTrue(actual.getMessages().getFirst().contains("not found"));
    }

    private EncounterResult makeResult(String message) {
        EncounterResult result = new EncounterResult();
        result.addErrorMessage(message);
        return result;
    }
}