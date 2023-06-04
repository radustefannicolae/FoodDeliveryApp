package PROGRAM;

/**
 * Exception thrown when a delivery is not found.
 */
public class DeliveryException extends Exception {
    private int deliveryId;

    /**
     * Constructs a DeliveryException object with the specified delivery ID.
     *
     * @param deliveryId the ID of the delivery not found
     */
    public DeliveryException(int deliveryId) {
        super("Delivery not found with ID: " + deliveryId);
        this.deliveryId = deliveryId;
    }

    /**
     * Returns the ID of the delivery not found.
     *
     * @return the ID of the delivery not found
     */
    public int getDeliveryId() {
        return deliveryId;
    }
}
