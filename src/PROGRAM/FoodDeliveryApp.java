package PROGRAM;

import GUI.*;

import javax.swing.*;
import java.util.*;

public class FoodDeliveryApp {
    public static void main(String[] args) {
        List<Venue> venues = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        List<Delivery> deliveries = new ArrayList<>();
        List<User> users = new ArrayList<>();
        FoodDeliveryService service = FoodDeliveryService.getInstance(venues, orders, deliveries, users);
        service.loadInitialData(service, users, venues, orders, deliveries);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FoodDeliveryAppGUI(service);
            }
        });

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- Menu -----");
            System.out.println("1. Show Venues");
            System.out.println("2. Show Orders");
            System.out.println("3. Show Deliveries");
            System.out.println("4. Show Users");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Display Venues
                    venues = service.getVenues();
                    for (Venue venue : venues) {
                        System.out.println("Venue: " + venue.getName() + ", Address: " + venue.getAddress());
                    }
                    break;
                case 2:
                    // Display Orders
                    orders = service.getOrders();
                    for (Order order : orders) {
                        System.out.println("Order Number: " + order.getOrderNumber() + ", Total Price: " + order.getTotalPrice());
                        List<Item> items = order.getItems();
                        for (Item item : items) {
                            System.out.println("Item: " + item.getName() + ", Price: " + item.getPrice());
                        }
                    }
                    break;
                case 3:
                    // Display Deliveries
                    deliveries = service.getDeliveries();
                    for (Delivery delivery : deliveries) {
                        System.out.println("Delivery ID: " + delivery.getDeliveryId() + ", Recipient Name: " + delivery.getRecipientName() + ", Address: " + delivery.getAddress());
                    }
                    break;
                case 4:
                    // Display Users
                    users = service.getUsers();
                    for (User user : users) {
                        System.out.println("Username: " + user.getUsername() + ", Email: " + user.getEmail());
                    }
                    break;
                case 0:
                    // Exit the program
                    System.out.println("Exiting and Saving...");
                    // Save data to CSV files
                    service.saveVenuesToCsv(service.getVenues());
                    service.saveOrdersToCsv(service.getOrders());
                    service.saveDeliveriesToCsv(service.getDeliveries());
                    service.saveUsersToCsv(service.getUsers());
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }




    }

}
    
