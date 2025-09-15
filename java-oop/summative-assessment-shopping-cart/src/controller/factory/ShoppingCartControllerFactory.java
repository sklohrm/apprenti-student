package controller.factory;

import controller.ShoppingCartController;
import controller.config.ShoppingCartControllerConfig;
import model.ShoppingCart;
import repo.factory.ProductRepoFactory;
import service.CheckoutService;
import service.ShoppingCartManager;
import view.AppView;
import view.ConsoleIO;

import java.util.Scanner;

/**
 * Factory class for creating fully configured instances of <code>ShoppingCartController</code>
 * <p>
 *     This factory encapsulates the wiring of the product repository, view layer, shopping cart manager,
 *     and checkout service.
 * </p>
 */
public class ShoppingCartControllerFactory {

    /**
     * <p> The following dependencies are provided:
     *     <ul>
     *         <li>{@link repo.IProductRepo}</li>
     *         <li>{@link AppView}</li>
     *         <li>{@link ShoppingCartManager}</li>
     *         <li>{@link CheckoutService}</li>
     *     </ul>
     * </p>
     * @return a fully configured <code>ShoppingCartController</code>
     */
    public static ShoppingCartController create() {
        // Configuration class to hold dependencies
        ShoppingCartControllerConfig controllerConfig = new ShoppingCartControllerConfig();

        // Initialize and set dependencies
        controllerConfig.setProductRepo(ProductRepoFactory.instance());
        controllerConfig.setAppView(new AppView(new ConsoleIO(new Scanner(System.in))));
        controllerConfig.setShoppingCart(new ShoppingCartManager(new ShoppingCart()));
        controllerConfig.setCheckoutService(new CheckoutService());

        // Declare and instantiate controller with configuration object
        ShoppingCartController controller = new ShoppingCartController(controllerConfig);

        return controller;
    }
}
