package view;

import static org.mockito.Mockito.*;

import model.CartItem;
import model.Product;
import model.ShoppingCart;
import service.ShoppingCartManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppViewTest {

    AppView view;
    ConsoleIO ioMock;

    @BeforeEach
    void setUp() {
        ioMock = mock(ConsoleIO.class);
        view = new AppView(ioMock);
    }

    @Test
    void displayMessage() {
        view.displayMessage("Test Message");
        verify(ioMock).print("Test Message");
    }

    @Test
    void testDisplayProductsDisplaysProducts() {
        //Arrange
        Product product1 = new Product("APL101", "Red Apples (1 lb)", 2.99);
        Product product2 = new Product("BNN102", "Bananas (1 lb)", 1.29);
        List<Product> products = new ArrayList<>(List.of(product1, product2));
        //Act
        view.displayProducts(products);
        //Assert
        verify(ioMock).print("=========================Inventory=========================");
        verify(ioMock).print("ID: APL101 | Name: Red Apples (1 lb)         | Price: $2.99");
        verify(ioMock).print("ID: BNN102 | Name: Bananas (1 lb)            | Price: $1.29");
    }

    @Test
    void testDisplayCartDisplaysCart() {
        CartItem item1 = new CartItem(new Product("APL101", "Red Apples (1 lb)", 2.99), 5);
        CartItem item2 = new CartItem(new Product("BNN102", "Bananas (1 lb)", 1.29), 10);
        ShoppingCart cart = new ShoppingCart();
        ShoppingCartManager cartManager = new ShoppingCartManager(cart);
        cartManager.addItem(item1);
        cartManager.addItem(item2);

        //Act
        view.displayCart(cart.getItems());
        //Assert
        verify(ioMock).print("===================================Cart Contents=====================================");
        verify(ioMock).print("ID: APL101 | Name: Red Apples (1 lb)         | Price: $2.99 | Quantity:             5");
        verify(ioMock).print("ID: BNN102 | Name: Bananas (1 lb)            | Price: $1.29 | Quantity:            10");
    }

    @Test
    void testDisplayEmptyCart() {
        ShoppingCart cart = new ShoppingCart();

        //Act
        view.displayCart(cart.getItems());
        //Assert
        verify(ioMock).print("Your cart is empty.");
    }

    @Test
    void testPromptPrintsMessageWithColon() {
        //Act
        view.prompt("Test Prompt");
        //Assert
        verify(ioMock).print("Test Prompt: ");
    }

    @Test
    void testGetStringPromptsMessageAndReturnsInput() {
        //Arrange
        String input = "Test Input";
        when(ioMock.getInput()).thenReturn(input);
        //Act
        String output = view.getString("Enter a value");
        //Assert
        assertEquals(input, output);
    }

    @Test
    void testGetStringUpperCaseReturnsUppercasedInput() {
        //Arrange
        String input = "Test Input";
        when(ioMock.getInput()).thenReturn(input);
        //Act
        String output = view.getStringUpperCase("Enter a value");
        //Assert
        assertEquals(input.toUpperCase(), output);
    }

    @Test
    void testGetIntValidInput() {
        //Arrange
        String input = "99";
        when(ioMock.getInput()).thenReturn(input);
        //Act
        int output = view.getInt("Enter a Number");
        //Assert
        assertEquals(99, output);
    }

    @Test
    void testGetIntInValidInput() {
        //Arrange
        String invalidInput = "hi";
        String validInput = "2";
        when(ioMock.getInput()).thenReturn(invalidInput).thenReturn(validInput);
        //Act
        int output = view.getInt("Enter a Number");
        //Assert
        assertEquals(2, output);
    }


    @Test
    void testGetIntInRangeWithIntInRange() {
        //Arrange
        String input = "5";
        when(ioMock.getInput()).thenReturn(input);
        //Act
        int output = view.getIntInRange("Enter a Number", 1, 5);
        //Assert
        assertEquals(5, output);
    }

    @Test
    void testGetIntInRangeWithIntTooSmall() {
        //Arrange
        String invalidInput = "0";
        String validInput = "2";
        when(ioMock.getInput()).thenReturn(invalidInput).thenReturn(validInput);
        //Act
        int output = view.getIntInRange("Enter a Number", 1, 5);
        //Assert
        assertEquals(2, output);
    }

    @Test
    void testGetIntInRangeWithIntTooBig() {
        //Arrange
        String invalidInput = "10";
        String validInput = "3";
        when(ioMock.getInput()).thenReturn(invalidInput).thenReturn(validInput);
        //Act
        int output = view.getIntInRange("Enter a Number", 1, 5);
        //Assert
        assertEquals(3, output);
    }

    @Test
    void testGetIntInRangeWithCustomError() {
        //Arrange
        String invalidInput = "0";
        String validInput = "2";
        when(ioMock.getInput()).thenReturn(invalidInput).thenReturn(validInput);
        String customError = "Custom Error Message";
        //Act
        int output = view.getIntInRange("Enter a Number", 1, 5, customError);
        //Assert
        verify(ioMock).print(customError);
    }

    @Test
    void testGetPositiveIntValidInput() {
        //Arrange
        String input = "2";
        when(ioMock.getInput()).thenReturn(input);
        //Act
        int output = view.getPositiveInt("Enter a Number");
        //Assert
        assertEquals(2, output);
    }

    @Test
    void testGetPositiveIntNegative() {
        //Arrange
        String invalidInput = "-1";
        String validInput = "2";
        when(ioMock.getInput()).thenReturn(invalidInput).thenReturn(validInput);
        //Act
        int output = view.getPositiveInt("Enter a Positive Number");
        //Assert
        assertEquals(2, output);
    }

    @Test
    void testGetPositiveIntZero() {
        //Arrange
        String invalidInput = "0";
        String validInput = "2";
        when(ioMock.getInput()).thenReturn(invalidInput).thenReturn(validInput);
        //Act
        int output = view.getPositiveInt("Enter a Positive Number");
        //Assert
        assertEquals(2, output);
    }

    @Test
    void testGetIntTooLarge() {
        //Arrange
        String invalidInput = "5000000000";
        String validInput = "2";
        when(ioMock.getInput()).thenReturn(invalidInput).thenReturn(validInput);
        //Act
        int output = view.getInt("Enter a number:");
        //Assert

        verify(ioMock).print("ERROR: Number is too large or too small.");
        assertEquals(2, output);
    }

    @Test
    void testGetIntTooSmall() {
        //Arrange
        String invalidInput = "-5000000000";
        String validInput = "-2";
        when(ioMock.getInput()).thenReturn(invalidInput).thenReturn(validInput);
        //Act
        int output = view.getInt("Enter a number:");
        //Assert

        verify(ioMock).print("ERROR: Number is too large or too small.");
        assertEquals(-2, output);
    }

    @Test
    void testDisplayFormattedQuantityMessage() {
        // Arrange
        String action = "Added";
        int quantity = 10;
        String productName = "Sandals";
        // Act
        view.displayformattedQuantityMessage(action, quantity, productName);
        // Assert
        verify(ioMock).print("Added x10 Sandals");
    }
}