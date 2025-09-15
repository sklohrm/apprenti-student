import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    private InputStream originalSystemIn;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent)); // Load our custom output stream
        originalSystemIn = System.in; // Store original System.in
        outContent.reset(); // Clear any previous output
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut); // Restore original System.out
        System.setIn(originalSystemIn); // Restore original System.in
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void testMain() {
        //Arrange
        String simulatedInput = "5\n"; // Select "Exit" menu option
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        //Act
        App.main(new String[]{}); // Call App.main() with an empty string array
        //Assert
        assertEquals("""
                Welcome to the Shopping Cart App
                Main Menu
                1. Display Cart
                2. Add an Item
                3. Remove an Item
                4. Checkout
                5. Exit
                Select an option:\s
                Goodbye
                """, outContent.toString());
    }
}