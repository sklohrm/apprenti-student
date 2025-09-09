package org.example.service;

import org.example.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineImplTest {

    private VendingMachineImpl testVM;
    private Product testApple;
    private Product testCandyBar;
    private Product testSoda;

    @BeforeEach
    void setUp() {
        testVM = new VendingMachineImpl();

        testApple = new Product("Apple", .25);
        testCandyBar = new Product("Candy Bar", 1.00);
        testSoda = new Product("Soda", .50);

        testVM.loadProduct("A1", testApple, 10);
        testVM.loadProduct("A2", testCandyBar, 10);

        testVM.addMoney(50.00);
    }

    @Test
    void testGetBinIds() {
        // Arrange
        List<String> expected = new ArrayList<>();
        expected.add("A1");
        expected.add("A2");

        // Act
        List<String> actual = testVM.getBinIds();

        // Assert
        assertEquals(Set.copyOf(expected), Set.copyOf(actual));
    }


    @Test
    void testGetBinContents() {
        // Arrange
        Product expected = testApple;
        String testBinID = "A1";

        // Act
        Product actual = testVM.getBinContents(testBinID);

        // Assert
        assertEquals(expected, actual);

    }

    @Test
    void testGetBinQuantity() {
        // Assert
        assertEquals(10, testVM.getBinQuantity("A1"));
    }

    @Test
    void testVendReducesStock() {
        // Arrange
        int expected;
        int actual;

        // Act
        for (int i = 10; i > 0; i--) {
            testVM.vend("A1");
            expected = i - 1;
            actual = testVM.getBinQuantity("A1");
            // Assert
            assertEquals(expected, actual);
        }
    }

    @Test void testVendIncreasesMoneyBin() {
        // Arrange
        double expected = 0.25;

        // Act
        testVM.vend("A1");
        double actual = testVM.getMoneyBinContents();

        // Assert
        assertEquals(expected, actual);

    }

    @Test
    void testLoadProduct() {
        // Arrange
        int expected = 10;

        // Act
        testVM.loadProduct("A3", testSoda, 10);
        int actual = testVM.getBinQuantity("A3");

        // Assert
        assertEquals(expected, actual);
    }
}