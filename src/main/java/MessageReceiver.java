import java.io.*;
import java.io.ObjectInputStream;

public class MessageReceiver implements Runnable {

    private ObjectInputStream inputStream;

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
                System.out.println("Connection with the Server is lost.");
            } catch (IOException e) {
                System.out.println("An error occurred while receiving the message.");
            }
        }
    }
}
