package ServerPart;

import Loader.JarLoader;
import org.apache.log4j.Logger;

import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CommandProc implements  Runnable {
    private String name;
    private String[] args;
    private String result;

    ObjectOutputStream sender;
    Chat chat;

    private static final Logger log = Logger.getLogger(CommandProc.class);

    public CommandProc(String name, String[] args, ObjectOutputStream sender, Chat chat) {
        this.name = name;
        this.args = args;
        this.sender = sender;
        this.chat = chat;
    }


    @Override
    public void run() {
        JarLoader jl = new JarLoader("src/jars/");
        Class cls = null;

        try {
            cls = jl.findClass(name);
        } catch (ClassNotFoundException e) {
            log.error("There is no class ———  " + name + "\n");
            result = "No such command";
        }

        try {
            Method comp= cls.getMethod("compute", String[].class);
            Object obj = cls.getConstructor().newInstance();
            result = (String) comp.invoke(obj,  new Object[]{args});
            System.out.println(result);

        } catch (NoSuchMethodException e) {
            result = "Wrong Arguments passed";
            log.error("Wrong Arguments passed");
        } catch (IllegalAccessException e) {
            log.error("Error occurred: " + e);
        } catch (InvocationTargetException e) {
            log.error("Error occurred: " + e + "\n");
        } catch (InstantiationException e) {
            log.error("Can't instantiate object of class " + cls.getName() + "\n");
        }

        chat.sendCommandResults(result, sender);
    }
}
