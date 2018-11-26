package ClientPart;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        int port = 9001;
        if (args.length == 0) {
            System.out.printf("Port number is not specified. Using default one: %d\n", port);
        } else {
            port = Integer.valueOf(args[0]);
            System.out.printf("Using port number: %d\n", port);
        }

        ClientConnector connector = new ClientConnector(port);
        connector.connect();
    }
}
