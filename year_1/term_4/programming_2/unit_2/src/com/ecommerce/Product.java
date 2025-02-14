package com.ecommerce;

/**
 * Represents a product in the e-commerce system.
 * Each product has a unique ID, name, price, and stock quantity.
 * 
 * @author Liam-York Robertson
 */
public class Product {
    private int productID;
    private String name;
    private double price;
    private int stock;

    /**
     * Constructs a new Product with the specified details.
     *
     * @param productID the unique ID of the product
     * @param name the name of the product
     * @param price the price of the product
     * @param stock the stock quantity of the product
     */
    public Product(int productID, String name, double price, int stock) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Returns the product ID.
     *
     * @return the product ID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Sets the product ID.
     *
     * @param newProductID the new product ID
     */
    public void setProductID(int newProductID) {
        this.productID = newProductID;
    }

    /**
     * Returns the product name.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the product name.
     *
     * @param newName the new product name
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Returns the product price.
     *
     * @return the product price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the product price.
     *
     * @param newPrice the new product price
     */
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    /**
     * Returns the product stock quantity.
     *
     * @return the stock quantity
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the product stock quantity.
     *
     * @param newStock the new stock quantity
     */
    public void setStock(int newStock) {
        this.stock = newStock;
    }
}