package service;

import model.CartItem;
import model.Product;
import model.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartManagerTest {
    ShoppingCart cart;
    ShoppingCartManager cartManager;
    Product product1 = new Product("APL101", "Red Apples (1 lb)", 2.99);
    Product product2 = new Product("BNN102", "Bananas (1 lb)", 1.29);
    CartItem item1;
    CartItem item2;
    final int ITEM_QUANTITY1 = 5;
    final int ITEM_QUANTITY2 = 10;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        cartManager = new ShoppingCartManager(cart);
        item1 = new CartItem(product1, ITEM_QUANTITY1);
        item2 = new CartItem(product2, ITEM_QUANTITY2);
    }

    @Test
    @DisplayName("Test adding a single item to the cart")
    void testAddSingleItem() {
        //Arrange
        List<CartItem> expected = new ArrayList<>(List.of(item1));
        //Act
        cartManager.addItem(item1);
        //Assert
        List<CartItem> actual = cart.getItems();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test adding multiple items to the cart")
    void testAddMultipleItems() {
        //Arrange
        List<CartItem> expected = new ArrayList<>(List.of(item1, item2));
        //Act
        cartManager.addItem(item1);
        cartManager.addItem(item2);
        //Assert
        List<CartItem> actual = cart.getItems();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test adding a duplicate cart item updates the quantity")
    void testAddDuplicateItem() {
        //Arrange
        int expected_count = 1;
        int expected_quantity = 2 * ITEM_QUANTITY1;
        Product expected_product = product1;
        //Act
        cartManager.addItem(item1);
        cartManager.addItem(item1);
        //Assert
        List<CartItem> items = cart.getItems();
        assertEquals(expected_count, items.size());
        CartItem item = items.get(0);
        assertEquals(expected_quantity, item.getQuantity());
        assertEquals(expected_product, item.getProduct());
    }

    @Test
    @DisplayName("Test that a CartItem with Integer.MAX_VALUE quantity can be added to the cart")
    void testAddExcessiveQuantity() {
        //Arrange
        CartItem newItem = new CartItem(product1, Integer.MAX_VALUE);
        //Act & Assert
        assertDoesNotThrow(() -> {
            cartManager.addItem(newItem);
        });
    }

    @Test
    @DisplayName("Test that adding a CartItem that will update quantity to > Integer.MAX_VALUE throws an exception")
    void testAddAdditionalExcessiveQuantity() {
        //Arrange
        CartItem newItem = new CartItem(product1, Integer.MAX_VALUE);
        cartManager.addItem(newItem);
        //Act & Assert
        assertThrows(ArithmeticException.class, () -> {
            cartManager.addItem(item1);
        });
    }

    @Test
    @DisplayName("Test removing some of a product updates quantity")
    void testRemovePartialItem() {
        //Arrange
        int quantityToRemove = 3;
        cartManager.addItem(item1);
        int expected = ITEM_QUANTITY1 - 3;
        //Act
        cartManager.removeItem(item1.getProduct().getId(), quantityToRemove);
        //Assert
        int actual = item1.getQuantity();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test removing all of a product removes the item")
    void testRemoveAllOfItem() {
        //Arrange
        cartManager.addItem(item1);
        int expected_count = 0;
        //Act
        cartManager.removeItem(item1.getProduct().getId(), ITEM_QUANTITY1);
        //Assert
        int actual_count = cart.getItems().size();
        assertEquals(expected_count, actual_count);
    }

    @Test
    @DisplayName("Test removing more than exists removes the item")
    void testRemoveMoreOfItemThanExists() {
        //Arrange
        cartManager.addItem(item1);
        int expected_count = 0;
        //Act
        cartManager.removeItem(item1.getProduct().getId(), ITEM_QUANTITY1 + 5);
        //Assert
        int actual_count = cart.getItems().size();
        assertEquals(expected_count, actual_count);
    }

    @Test
    @DisplayName("Test removing item that doesn't exist does nothing")
    void testRemoveNonExistentItem() {
        // Arrange
        cartManager.addItem(item1);

        // Act
        cartManager.removeItem(item2.getProduct().getId(), 1);

        // Assert
        assertTrue(cart.getItems().contains(item1));
        assertFalse(cart.getItems().contains(item2));
    }

    @Test
    @DisplayName("Test getting the cart")
    void testGetCart() {
        assertEquals(cart, cartManager.getCart());
    }

    @Test
    @DisplayName("Test getting cart items")
    void testGetCartItems() {
        assertEquals(cart.getItems(), cartManager.getCartItems());
    }
}