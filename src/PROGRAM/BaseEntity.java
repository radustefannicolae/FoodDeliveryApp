package PROGRAM;

/**
 * The base entity class representing an entity with an ID.
 */
public abstract class BaseEntity {
    private int id;

    /**
     * Constructs a BaseEntity object with the specified ID.
     *
     * @param id the ID of the BaseEntity
     */
    public BaseEntity(int id) {
        this.id = id;
    }

    /**
     * Returns the ID of the BaseEntity.
     *
     * @return the ID of the BaseEntity
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the BaseEntity.
     *
     * @param id the ID of the BaseEntity
     */
    public void setId(int id) {
        this.id = id;
    }
}
