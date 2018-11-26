package ClientPart;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class ClientConnector {
    int port;
    Socket socket;
    private static final Logger log = Logger.getLogger(ClientConnector.class);

    public ClientConnector(int port) {
        this.port = port;
    }

    public void connect() {
        try {
            socket = new Socket("127.0.0.1", port);
        } catch (IOException e) {
            System.out.println("Cannot connect to Server. Please, try again");
            return;
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {

            System.out.println("Welcome to the Public Chat Application");

            Scanner in = new Scanner(System.in);

            System.out.print("Enter your Nickname: ");
            String username = in.next();
            outputStream.writeUTF(username);

            System.out.println("Connecting to the chat...");

            MessageSender ms = new MessageSender(outputStream);
            MessageReceiver mr = new MessageReceiver(inputStream);
            Thread sender = new Thread(ms);
            Thread receiver = new Thread(mr);

            System.out.print("–––––––– Welcome to Chat ––––––––\n");
            System.out.println("–– type \\exit to exit from chat and close the application. \n");

            sender.start();
            receiver.start();

            sender.join();
            receiver.join();

        } catch (IOException e) {
            log.error("Can't communicate with Server. Connection was lost");
        } catch (InterruptedException e) {
            log.error("An error occured! Please reconnect.");
        }
    }
}
