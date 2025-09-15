package repo.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repo.ProductRepo;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoFactoryTest {

    @Test
    @DisplayName("Test instance() returns a ProductRepo with more than one Product")
    void testInstanceHasMoreThanOneProduct() {
        //Arrange
        ProductRepo repo = ProductRepoFactory.instance();
        //Act
        int product_count = repo.getAllProducts().size();
        //Assert
        assertNotEquals(0, product_count);
    }

    @Test
    @DisplayName("Test calling instance() more than once returns the same instance")
    void testInstanceIsSingleton() {
        //Arrange
        //Act
        ProductRepo repo1 = ProductRepoFactory.instance();
        ProductRepo repo2 = ProductRepoFactory.instance();
        //Assert
        assertEquals(repo1, repo2);
    }
}