// Server2 claserverSocket that
// receives data and sends data

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String args[]) throws Exception {

        ServerSocket serverSocket = new ServerSocket(888);

        Socket socket = serverSocket.accept();
        System.out.println("Connection established");

        PrintStream printStream = new PrintStream(socket.getOutputStream());
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String msg, msg1;

            while ((msg = bufferReader.readLine()) != null) {
                System.out.println(msg);
                msg1 = keyboardReader.readLine();

                printStream.println(String.format("\t\t\t\t%s",msg1));
            }

            // close connection
            printStream.close();
            bufferReader.close();
            keyboardReader.close();
            serverSocket.close();
            socket.close();

            // terminate application
            System.exit(0);

        }
    }
}
