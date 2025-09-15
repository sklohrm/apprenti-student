package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product;
    final String PRODUCT_ID = "APL101";
    final String PRODUCT_NAME = "Red Apples (1 lb)";
    final double PRODUCT_PRICE = 2.99;

    @BeforeEach
    void setUp() {
        product = new Product(PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE);
    }

    @Test
    @DisplayName("Testing getId() should return the Product ID")
    void testGetId() {
        //Arrange
        String expected = PRODUCT_ID;
        //Act
        String actual = product.getId();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testing getName() should return the Product Name")
    void testGetName() {
        //Arrange
        String expected = PRODUCT_NAME;
        //Act
        String actual = product.getName();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testing getPrice() should return the Product Price")
    void testGetPrice() {
        //Arrange
        double expected = PRODUCT_PRICE;
        //Act
        double actual = product.getPrice();
        //Assert
        assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("Testing toString() should return a formatted string")
    void testToString() {
        //Arrange
        String expected = "ID: " + PRODUCT_ID + " | Name: " + PRODUCT_NAME + " | Price: $" + String.format("%.2f", PRODUCT_PRICE);
        //Act
        String actual = product.toString();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testing setPrice() with negative value should throw error")
    void testSetPriceWithNegativeThrows() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Product(PRODUCT_ID, PRODUCT_NAME, -PRODUCT_PRICE));
    }
}