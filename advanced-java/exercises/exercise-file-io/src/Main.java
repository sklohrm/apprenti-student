import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static final String FILE_NAME = "student_data.txt";

    public static void main(String[] args) {

        // Part 1: Create a New File
        // 1. Use the File class to create a new file named student_data.txt.
        File file = new File(FILE_NAME);

        // 2. Check if the file was created successfully or if it already exists.
        // 3. Print a message indicating whether the file was created or if it already existed.
        try {
            if (file.createNewFile()) {

                System.out.println("CREATED FILE: " + file.getName());
            } else {
                System.out.println("ERROR: " + file.getName() + " already exists.");
            }
        } catch(IOException e) {
            System.out.println("An error occurred when creating the file.");
            e.printStackTrace();
        }

        // Part 2: Write Data to the File
        // 1. Open the file for writing using the appropriate Java class for writing text files.
        // 2. Write the following lines to the file:
        //    "Alice, A"
        //    "Bob, B"
        //    "Charlie, A+"
        // 3. Close the file after writing.
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("Alice, A");
            writer.println("Bob, B");
            writer.println("Charlie, A+");
        } catch (IOException e) {
            System.out.println("An error occurred when writing to file.");
            e.printStackTrace();
        }

        // Part 3: Append Data to the File
        // 1. Open the file again, but this time, use an option that allows you to append to the
        //    file instead of overwriting it.
        // 2. Append the following lines to the file:
        //    "David, B+"
        //    "Eva, A"
        // 3. Close the file after appending the data.
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.println("David, B+");
            writer.println("Eva, A");
        } catch (IOException e) {
            System.out.println("An error occurred when writing to file.");
            e.printStackTrace();
        }

        // Part 4: Read Data from the File
        // 1. Open the file for reading using the appropriate Java class.
        // 4. Close the file after reading.
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            // 2. Read the file line by line.
            while ((line = reader.readLine()) != null) {
                // 3. For each line, print its contents to the console.
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred when writing to file.");
            e.printStackTrace();
        }

        // Part 5: Path Exploration
        // 1. Determine the absolute path of the file on your system. The absolute path
        //    includes the full directory structure from the root directory
        //    (e.g., C:\Users\YourName\Documents\student_data.txt on Windows or /home/username/student_data.txt on Linux/macOS).
        // 2. Determine the relative path of the file based on where the file is located relative
        //    to your Java project (e.g., if the file is in the same directory as your Java code,
        //    the relative path will just be student_data.txt).
        // 3. Compare absolute vs. relative paths and provide examples for both.
        String absolutePathString = "/Users/sklohrm/Developer/apprenti/apprenti-student/advanced-java/exercises/exercise-file-io/student_data.txt";
        String relativePathString = "student_data.txt";

        Path relativePath = Paths.get(relativePathString);

        // Part 6: Delete the File
        // 1. Use the delete() method of the File class to remove the file.
        // 2. Print a message indicating whether the file was successfully deleted or if the
        //    deletion failed.
        try {
            if (Files.deleteIfExists(relativePath)) {
                System.out.println("File deleted.");
            } else {
                System.out.println("Unable to delete file.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred when writing to file.");
            e.printStackTrace();
        }

        // Part 7: Reflection Questions
        // 1. Why is it better to use a relative path instead of an absolute path when working
        //    with files in a Java program? Provide examples.

        // A relative path is the path to the file from the project, absolute is the path to the file from the root
        // directory. Relative path can be used reliably access files on any system.
        // For example if you are trying to access a file in the working directory, using absolute path will be the same
        // on any system. Using absolute path will cause errors unless the file structure is exactly the same as the
        // system that the program was built on.

        // 2. What could happen if you do not use the try-with-resources statement
        //    when handling file input/output operations?

        // Resources would not be closed automatically, causing resource leaks, and unexpected behavior when reading
        // and writing repeatedly to the same file.

        // 3. In what situations would you need to append data to an existing file, rather than
        //    overwriting the file's contents?

        // You would use append if you have a file with contents that need to stay, but simply be added to.
        // Like in this project where we have a list of students with grades. If a new student joins, we still want
        // the old students to be on file, so we just append the new one.

        // 4. Can you think of real-world scenarios where file I/O is necessary? How does file
        //    I/O enhance the functionality of a program in those scenarios?

        // Any program with persistent state needs file IO at some point. Whether it is pulling from a local file, or contacting
        // a server that is retrieving the contents of those files. We went over the example in class of databases. This is
        // a widespread example of data being stored using file IO in the real world. Another example is any application that
        // you use that is saving user preferences between runs is using filo IO to save those settings somewhere.

    }

}
