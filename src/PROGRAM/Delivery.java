package PROGRAM;

public class Delivery {
    private int deliveryId;
    private String recipientName;
    private String address;

    /**
     * Constructs a new Delivery object with the specified delivery ID, recipient name, and address.
     *
     * @param deliveryId     the ID of the delivery
     * @param recipientName  the name of the recipient
     * @param address        the delivery address
     */
    public Delivery(int deliveryId, String recipientName, String address) {
        this.deliveryId = deliveryId;
        this.recipientName = recipientName;
        this.address = address;
    }

    /**
     * Returns the delivery ID.
     *
     * @return the delivery ID
     */
    public int getDeliveryId() {
        return deliveryId;
    }

    /**
     * Sets the delivery ID.
     *
     * @param deliveryId the delivery ID to set
     */
    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    /**
     * Returns the name of the recipient.
     *
     * @return the name of the recipient
     */
    public String getRecipientName() {
        return recipientName;
    }

    /**
     * Sets the name of the recipient.
     *
     * @param recipientName the name of the recipient to set
     */
    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    /**
     * Returns the delivery address.
     *
     * @return the delivery address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the delivery address.
     *
     * @param address the delivery address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
