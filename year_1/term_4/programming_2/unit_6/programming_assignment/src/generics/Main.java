/**
 * Compiling program: go to parent directory "cd .." and type "javac parent_directory_name.*.java"
 * Running program: go to parent directory "cd .." and insert "java parent_directory_name.Main"
 */

package generics;

import java.util.*;

/**
 * Main class that manages the functionality of a library system.
 * This program allows users to add, remove, and view library items, using a CLI.
 * 
 * @author Liam-York Robertson
 */
public class Main {
	/**
     * Main method that runs the library system.
     * It provides a command-line interface for the user to interact with the catalogue.
     * 
     * @param args none
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        GenericCatalog<LibraryItem> catalogue = new GenericCatalog<>();
        
        System.out.println("Welcome to the Library!");
        while (true) {
            System.out.println("\nWhich of the following operations would you like to perform:\n");
            System.out.println("1. Add a new library item");
            System.out.println("2. Remove a library item");
            System.out.println("3. View Item details");
            System.out.println("4. Exit program");
            System.out.println("\nEnter choice: ");
            
            int userChoice1;
            
            try {
                userChoice1 = s.nextInt();
                s.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }
            
            switch (userChoice1) {
                case 1: {
                	System.out.println("\nInsert the type of the library item (DVD, magazine, book): ");
                    String itemType = s.nextLine().toLowerCase();

                    if (!(itemType.equals("dvd") || itemType.equals("magazine") || itemType.equals("book"))) {
                        System.out.println("\nInvalid item type. Please enter either DVD, magazine, or book.");
                        break;
                    }
                    
                    System.out.println("Insert the title of the " + itemType + ": ");
                    String itemTitle = s.nextLine();
                    System.out.println("Insert the author of the " + itemType + ": ");
                    String itemAuthor = s.nextLine();
                    
                    LibraryItem<String> item = new LibraryItem<>(itemType, itemTitle, itemAuthor);
                    catalogue.addItem(item);
                    System.out.println("\nYour item has been added to the library");
                    break;
                }
                case 2: {
                    System.out.print("\nEnter the item ID of the item you want to remove: ");
                    int removeID;
                    
                    try {
                        removeID = s.nextInt();
                        s.nextLine();
                        catalogue.removeItem(removeID);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid item ID.");
                    }
                    break;
                }
                case 3: {
                    catalogue.displayItems();
                    break;
                }
                case 4: {
                    System.out.println("Exiting the program");
                    System.exit(0);
                }
                default: {
                    System.out.println("Invalid input. Please select a valid option.");
                }
            }
        }
    }
}
