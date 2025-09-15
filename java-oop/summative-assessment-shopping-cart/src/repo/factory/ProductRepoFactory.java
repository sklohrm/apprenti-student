package repo.factory;

import model.Product;
import repo.ProductRepo;

/**
 * Populates an in-memory implementation of IProductRepo
 */
public class ProductRepoFactory {

    private static ProductRepo instance = null;

    /**
     * Create or return an instance of ProductRepo
     *
     * @return The ProductRepo singleton
     */
    public static ProductRepo instance() {
        if (instance == null) {
            instance = new ProductRepo();
            instance.addProduct(new Product("APL101", "Red Apples (1 lb)", 2.99));
            instance.addProduct(new Product("BNN102", "Bananas (1 lb)", 1.29));
            instance.addProduct(new Product("MLK201", "Whole Milk (1 gal)", 3.79));
            instance.addProduct(new Product("BRD202", "Sliced Bread", 2.49));
            instance.addProduct(new Product("EGG203", "Large Eggs (12 ct)", 3.19));
            instance.addProduct(new Product("CHS301", "Cheddar Cheese (8 oz)", 4.49));
            instance.addProduct(new Product("RCE302", "White Rice (2 lb)", 5.29));
            instance.addProduct(new Product("PST303", "Spaghetti Pasta (16 oz)", 1.99));
            instance.addProduct(new Product("CKN401", "Chicken Breast (1 lb)", 6.49));
            instance.addProduct(new Product("BFC402", "Ground Beef (1 lb)", 7.29));
        }
        return instance;
    }
}
