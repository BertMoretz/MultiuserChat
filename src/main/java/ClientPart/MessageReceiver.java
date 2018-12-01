package ClientPart;

import java.io.*;
import java.io.ObjectInputStream;
import org.apache.log4j.Logger;

public class MessageReceiver implements Runnable {

    private ObjectInputStream inputStream;

    private static final Logger log = Logger.getLogger(MessageReceiver.class);
    public MessageReceiver(ObjectInputStream inputStream) {
            this.inputStream = inputStream;
    }

    @Override
    public void run() {
        String message;
        while (true) {
            try {
                message = inputStream.readUTF();
                if ("\\exit".equals(message)) {
                    return;
                }
                System.out.println(message);
            } catch (EOFException e) {
                log.error("Connection with the Server is lost.");
                return;
            } catch (IOException e) {
                log.error("An error occurred while receiving the message.");
            }
        }
    }
}
