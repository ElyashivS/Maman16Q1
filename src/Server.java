import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server() {
        boolean listening = true;
        try {
            ServerSocket sc = null;
            Socket s = null;
            sc = new ServerSocket(7777);
            while (listening) {
                s = sc.accept();
                new ServerThread(s).start();
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
