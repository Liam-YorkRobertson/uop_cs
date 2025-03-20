package networks;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * The ChatServer class represents a server that manages multiple clients in a chatroom.
 * It handles incoming client connections, user authentication, and broadcasting messages to all connected clients.
 * 
 * @author Liam-York Robertson
 */
public class ChatServer {
    private static ServerSocket serverSocket;
    private static final int port = 5000;
    private static Map<String, ClientInfo> clients = new HashMap<>();
    private static Set<PrintWriter> clientWriters = new HashSet<>();
    private static int clientIdCounter = 1;
    

    /**
     * The ClientHandler class handles individual client connections in separate threads.
     * It is responsible for managing communication with a specific client, processing their messages, 
     * broadcasting messages to other clients, and managing the client's connection lifecycle.
     * 
     * @author Liam-York Robertson
     */
    private static class ClientHandler extends Thread {
        private String username;
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private ClientInfo clientInfo;

        /**
         * Constructs a ClientHandler instance for a specific client connection.
         * 
         * @param socket the socket representing the client connection
         */
        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        /**
         * The run method that is executed when the thread starts.
         * It handles user input, broadcasts messages, and manages client connections.
         */
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                username = in.readLine();
                if (username == null || username.trim().isEmpty()) {
                    out.println("Invalid username. Please provide a non-empty username.");
                    return;
                }

                synchronized (clients) {
                    clientInfo = new ClientInfo(clientIdCounter++, username);
                    clients.put(username, clientInfo);
                    System.out.println("Client #" + String.format("%04d", clientInfo.id) + " (" + username + ") has connected...");
                    broadcast(username + " has joined the chatroom!", out);
                    printActiveClients();
                }

                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("Over")) {
                        break;
                    }

                    if (message.trim().isEmpty()) {
                        out.println("Error: Message cannot be empty.");
                        continue;
                    }

                    broadcast(username + ": " + message, out);
                }

                synchronized (clients) {
                    clients.remove(username);
                    System.out.println("Client " + username + " has disconnected.");
                    broadcast(username + " has left the chatroom", out);
                    printActiveClients();
                }

                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    if (out != null) out.close();
                    if (in != null) in.close();
                    if (socket != null) socket.close();
                } catch (IOException e) {
                    System.out.println("Error closing resources: " + e.getMessage());
                }
            }
        }

        /**
         * Broadcasts a message to all clients except the one that sent the message.
         * 
         * @param message the message to be broadcast
         * @param excludeWriter the writer to exclude from receiving the message (the client that sent it)
         */
        private void broadcast(String message, PrintWriter excludeWriter) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters) {
                    if (writer != excludeWriter) {
                        writer.println(message);
                    }
                }
            }
        }

        /**
         * Prints the list of active clients currently connected to the server.
         * Displays client information such as their ID and username.
         */
        private void printActiveClients() {
            synchronized (clients) {
                StringBuilder clientList = new StringBuilder("Connected clients: [");
                List<ClientInfo> sortedClients = new ArrayList<>(clients.values());
                sortedClients.sort(Comparator.comparingInt(client -> client.id));

                for (int i = 0; i < sortedClients.size(); i++) {
                    ClientInfo client = sortedClients.get(i);
                    clientList.append("Client #").append(String.format("%04d", client.id))
                              .append(": ").append(client.username);
                    
                    if (i < sortedClients.size() - 1) {
                        clientList.append(", ");
                    }
                }
                
                clientList.append("]");
                System.out.println(clientList);
            }
        }
    }

    /**
     * The ClientInfo class holds information about each connected client.
     * This includes their unique ID and username.
     * 
     * @author Liam-York Robertson
     */
    private static class ClientInfo {
        private int id;
        private String username;

        /**
         * Constructs a ClientInfo instance for a connected client.
         * 
         * @param id the unique ID of the client
         * @param username the username of the client
         */
        public ClientInfo(int id, String username) {
            this.id = id;
            this.username = username;
        }
    }

    /**
     * The main method that starts the chat server.
     * It listens for incoming client connections and creates a new thread for each client.
     * 
     * @param args command-line arguments (not used in this implementation)
     * @throws IOException if an error occurs while accepting client connections
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the Chat Server!");
        serverSocket = new ServerSocket(port);
        System.out.println("Waiting for clients to connect...");

        while (true) {
            try {
                new ClientHandler(serverSocket.accept()).start();
            } catch (IOException e) {
                System.out.println("Error accepting client connection: " + e.getMessage());
            }
        }
    }
}
