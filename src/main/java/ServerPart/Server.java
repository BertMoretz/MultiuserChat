package ServerPart;


public class Server {
    public static void main(String[] args) {
        int port = 9001;

        if (args.length != 1) {
            System.out.printf("Using default port number: %d\n", port);
        } else {
            port = Integer.valueOf(args[0]);
        }
        System.out.printf("Using port number: %d\n", port);

        Accepter accepter = new Accepter(port);
        accepter.run();
    }
}
