import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server() {
        boolean listening = true;
        boolean firstConnected = true;

        try {
            ServerSocket serverSocket = null;
            Socket socket = null;
            ServerThread user1 = null;
            ServerThread user2 = null;

            serverSocket = new ServerSocket(7777);
            while (listening) {
                socket = serverSocket.accept();
                if (firstConnected) {
                    firstConnected = false;
                    user1 = new ServerThread(socket);
                } else {
                    firstConnected = true;
                    user2 = new ServerThread(socket);
                }
//                new ServerThread(socket).start();

            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
