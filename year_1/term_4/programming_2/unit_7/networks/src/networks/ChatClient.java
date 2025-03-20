package networks;

import java.io.*;
import java.net.*;

/**
 * Represents a client that connects to a chat server for communication.
 * This class allows the user to input a username, send messages to the server,
 * and display incoming messages from the server.
 * 
 * @author Liam-York Robertson
 */
public class ChatClient {
    private Socket serverSocket;
    private PrintWriter serverOutput;
    private BufferedReader serverInput;
    private BufferedReader userInput;
    private String username;

    /**
     * Constructs a ChatClient instance that connects to the server.
     * Initialises necessary streams for communication and starts listening for server messages.
     * 
     * @param serverAddress the IP address of the server
     * @param port the port number to connect to on the server
     */
    public ChatClient(String serverAddress, int port) {
        try {
            serverSocket = new Socket(serverAddress, port);
            System.out.println("Connected to the Chat Server!");
            System.out.println("Type 'over' to disconnect from the server");

            userInput = new BufferedReader(new InputStreamReader(System.in));
            serverOutput = new PrintWriter(serverSocket.getOutputStream(), true);
            serverInput = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

            System.out.print("Enter your username: ");
            username = userInput.readLine();
            while (username == null || username.trim().isEmpty()) {
                System.out.print("Username cannot be empty. Please enter a valid username: ");
                username = userInput.readLine();
            }

            serverOutput.println(username);

            new Thread(this::listenToServer).start();

            handleUserInput();
            
            closeConnections();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Listens to messages from the server and displays them on the client's terminal.
     * This method runs in a separate thread to continuously monitor the server for new messages.
     * 
     * @return none
     */
    private void listenToServer() {
        try {
            while (true) {
                String serverMessage = serverInput.readLine();
                
                if (serverMessage == null) {
                    System.out.println("Server disconnected. Exiting...");
                    break;
                }
                
                System.out.println(serverMessage);
            }
        } catch (IOException e) {
            System.out.println("Connection closed: " + e.getMessage());
        } finally {
            System.exit(0);
        }
    }

    /**
     * Handles user input by reading messages from the console and sending them to the server.
     * Ensures that messages are not empty before sending and closes the connection if the user types "Over".
     * 
     * @throws IOException if an input/output error occurs
     */
    private void handleUserInput() throws IOException {
        String message;
        while (true) {
            message = userInput.readLine();

            if (message != null && message.trim().isEmpty()) {
                System.out.println("Error: Message cannot be empty.");
                continue;
            }

            if (message == null || message.equalsIgnoreCase("Over")) {
                break;
            }
            serverOutput.println(message);
        }
    }

    /**
     * Closes the resources and shuts down the connection.
     * This method is called when the client disconnects from the server.
     * 
     * @throws IOException if an input/output error occurs during closing
     */
    private void closeConnections() throws IOException {
        System.out.println("Closing connection...");
        if (serverSocket != null) serverSocket.close();
        if (serverInput != null) serverInput.close();
        if (serverOutput != null) serverOutput.close();
        if (userInput != null) userInput.close();
    }

    /**
     * The main method that runs the ChatClient application.
     * 
     * @param args command-line arguments (not used in this implementation)
     */
    public static void main(String[] args) {
        new ChatClient("127.0.0.1", 5000);
    }
}
