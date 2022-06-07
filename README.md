# java-socket-programming
Java program that allows a two-way communication between two computers (client and server program).
The program's main purpose is to get a client's disk information remotely, by implementing client-server architecture using Java Socket. The program is made of three Java classes: Client, Server, and DeviceInfo classes.

DeviceInfo class: responsible for providing the device's disk information to the client program.

Client class: initiates connection to the server and sends it's disk information to it.

Server class: listening to a connection request from the clients and communicating with them

To check the program you are required to run the server class first and then the client class. But you don't need to run the DeviceInfo class, it implicitly run and built by the Client program.
