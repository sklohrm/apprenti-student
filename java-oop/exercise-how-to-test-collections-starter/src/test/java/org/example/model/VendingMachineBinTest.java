package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class VendingMachineBinTest {

    VendingMachineBin vmb;
    Product apple;

    @BeforeEach
    void setup() {
        vmb = new VendingMachineBin();

        Product apple = new Product();
        apple.setItemName("Apple");
        apple.setPrice(.25);

        vmb.loadProduct(apple);
        vmb.loadProduct(Product.clone(apple));
        vmb.loadProduct(Product.clone(apple));
        vmb.loadProduct(Product.clone(apple));
        vmb.loadProduct(Product.clone(apple));
    }

    @Test
    void vendProduct() {
        // Arrange
        Product expected;

        // Act
        vmb.vendProduct();
        vmb.vendProduct();
        vmb.vendProduct();
        vmb.vendProduct();
        expected = vmb.vendProduct();

        // Assert
        assertNull(expected);
    }
}