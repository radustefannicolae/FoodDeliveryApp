package GUI;

import PROGRAM.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class FoodDeliveryAppGUI {
    private FoodDeliveryService service;
    private JFrame frame;
    private JTextArea textArea;
    private JTextArea logTextArea;

    public FoodDeliveryAppGUI(FoodDeliveryService service) {
        this.service = service;
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Food com.Delivery App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JButton venuesButton = new JButton("Show Venues");
        JButton ordersButton = new JButton("Show Orders");
        JButton deliveriesButton = new JButton("Show Deliveries");
        JButton usersButton = new JButton("Show Users");
        JButton addUserButton = new JButton("Add User");
        JButton addDeliveryButton = new JButton("Add Delivery");
        JButton saveCSVButton = new JButton("Save CSV");

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(venuesButton);
        buttonPanel.add(ordersButton);
        buttonPanel.add(deliveriesButton);
        buttonPanel.add(usersButton);
        buttonPanel.add(addUserButton);
        buttonPanel.add(addDeliveryButton);
        buttonPanel.add(saveCSVButton);
        // View Log button
        JButton viewLogButton = new JButton("View Log");
        buttonPanel.add(viewLogButton);

        // Log TextArea
        logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(logTextArea);
        mainPanel.add(logScrollPane, BorderLayout.EAST);


        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
        // View Log button action listener
        viewLogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLogWindow();
            }
        });

        saveCSVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUserButton.setVisible(true);  // Show "Add User" button
                addDeliveryButton.setVisible(true);  // Hide "Add Delivery" button
                service.logAction("Saving Files...");
                // Save data to CSV files
                service.saveVenuesToCsv(service.getVenues());
                service.saveOrdersToCsv(service.getOrders());
                service.saveDeliveriesToCsv(service.getDeliveries());
                service.saveUsersToCsv(service.getUsers());

                JOptionPane.showMessageDialog(frame, "Data saved successfully!");
            }
        });
        venuesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                service.logAction("Display Venues");
                displayVenues();
                addUserButton.setVisible(true);  // Show "Add User" button
                addDeliveryButton.setVisible(false);  // Hide "Add Delivery" button
            }
        });
        ordersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                service.logAction("Display Orders");
                displayOrders();
                addUserButton.setVisible(true);  // Show "Add User" button
                addDeliveryButton.setVisible(false);  // Hide "Add Delivery" button
            }
        });
        usersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                service.logAction("Displaying Users...");
                displayUsers();
                addUserButton.setVisible(true);  // Show "Add User" button
                addDeliveryButton.setVisible(false);  // Hide "Add Delivery" button
            }
        });

        deliveriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                service.logAction("Displaying Deliveries...");
                displayDeliveries();
                addUserButton.setVisible(false);  // Hide "Add User" button
                addDeliveryButton.setVisible(true);  // Show "Add Delivery" button
            }
        });

        // Add User button action listener
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                service.logAction("Adding User...");
                addUser();
            }
        });

        // Add Delivery button action listener
        addDeliveryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                service.logAction("Adding Delivery...");
                addDelivery();
            }
        });

    }
    /**
     * Displays the venues in the text area.
     */
    private void displayVenues() {
        List<Venue> venues = service.getVenues();
        StringBuilder sb = new StringBuilder();
        for (Venue venue : venues) {
            sb.append("Name: ").append(venue.getName()).append(", Address: ").append(venue.getAddress()).append("\n");
        }
        textArea.setText(sb.toString());
    }
    /**
     * Displays the orders in the text area.
     */
    private void displayOrders() {
        List<Order> orders = new ArrayList<>();
        service.readOrdersFromCsv(orders); // Read orders from CSV file

        StringBuilder sb = new StringBuilder();
        for (Order order : orders) {
            sb.append("Order Number: ").append(order.getOrderNumber()).append(", Total Price: ").append(order.getTotalPrice()).append("\n");

            List<Item> items = order.getItems();
            for (Item item : items) {
                sb.append("Item: ").append(item.getName()).append(", Price: ").append(item.getPrice()).append("\n");
            }
            sb.append("\n");
        }
        textArea.setText(sb.toString());
    }


    /**
     * Displays the deliveries in the text area.
     */
    private void displayDeliveries() {
        List<Delivery> deliveries = service.getDeliveries();
        StringBuilder sb = new StringBuilder();
        for (Delivery delivery : deliveries) {
            sb.append("com.Delivery ID: ").append(delivery.getDeliveryId()).append(", Recipient Name: ").append(delivery.getRecipientName()).append(", Address: ").append(delivery.getAddress()).append("\n");
        }
        textArea.setText(sb.toString());
    }
    /**
     * Displays the users in the text area.
     */
    private void displayUsers() {
        List<User> users = service.getUsers();
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append("Username: ").append(user.getUsername()).append(", Email: ").append(user.getEmail()).append("\n");
        }
        textArea.setText(sb.toString());
    }
    /**
     * Adds a new venue.
     */
    private void addVenue() {
        String name = JOptionPane.showInputDialog(frame, "Enter the venue name:");
        String address = JOptionPane.showInputDialog(frame, "Enter the venue address:");

        Venue venue = new Venue(name, address);
        service.addVenue(venue);
        JOptionPane.showMessageDialog(frame, "Venue added successfully!");
    }
    /**
     * Adds a new order.
     */
    private void addOrder() {
        // Prompt for order details
        String orderNumberStr = JOptionPane.showInputDialog(frame, "Enter the order number:");
        int orderNumber = Integer.parseInt(orderNumberStr);

        String totalPriceStr = JOptionPane.showInputDialog(frame, "Enter the total price:");
        double totalPrice = Double.parseDouble(totalPriceStr);

        String itemName = JOptionPane.showInputDialog(frame, "Enter the item name:");
        String itemPriceStr = JOptionPane.showInputDialog(frame, "Enter the item price:");
        double itemPrice = Double.parseDouble(itemPriceStr);

        Item item = new Item(itemName, itemPrice);
        List<Item> items = new ArrayList<>();
        items.add(item);

        Order order = new Order(orderNumber, items, totalPrice);
        service.addOrder(order);
        JOptionPane.showMessageDialog(frame, "Order added successfully!");
    }
    /**
     * Adds a new delivery.
     */
    private void addDelivery() {
        // Prompt for delivery details
        String deliveryIdStr = JOptionPane.showInputDialog(frame, "Enter the delivery ID:");
        int deliveryId = Integer.parseInt(deliveryIdStr);

        String recipientName = JOptionPane.showInputDialog(frame, "Enter the recipient name:");
        String address = JOptionPane.showInputDialog(frame, "Enter the delivery address:");

        Delivery delivery = new Delivery(deliveryId, recipientName, address);
        if (delivery != null) {
            service.addDelivery(delivery);
            JOptionPane.showMessageDialog(frame, "Delivery added successfully!");
        }
    }
    /**
     * Adds a new user.
     */
    private void addUser() {
        String username = JOptionPane.showInputDialog(frame, "Enter the username:");
        String email = JOptionPane.showInputDialog(frame, "Enter the email:");

        User user = new User(username, email);
        service.addUser(user);
        JOptionPane.showMessageDialog(frame, "User added successfully!");
    }
    /**
     * Shows the log window and displays the log entries.
     */
    private void showLogWindow() {
        JFrame logFrame = new JFrame("Log");
        logFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        logFrame.setSize(400, 300);

        logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(logTextArea);

        logFrame.add(logScrollPane);
        logFrame.setVisible(true);

        // Read existing log entries and display them
        service.readLogEntries(logTextArea);
    }
    /**
            * The main entry point of the application.
     *
             * @param args    command-line arguments
     * @param service the FoodDeliveryService instance
     */
    public static void main(String[] args,FoodDeliveryService service) {
        //FoodDeliveryService service = new FoodDeliveryService();
        // Load initial data
        List<User> users = null;
        List<Venue> venues = null;
        List<Order> orders = null;
        List<Delivery> deliveries = null;
        service.loadInitialData(service, users, venues, orders, deliveries);

        // Create and show the GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FoodDeliveryAppGUI(service);
            }
        });
    }
}

