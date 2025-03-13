package generics;

import java.util.*;

/**
 * Represents a generic catalogue that stores library items of a specific type.
 * This class allows adding, removing, and displaying items in the catalogue.
 * 
 * @param <T> the type of the library item
 * @author Liam-York Robertson
 */
public class GenericCatalog <T extends LibraryItem> {
	ArrayList<T> library = new ArrayList<>();
	
	/**
     * Adds a new item to the catalogue.
     * 
     * @param newItem library item to be added
     * @return none
     */
	public void addItem(T newItem) {
		if (newItem == null) {
	        System.out.println("Cannot add a null item to the catalogue.");
	    } else {
	        library.add(newItem);
	    }
	}
	
	/**
     * Removes an item from the catalogue.
     * 
     * @param itemID ID of the item to be removed
     * @return none
     */
	public void removeItem(int itemID) {
		Iterator<T> iterator = library.iterator();
	    while (iterator.hasNext()) {
	        if (iterator.next().getItemID() == itemID) {
	            iterator.remove();
	            System.out.println("\nItem removed successfully.");
	            return;
	        }
	    }
	    System.out.println("\nItem with ID " + itemID + " not found.");
	}
	
	/**
     * Displays all the items currently in the catalogue.
     * 
     * @return none
     */
	public void displayItems() {
		if (library.isEmpty()) {
            System.out.println("\nNo items in the catalogue.");
        }
		
		for (T item : library) {
			System.out.println();
			System.out.println("Item Type: " + item.getLibraryItem());
            System.out.println("Title: " + item.getTitle());
            System.out.println("Author: " + item.getAuthor());
            System.out.println("Item ID: " + item.getItemID());
		}
	}
}
