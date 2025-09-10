package org.example.service;

import org.example.model.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineImplTest {

    VendingMachine vm;
    static Product apple;
    static Product candyBar;
    static Product soda;

    @BeforeAll
    static void buildProducts() {
        apple = new Product("Apple", .25);
        candyBar = new Product("Candy Bar", 1.00);
        soda = new Product("Soda", .50);
    }

    @BeforeEach
    void setUp() {
        vm = new VendingMachineImpl();

        vm.loadProduct("A1", apple, 10);
        vm.loadProduct("A2", candyBar, 10);

        vm.addMoney(50.00);
    }

    @Test
    void testGetBinIds() {
        // Arrange
        List<String> expected = new ArrayList<>();
        expected.add("A1");
        expected.add("A2");

        // Act
        List<String> actual = vm.getBinIds();

        // Assert
        assertEquals(Set.copyOf(expected), Set.copyOf(actual));
    }


    @Test
    void testGetBinContents() {
        // Arrange
        Product expected = apple;
        String testBinID = "A1";

        // Act
        Product actual = vm.getBinContents(testBinID);

        // Assert
        assertEquals(expected, actual);

    }

    @Test
    void testGetBinQuantity() {
        // Assert
        assertEquals(10, vm.getBinQuantity("A1"));
    }

    @Test
    void testVendReducesStock() {
        // Arrange
        int expected;
        int actual;

        // Act
        for (int i = 10; i > 0; i--) {
            vm.vend("A1");
            expected = i - 1;
            actual = vm.getBinQuantity("A1");
            // Assert
            assertEquals(expected, actual);
        }
    }

    @Test void testVendIncreasesMoneyBin() {
        // Arrange
        double expected = 0.25;

        // Act
        vm.vend("A1");
        double actual = vm.getMoneyBinContents();

        // Assert
        assertEquals(expected, actual);

    }

    @Test
    void testLoadProduct() {
        // Arrange
        int expected = 10;

        // Act
        vm.loadProduct("A3", soda, 10);
        int actual = vm.getBinQuantity("A3");

        // Assert
        assertEquals(expected, actual);
    }
}