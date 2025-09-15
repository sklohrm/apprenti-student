package controller;

import controller.config.ShoppingCartControllerConfig;
import exception.InvalidProductIdException;
import model.CartItem;
import model.Product;
import repo.IProductRepo;
import service.CheckoutService;
import service.ShoppingCartManager;
import view.AppView;

import java.util.List;
import java.util.function.Supplier;

/**
 * Controller class for managing the shopping cart application.
 */
public class ShoppingCartController {

    private IProductRepo productRepo;
    private AppView appView;
    private ShoppingCartManager shoppingCartManager;
    private CheckoutService checkoutService;

    /**
     * Constructs a <code>ShoppingCartController</code> using the provided configuration object.
     *
     * @param config the configuration object containing dependencies required by this controller
     */
    public ShoppingCartController(ShoppingCartControllerConfig config) {
        this.productRepo = config.getProductRepo();
        this.appView = config.getAppView();
        this.shoppingCartManager = config.getShoppingCart();
        this.checkoutService = config.getCheckoutService();
    }

    /**
     * Runs the main application loop.
     * <p>
     * Displays welcome message, then repeatedly displays main menu and handles user input until
     * the user chooses to exit.
     */
    public void run() {

        appView.displayMessage("Welcome to the Shopping Cart App");
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = appView.getIntInRange("Select an option", 1, 5);

            switch (choice) {
                case 1:
                    displayCart();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    removeItem();
                    break;
                case 4:
                    checkout();
                    break;
                case 5:
                    exit = true;
                    break;
            }
        }
        appView.displayMessage("Goodbye");
    }

    /**
     * Displays the current contents of the shopping cart.
     */
    public void displayCart() {
        appView.displayCart(shoppingCartManager.getCart().getItems());
    }

    /**
     * Adds an item to the shopping cart.
     * <p>
     * Displays available products, prompts for ID and quantity, validates ID, and adds item to the cart.
     * Throws an error if the ID or quantity are invalid.
     */
    public void addItem() {
        List<Product> products = productRepo.getAllProducts();
        appView.displayProducts(products);

        String id = appView.getStringUpperCase("Enter the ID of the Product you would like to add");
        Product product = handleProductOperation(() -> productRepo.getProduct(id));
        if (product == null) return;

        int quantity = appView.getPositiveInt("Enter the quantity you would like to add");

        CartItem cartItem = new CartItem(product, quantity);
        try {
            shoppingCartManager.addItem(cartItem);
        } catch (ArithmeticException e) {
            appView.displayMessage("Error: Quantity limit exceeded");
            return;
        } catch (Exception e) {
            appView.displayMessage("An unexpected error occurred: " + e);
            return;
        }

        appView.displayformattedQuantityMessage("Added", quantity, cartItem.getProduct().getName());
    }

    /**
     * Removes an item from the shopping cart.
     * <p>
     * Displays the cart contents, prompts the user for product ID and quantity, and removes the specified quantity
     * of the product from the cart. If the resulting quantity is 0 or less, the product is removed from the list.
     */
    public void removeItem() {
        if (!validateCartNotEmpty("remove")) return;

        List<CartItem> cartItems = shoppingCartManager.getCartItems();
        appView.displayCart(cartItems);

        String id = appView.getStringUpperCase("Enter the ID of the Product you would like to remove");

        CartItem cartItem = handleProductOperation(() -> shoppingCartManager.getCart().getItem(id));
        if (cartItem == null) return;

        int quantity = appView.getIntInRange("Enter the quantity you would like to remove", 1, cartItem.getQuantity());

        shoppingCartManager.removeItem(id, quantity);
        appView.displayformattedQuantityMessage("Removed", quantity, cartItem.getProduct().getName());
    }

    /**
     * Performs the checkout process.
     * <p>
     * Displays the contents of the cart, calculates and displays the total cost, and empties the cart.
     */
    public void checkout() {
        if (!validateCartNotEmpty("checkout")) return;

        List<CartItem> cartItems = shoppingCartManager.getCartItems();
        appView.displayMessage("Checking out your cart");
        appView.displayCart(cartItems);
        double total = checkoutService.checkout(shoppingCartManager.getCart());
        appView.displayMessage(String.format("Total: $%,.2f", total));
        appView.displayMessage("Clearing cart contents");
    }

    /**
     * Displays the main application options to the user.
     */
    public void displayMenu() {
        appView.displayMessage("Main Menu");
        appView.displayMessage("1. Display Cart");
        appView.displayMessage("2. Add an Item");
        appView.displayMessage("3. Remove an Item");
        appView.displayMessage("4. Checkout");
        appView.displayMessage("5. Exit");
    }

    /**
     * Executes a product-related operation with standardized exception handling.
     * <p>
     * This method wraps operations that may throw InvalidProductIdException or other exceptions,
     * providing consistent error messaging to the user. If an exception occurs, an appropriate
     * error message is displayed and null is returned.
     *
     * @param <T> the return type of the operation
     * @param operation a Supplier that performs the product operation
     * @return the result of the operation, or null if an exception occurred
     */
    private <T> T handleProductOperation(Supplier<T> operation) {
        try {
            return operation.get();
        } catch (InvalidProductIdException e) {
            appView.displayMessage("Error: Invalid Product ID");
            return null;
        } catch (Exception e) {
            appView.displayMessage("An unexpected error occurred: " + e);
            return null;
        }
    }

    /**
     * Validates that the shopping cart contains at least one item.
     * <p>
     * If the cart is empty, displays an appropriate error message to the user
     * indicating that the specified operation cannot be performed.
     *
     * @param operationName the name of the operation being attempted (e.g., "remove", "checkout")
     * @return true if the cart contains items, false if the cart is empty
     */
    private boolean validateCartNotEmpty(String operationName) {
        List<CartItem> cartItems = shoppingCartManager.getCartItems();
        if (cartItems.isEmpty()) {
            appView.displayMessage("Your cart is empty! There is nothing to " + operationName);
            return false;
        }
        return true;
    }
}
