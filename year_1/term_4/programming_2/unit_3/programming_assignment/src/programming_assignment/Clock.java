/**
 * Compiling program: compile Clock.java with "javac Clock.java"
 * Running program: go to parent directory "cd .." and insert "java parent_directory_name.Clock"
 */

package programming_assignment;

import java.util.*;
import java.time.*;
import java.time.format.*;

/**
 * Represents a thread that continuously updates current date and time.
 * This thread runs in an infinite loop, updating the time and date at regular intervals.
 * 
 * @author Liam-York Robertson
 */
class UpdateThread implements Runnable {
    private LocalDate currentDate;
    private LocalTime currentTime;

    /**
     * Continuously updates the current date and time in a loop.
     * 
     * @return none
     */
    @Override
    public void run() {
        while (true) {
            setCurrentDate(LocalDate.now());
            setCurrentTime(LocalTime.now());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Returns the current date.
     *
     * @return the current date
     */
    public LocalDate getCurrentDate() {
        return currentDate;
    }

    /**
     * Sets the current date.
     *
     * @param currentDate the new current date
     */
    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    /**
     * Returns the current time.
     *
     * @return the current time
     */
    public LocalTime getCurrentTime() {
        return currentTime;
    }

    /**
     * Sets the current time.
     *
     * @param currentTime the new current time
     */
    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
    }
}

/**
 * Represents a thread that displays the current date and time at regular intervals.
 * This thread formats and prints the date and time every second.
 * 
 * @author Liam-York Robertson
 */
class DisplayThread implements Runnable {
    private UpdateThread updateThread;
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /**
     * Constructs a DisplayThread with the specified UpdateThread.
     * This is used so that DisplayThread accesses the data from UpdateThread in order to display it
     *
     * @param updateThread the UpdateThread that provides the current date and time
     */
    public DisplayThread(UpdateThread updateThread) {
        this.updateThread = updateThread;
    }

    /**
     * Continuously displays the current time and date once every second.
     * 
     * @return none
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(updateThread.getCurrentTime().format(timeFormatter) + " " 
            + updateThread.getCurrentDate().format(dateFormatter));
        }
    }
}

/**
 * Main class to start the clock system.
 * This class prompts the user to start the clock and handles the threads.
 * 
 * @author Liam-York Robertson
 */
public class Clock {
    /**
     * Main method to initiate the clock system.
     * It prompts the user to start the clock and starts the UpdateThread and DisplayThread.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Clock System!\n");
        System.out.println("Press the key 's' to start the clock.");
        System.out.println("Press the combination \"ctrl + c\" to stop the program at any time.");
        System.out.println("\nEnter your choice:");

        Scanner scanner = new Scanner(System.in);

        // wait for user input to start the clock
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("s")) {
                UpdateThread updateData = new UpdateThread();
                DisplayThread displayData = new DisplayThread(updateData);

                Thread updateThread = new Thread(updateData);
                Thread displayThread = new Thread(displayData);

                updateThread.setPriority(7);
                displayThread.setPriority(10);

                updateThread.start();
                displayThread.start();

                System.out.println("\nThe clock will start soon.\n");
                break;
            } else {
                System.out.println("\nInvalid input. Please press 's' to start.");
                System.out.println("\nEnter your choice:");
            }
        }
        scanner.close();
    }
}
