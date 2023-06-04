package PROGRAM;

public class Item {
    private String name;
    private double price;

    /**
     * Constructs an Item object with the specified name and price.
     *
     * @param name  The name of the item.
     * @param price The price of the item.
     */
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the item.
     *
     * @param name The new name of the item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the price of the item.
     *
     * @return The price of the item.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the item.
     *
     * @param price The new price of the item.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
