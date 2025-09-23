package learn.unexplained.domain;

import learn.unexplained.data.DataAccessException;
import learn.unexplained.data.EncounterRepository;
import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EncounterService {

    private final EncounterRepository repository;

    public EncounterService(EncounterRepository repository) {
        this.repository = repository;
    }

    public List<Encounter> findAll() throws DataAccessException {
        return repository.findAll();
    }

    public EncounterResult add(Encounter encounter) throws DataAccessException {
        EncounterResult result = validate(encounter);
        if (!result.isSuccess()) {
            return result;
        }

        // check for duplicate
        List<Encounter> encounters = repository.findAll();
        for (Encounter e : encounters) {
            if (Objects.equals(encounter.getWhen(), e.getWhen())
                    && Objects.equals(encounter.getType(), e.getType())
                    && Objects.equals(encounter.getDescription(), e.getDescription())) {
                result.addErrorMessage("duplicate encounter is not allowed");
                return result;
            }
        }

        encounter = repository.add(encounter);
        result.setPayload(encounter);
        return result;
    }

    // 6. Add the following Service Methods:
    // a. Find By Type
    // b. update
    // c. deleteById
    public List<Encounter> findByType(EncounterType encounterType) throws DataAccessException {
        return repository.findByType(encounterType);
    }

    public EncounterResult deleteById(int encounterId) throws DataAccessException {
        EncounterResult result = new EncounterResult();
        Encounter encounterToDelete = repository.findById(encounterId);

        if (!repository.deleteById(encounterId)) {
            result.addErrorMessage("Encounter " + encounterId + " not found.");
        } else {
            result.setPayload(encounterToDelete);
        }

        return result;
    }


    public EncounterResult update(Encounter encounter) throws DataAccessException {
        EncounterResult result = validate(encounter);

        // Update specific validation
        if (encounter.getEncounterId() <= 0) {
            result.addErrorMessage("Encounter ID is required.");
        }

        if (result.isSuccess()) {
            if (repository.update(encounter)) {
                result.setPayload(encounter);
            } else {
                result.addErrorMessage("Encounter ID " + encounter.getEncounterId() + " was not found.");
            }
        }

        return result;
    }


    private EncounterResult validate(Encounter encounter) {

        EncounterResult result = new EncounterResult();
        if (encounter == null) {
            result.addErrorMessage("encounter cannot be null");
            return result;
        }

        if (encounter.getWhen() == null || encounter.getWhen().trim().length() == 0) {
            result.addErrorMessage("when is required");
        }

        if (encounter.getDescription() == null || encounter.getDescription().trim().length() == 0) {
            result.addErrorMessage("description is required");
        }

        if (encounter.getOccurrences() <= 0) {
            result.addErrorMessage("occurrences must be greater than 0");
        }

        return result;
    }


}
