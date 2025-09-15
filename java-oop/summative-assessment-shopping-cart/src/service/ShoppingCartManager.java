package service;

import model.CartItem;
import model.ShoppingCart;

import java.util.List;
import java.util.Map;

/**
 * Manages operations on a <code>ShoppingCart</code>, such as adding and removing items.
 * <p>
 * This class provides logic for maintaining item quantities in the cart, ensuring that duplicate products are merged,
 * and invalid quantities are properly handles.
 */
public class ShoppingCartManager {

    ShoppingCart cart;

    /**
     * Constructs a new manager for the given shopping cart.
     *
     * @param cart the {@link ShoppingCart} instance to manage
     */
    public ShoppingCartManager(ShoppingCart cart) {
        this.cart = cart;
    }

    /**
     * Returns the shopping cart managed by this instance.
     *
     * @return the managed {@link ShoppingCart}
     */
    public ShoppingCart getCart() {
        return cart;
    }

    /**
     * Returns the cart items list
     *
     * @return the cart items
     */
    public List<CartItem> getCartItems() {
        return cart.getItems();
    }

    /**
     * Adds a <code>CartItem</code> to the shopping cart.
     * If an item with the same product ID already exists, its quantity is increased.
     * <p>
     * Throws ArithmeticException if the resulting quantity exceeds <code>Integer.MAX_VALUE</code>
     *
     * @param newItem the CartItem to add.
     * @throws ArithmeticException if the combined quantity exceeds <code>Integer.MAX_VALUE</code>
     */
    public void addItem(CartItem newItem) {
        Map<String, CartItem> cartItems = cart.getCartItems();
        String newItemProductId = newItem.getProduct().getId();

        if (cartItems.containsKey(newItemProductId)) {
            CartItem existingItem = cartItems.get(newItemProductId);
            int currentQuantity = existingItem.getQuantity();
            int addedQuantity = newItem.getQuantity();

            if (currentQuantity > Integer.MAX_VALUE - addedQuantity) {
                throw new ArithmeticException();
            } else {
                existingItem.setQuantity(currentQuantity + addedQuantity);
            }
        } else {
            cartItems.put(newItemProductId, newItem);
        }
    }

    /**
     * Removes the specified quantity of a product from the shopping cart.
     * <p>
     * If the resulting quantity is zero or less, the <code>CartItem</code> is removed from the cart.
     *
     * @param productId The ID of the product to remove
     * @param quantity  The quantity to remove
     */
    public void removeItem(String productId, int quantity) {
        Map<String, CartItem> cartItems = cart.getCartItems();
        if (cartItems.containsKey(productId)) {
            CartItem existingItem = cartItems.get(productId);
            int updatedQuantity = existingItem.getQuantity() - quantity;

            if (updatedQuantity > 0) {
                existingItem.setQuantity(updatedQuantity);
            } else {
                cartItems.remove(productId);
            }
        }
    }


}
