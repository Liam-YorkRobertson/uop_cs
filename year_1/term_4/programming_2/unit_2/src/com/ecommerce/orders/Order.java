package com.ecommerce.orders;

import com.ecommerce.Product;
import java.util.*;

/**
 * Represents an order in the e-commerce system.
 * Each order has a unique ID, customer name, list of products, total price, and status.
 * 
 * @author Liam-York Robertson
 */
public class Order {
    private int orderID;
    private String customer;
    private ArrayList<Product> products;
    private double orderTotal;
    private String orderStatus;

    /**
     * Constructs a new Order with the specified details.
     *
     * @param orderID the unique ID of the order
     * @param customer the name of the customer placing the order
     * @param products the list of products in the order
     */
    public Order(int orderID, String customer, ArrayList<Product> products) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = products;
        this.orderTotal = calculateOrderTotal();
        this.orderStatus = "pending";
    }

    /**
     * Returns the order ID.
     *
     * @return the order ID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * Updates the order ID.
     *
     * @param orderID the new order ID
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * Returns the customer name associated with the order.
     *
     * @return the customer name
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * Updates the customer name associated with the order.
     *
     * @param customer the new customer name
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * Returns the list of products in the order.
     *
     * @return the list of products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Updates the list of products in the order and recalculates the total price.
     *
     * @param products the new list of products
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
        this.orderTotal = calculateOrderTotal();
    }

    /**
     * Returns the total price of the order.
     *
     * @return the total price
     */
    public double getOrderTotal() {
        return orderTotal;
    }

    /**
     * Returns the current status of the order.
     *
     * @return the order status
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * Calculates the total price of all products in the order.
     *
     * @return the total price
     */
    private double calculateOrderTotal() {
        double total = 0;
        for (int i = 0; i < products.size(); i++) {
            total += products.get(i).getPrice();
        }
        return total;
    }

    /**
     * Displays a summary of the order, including ID, customer, status, products, and total price.
     */
    public void displayOrderSummary() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer: " + customer);
        System.out.println("Order Status: " + orderStatus);
        System.out.println("Products in the order:\n");

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println("- " + product.getName() + " | Price: " + product.getPrice());
        }

        double roundedTotal = Math.round(orderTotal * 100.0) / 100.0;
        System.out.println("\nTotal Order Price: " + String.format(Locale.US, "%.2f", roundedTotal));
    }

    /**
     * Updates the status of the order.
     *
     * @param newStatus the new status of the order
     */
    public void updateOrderStatus(String newStatus) {
        this.orderStatus = newStatus;
        System.out.println("\nOrder status updated to: " + newStatus + "\n");
    }
}