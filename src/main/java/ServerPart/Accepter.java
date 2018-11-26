package ServerPart;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Accepter {
    int port;
    ServerSocket serverSocket;
    private static final Logger log = Logger.getLogger(Accepter.class);

    public Accepter(int port) {
        this.port = port;
    }

    public void run() {

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            log.error("An error occurred! Please, try again! " + e.getMessage() + "\n");
            return;
        }

        Chat chat = new Chat();

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                log.info("New User Accepted  (" + socket + ") \n");

                Connection connection = new Connection(socket, chat);

                Thread connectionThread = new Thread(connection);
                //connectionThread.setName("ServerPart.Connection-");
                connectionThread.start();

//                Scanner in = new Scanner(System.in);
//                String command = in.next();
//                if ("\\down".equals(command)) {     //to shut down the server
//                    socket.close();
//                    return;
//                }

            } catch (IOException e) {
                log.error("An error occurred! Please, try again! " + e.getMessage() + "\n");
            }
        }
    }

}
