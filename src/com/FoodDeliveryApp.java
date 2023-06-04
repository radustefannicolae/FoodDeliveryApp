package com;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.*;

public class FoodDeliveryApp {
    private static Delivery createDelivery(int deliveryId, String recipientName, String address) {
        return new Delivery(deliveryId, recipientName, address);
    }

    private static User createUser(String username, String email) {
        return new User(username, email);
    }

    private static final String VENUES_CSV_FILE = "D:\\WORK\\INFO_TITU\\AN II\\MAP\\project\\src\\CSV\\venues.csv";
    private static final String ORDERS_CSV_FILE = "D:\\WORK\\INFO_TITU\\AN II\\MAP\\project\\src\\CSV\\orders.csv";
    private static final String DELIVERIES_CSV_FILE = "D:\\WORK\\INFO_TITU\\AN II\\MAP\\project\\src\\CSV\\deliveries.csv";
    private static final String USERS_CSV_FILE = "D:\\WORK\\INFO_TITU\\AN II\\MAP\\project\\src\\CSV\\users.csv";
    private static final String AUDIT_LOG_CSV_FILE = "D:\\WORK\\INFO_TITU\\AN II\\MAP\\project\\src\\CSV\\audit_log.csv";



    public static void main(String[] args) {
        FoodDeliveryService service = new FoodDeliveryService();
        loadInitialData(service);

        // Demonstrate the functionality of the food delivery platform
        // ...

        // Example usage: Place an order
        Order order = new Order();
        // Set order details
        // ...
        service.placeOrder(order);

        // Save data to CSV files
        saveVenuesToCsv(service.getVenues());
        saveOrdersToCsv(service.getOrders());
        saveDeliveriesToCsv(service.getDeliveries());
        saveUsersToCsv(service.getUsers());
    }

    private static void loadInitialData(FoodDeliveryService service) {
        service.setVenues(readVenuesFromCsv());
        service.setOrders(readOrdersFromCsv());
        service.setDeliveries(readDeliveriesFromCsv());
        service.setUsers(readUsersFromCsv());
    }

    private static List<Venue> readVenuesFromCsv() {
        List<Venue> venues = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(VENUES_CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Venue venue = new Venue();
                // Set venue details based on data array
                // ...
                venues.add(venue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return venues;
    }

    private static void saveVenuesToCsv(List<Venue> venues) {
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

    private static List<Order> readOrdersFromCsv() {
        List<Order> orders = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(ORDERS_CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Order order = new Order();
                // Set order details based on data array
                // ...
                orders.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }

    private static void saveOrdersToCsv(List<Order> orders) {
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

    private static List<Delivery> readDeliveriesFromCsv() {
        List<Delivery> deliveries = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(DELIVERIES_CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int deliveryId = Integer.parseInt(data[0]); // Extract the deliveryId from the data array
                String recipientName = data[1]; // Extract the recipientName from the data array
                String address = data[2]; // Extract the address from the data array
                Delivery delivery = new Delivery(deliveryId, recipientName, address);
                // Set delivery details based on data array
                // ...
                deliveries.add(delivery);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deliveries;
    }

    
    private static void saveDeliveriesToCsv(List<Delivery> deliveries) {
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

    private static List<User> readUsersFromCsv() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(USERS_CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String username = data[0];
                String email = data[1];
                User user = new User(username, email);
                // Set user details based on data array
                // ...
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
    
        private static void saveUsersToCsv(List<User> users) {
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
    
