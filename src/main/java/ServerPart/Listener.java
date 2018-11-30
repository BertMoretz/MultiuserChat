package ServerPart;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;
import java.net.ServerSocket;

public class Listener implements Runnable{

    ServerSocket socket;
    private static final Logger log = Logger.getLogger(Listener.class);

    public Listener (ServerSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Scanner in = new Scanner(System.in);
            String command = in.next();
            if ("\\down".equals(command)) {     //to shut down the server
                socket.close();
                return;
            }
        } catch (IOException e) {
            log.error("An error occurred! Please, try again! " + e.getMessage() + "\n");
            return;
        }
    }
}
