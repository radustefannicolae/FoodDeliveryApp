package PROGRAM;

import java.util.concurrent.atomic.AtomicReference;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
/**
 * The FoodDeliveryService class manages the operations and data related to food delivery services.
 */
public class FoodDeliveryService {
    private static final String VENUES_CSV_FILE = "D:\\WORK\\INFO_TITU\\AN II\\MAP\\project\\src\\CSV\\venues.csv";
    private static final String ORDERS_CSV_FILE = "D:\\WORK\\INFO_TITU\\AN II\\MAP\\project\\src\\CSV\\orders.csv";
    private static final String DELIVERIES_CSV_FILE = "D:\\WORK\\INFO_TITU\\AN II\\MAP\\project\\src\\CSV\\deliveries.csv";
    private static final String USERS_CSV_FILE = "D:\\WORK\\INFO_TITU\\AN II\\MAP\\project\\src\\CSV\\users.csv";
    private static final String AUDIT_LOG_CSV_FILE = "D:\\WORK\\INFO_TITU\\AN II\\MAP\\project\\src\\CSV\\audit_log.csv";
    private static FoodDeliveryService instance = null;
    private List<Venue> venues;
    private List<Order> orders;
    private List<Delivery> deliveries;
    private List<User> users;
    private static String name; // Declare the 'name' variable
    private static String address; // Declare the 'address' variable

    // Methods for managing venues, orders, deliveries, and users
    // ...

    /**
     * Retrieves the singleton instance of the FoodDeliveryService.
     *
     * @param venues     The list of venues.
     * @param orders     The list of orders.
     * @param deliveries The list of deliveries.
     * @param users      The list of users.
     * @return The FoodDeliveryService instance.
     */
    public static FoodDeliveryService getInstance(List<Venue> venues, List<Order> orders, List<Delivery> deliveries, List<User> users) {
        if (instance == null) {
            instance = new FoodDeliveryService(venues, orders, deliveries, users);
        }
        return instance;
    }

    /**
     * Constructs a new FoodDeliveryService instance with the specified lists of venues, orders, deliveries, and users.
     *
     * @param venues     The list of venues.
     * @param orders     The list of orders.
     * @param deliveries The list of deliveries.
     * @param users      The list of users.
     */
    private FoodDeliveryService(List<Venue> venues, List<Order> orders, List<Delivery> deliveries, List<User> users) {
        this.deliveries = deliveries;
        this.venues = venues;
        this.orders = orders;
        this.users = users;
    }

    /**
     * Retrieves the list of venues.
     *
     * @return The list of venues.
     */
    public List<Venue> getVenues() {
        return venues;
    }

    /**
     * Sets the list of venues.
     *
     * @param venues The list of venues.
     */
    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

    /**
     * Retrieves the list of orders.
     *
     * @return The list of orders.
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Sets the list of orders.
     *
     * @param orders The list of orders.
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    /**
     * Retrieves the list of deliveries.
     *
     * @return The list of deliveries.
     */

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    /**
     * Sets the list of deliveries.
     *
     * @param deliveries The list of deliveries.
     */
    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    /**
     * Retrieves the list of users.
     *
     * @return The list of users.
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Sets the list of users.
     *
     * @param users The list of users.
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    // Example method for placing an order
    public void placeOrder(Order order) {
        // Logic for placing an order
        // ...
    }

    /**
     * Loads the initial data for the FoodDeliveryService from the CSV files.
     *
     * @param service    The FoodDeliveryService instance.
     * @param users      The list of users.
     * @param venues     The list of venues.
     * @param orders     The list of orders.
     * @param deliveries The list of deliveries.
     */
    public static void loadInitialData(FoodDeliveryService service, List<User> users, List<Venue> venues, List<Order> orders, List<Delivery> deliveries) {
        readUsersFromCsv(users);
        readVenuesFromCsv(venues);
        readDeliveriesFromCsv(deliveries);
        readOrdersFromCsv(orders);
    }

