package model;

import exception.InvalidProductIdException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    ShoppingCart cart;
    Product product1 = new Product("APL101", "Red Apples (1 lb)", 2.99);
    Product product2 = new Product("BNN102", "Bananas (1 lb)", 1.29);
    CartItem item1;
    CartItem item2;
    final int ITEM_QUANTITY1 = 5;
    final int ITEM_QUANTITY2 = 10;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        item1 = new CartItem(product1, ITEM_QUANTITY1);
        item2 = new CartItem(product2, ITEM_QUANTITY2);
    }

    @Test
    @DisplayName("Test getItems() returns all CartItems")
    void testGetItemsGetsAllItems() {
        //Arrange
        // Manually add items to cart via cartItems map for testing getItems()
        cart.getCartItems().put(item1.getProduct().getId(), item1);
        cart.getCartItems().put(item2.getProduct().getId(), item2);
        List<CartItem> expected = new ArrayList<>(List.of(item1, item2));
        //Act
        List<CartItem> actual = cart.getItems();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test clearItems() empties the cart")
    void clearItems() {
        //Arrange
        // Manually add items to cart via cartItems map for testing clearItems()
        cart.getCartItems().put(item1.getProduct().getId(), item1);
        cart.getCartItems().put(item2.getProduct().getId(), item2);
        int expected_count = 0;
        //Act
        cart.clearItems();
        //Assert
        int actual_count = cart.getItems().size();
        assertEquals(expected_count, actual_count);
    }

    @Test
    @DisplayName("Test getItem() returns the correct CartItem")
    void testGetItem() {
        //Arrange
        cart.getCartItems().put(item1.getProduct().getId(), item1);
        //Act
        CartItem actual = cart.getItem(item1.getProduct().getId());
        //Assert
        assertEquals(item1, actual);
    }

    @Test
    @DisplayName("Test getItem() throws exception for non-existent item")
    void testGetItemReturnsNull() {
        //Act & Assert
        assertThrows(InvalidProductIdException.class, () -> {
            cart.getItem("INVALID_ID");
        });
    }
}