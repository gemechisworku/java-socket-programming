// Client2 class that
// sends data and receives also

import java.io.*;
import java.net.*;
import java.util.List;

public class Client {

    public static void main(String[] args) throws Exception
    {
        List<Double> clientInfo = DeviceInfo.findTotalUsage();

        System.out.println("Connecting to server....");
        Socket socket = new Socket("localhost", 888);
        System.out.println("Connection successful. Have a fun with your server!\n");

        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Here is my Disk Usage Info:");


            System.out.println((String.format("\tTotal Space %.2f", clientInfo.get(0))));
            System.out.println((String.format("\tUsed Space %.2f", clientInfo.get(1))));
            System.out.println((String.format("\tFree Space %.2f", clientInfo.get(2))));

            String msg, msg1;
            outputStream.writeBytes(String.format("Total Space: %.2f, Used Space: %.2f, Free Space: %.2f \n",
                    clientInfo.get(0), clientInfo.get(1), clientInfo.get(2)));
            do {
                msg1 = bufferReader.readLine();
                System.out.println(msg1);

                msg = keyboardReader.readLine();
                outputStream.writeBytes(msg + "\n");

            }while (!(msg.equals("exit")));

            // close connection.
            outputStream.close();
            bufferReader.close();
            keyboardReader.close();
            socket.close();
        }


    }

