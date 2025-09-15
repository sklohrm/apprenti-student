package repo;

import model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> getAllProducts();

    Product getProduct(String id);

    void addProduct(Product product);
}
