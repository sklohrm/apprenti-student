package controller.factory;

import controller.ShoppingCartController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartControllerFactoryTest {

    @Test
    void testCreateCreatesShoppingCartControllerWithDependencies() {
        // Arrange
        // Act
        ShoppingCartController controller = ShoppingCartControllerFactory.create();
        // Assert
        assertInstanceOf(ShoppingCartController.class, controller);
    }
}