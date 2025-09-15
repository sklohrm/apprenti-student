package repo;

import exception.InvalidProductIdException;
import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {
    ProductRepo repo;
    Product product1 = new Product("APL101", "Red Apples (1 lb)", 2.99);
    Product product2 = new Product("BNN102", "Bananas (1 lb)", 1.29);

    @BeforeEach
    void setUp() {
        repo = new ProductRepo();
    }

    @Test
    @DisplayName("Test getAllProducts returns all products")
    void testGetAllProducts() {
        //Arrange
        repo.addProduct(product1);
        repo.addProduct(product2);
        List<Product> expected = new ArrayList<>(List.of(product1, product2));
        //Act
        List<Product> actual = repo.getAllProducts();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test getProduct returns a product by ID")
    void testGetProduct() {
        //Arrange
        repo.addProduct(product1);
        Product expected = product1;
        //Act
        Product actual = repo.getProduct(product1.getId());
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test getProduct with invalid ID throws an exception")
    void testGetProductInvalidID() {
        //Arrange
        //Act & Assert
        assertThrows(InvalidProductIdException.class, () -> {
            repo.getProduct(product1.getId());
        });
    }

    @Test
    @DisplayName("Test addProduct adds a product to the repo")
    void testAddProduct() {
        //Arrange
        Product expected = product1;
        //Act
        repo.addProduct(product1);
        //Assert
        Product actual = repo.getProduct(product1.getId());
        assertEquals(expected, actual);
    }
}