import java.util.*;

public class BasicLibrary {
    public static void main(String[] args) {
        // declare variables
        String userDemand;
        String addBook, addAuthor, borrowBook, returnBook;
        int addQuantity, borrowQuantity, returnQuantity;
        // using a map to store library data
        Map<String, Object[]> library = new HashMap<>();
        // resource to read user input
        Scanner s = new Scanner(System.in);
        // welcome user to application
        System.out.println("Welcome the the library!\n");
        // informs user of how to exit
        System.out.println("To exit the program at any time type \"exit\".");
        do {    
            // ask user if they want to add, borrow or remove book
            System.out.println("\nWould you like to add, borrow, or return a book?");
            // get user input
            userDemand = s.nextLine();
            // switch statement depends on user input
            switch(userDemand) {
                case "Add", "add" -> {
                    // prompt user to enter book title they want to add and test input
                    System.out.println("Please enter the book title:");
                    while (true) {
                        addBook = s.nextLine();
                        if (!addBook.isEmpty()) {
                            break;
                        }
                        System.out.println("Book title cannot be empty.");
                    }
                    // prompt user to enter book author and test input
                    System.out.println("Please enter the book Author:");
                    while (true) {
                        addAuthor = s.nextLine();
                        if (!addAuthor.isEmpty()) {
                            break;
                        }
                        System.out.println("Author name cannot be empty.");
                    }
                    // prompt user to enter book quantity and test input
                    System.out.println("Please enter the book Quantity:");
                    while (true) {
                        try {
                            addQuantity = s.nextInt();
                            s.nextLine();
                            if (addQuantity > 0) {
                                break;
                            }
                            System.out.println("Quantity cannot be negative.");
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please insert a valid integer:");
                            s.nextLine();
                        }
                    }
                    // checks if book already exists in library
                    if (library.containsKey(addBook)) {
                        // if it exists, gets book details updates book quantity
                        Object[] bookDetails = library.get(addBook);
                        if (bookDetails[0].toString().equalsIgnoreCase(addAuthor)) {
                        bookDetails[1] = (int) bookDetails[1] + addQuantity;
                        }
                    } else {
                        // if it does not exist, adds it to library
                        library.put(addBook, new Object[]{addAuthor, addQuantity});
                    }
                }
                case "Borrow", "borrow" -> {
                    // prompt user to enter book title they want to borrow and test input
                    System.out.println("Please enter the title of the book you would like to borrow:");
                    while (true) {
                        borrowBook = s.nextLine();
                        if (!borrowBook.isEmpty()) {
                            break;
                        }
                        System.out.println("Book title cannot be empty.");
                    }
                    // prompt user to enter book quantity and test input
                    System.out.println("Please enter the quantity you would like to borrow:");
                    while (true) {
                        try {
                            borrowQuantity = s.nextInt();
                            s.nextLine();
                            if (borrowQuantity > 0) {
                                break;
                            }
                            System.out.println("Quantity must be greater than zero.");
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please insert a valid integer:");
                            s.nextLine();
                        }
                    }
                    // checks if book exists in library
                    if (library.containsKey(borrowBook)) {
                        // if it exists, gets book details and updates book quantity
                        Object[] bookDetails = library.get(borrowBook);
                        // decreases book quantity if enough copies available
                        if ((int) bookDetails[1] >= borrowQuantity) {
                            bookDetails[1] = (int) bookDetails[1] - borrowQuantity;
                            System.out.println("You have successfully borrowed " + borrowQuantity + " copy(ies) of " + borrowBook + ".");
                        } else {
                            System.out.println("Insufficient quantity available to borrow.");
                        }
                    } else {
                        System.out.println("The book is not available in the library.");
                    }
                }
                case "Return", "return" -> {
                    // prompt user to enter book title they want to return and test input
                    System.out.println("Please enter the title of the book you would like to return:");
                    while (true) {
                        returnBook = s.nextLine();
                        if (!returnBook.isEmpty()) {
                            break;
                        }
                        System.out.println("Book title cannot be empty.");
                    }
                    // prompt user to enter book quantity and test input
                    System.out.println("Please enter the quantity you would like to return:");
                    while (true) {
                        try {
                            returnQuantity = s.nextInt();
                            s.nextLine();
                            if (returnQuantity > 0) {
                                break;
                            }
                            System.out.println("Quantity must be greater than zero.");
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please insert a valid integer:");
                            s.nextLine();
                        }
                    }
                    // checks if book exists in library
                    if (library.containsKey(returnBook)) {
                        // if it exists, gets book details and updates book quantity
                        Object[] bookDetails = library.get(returnBook);
                        // increases book quantity if it exists
                        bookDetails[1] = (int) bookDetails[1] + returnQuantity;
                        System.out.println("You have successfully returned " + returnQuantity + " copy(ies) of " + returnBook + ".");
                    } else {
                        System.out.println("The book does not belong to the library.");
                    }
                }
                case "Exit", "exit" -> {
                    // exits program
                    System.out.println("Thank you for using the library system. Happy reading!");
                    System.exit(0);
                }
                default -> {
                    // message for unrecognised input
                    System.out.println("\nInvalid input. Please enter 'Add', 'Borrow', 'Return', or 'Exit'.");
                }
            }
        // code loops as long as user does not exit
        } while (!userDemand.equalsIgnoreCase("Exit"));
        // close scanner resource
        s.close();
    }
}