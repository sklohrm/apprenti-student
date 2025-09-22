package learn.unexplained.ui;

import learn.unexplained.data.DataAccessException;
import learn.unexplained.domain.EncounterResult;
import learn.unexplained.domain.EncounterService;
import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;

import java.util.List;

public class Controller {

    private final EncounterService service;
    private final View view;

    public Controller(EncounterService service, View view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        view.printHeader("Welcome To Unexplained Encounters.");

        try {
            runMenuLoop();
        } catch (DataAccessException ex) {
            view.printHeader("CRITICAL ERROR:" + ex.getMessage());
        }

        view.printHeader("Goodbye");
    }

    private void runMenuLoop() throws DataAccessException {
        MenuOption option;
        do {
            option = view.displayMenuGetOption();
            switch (option) {
                case DISPLAY_ALL:
                    displayAllEncounters();
                    break;
                case ADD:
                    addEncounter();
                    break;
                case DISPLAY_BY_TYPE:
                    displayEncountersByType();
                    break;
                case UPDATE:
                    updateEncounter();
                    break;
                case DELETE:
                    deleteEncounter();
                    break;
            }
        } while (option != MenuOption.EXIT);
    }

    private void displayAllEncounters() throws DataAccessException {
        List<Encounter> encounters = service.findAll();
        view.printAllEncounters(encounters);
    }

    private void addEncounter() throws DataAccessException {
        Encounter encounter = view.makeEncounter();
        EncounterResult result = service.add(encounter);
        view.printResult(result);
    }

//    	8. Display Encounters By Type
//    a. The controller requests an EncounterType from the view.
//    b. It then uses service.findByType with the EncounterType to retrieve a list of encounters.
//    c. The controller passes this list to the view for display. If no encounters of that type exist, indicate this to the user.
    private void displayEncountersByType() throws DataAccessException {
        EncounterType encounterType = view.readType();
        List<Encounter> encounters = service.findByType(encounterType);
        view.printAllEncounters(encounters);
    }


//    	9. Update An Encounter
//    a. Determine how to locate the encounter for updating: either by id or through a list of encounters.
//            i. Option 1: Search by encounter id, requiring findById methods in both the repository and service.
//    ii. Option 2: Fetch a list of encounters for user selection.
//    b. Once the method is decided:
//    i. The controller obtains selection criteria from the view.
//    ii. It retrieves encounters from the service based on these criteria.
//    iii. The controller presents the encounter(s) to the view. If multiple, the user selects one; if a single encounter, it is ready for update.
//    iv. The view updates the encounter fields with user input.
//    v. The view returns the updated encounter to the controller.
//    vi. The controller passes the updated encounter to service.update and receives the result.
//    vii. The result is presented to the view, displaying either a success or failure message.
    private void updateEncounter() throws DataAccessException {
        List<Encounter> encounters = service.findAll();
        Encounter encounter = view.chooseEncounter(encounters);
        if (encounter == null) {
            view.printHeader("Encounter Not Found");
            return;
        }
        encounter = view.editEncounter(encounter);
        EncounterResult result = service.update(encounter);
        view.printResult(result);
    }


//    		4. Delete An Encounter
//    a. Decide how to select an existing encounter for deletion: by id or from a list.
//    b. With the encounter id, the controller calls service.deleteById and receives a result.
//    c. The result is then shown to the view, indicating success or failure.
    private void deleteEncounter() throws DataAccessException {
        List<Encounter> encounters = service.findAll();
        Encounter encounter = view.chooseEncounter(encounters);
        if (encounter == null) {
            view.printHeader("Encounter Not Found");
            return;
        }
        EncounterResult result = service.deleteById(encounter.getEncounterId());
        view.printResult(result);
    }
}
