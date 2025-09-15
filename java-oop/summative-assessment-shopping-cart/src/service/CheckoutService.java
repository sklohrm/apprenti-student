package service;

import model.CartItem;
import model.ShoppingCart;

import java.util.List;

/**
 * Service class responsible for handling checkout operations.
 * <p>
 * This service calculates the total cost of items in a <code>ShoppingCart</code> and clears the cart once checkout
 * is complete.
 */
public class CheckoutService {

    /**
     * Completes the checkout process for the given shopping cart.
     * <p>
     * This method calculates the price of all items in the card using {@link #calculateTotal(List)}, then clears the
     * cart to finalize the purchase.
     *
     * @param cart the <code>ShoppingCart</code> to check out
     * @return the total cost of all items in the cart
     */
    public double checkout(ShoppingCart cart) {
        double total = calculateTotal(cart.getItems());
        cart.clearItems();
        return total;
    }

    /**
     * Calculates the total price of a list of cart items.
     *
     * @param cartItems the list of {@link CartItem} objects to calculate
     * @return the total price of the given items
     */
    public double calculateTotal(List<CartItem> cartItems) {
        double total = 0.0;
        for (CartItem cartItem : cartItems) {
            total += cartItem.getProduct().getPrice() * cartItem.getQuantity();
        }
        return total;
    }


}
