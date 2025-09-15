package model;

/**
 * A Product that can be added to the <code>ShoppingCart</code> and processed by <code>ShoppingCartService.checkout()</code>
 */
public class Product {
    private String id;
    private String name;
    private double price;

    /**
     * Constructs a new Product with the given ID, name, and price.
     *
     * @param id    the unique identifier for the product
     * @param name  the name of the product
     * @param price the price of the product (must be a positive number)
     * @throws IllegalArgumentException if <code>price</code> is negative.
     */
    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        setPrice(price);
    }

    // Getters

    /**
     * Returns the ID of this product.
     *
     * @return the product ID
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name of this product.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of this product.
     *
     * @return the product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of this product.
     * <p>
     * Throws an <code>IllegalArgumentException</code> if a negative price is provided.
     *
     * @param price price for the product
     * @throws IllegalArgumentException if <code>price</code> is negative
     */
    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must not be negative.");
        }
        this.price = price;
    }

    /**
     * Returns a string representation of the product.
     * <p>
     * Example output:
     * <p>
     * <code>ID: APL101 | Name: Red Apples (1 lb) | Price: $2.99</code>
     *
     * @return formatted string with product ID, name, and price
     */
    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Price: $%.2f", id, name, price);
    }
}
