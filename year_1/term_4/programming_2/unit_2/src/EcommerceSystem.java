import com.ecommerce.*;
import com.ecommerce.orders.*;
import java.util.*;

/**
 * Represents the main e-commerce management system.
 * The program allows users to manage products, customers, and orders through a command line interface.
 * 
 * @author Liam-York Robertson
 */
public class EcommerceSystem {
	
	/**
     * The main method that runs the e-commerce management system.
     * It provides a menu-driven interface for users to interact with the system.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Product> listOfProducts = new ArrayList<>();
        ArrayList<Customer> listOfCustomers = new ArrayList<>();
        ArrayList<Product> cartProducts = new ArrayList<>();
        ArrayList<Order> listOfOrders = new ArrayList<>();
        
        System.out.println("Welcome to the Ecommerce Management System\n");
        
        while (true) {
            System.out.println("Which of the following operations would you like to perform:\n");
            System.out.println("1. Create a product, customer account, or place an order");
            System.out.println("2. View information regarding products, customer accounts, or orders");
            System.out.println("3. Update order status or cancel orders");
            System.out.println("4. Exit the program\n");
            System.out.print("Enter choice: ");

            int userChoice1 = s.nextInt();
            s.nextLine();

            switch (userChoice1) {
	            case 1 -> {
	                while (true) {
	                    System.out.println("\nWhich of the following operations would you like to perform:\n");
	                    System.out.println("1. Create a product");
	                    System.out.println("2. Create a customer account");
	                    System.out.println("3. Place an order");
	                    System.out.println("4. Return to main menu\n");
	                    System.out.print("Enter choice: ");
	
	                    int userChoice2;
	                    try {
	                        userChoice2 = s.nextInt();
	                        s.nextLine();
	                    } catch (InputMismatchException e) {
	                        System.out.println("\nInvalid input. Please enter a number between 1 and 4\n");
	                        s.nextLine();
	                        continue;
	                    }
	
	                    switch (userChoice2) {
	                        case 1 -> {
	                            System.out.println("\nYou chose to create a product\n");
	
	                            int newProductID;
	                            while (true) {
	                                System.out.println("Insert the product ID (8 digits long): ");
	                                try {
	                                    newProductID = s.nextInt();
	                                    s.nextLine();
	                                    if (String.valueOf(newProductID).length() == 8) {
	                                        break;
	                                    } else {
	                                        System.out.println("Product ID must be exactly 8 digits");
	                                    }
	                                } catch (InputMismatchException e) {
	                                    System.out.println("Invalid input. Product ID must be an 8-digit number");
	                                    s.nextLine();
	                                }
	                            }
	
	                            System.out.println("Insert the product name: ");
	                            String newName = s.nextLine();
	
	                            double newPrice;
	                            while (true) {
	                                System.out.println("Insert the price of the product: ");
	                                try {
	                                    newPrice = Double.parseDouble(s.nextLine());
	                                    if (newPrice > 0) {
	                                        break;
	                                    } else {
	                                        System.out.println("Price must be greater than zero");
	                                    }
	                                } catch (NumberFormatException e) {
	                                    System.out.println("Invalid input. Please enter a valid price");
	                                }
	                            }
	
	                            int newStock;
	                            while (true) {
	                                System.out.println("Insert the stock of the product: ");
	                                try {
	                                    newStock = s.nextInt();
	                                    s.nextLine();
	                                    if (newStock >= 0) {
	                                        break;
	                                    } else {
	                                        System.out.println("Stock cannot be negative");
	                                    }
	                                } catch (InputMismatchException e) {
	                                    System.out.println("Invalid input. Stock must be a whole number");
	                                    s.nextLine();
	                                }
	                            }
	
	                            listOfProducts.add(new Product(newProductID, newName, newPrice, newStock));
	                            System.out.println("\nProduct created successfully\n");
	                        }
	                        case 2 -> {
	                            System.out.println("\nYou chose to create a customer account\n");
	                            System.out.println("Enter your name: ");
	                            String newCustomerName = s.nextLine();
	                            int newCustomerID = (int) (Math.random() * 90_000_000) + 10_000_000;
	                            listOfCustomers.add(new Customer(newCustomerID, newCustomerName));
	                            System.out.println("\nCustomer account created successfully\n");
	                        }
	                        case 3 -> {
	                            System.out.println("\nYou chose to place an order\n");
	
	                            if (listOfProducts.isEmpty()) {
	                                System.out.println("No products available to purchase");
	                                break;
	                            }
	
	                            System.out.println("List of products you could add to your cart:\n");
	                            for (Product product : listOfProducts) {
	                                System.out.println("Product name: " + product.getName() + " | Product price: " +
	                                        product.getPrice() + " | Product stock: " + product.getStock());
	                            }
	
	                            System.out.println("\nInsert the name of the product you would like to purchase:");
	                            String cartProduct = s.nextLine();
	                            Product selectedProduct = null;
	
	                            for (Product product : listOfProducts) {
	                                if (product.getName().equalsIgnoreCase(cartProduct)) {
	                                    selectedProduct = product;
	                                    break;
	                                }
	                            }
	
	                            if (selectedProduct == null) {
	                                System.out.println("Product not found");
	                                break;
	                            }
	
	                            int cartProductAmount;
	                            while (true) {
	                                System.out.println("\nHow many of these items would you like to purchase:");
	                                try {
	                                    cartProductAmount = s.nextInt();
	                                    s.nextLine();
	                                    if (cartProductAmount > 0 && cartProductAmount <= selectedProduct.getStock()) {
	                                        selectedProduct.setStock(selectedProduct.getStock() - cartProductAmount);
	                                        for (int i = 0; i < cartProductAmount; i++) {
	                                            cartProducts.add(selectedProduct);
	                                        }
	                                        break;
	                                    } else {
	                                        System.out.println("Invalid quantity. Only " + selectedProduct.getStock() + " in stock.");
	                                    }
	                                } catch (InputMismatchException e) {
	                                    System.out.println("Invalid input. Please enter a whole number");
	                                    s.nextLine();
	                                }
	                            }
	
	                            System.out.println("\nEnter your name:");
	                            String customerName = s.nextLine();

	                            Order newOrder = new Order((int) (Math.random() * 1000), customerName, cartProducts);
	                            System.out.println("\nPlease review your order details:\n");
	                            newOrder.displayOrderSummary();

	                            System.out.print("\nConfirm order? (yes/no): ");
	                            String confirmation = s.nextLine().trim().toLowerCase();

	                            if (confirmation.equals("yes")) {
	                                listOfOrders.add(newOrder);
	                                System.out.println("\nOrder placed successfully\n");
	                            } else {
	                                System.out.println("\nOrder cancelled\n");
	                            }
	                        }
	                        case 4 -> {
	                            System.out.println("\nReturning to main menu\n");
	                            break;
	                        }
	                        default -> System.out.println("\nInvalid choice\n");
	                    }
	                    break;
	                }
	            }
	            case 2 -> {
	                while (true) {
	                    System.out.println("\nWhich of the following information would you like to view:\n");
	                    System.out.println("1. View product details");
	                    System.out.println("2. View customer account details");
	                    System.out.println("3. View order details");
	                    System.out.println("4. Return to main menu\n");
	                    System.out.print("Enter choice: ");

	                    int userChoice3;
	                    try {
	                        userChoice3 = s.nextInt();
	                        s.nextLine();
	                    } catch (InputMismatchException e) {
	                        System.out.println("\nInvalid input. Please enter a number between 1 and 4\n");
	                        s.nextLine();
	                        continue;
	                    }

	                    switch (userChoice3) {
	                        case 1 -> {
	                            System.out.println("\nDisplaying product details:\n");
	                            if (listOfProducts.isEmpty()) {
	                                System.out.println("No products available\n");
	                            } else {
	                                for (int i = 0; i < listOfProducts.size(); i++) {
	                                    Product product = listOfProducts.get(i);
	                                    System.out.println("Product ID: " + product.getProductID() + " | Name: " + product.getName() +
	                                            " | Price: $" + product.getPrice() + " | Stock: " + product.getStock());
	                                }
	                            }
	                            System.out.println();
	                        }
	                        case 2 -> {
	                            System.out.println("\nDisplaying customer account details:\n");
	                            if (listOfCustomers.isEmpty()) {
	                                System.out.println("No customers available\n");
	                            } else {
	                                for (int i = 0; i < listOfCustomers.size(); i++) {
	                                    Customer customer = listOfCustomers.get(i);
	                                    System.out.println("Customer ID: " + customer.getCustomerID() + " | Name: " + customer.getName());
	                                }
	                            }
	                            System.out.println();
	                        }
	                        case 3 -> {
	                            System.out.println("\nDisplaying order details:\n");
	                            if (listOfOrders.isEmpty()) {
	                                System.out.println("No orders placed\n");
	                            } else {
	                                for (int i = 0; i < listOfOrders.size(); i++) {
	                                    Order order = listOfOrders.get(i);
	                                    order.displayOrderSummary();
	                                    System.out.println();
	                                }
	                            }
	                        }
	                        case 4 -> {
	                            System.out.println("\nReturning to main menu\n");
	                            break;
	                        }
	                        default -> {
	                        	System.out.println("\nInvalid choice\n");
	                        }  
	                    }
	                    break;
	                }
	            }
	            case 3 -> {
	                while (true) {
	                    System.out.println("\nWhich of the following operations would you like to perform:\n");
	                    System.out.println("1. Update Order Status");
	                    System.out.println("2. Cancel Order");
	                    System.out.println("3. Return to main menu");
	                    System.out.print("\nEnter choice: ");

	                    if (!s.hasNextInt()) {
	                        System.out.println("Invalid input. Please enter a number between 1 and 3\n");
	                        s.nextLine();
	                        continue;
	                    }

	                    int userChoice4 = s.nextInt();
	                    s.nextLine();

	                    System.out.print("\nEnter Order ID: ");
	                    if (!s.hasNextInt()) {
	                        System.out.println("Invalid Order ID. Please enter a valid ID number\n");
	                        s.nextLine();
	                        continue;
	                    }

	                    int orderID = s.nextInt();
	                    s.nextLine();

	                    Order selectedOrder = null;

	                    for (int i = 0; i < listOfOrders.size(); i++) {
	                        if (listOfOrders.get(i).getOrderID() == orderID) {
	                            selectedOrder = listOfOrders.get(i);
	                            break;
	                        }
	                    }

	                    switch (userChoice4) {
	                        case 1 -> {
	                            if (selectedOrder == null) {
	                                System.out.println("Order not found\n");
	                            } else {
	                                System.out.println("Current Order Status: " + selectedOrder.getOrderStatus());
	                                System.out.print("\nEnter new status (Pending, Enroute, Completed):\n");
	                                String newStatus = s.nextLine().trim();

	                                if (newStatus.equalsIgnoreCase("pending") || newStatus.equalsIgnoreCase("enroute")
	                                        || newStatus.equalsIgnoreCase("completed")) {
	                                    selectedOrder.updateOrderStatus(newStatus);
	                                } else {
	                                    System.out.println("Invalid status. Please enter one of: Pending, Enroute, Completed\n");
	                                }
	                            }
	                        }
	                        case 2 -> {
	                            if (selectedOrder == null) {
	                                System.out.println("Order not found\n");
	                            } else {
	                                listOfOrders.remove(selectedOrder);
	                                System.out.println("\nOrder has been cancelled\n");
	                            }
	                        }
	                        case 3 -> {
	                        	System.out.println("\nReturning to main menu\n");
		                        break;
	                        }
	                        default -> {
	                            System.out.println("Invalid choice. Please enter a number between 1 and 3\n");
	                        }
	                    }
	                    break;
	                }
	            }
                case 4 -> {
                    System.out.println("\nThank you for using the Ecommerce Management System!\n");
                    s.close();
                    System.exit(0);
                }
                default -> {
                    System.out.println("\nInvalid choice\n");
                }
            }
        }
    }
}
