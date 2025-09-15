package controller.config;

import repo.IProductRepo;
import service.CheckoutService;
import service.ShoppingCartManager;
import view.AppView;

/**
 * Configuration class for <code>controller.ShoppingCartController</code>.
 * <p>
 * This class acts as a container for all the dependencies required by the <code>ShoppingCartController</code>.
 *
 */
public class ShoppingCartControllerConfig {

    private IProductRepo productRepo;
    private AppView appView;
    private ShoppingCartManager shoppingCart;
    private CheckoutService checkoutService;

    /**
     * Creates an empty <code>ShoppingCartControllerConfig</code>
     * <p>
     *     Dependencies should be provided using the setter methods before passing this configuration to
     *     a <code>ShoppingCartController</code>
     * </p>
     */
    public ShoppingCartControllerConfig() {
    }

    /**
     * Returns the configured <code>IProductRepo</code>
     *
     * @return the product repository
     */
    public IProductRepo getProductRepo() {
        return productRepo;
    }

    /**
     * Sets the <code>IProductRepo</code> dependency.
     *
     * @param productRepo the product repository to set
     */
    public void setProductRepo(IProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    /**
     * Returns the configured <code>AppView</code>.
     *
     * @return the application view
     */
    public AppView getAppView() {
        return appView;
    }

    /**
     * Sets the <code>AppView</code> dependency.
     *
     * @param appView the application view to set
     */
    public void setAppView(AppView appView) {
        this.appView = appView;
    }

    /**
     * Returns the configured <code>ShoppingCartManager</code>.
     *
     * @return the shopping cart manager
     */
    public ShoppingCartManager getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Sets the <code>ShoppingCartManager</code> dependency.
     *
     * @param shoppingCart the shopping cart manager to set
     */
    public void setShoppingCart(ShoppingCartManager shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * Returns the configured <code>CheckoutService</code>.
     *
     * @return the checkout service
     */
    public CheckoutService getCheckoutService() {
        return checkoutService;
    }

    /**
     * Sets the <code>CheckoutService</code> dependency.
     *
     * @param checkoutService the checkout service to set
     */
    public void setCheckoutService(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }
}
