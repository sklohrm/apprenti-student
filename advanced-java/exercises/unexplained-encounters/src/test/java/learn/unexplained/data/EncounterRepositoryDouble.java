package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;

import java.util.List;

public class EncounterRepositoryDouble implements EncounterRepository {
    @Override
    public List<Encounter> findAll() throws DataAccessException {
        return List.of(new Encounter(2, EncounterType.CREATURE, "1/1/2015", "test description", 1));
    }

    @Override
    public Encounter add(Encounter encounter) throws DataAccessException {
        return encounter;
    }

    @Override
    public boolean deleteById(int encounterId) throws DataAccessException {
        Encounter encounter = findById(encounterId);
        return encounter != null;
    }

    @Override
    public List<Encounter> findByType(EncounterType encounterType) throws DataAccessException {
        return List.of(new Encounter(2, encounterType, "1/1/2015", "test description", 1));
    }

    @Override
    public boolean update(Encounter encounter) throws DataAccessException {
        return findById(encounter.getEncounterId()) != null;
    }

    @Override
    public Encounter findById(int encounterId) throws DataAccessException {
        for (Encounter encounter : findAll()) {
            if (encounter.getEncounterId() == encounterId) {
                return encounter;
            }
        }
        return null;
    }
}
