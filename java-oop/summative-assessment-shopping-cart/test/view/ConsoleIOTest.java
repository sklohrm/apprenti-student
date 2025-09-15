package view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleIOTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        outContent.reset(); // Clear any previous output
        System.setOut(new PrintStream(outContent)); // Capture output
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testPrint() {
        //Arrange
        String expected = "Test Output\n";
        ConsoleIO console = new ConsoleIO(new Scanner(System.in));
        //Act
        console.print("Test Output");
        //Assert
        assertEquals(expected, outContent.toString());
    }

    @Test
    void testGetInput() {
        //Arrange
        String simulatedInput = "Test Input\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        ConsoleIO console = new ConsoleIO(new Scanner(inputStream));
        //Act
        String actual = console.getInput();
        //Assert
        assertEquals("Test Input", actual);
    }
}