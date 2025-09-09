import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // 1. Create a HashMap with keys of the month numbers of the year and values of the
        // String names
        HashMap<Integer, String> months = new HashMap<>();
        months.put(1, "January");
        months.put(2, "February");
        months.put(3, "March");
        months.put(4, "April");
        months.put(5, "May");
        months.put(6, "June");
        months.put(7, "July");
        months.put(8, "August");
        months.put(9, "September");
        months.put(10, "October");
        months.put(11, "November");
        months.put(12, "December");

        // 2. Use the keySet method in a for loop to print all the keys and their values to the
        // console.
        for (Integer index : months.keySet()) {
            System.out.println(index + " " + months.get(index));
        }

        // 3. Create a HashMap<String, List<String>> and load it with the following:
        // Key      Value
        // Hearts   Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King
        // Diamonds Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King
        // Clubs    Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King
        // Spades   Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King
        List<String> suits = new ArrayList<>(List.of("Hearts", "Diamonds", "Clubs", "Spades"));
        List<String> values = new ArrayList<>(
                List.of("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King")
        );
        HashMap<String, List<String>> deck = new HashMap<>();
        for (String suit : suits) {
            deck.put(suit, new ArrayList<>(values));
        }

        // 4. Using this HashMap, print a list of all the cards in a standard deck of playing
        // cards
        for (Map.Entry<String, List<String>> entry : deck.entrySet()) {
            for (String value : entry.getValue()) {
                System.out.println(value + " of " + entry.getKey());
            }
        }

    }

}
