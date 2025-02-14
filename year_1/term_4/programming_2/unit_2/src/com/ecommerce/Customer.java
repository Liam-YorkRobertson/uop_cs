package com.ecommerce;

import java.util.*;

/**
 * Represents a customer in the e-commerce system.
 * Each customer has a unique ID, name, and a shopping cart to hold products.
 * 
 * @author Liam-York Robertson
 */
public class Customer {
    private int customerID;
    private String name;
    // has to dynamically change size, as length is user determined
    private ArrayList<Product> shoppingCart = new ArrayList<>();

    /**
     * Constructs a new Customer with the specified details.
     *
     * @param customerID the unique ID of the customer
     * @param name the name of the customer
     */
    public Customer(int customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
    }

    /**
     * Returns the customer ID.
     *
     * @return the customer ID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Returns the customer name.
     *
     * @return the customer name
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the customer name.
     *
     * @param name the new customer name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds a product to the customer's shopping cart.
     *
     * @param userOrder the product to add
     */
    public void addToCart(Product userOrder) {
        shoppingCart.add(userOrder);
        System.out.println(userOrder.getName() + " added to cart");
    }

    /**
     * Removes a product from the customer's shopping cart.
     *
     * @param userOrder the product to remove
     */
    public void removeFromCart(Product userOrder) {
        shoppingCart.remove(userOrder);
        System.out.println(userOrder.getName() + " removed from cart");
    }

    /**
     * Calculates the total price of all products in the shopping cart.
     *
     * @return the total price of the shopping cart
     */
    public double cartTotal() {
        double cartTotal = 0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            cartTotal += shoppingCart.get(i).getPrice();
        }
        return cartTotal;
    }

    /**
     * Places an order if the shopping cart is not empty.
     * Displays a message if the cart is empty.
     */
    public void placeOrder() {
        if (shoppingCart.isEmpty()) {
            System.out.println("Your cart is empty");
        } else {
            System.out.println("Your order was placed successfully!");
        }
    }
}