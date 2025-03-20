How to Run:

	Compiling: In the parent directory, use the wildcard to compile all Java files 	simultaneously. For example, in the parent directory that contains the files, run the 	following command: "javac parent_directory/*.java"

	Running the Server: In the parent directory, run the server using the following command: 	"java parent_directory.ChatServer"

	Running the Client: In the parent directory, open a new terminal and run the following 	command to start the client: "java parent_directory.ChatClient"
	
Implementation:

	To create this program, I utilised various resources, including the assigned reading and videos, as well as an introduction to networking in Java (Eck, 2022; Pankaj, 2022; SimpliCode, 2021). However, additional knowledge was necessary to meet the requirements of the project, and I primarily relied on articles from GeeksforGeeks (2020, 2021, 2025) for guidance on creating a multithreaded chatroom that manages multiple clients connecting to the server simultaneously. A particularly useful source was the article by Jenkov (2020), where I gained a deeper understanding of synchronised blocks in instance methods.

	Regarding the actual program, I created two classes: ChatServer and ChatClient. The server manages connections from multiple clients and broadcasts messages from one client to others. It also assigns an ID to each user and keeps track of the clients within the instance using a HashMap. The ChatClient class handles client-side operations, including connecting to the server, sending messages, and receiving broadcasts. It establishes a connection using sockets and maintains communication through input and output streams.

	The ChatServer class manages multiple clients by handling connections, user authentication, and message broadcasting. It listens for incoming connections using a ServerSocket and creates a new thread for each client. The run method processes client communication, handles messages, and manages disconnections. Messages are broadcast using the broadcast method, ensuring all clients receive updates except the sender, while the printActiveClients method maintains a list of connected users. The ClientInfo class stores client details, including their ID and username, which enables the server to track active users. Thanks to multithreading, the server efficiently supports multiple clients, ensuring smooth and continuous communication.

	The ChatClient class manages the client-side operations of the chat application, enabling users to connect to the server, send messages, and receive broadcasts. It establishes a connection to the server through a socket and manages communication via input and output streams. The class creates two threads: one for reading user input and sending messages to the server, and another for listening for incoming messages from the server. This multithreaded approach ensures seamless, uninterrupted communication. The client maintains continuous interaction with the server, receiving real-time updates from other clients while allowing the user to send their own messages to the chatroom.

	References:

	Eck, D. J. (2022). Introduction to programming using Java version 9, JavaFX edition. Licensed under CC 4.0. https://math.hws.edu/javanotes/ 
	GeeksforGeeks. (2020, November 6). Multithreaded servers in Java. https://www.geeksforgeeks.org/multithreaded-servers-in-java/ 
	GeeksforGeeks. (2021, September 3). Multi-threaded chat application in Java | Set 1 (Server-side programming). https://www.geeksforgeeks.org/multi-threaded-chat-application-set-1/ 
	GeeksforGeeks. (2025, January 3). Socket programming in Java. https://www.geeksforgeeks.org/socket-programming-in-java/ 
	Jenkov, J. (2020). Java synchronized blocks. Jenkov.com. https://jenkov.com/tutorials/java-concurrency/synchronized.html 
	Pankaj. (2022, August 4). Java socket programming – Socket server, client example. DigitalOcean. https://www.digitalocean.com/community/tutorials/java-socket-programming-server-client 
	SimpliCode. (2021, February 14). Java tutorial for beginners | Networking in Java | Java networking tutorial | SimpliCode [Video]. YouTube.