package PROGRAM;

/**
 * Exception thrown when an order is not found.
 */
public class OrderNotFoundException extends Exception {
    private int orderNumber;

    /**
     * Constructs a new OrderNotFoundException with the specified order number.
     *
     * @param orderNumber the order number that was not found
     */
    public OrderNotFoundException(int orderNumber) {
        super("Order not found with number: " + orderNumber);
        this.orderNumber = orderNumber;
    }

    /**
     * Retrieves the order number associated with this exception.
     *
     * @return the order number that was not found
     */
    public int getOrderNumber() {
        return orderNumber;
    }
}
