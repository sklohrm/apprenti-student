package org.example;

import java.util.List;

public class OrderManager {

    private Order order;

    public double orderTotal(Order order) {
        double orderSum = 0.0;

        for (Item i: order.getItems()) {
            orderSum += i.getPrice();
        }

        orderSum = orderSum - (orderSum * order.getDiscountRate());

        orderSum += orderSum * order.getTaxRate();

        return orderSum;
    }
}
