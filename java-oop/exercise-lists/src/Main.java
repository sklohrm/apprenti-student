import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class Main {

    public static void main(String[] args) {

        // 1. Declare and initialize an ArrayList.
        List<String> nameList = new ArrayList<>();

        // 2. Add elements to an ArrayList using .add().
        nameList.add("Severian");
        nameList.add("Dorcas");
        nameList.add("Dr. Talos");
        nameList.add("Baldanders");
        nameList.add("Jolenta");

        // 3. Retrieve elements using .get().
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println("Index " + i + ": " + nameList.get(i));
        }

        // 4. Remove elements using .remove() and understand how it affects indexing.
        System.out.println("\nRemoving the third element will shift all the following elements down by one.");
        nameList.remove(2);
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println("Index " + i + ": " + nameList.get(i));
        }

        // 5. Determine the size of an ArrayList using .size().
        System.out.println("\nSize: " + nameList.size());

        // 6. Check if an ArrayList is empty using .isEmpty().
        System.out.println("The list is " + (nameList.isEmpty() ? "empty." : "not empty."));

        // 7. Sort an ArrayList using java.util.Collections.sort().
        sort(nameList);
        System.out.println("\nAlphabetically Sorted List");
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println("Index " + i + ": " + nameList.get(i));
        }
        System.out.println("\n");

        // 8. Apply basic ArrayList operations to manage a collection of data.
        nameList.add("Jonas");
        if (nameList.contains("Jonas")) {
            System.out.println("Jonas is here!");
        }

        System.out.println("Baldanders is at index: " + nameList.indexOf("Baldanders"));

        nameList.clear();
        if (nameList.isEmpty()) {
            System.out.println("\nEveryone is gone!");
        }


    }

}
