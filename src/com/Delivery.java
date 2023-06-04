package com;

public class Delivery {
    private int deliveryId;
    private String recipientName;
    private String address;

    public Delivery(int deliveryId, String recipientName, String address) {
        this.deliveryId = deliveryId;
        this.recipientName = recipientName;
        this.address = address;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
