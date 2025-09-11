package org.example.service;

import org.example.exception.PrinterKeyExistsException;
import org.example.model.Printer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrinterManagerTest {
    PrinterManager manager;
    Printer printer1;
    Printer printer2;
    final String PRINTER1_ID = "P1";
    final String PRINTER2_ID = "P2";


    @BeforeEach
    void setUp() {
        manager = new PrinterManager();
        printer1 = new Printer(PRINTER1_ID, "Printer 1");
        printer2 = new Printer(PRINTER2_ID, "Printer 2");
    }

    @AfterEach
    void tearDown() {
        manager.haltMonitors();
    }

    @Test
    @DisplayName("Test addPrinter() should add a Printer")
    void testAddPrinterAddsPrinter() {
        //Arrange
        Printer expected = printer1;

        //Act
        manager.addPrinter(PRINTER1_ID, printer1);

        //Assert
        Printer actual = manager.getPrinter(PRINTER1_ID);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test getPrinter() should get a Printer")
    void testGetPrinterGetsPrinter() {
        //Arrange
        Printer expected = printer1;
        manager.addPrinter(PRINTER1_ID, printer1);

        //Act
        Printer actual = manager.getPrinter(PRINTER1_ID);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test getPrinter() should return null if ID doesn't exist")
    void testGetPrinterReturnsNull() {
        //Arrange
        // Nothing to do here

        //Act
        Printer actual = manager.getPrinter(PRINTER1_ID);

        //Assert
        assertNull(actual);
    }

    @Test
    @DisplayName("Test getAllPrinterIds() should return a list of printer IDs")
    void getAllPrinterIds() {
        //Arrange
        manager.addPrinter(PRINTER1_ID, printer1);
        manager.addPrinter(PRINTER2_ID, printer2);
        List<String> expected = new ArrayList<>(List.of(PRINTER1_ID, PRINTER2_ID));

        //Act
        List<String> actual = manager.getAllPrinterIds();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test addPrinter() should throw exception if printer key already exists")
    void testAddDuplicatePrinter() {
        // Arrange
        manager.addPrinter(PRINTER1_ID, printer1);
        // Act

        // Assert
        assertThrows(PrinterKeyExistsException.class, () -> manager.addPrinter(PRINTER1_ID, printer1));
    }
}