package PROGRAM;

import java.util.List;

/**
 * Represents an order in the food delivery service.
 */
public class Order {
    private int orderNumber;
    private List<Item> items;
    private double totalPrice;

    /**
     * Constructs an Order object with the specified order number, items, and total price.
     *
     * @param orderNumber the order number
     * @param items       the list of items in the order
     * @param totalPrice the total price of the order
     */
    public Order(int orderNumber, List<Item> items, double totalPrice) {
        this.orderNumber = orderNumber;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    /**
     * Returns the order number.
     *
     * @return the order number
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets the order number.
     *
     * @param orderNumber the order number to set
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Returns the list of items in the order.
     *
     * @return the list of items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Sets the list of items in the order.
     *
     * @param items the list of items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Returns the total price of the order.
     *
     * @return the total price
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the total price of the order.
     *
     * @param totalPrice the total price to set
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