    /**
     * Reads the venue data from the CSV file and populates the venues list.
     *
     * @param venues The list of venues.
     */
    public static void readVenuesFromCsv(List<Venue> venues) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(VENUES_CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String address = data[1];
                Venue venue = new Venue(name, address);
                venues.add(venue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the venues data from the list to the CSV file.
     *
     * @param venues The list of venues.
     */
    public static void saveVenuesToCsv(List<Venue> venues) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(VENUES_CSV_FILE))) {
            for (Venue venue : venues) {
                String line = String.join(",", venue.getName(), venue.getAddress());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the order data from the CSV file and populates the orders list.
     *
     * @param orders The list of orders.
     */
    public static void readOrdersFromCsv(List<Order> orders) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(ORDERS_CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int orderNumber = Integer.parseInt(data[0]);
                List<Item> items = new ArrayList<>();
                String[] itemData = data[1].split(";");
                for (String item : itemData) {
                    String[] itemInfo = item.split(":");
                    String itemName = itemInfo[0];
                    double itemPrice = Double.parseDouble(itemInfo[1]);
                    Item newItem = new Item(itemName, itemPrice);
                    items.add(newItem);
                }
                double totalPrice = Double.parseDouble(data[2]);

                Order order = new Order(orderNumber, items, totalPrice);
                orders.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the orders data from the list to the CSV file.
     *
     * @param orders The list of orders.
     */
    public static void saveOrdersToCsv(List<Order> orders) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(ORDERS_CSV_FILE))) {
            for (Order order : orders) {
                StringBuilder line = new StringBuilder();
                line.append(order.getOrderNumber()).append(",");
                for (Item item : order.getItems()) {
                    line.append(item.getName()).append(":").append(item.getPrice()).append(";");
                }
                line.deleteCharAt(line.length() - 1); // Remove the trailing semicolon
                line.append(",").append(order.getTotalPrice());
                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the delivery data from the CSV file and populates the deliveries list.
     *
     * @param deliveries The list of deliveries.
     */
    private static void readDeliveriesFromCsv(List<Delivery> deliveries) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(DELIVERIES_CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int deliveryId = Integer.parseInt(data[0]); // Extract the deliveryId from the data array
                String recipientName = data[1]; // Extract the recipientName from the data array
                String address = data[2]; // Extract the address from the data array
                Delivery delivery = new Delivery(deliveryId, recipientName, address);
                deliveries.add(delivery);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the deliveries data from the list to the CSV file.
     *
     * @param deliveries The list of deliveries.
     */
    public static void saveDeliveriesToCsv(List<Delivery> deliveries) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(DELIVERIES_CSV_FILE))) {
            for (Delivery delivery : deliveries) {
                String line = String.join(",", String.valueOf(delivery.getDeliveryId()), delivery.getRecipientName(), delivery.getAddress());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the user data from the CSV file and populates the users list.
     *
     * @param users The list of users.
     */
    public static void readUsersFromCsv(List<User> users) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(USERS_CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String username = data[0];
                String email = data[1];
                User user = new User(username, email);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the users data from the list to the CSV file.
     *
     * @param users The list of users.
     */
    public static void saveUsersToCsv(List<User> users) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(USERS_CSV_FILE))) {
            for (User user : users) {
                String line = String.join(",", user.getUsername(), user.getEmail());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Logs an action to the audit log CSV file.
     *
     * @param actionName The name of the action.
     */
    public static void logAction(String actionName) {
        LocalDateTime timestamp = LocalDateTime.now();
        String logEntry = String.join(",", actionName, timestamp.toString());
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(AUDIT_LOG_CSV_FILE), StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Processes the order with the specified order number.
     *
     * @param orderNumber the order number to process
     * @throws OrderNotFoundException if the order does not exist
     */
    public void processOrder(int orderNumber) throws OrderNotFoundException {
        // Code to process the order

        // If the order is not found, throw the exception
        if (!orderExists(orderNumber)) {
            throw new OrderNotFoundException(orderNumber);
        }

        // Continue with order processing if the order is found
        // ...
    }

    /**
     * Checks if the order with the specified order number exists.
     *
     * @param orderNumber the order number to check
     * @return true if the order exists, false otherwise
     */
    public boolean orderExists(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                return true; // Order found
            }
        }
        return false; // Order not found
    }

    /**
     * Creates a new delivery with the specified details.
     *
     * @param deliveryId    the delivery ID
     * @param recipientName the recipient's name
     * @param address       the delivery address
     * @return the created Delivery object
     */
    private static Delivery createDelivery(int deliveryId, String recipientName, String address) {
        return new Delivery(deliveryId, recipientName, address);
    }

    /**
     * Creates a new user with the specified details.
     *
     * @param username the username
     * @param email    the email address
     * @return the created User object
     */
    private static User createUser(String username, String email) {
        return new User(username, email);
    }

    /**
     * Adds a venue to the service.
     *
     * @param venue the venue to add
     */
    public void addVenue(Venue venue) {
        venues.add(venue);
    }

    /**
     * Adds an order to the service.
     *
     * @param order the order to add
     */
    public void addOrder(Order order) {
        orders.add(order);
    }

    /**
     * Adds a delivery to the service.
     *
     * @param delivery the delivery to add
     */
    public void addDelivery(Delivery delivery) {
        deliveries.add(delivery);
    }

    /**
     * Adds a user to the service.
     *
     * @param user the user to add
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Reads log entries from a file and displays them in the specified JTextArea.
     *
     * @param logTextArea the JTextArea to display the log entries
     */
    public void readLogEntries(JTextArea logTextArea) {
        AtomicReference<JTextArea> logAreaRef = new AtomicReference<>(logTextArea);

        Thread thread = new Thread(() -> {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(AUDIT_LOG_CSV_FILE))) {
                String line;
                while (true) {
                    line = reader.readLine();
                    if (line != null) {
                        String finalLine = line;
                        SwingUtilities.invokeLater(() -> {
                            JTextArea logArea = logAreaRef.get();
                            logArea.append(finalLine + "\n");
                            logArea.setCaretPosition(logArea.getDocument().getLength());
                        });
                    } else {
                        Thread.sleep(1000); // Wait for 1 second before checking for new entries
                    }
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }
}