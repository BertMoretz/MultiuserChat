package ServerPart;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Arrays;

import Loader.JarLoader;
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

            username = (String) inputStream.readObject();

            User user = new User(chat.isEmpty() ? 1 : chat.usersLength() + 1, username);

            chat.addUser(user);
            chat.addOutputStream(outputStream);

            processMessage(inputStream, outputStream, user);

        } catch (IOException e) {
            log.error(Thread.currentThread().getName() + " -  Connection with " + username + " was lost.   Socket is closed\n");
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
                log.info(Thread.currentThread().getName() + " -  User " + user.getNickname() + " has left the Chat \n");
                return;
            } else if (message.startsWith("\\")) {
                String[] command = message.split(" "); // \command arg1 arg2 ...
                String commandName = command[0].substring(1); // commandName = command
                log.info(commandName);

               JarLoader jl = new JarLoader("src/jars/");
               Class cls = jl.findClass(commandName);

               
                try {
                    Method[] compute = cls.getDeclaredMethods();


                    for (int i = 0; i < compute.length; i++) {
                        System.out.println(compute[i].getName());
                    }
                    Method comp= cls.getMethod("compute", int.class);
                    Object obj = cls.getConstructor().newInstance();
                    System.out.println(comp.invoke(obj, Integer.parseInt(command[1])));

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            } else {
                log.info(Thread.currentThread().getName() + " -  Message from " + user.getNickname() + ":  " + message + "\n");

                chat.sendMessage(message, outputStream);
            }
        }
    }
}
