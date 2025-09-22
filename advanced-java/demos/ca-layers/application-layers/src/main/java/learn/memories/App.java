package learn.memories;

import learn.memories.data.MemoryFileRepository;
import learn.memories.data.MemoryRepository;
import learn.memories.domain.MemoryService;
import learn.memories.ui.ConsoleIO;
import learn.memories.ui.Controller;
import learn.memories.ui.TextIO;
import learn.memories.ui.View;

public class App {

    public static void main(String[] args) {

        MemoryRepository repository = new MemoryFileRepository("./data/memories.txt");
        MemoryService service = new MemoryService(repository);

        TextIO io = new ConsoleIO();
        View view = new View(io);

        Controller controller = new Controller(view, service);
        controller.run();
    }

}
