package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineBin {
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void loadProduct(Product product) {
        products.add(product);
    }

    // I chose to leave the .get(1) at one because it seems like from the other project that they intend
    // to keep the first one in the list to show what type of product belong in there. I know that this
    // App lets you put in products with different names, so you could just change the .get() to 0 and
    // and have the same outcome.
    public Product vendProduct() {
        Product result = null;
        try {
            result = products.get(1);
            products.remove(1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Bin is empty");
        }

        return result;
    }
}
