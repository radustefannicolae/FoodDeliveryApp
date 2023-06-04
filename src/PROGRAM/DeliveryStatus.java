/**
 * Represents the status of a delivery in a food delivery service.
 */
public enum DeliveryStatus {
    /**
     * The delivery is pending and has not yet started.
     */
    PENDING,

    /**
     * The delivery is in progress and is currently being carried out.
     */
    IN_PROGRESS,

    /**
     * The delivery has been completed successfully.
     */
    COMPLETED,

    /**
     * The delivery has been canceled.
     */
    CANCELED
}
