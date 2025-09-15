package service;

import model.CartItem;
import model.Product;
import model.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutServiceTest {

    ShoppingCart cart;
    ShoppingCartManager cartManager;

    final int ITEM_QUANTITY1 = 5;
    final int ITEM_QUANTITY2 = 10;
    CartItem item1 = new CartItem(new Product("APL101", "Red Apples (1 lb)", 2.99), ITEM_QUANTITY1);
    CartItem item2 = new CartItem(new Product("BNN102", "Bananas (1 lb)", 1.29), ITEM_QUANTITY2);
    CheckoutService checkoutService;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        cartManager = new ShoppingCartManager(cart);
        checkoutService = new CheckoutService();
    }

    @Test
    @DisplayName("Test checkout() clears the cart")
    void testCheckoutClearsCart() {
        //Arrange
        cartManager.addItem(item1);
        cartManager.addItem(item2);
        // Verify cart items count
        assertEquals(2, cart.getItems().size());
        //Act
        checkoutService.checkout(cart);
        //Assert
        assertEquals(0, cart.getItems().size());
    }

    @Test
    @DisplayName("Test checkout() calculates the correct total")
    void testCheckoutCalculatesTotal() {
        //Arrange
        cartManager.addItem(item1);
        cartManager.addItem(item2);
        double expected = item1.getProduct().getPrice() * ITEM_QUANTITY1 + item2.getProduct().getPrice() * ITEM_QUANTITY2;
        //Act
        double actual = checkoutService.checkout(cart);
        //Assert
        assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("Test checkout() with empty cart returns 0")
    void testCheckoutEmptyCart() {
        //Arrange
        double expected = 0;
        //Act
        double actual = checkoutService.checkout(cart);
        //Assert
        assertEquals(expected, actual, 0.001);
    }
}