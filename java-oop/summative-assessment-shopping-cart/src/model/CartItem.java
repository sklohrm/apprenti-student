package model;

/**
 * Represents an item in a <code>ShoppingCart</code>. Contains a <code>Product</code>
 * and a quantity.
 */
public class CartItem {

    private Product product;
    private int quantity;

    /**
     * Constructs a new CartItem with the given product and quantity.
     *
     * @param product  the product to add to the cart
     * @param quantity the quantity of the product (must be non-negative)
     * @throws IllegalArgumentException if <code>quantity</code> is negative
     */
    public CartItem(Product product, int quantity) {
        this.product = product;
        setQuantity(quantity);
    }

    /**
     * Returns the product associated with this cart item.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Returns the quantity of the product associated with this cart item.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity for this cart item
     * <p>
     * Quantity must be non-negative. Attempting to set a negative quantity will throw
     * an <code>IllegalArgumentException</code>.
     *
     * @param quantity the new quantity
     * @throws IllegalArgumentException if <code>quantity</code> is negative
     */
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }

    /**
     * Returns a string represntation of this cart item, including the product information and quantity.
     * <p>
     * Example output:
     * <code>ID: APL101 | Name: Red Apples (1 lb) | Price: $2.99 | Quantity: 5</code>
     *
     * @return formatted string with product details and quantity
     */
    @Override
    public String toString() {
        return product.toString() + " | Quantity: " + String.format("%,d", quantity);
    }
}
