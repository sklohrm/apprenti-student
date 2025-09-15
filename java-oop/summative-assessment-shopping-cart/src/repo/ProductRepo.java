package repo;

import exception.InvalidProductIdException;
import model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In-memory implementation of IProductRepo.
 */
public class ProductRepo implements IProductRepo {
    // A mapping of Product IDs to Product Objects.
    // Represents all Products available for purchase
    Map<String, Product> productMap;

    public ProductRepo() {
        this.productMap = new HashMap<>();
    }

    /**
     * Get all Products available for purchase
     *
     * @return A List of Products
     */
    public List<Product> getAllProducts() {
        return productMap.values().stream().toList();
    }

    /**
     * Gets a Product given its ID.
     * Throws an exception if the Product is not found
     *
     * @param id
     * @return A Product
     */
    public Product getProduct(String id) {
        Product product = productMap.get(id.toUpperCase());

        if (product == null) {
            throw new InvalidProductIdException(id);
        }
        return product;
    }

    /**
     * Add a new Product
     *
     * @param product
     */
    public void addProduct(Product product) {
        productMap.put(product.getId(), product);
    }
}
