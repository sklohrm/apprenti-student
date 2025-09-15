package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartItemTest {
    CartItem item;
    Product product;
    final int ITEM_QUANTITY = 10;

    @BeforeEach
    void setUp() {
        product = new Product("APL101", "Red Apples (1 lb)", 2.99);
        item = new CartItem(product, ITEM_QUANTITY);
    }

    @Test
    @DisplayName("Test that getProduct() returns the associated Product")
    void testGetProductReturnsProduct() {
        //Arrange
        Product expected = product;
        //Act
        Product actual = item.getProduct();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test that getQuantity() gets the quantity")
    void testGetQuantityGetsQuantity() {
        //Arrange
        int expected = ITEM_QUANTITY;
        //Act
        int actual = item.getQuantity();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test that setQuantity() sets the quantity")
    void testSetQuantitySetsQuantity() {
        //Arrange
        int expected = 4;
        item.setQuantity(expected);
        //Act
        int actual = item.getQuantity();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test that negative quantity throws error")
    void testSetQuantityWithNegativeThrows() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> item.setQuantity(-1));
    }

    @Test
    @DisplayName("Testing toString() should return a formatted string")
    void testToString() {
        //Arrange
        String expected = product.toString() + " | Quantity: " + ITEM_QUANTITY;
        //Act
        String actual = item.toString();
        //Assert
        assertEquals(expected, actual);
    }
}