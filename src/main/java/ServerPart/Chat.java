package ServerPart;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public class Chat implements Serializable{
    private Vector<User> users = new Vector<>();
    private Vector<ObjectOutputStream> outputStreams = new Vector<>();

    public Chat () {
        //Chat created
    }

    public void addUser(User newUser) {
        users.add(newUser);
    }

    public  void removeUser (User user) {
        users.remove(user);
    }

    public void  addOutputStream(ObjectOutputStream oos) {
        outputStreams.add(oos);
    }

    public void removeOutputStream (ObjectOutputStream oos) {
        outputStreams.remove(oos);
    }

    public int usersLength() {
        return users.size();
    }

    public boolean isEmpty() {
        return users.isEmpty();
    }

    public void sendMessage(String message, ObjectOutputStream outputStream) {
        Vector<ObjectOutputStream> closedStreams = new Vector<>();

        String senderName = users.get(outputStreams.indexOf(outputStream)).getNickname();
        for (ObjectOutputStream oos : outputStreams) {
            if (oos != outputStream) {
                try {
                    oos.writeUTF(senderName + ":\t" + message);
                    oos.flush();
                } catch (IOException e) {
                    // Socket was closed for that stream
                    closedStreams.add(oos);
                }
            }
        }
        outputStreams.removeAll(closedStreams);
    }

    public void sendCommandResults(String message, ObjectOutputStream outputStream) {
        try {
            outputStream.writeUTF("Result:\t" + message);
            outputStream.flush();
        } catch (IOException e) {
                    // Socket was closed for that stream

        }
    }
}
