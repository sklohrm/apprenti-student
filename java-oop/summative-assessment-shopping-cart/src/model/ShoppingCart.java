package model;

import exception.InvalidProductIdException;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A shopping cart that holds <code>CartItem</code>.
 * Allows adding, removing, retrieving, and clearing items.
 */
public class ShoppingCart {

    private Map<String, CartItem> cartItems;

    /**
     * Constructs an empty ShoppingCart.
     */
    public ShoppingCart() {
        this.cartItems = new HashMap<>();
    }

    /**
     * Retrieves all items currently in the shopping cart.
     *
     * @return the map of product IDs to <code>CartItem</code> objects in the cart
     */
    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    /**
     * Retrieves a <code>CartItem</code> from the cart by its product ID.
     *
     * @param id the product ID to look up
     * @return the <code>CartItem</code> associated with the given product ID
     * @throws exception.InvalidProductIdException if no cart item exists for the given product ID
     */
    public CartItem getItem(String id) {
        CartItem cartItem = cartItems.get(id.toUpperCase());

        if (cartItem == null) {
            throw new InvalidProductIdException(id);
        }
        return cartItem;
    }

    /**
     * Returns a list of all CartItems currently in the shopping cart.
     *
     * @return a List of <code>CartItem</code>
     */
    public List<CartItem> getItems() {
        return cartItems.values().stream().toList();
    }

    /**
     * Clears all items from the shopping cart.
     */
    public void clearItems() {
        cartItems.clear();
    }
}
