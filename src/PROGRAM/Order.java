package PROGRAM;

import java.util.List;

public class Order extends BaseEntity {
    private int orderNumber;
    private List<Item> items;
    private double totalPrice;

    // Constructor, getters, and setters
    // ...
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
