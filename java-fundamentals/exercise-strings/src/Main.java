public class Main {
    public static void main(String[] args) {

        // Declare and assign variables
        String firstName = "Harry";
        String lastName = "Potter";
        String fullName = firstName + lastName;
        System.out.println("Full Name: " + fullName);

        // Find the length of fullName and print it
        System.out.println("Length: " + fullName.length());

        // Extract and print the first character
        System.out.println("First Character: " + fullName.charAt(0));

        // Find the position of the letter 'r'
        System.out.println("'r' Found at: " + fullName.indexOf("r"));

        // Declare a string
        String sentence = "Learning Java is fun!";

        // Extract and print "Learning" "Java" "fun"
        System.out.println(sentence.substring(0, 8));
        System.out.println(sentence.substring(9, 13));
        System.out.println(sentence.substring(sentence.length() - 4, sentence.length() - 1));

        // Declare a string
        String csvData = "apple,banana,grape,orange";
        String[] csvArr = csvData.split(",");
        for (String s : csvArr) {
            System.out.println(s);
        }

        //Declare a string
        String sentence1 = "The quick brown fox.";

        // Replace "quick" with "slow"
        sentence1 = sentence1.replace("quick", "slow");
        sentence1 = sentence1.replace(" ", "_");

        System.out.println(sentence1);

        // Declare a string variable but set it to null
        String nullStr = null;

        // Use an if statement to check if the string is null before printing its length
        if (nullStr != null) {
            System.out.println(nullStr);
        }

        // Declare another string as an empty string and print its length
        String emptyStr = "";
        System.out.println(emptyStr.length());


    }
}