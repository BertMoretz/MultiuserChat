package ServerPart;

import java.io.*;
import java.net.Socket;
import org.apache.log4j.Logger;

public class Connection implements Runnable {

    Socket socket;

    Chat chat;

    private static final Logger log = Logger.getLogger(Connection.class);

    public Connection (Socket socket, Chat chat) {
        this.socket = socket;
        this.chat = chat;
    }

    @Override
    public void run() {
        String username = "";
        try (ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {

            username = inputStream.readUTF();

            User user = new User(chat.isEmpty() ? 1 : chat.usersLength() + 1, username);

            chat.addUser(user);
            chat.addOutputStream(outputStream);

            processMessage(inputStream, outputStream, user);

        } catch (IOException e) {
            log.error(Thread.currentThread().getName() + " -  ServerPart.Connection with " + username + " was lost.   Socket is closed\n");
        } catch (ClassNotFoundException e) {
            log.error(Thread.currentThread().getName() + " -  An error occurred while object was read. Class was not found in the packages\n");
        }
    }

    private void processMessage(ObjectInputStream inputStream, ObjectOutputStream outputStream, User user) throws IOException, ClassNotFoundException {
        String message;
        while (true) {
            message = (String) inputStream.readObject();

            if ("\\exit".equals(message)) {
                outputStream.writeObject(message);
                outputStream.flush();
                chat.removeOutputStream(outputStream);
                chat.removeUser(user);
                log.info(Thread.currentThread().getName() + " -  ServerPart.User " + user.getNickname() + " has left the ServerPart.Chat \n");
                return;
            } else {
                log.info(Thread.currentThread().getName() + " -  Message from " + user.getNickname() + ":  " + message + "\n");

                chat.sendMessage(message, outputStream);
            }
        }
    }
}
