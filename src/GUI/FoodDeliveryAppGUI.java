//package GUI;
//
//import com.*;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//
//public class FoodDeliveryAppGUI {
//    private FoodDeliveryApp service;
//    private JFrame frame;
//    private JTextArea textArea;
//
//    public FoodDeliveryAppGUI(FoodDeliveryApp service) {
//        this.service = service;
//        createGUI();
//    }
//
//    private void createGUI() {
//        frame = new JFrame("Food com.Delivery App");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 300);
//
//        JPanel mainPanel = new JPanel();
//        mainPanel.setLayout(new BorderLayout());
//
//        JButton venuesButton = new JButton("Show Venues");
//        JButton ordersButton = new JButton("Show Orders");
//        JButton deliveriesButton = new JButton("Show Deliveries");
//        JButton usersButton = new JButton("Show Users");
//
//        textArea = new JTextArea();
//        textArea.setEditable(false);
//        JScrollPane scrollPane = new JScrollPane(textArea);
//
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.setLayout(new FlowLayout());
//        buttonPanel.add(venuesButton);
//        buttonPanel.add(ordersButton);
//        buttonPanel.add(deliveriesButton);
//        buttonPanel.add(usersButton);
//
//        mainPanel.add(scrollPane, BorderLayout.CENTER);
//        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
//
//        frame.add(mainPanel);
//        frame.setVisible(true);
//
//        venuesButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                displayVenues();
//            }
//        });
//
//        ordersButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                displayOrders();
//            }
//        });
//
//        deliveriesButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                displayDeliveries();
//            }
//        });
//
//        usersButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                displayUsers();
//            }
//        });
//    }
//
//    private void displayVenues() {
//        List<Venue> venues = service.getVenues();
//        StringBuilder sb = new StringBuilder();
//        for (Venue venue : venues) {
//            sb.append("Name: ").append(venue.getName()).append(", Address: ").append(venue.getAddress()).append("\n");
//        }
//        textArea.setText(sb.toString());
//    }
//
//    private void displayOrders() {
//        List<Order> orders = service.getOrders();
//        StringBuilder sb = new StringBuilder();
//        for (Order order : orders) {
//            sb.append("com.Order Number: ").append(order.getOrderNumber()).append(", Total Price: ").append(order.getTotalPrice()).append("\n");
//        }
//        textArea.setText(sb.toString());
//    }
//
//    private void displayDeliveries() {
//        List<Delivery> deliveries = service.getDeliveries();
//        StringBuilder sb = new StringBuilder();
//        for (Delivery delivery : deliveries) {
//            sb.append("com.Delivery ID: ").append(delivery.getDeliveryId()).append(", Recipient Name: ").append(delivery.getRecipientName()).append(", Address: ").append(delivery.getAddress()).append("\n");
//        }
//        textArea.setText(sb.toString());
//    }
//
//    private void displayUsers() {
//        List<User> users = service.getUsers();
//        StringBuilder sb = new StringBuilder();
//        for (User user : users) {
//            sb.append("Username: ").append(user.getUsername()).append(", Email: ").append(user.getEmail()).append("\n");
//        }
//        textArea.setText(sb.toString());
//    }
//
//    public static void main(String[] args) {
//        FoodDeliveryApp service = new FoodDeliveryApp();
//        // Load initial data
//        service.loadInitialData();
//
//        // Create and show the GUI
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new FoodDeliveryAppGUI(service);
//            }
//        });
//    }
//}
//
