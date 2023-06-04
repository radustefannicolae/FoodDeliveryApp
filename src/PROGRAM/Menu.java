package PROGRAM;

import java.util.List;

/**
 * Represents a menu that contains a list of items.
 */
public class Menu {
    private List<Item> items;

    /**
     * Constructs a new menu with the specified items.
     *
     * @param items the list of items in the menu
     */
    public Menu(List<Item> items) {
        this.items = items;
    }

    /**
     * Retrieves the list of items in the menu.
     *
     * @return the list of items in the menu
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Sets the list of items in the menu.
     *
     * @param items the list of items to set in the menu
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }
}
