package PROGRAM;

import java.util.*;

public class FoodDeliveryApp {
    private static Delivery createDelivery(int deliveryId, String recipientName, String address) {
        return new Delivery(deliveryId, recipientName, address);
    }

    private static User createUser(String username, String email) {
        return new User(username, email);
    }


    public static void main(String[] args) {
        List<Venue> venues = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        List<Delivery> deliveries = new ArrayList<>();
        List<User> users = new ArrayList<>();
        FoodDeliveryService service = FoodDeliveryService.getInstance(venues, orders, deliveries, users);
        service.loadInitialData(service, users, venues, orders, deliveries);

        // Save data to CSV files
        service.saveVenuesToCsv(service.getVenues());
        service.saveOrdersToCsv(service.getOrders());
        service.saveDeliveriesToCsv(service.getDeliveries());
        service.saveUsersToCsv(service.getUsers());
    }

}
    
