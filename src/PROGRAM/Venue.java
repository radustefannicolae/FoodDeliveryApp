package PROGRAM;

public class Venue {
    private String name;
    private String address;
    private Menu menu;

    /**
     * Constructs a Venue object with the specified name and address.
     *
     * @param name    The name of the venue.
     * @param address The address of the venue.
     */
    public Venue(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Returns the name of the venue.
     *
     * @return The name of the venue.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the venue.
     *
     * @param name The new name of the venue.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the address of the venue.
     *
     * @return The address of the venue.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the venue.
     *
     * @param address The new address of the venue.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the menu of the venue.
     *
     * @return The menu of the venue.
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * Sets the menu of the venue.
     *
     * @param menu The new menu of the venue.
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
