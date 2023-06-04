package PROGRAM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    // Methods for managing venues, orders, deliveries, and users
    // ...
    public static FoodDeliveryService getInstance(List<Venue> venues, List<Order> orders, List<Delivery> deliveries, List<User> users){
        if(instance == null){
            instance = new FoodDeliveryService(venues,orders,deliveries,users);
        }
        return instance;
    }

    private FoodDeliveryService(List<Venue> venues, List<Order> orders, List<Delivery> deliveries, List<User> users){
        this.deliveries = deliveries;
        this.venues = venues;
        this.orders = orders;
        this.users = users;
    }
    
    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    // Example method for placing an order
    public void placeOrder(Order order) {
        // Logic for placing an order
        // ...
    }

    public static void loadInitialData(FoodDeliveryService service, List<User> users, List<Venue> venues, List<Order> orders, List<Delivery> deliveries) {
        readUsersFromCsv(users);
        readVenuesFromCsv(venues);
        readDeliveriesFromCsv(deliveries);
        readOrdersFromCsv(orders);
    }

    public static void readVenuesFromCsv(List<Venue> venues) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(VENUES_CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Venue venue = new Venue();
                venues.add(venue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public static void readOrdersFromCsv(List<Order> orders) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(ORDERS_CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Order order = new Order();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveOrdersToCsv(List<Order> orders) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(ORDERS_CSV_FILE))) {
            for (Order order : orders) {
                String line = String.join(",", String.valueOf(order.getOrderNumber()), String.valueOf(order.getTotalPrice()));
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    private static void readUsersFromCsv(List<User> users) {
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

    private static void logAction(String actionName) {
        LocalDateTime timestamp = LocalDateTime.now();
        String logEntry = String.join(",", actionName, timestamp.toString());
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(AUDIT_LOG_CSV_FILE), StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
