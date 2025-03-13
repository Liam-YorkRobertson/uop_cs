package generics;

/**
 * Represents a library item with a specific type, title, author, and unique ID.
 * This class is used to store and manage details of library items.
 * 
 * @param <T> the type of the library item
 * @author Liam-York Robertson
 */
public class LibraryItem <T> {
	private T libraryObj;
	private String title;
	private String author;
	private int itemID;
	
	private static int counter = 1;

	/**
     * Constructor to create a new LibraryItem with the specified properties.
     * 
     * @param libraryObj library item
     * @param title title of the library item
     * @param author author of the library item
     */
	public LibraryItem(T libraryObj, String title, String author) {
		this.libraryObj = libraryObj;
		this.title = title;
		this.author = author;
		this.itemID = counter++;
	}
	
	/**
     * Returns the type of the library item.
     * 
     * @return library object associated with this item
     */
	public T getLibraryItem() {
		return this.libraryObj;
	}
	
	/**
     * Returns the title of the library item.
     * 
     * @return title of the library item
     */
	public String getTitle() {
        return title;
    }

	/**
     * Returns the author of the library item.
     * 
     * @return author of the library item
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the unique item ID for this library item.
     * 
     * @return unique ID of the library item
     */
    public int getItemID() {
        return itemID;
    }
}
