package controller;

import controller.config.ShoppingCartControllerConfig;
import exception.InvalidProductIdException;
import model.CartItem;
import model.Product;
import model.ShoppingCart;
import service.ShoppingCartManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import repo.IProductRepo;
import repo.ProductRepo;
import service.CheckoutService;
import view.AppView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShoppingCartControllerTest {
    // MOCKS
    IProductRepo repoMock;
    AppView viewMock;
    ShoppingCartManager cartManagerMock;
    ShoppingCart cartMock;
    CheckoutService checkoutMock;

    // SOT
    ShoppingCartController controller;

    @BeforeEach
    void setUp() {
        repoMock = mock(ProductRepo.class);
        viewMock = mock(AppView.class);
        cartManagerMock = mock(ShoppingCartManager.class);
        cartMock = mock(ShoppingCart.class);
        checkoutMock = mock(CheckoutService.class);

        ShoppingCartControllerConfig config = new ShoppingCartControllerConfig();
        config.setProductRepo(repoMock);
        config.setAppView(viewMock);
        config.setShoppingCart(cartManagerMock);
        config.setCheckoutService(checkoutMock);
        controller = new ShoppingCartController(config);
    }

    @Test
    void testRunDisplaysWelcomeMessage() {
        //Arrange
        String expected = "Welcome to the Shopping Cart App";
        when(viewMock.getIntInRange(anyString(), anyInt(), anyInt())).thenReturn(5);
        //Act
        controller.run();
        //Assert
        verify(viewMock).displayMessage(expected);
    }

    @Test
    void testRunDisplaysMenu() {
        //Arrange
        when(viewMock.getIntInRange(anyString(), anyInt(), anyInt())).thenReturn(5);

        //Act
        controller.run();

        //Assert
        InOrder inOrder = inOrder(viewMock);

        inOrder.verify(viewMock).displayMessage("Main Menu");
        inOrder.verify(viewMock).displayMessage("1. Display Cart");
        inOrder.verify(viewMock).displayMessage("2. Add an Item");
        inOrder.verify(viewMock).displayMessage("3. Remove an Item");
        inOrder.verify(viewMock).displayMessage("4. Checkout");
        inOrder.verify(viewMock).displayMessage("5. Exit");
    }

    @Test
    void testDisplayCart() {
        // Arrange
        when(viewMock.getIntInRange(anyString(), anyInt(), anyInt())).thenReturn(1).thenReturn(5);
        when(cartManagerMock.getCart()).thenReturn(cartMock);

        // Act
        controller.run();

        // Assert
        verify(viewMock).displayCart(anyList());
    }

    @Test
    void testAddItemDisplaysAllProducts() {
        // Arrange
        Product product1 = new Product("APL101", "Red Apples (1 lb)", 2.99);
        Product product2 = new Product("BNN102", "Bananas (1 lb)", 1.29);
        List<Product> products = new ArrayList<>(List.of(product1, product2));

        when(viewMock.getIntInRange(anyString(), anyInt(), anyInt())).thenReturn(2).thenReturn(5);
        when(repoMock.getAllProducts()).thenReturn(products);
        when(repoMock.getProduct(any())).thenReturn(product1);

        // Act
        controller.run();

        // Assert
        verify(viewMock).displayProducts(products);
    }

    @Test
    void testAddItemAddsItem() {
        // Arrange
        Product product1 = new Product("APL101", "Red Apples (1 lb)", 2.99);

        when(viewMock.getIntInRange(anyString(), anyInt(), anyInt())).thenReturn(2).thenReturn(5);
        when(repoMock.getProduct(any())).thenReturn(product1);
        when(viewMock.getPositiveInt(anyString())).thenReturn(5);

        // Act
        controller.run();

        // Assert
        ArgumentCaptor<CartItem> captor = ArgumentCaptor.forClass(CartItem.class);
        verify(cartManagerMock).addItem(captor.capture());

        CartItem captured = captor.getValue();
        assertEquals(product1, captured.getProduct());
        assertEquals(5, captured.getQuantity());
    }

    @Test
    void testAddInvalidItemIdDisplaysError() {
        when(viewMock.getIntInRange(anyString(), anyInt(), anyInt())).thenReturn(2).thenReturn(5);
        when(repoMock.getProduct(any())).thenThrow(new InvalidProductIdException("invalid"));
        // Act
        controller.run();
        // Assert
        verify(viewMock).displayMessage("Error: Invalid Product ID");
        verifyZeroInteractions(cartManagerMock); // This ensures the cart isn't touched after entering an invalid product id
    }

    @Test
    void testAddItemUnexpectedExceptionDisplaysError() {
        when(viewMock.getIntInRange(anyString(), anyInt(), anyInt())).thenReturn(2).thenReturn(5);
        when(repoMock.getProduct(any())).thenThrow(new RuntimeException("An Error Occurred"));
        // Act
        controller.run();
        // Assert
        verify(viewMock).displayMessage("An unexpected error occurred: java.lang.RuntimeException: An Error Occurred");
        verifyZeroInteractions(cartManagerMock); // This ensures the cart isn't touched after entering an invalid product id
    }

    @Test
    void testAddInvalidQuantityDisplaysError() {
        Product product1 = new Product("APL101", "Red Apples (1 lb)", 2.99);
        when(viewMock.getIntInRange(anyString(), anyInt(), anyInt())).thenReturn(2).thenReturn(5);
        when(repoMock.getProduct(any())).thenReturn(product1);
        doThrow(new ArithmeticException())
                .when(cartManagerMock)
                .addItem(any());
        // Act
        controller.run();
        // Assert
        verify(viewMock).displayMessage("Error: Quantity limit exceeded");
    }

    @Test
    void testAddQuantityUnexpectedErrorDisplaysError() {
        Product product1 = new Product("APL101", "Red Apples (1 lb)", 2.99);
        when(viewMock.getIntInRange(anyString(), anyInt(), anyInt())).thenReturn(2).thenReturn(5);
        when(repoMock.getProduct(any())).thenReturn(product1);
        doThrow(new RuntimeException())
                .when(cartManagerMock)
                .addItem(any());
        // Act
        controller.run();
        // Assert
        verify(viewMock).displayMessage("An unexpected error occurred: java.lang.RuntimeException");
    }

    @Test
    void testRemoveItemDisplaysCartItems() {
        // Arrange
        when(viewMock.getIntInRange(anyString(), anyInt(), anyInt())).thenReturn(3).thenReturn(5);
        CartItem item1 = new CartItem(new Product("APL101", "Red Apples (1 lb)", 2.99), 5);
        CartItem item2 = new CartItem(new Product("BNN102", "Bananas (1 lb)", 1.29), 10);
        List<CartItem> items = new ArrayList<>(List.of(item1, item2));
        when(cartMock.getItem(any())).thenReturn(item1);
        when(cartManagerMock.getCartItems()).thenReturn(items);
        when(cartManagerMock.getCart()).thenReturn(cartMock);

        // Act
        controller.run();

        // Assert
        verify(viewMock).displayCart(items);
    }

    @Test
    void testRemoveItemRemovesItemWithIdAndQuantity() {
        String productId = "APL101";
        int quantity = 5;
        CartItem item1 = new CartItem(new Product(productId, "Red Apples (1 lb)", 2.99), quantity);
        when(viewMock.getIntInRange(anyString(), anyInt(), anyInt())).thenReturn(3).thenReturn(5);
        when(viewMock.getStringUpperCase(anyString())).thenReturn(productId);
        when(cartManagerMock.getCartItems()).thenReturn(new ArrayList<>(List.of(item1)));
        when(cartMock.getItem(any())).thenReturn(item1);
        when(cartManagerMock.getCart()).thenReturn(cartMock);

        // Act
        controller.run();

        // Assert
        verify(cartManagerMock).removeItem(productId, quantity);
    }

    @Test
    void testRemoveItemWithInvalidIdDisplaysError() {
        int quantity = 5;
        CartItem item1 = new CartItem(new Product("APL101", "Red Apples (1 lb)", 2.99), quantity);
        when(viewMock.getIntInRange(anyString(), anyInt(), anyInt())).thenReturn(3).thenReturn(5);
        when(viewMock.getStringUpperCase(anyString())).thenReturn("INVALID");
        when(cartManagerMock.getCartItems()).thenReturn(new ArrayList<>(List.of(item1)));
        when(cartMock.getItem(any())).thenThrow(InvalidProductIdException.class);
        when(cartManagerMock.getCart()).thenReturn(cartMock);

        // Act
        controller.run();

        // Assert
        verify(viewMock).displayMessage("Error: Invalid Product ID");
    }

    @Test
    void testRemoveItemWithUnexpectedExceptionDisplaysError() {
        int quantity = 5;
        CartItem item1 = new CartItem(new Product("APL101", "Red Apples (1 lb)", 2.99), quantity);
        when(viewMock.getIntInRange(anyString(), anyInt(), anyInt())).thenReturn(3).thenReturn(5);
        when(viewMock.getStringUpperCase(anyString())).thenReturn("APL101");
        when(cartManagerMock.getCartItems()).thenReturn(new ArrayList<>(List.of(item1)));
        when(cartMock.getItem(any())).thenThrow(RuntimeException.class);
        when(cartManagerMock.getCart()).thenReturn(cartMock);

        // Act
        controller.run();

        // Assert
        verify(viewMock).displayMessage("An unexpected error occurred: java.lang.RuntimeException");
    }

    @Test
    void testRemoveItemWithEmtpyCart() {
        when(viewMock.getIntInRange(anyString(), anyInt(), anyInt())).thenReturn(3).thenReturn(5);
        when(viewMock.getStringUpperCase(anyString())).thenReturn("APL101");
        when(cartManagerMock.getCartItems()).thenReturn(new ArrayList<>());

        // Act
        controller.run();

        // Assert
        verify(viewMock).displayMessage("Your cart is empty! There is nothing to remove");
    }

    @Test
    void testCheckoutFlow() {
        // Arrange
        double total = 27.85;
        when(viewMock.getIntInRange(anyString(), anyInt(), anyInt())).thenReturn(4).thenReturn(5);
        CartItem item1 = new CartItem(new Product("APL101", "Red Apples (1 lb)", 2.99), 5);
        CartItem item2 = new CartItem(new Product("BNN102", "Bananas (1 lb)", 1.29), 10);
        List<CartItem> items = new ArrayList<>(List.of(item1, item2));
        when(cartManagerMock.getCartItems()).thenReturn(items);
        when(cartManagerMock.getCart()).thenReturn(cartMock);
        when(checkoutMock.checkout(cartMock)).thenReturn(total);

        // Act
        controller.run();

        // Assert
        verify(viewMock).displayMessage("Checking out your cart");
        verify(viewMock).displayCart(items);
        verify(viewMock).displayMessage("Total: $27.85");
    }

    @Test
    void testCheckoutWithEmptyCart() {
        when(viewMock.getIntInRange(anyString(), anyInt(), anyInt())).thenReturn(4).thenReturn(5);
        when(cartManagerMock.getCartItems()).thenReturn(new ArrayList<>());

        // Act
        controller.run();

        // Assert
        verify(viewMock).displayMessage("Your cart is empty! There is nothing to checkout");
    }

    @Test
    void testExitDisplaysGoodbye() {
        //Arrange
        String expected = "Goodbye";
        when(viewMock.getIntInRange(anyString(), anyInt(), anyInt())).thenReturn(5);
        //Act
        controller.run();
        //Assert
        verify(viewMock).displayMessage(expected);
    }
}