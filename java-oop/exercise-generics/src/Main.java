import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Box<T> {
    private T value;
    private String label;

    public Box(String label) {
        this.label = label;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void display() {
        System.out.println(label + " contains: " + value);
    }
}

public class Main {

    public static void main(String[] args) {

        Box<Integer> numberBox = new Box<>("Number Box");
        numberBox.setValue(42);
        numberBox.display();

        Box<String> messageBox = new Box<>("Message Box");
        messageBox.setValue("The pelagic argosy sights land.");
        messageBox.display();

        ArrayList<Box<Integer>> boxList = new ArrayList<>();
        Box<Integer> numBox1 = new Box<>("Number Box 1");
        Box<Integer> numBox2 = new Box<>("Number Box 2");
        Box<Integer> numBox3 = new Box<>("Number Box 3");

        numBox1.setValue(10);
        numBox2.setValue(30);
        numBox3.setValue(20);

        boxList.add(numBox1);
        boxList.add(numBox2);
        boxList.add(numBox3);

        System.out.println("What's in the box?");
        for (Box<Integer> box : boxList) {
            box.display();
        }

        Queue<Box<String>> messageQueue = new LinkedList<>();
        Box<String> stringBox1 = new Box<>("Poké Box 1");
        Box<String> stringBox2 = new Box<>("Poké Box 2");
        Box<String> stringBox3 = new Box<>("Poké Box 3");

        stringBox1.setValue("Abra");
        stringBox2.setValue("Kadabra");
        stringBox3.setValue("Alakazam");

        messageQueue.add(stringBox1);
        messageQueue.add(stringBox2);
        messageQueue.add(stringBox3);

        System.out.println("Processing Queue:");
        while (!messageQueue.isEmpty()) {
            messageQueue.poll().display();
        }

        boxList.sort(Comparator.comparingInt(Box::getValue));
        for (Box<Integer> box : boxList) {
            box.display();
        }

    }



}
