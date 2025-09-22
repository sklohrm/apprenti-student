package learn.unexplained;

import learn.unexplained.data.EncounterFileRepository;
import learn.unexplained.domain.EncounterService;
import learn.unexplained.ui.Controller;
import learn.unexplained.ui.View;

public class App {

    public static void main(String[] args) {

//        7. Instantiate and Run Controller
//        a. Create a Controller instance in App.main and call its run method.
//        b. Provide the required dependencies through manual dependency injection. Ensure to resolve the entire dependency chain.
//        c. Use the existing EncounterFileRepository with the file path ./data/encounters.csv for production data.
        EncounterFileRepository repository = new EncounterFileRepository("./data/encounters.csv");
        EncounterService service = new EncounterService(repository);
        View view = new View();
        Controller controller = new Controller(service, view);
        controller.run();
    }
}
