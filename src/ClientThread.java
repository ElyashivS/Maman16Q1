import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
    private ServerController cont;
    private String ip;
    private Message msg;

    public ClientThread(ServerController cont, String ip, Message msg) {
        this.cont = cont;
        this.ip = ip;
        this.msg = msg;
    }

    public void run() {
        super.run();
        try {
            handleReadAndWrite();
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void handleReadAndWrite() throws IOException, ClassNotFoundException {
        Socket s = new Socket(ip, 7777);

        // Create connections.
        OutputStream outputStream = s.getOutputStream();
        ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
        InputStream inputStream = s.getInputStream();
        ObjectInputStream objInputStream = new ObjectInputStream(inputStream);

        // Write and read object.
        objOutputStream.writeObject(msg);
        msg = (Message) objInputStream.readObject();
        cont.setTextArea(msg.getMsg());

        // Close connections.
        outputStream.close();
        objOutputStream.close();
        inputStream.close();
        objInputStream.close();
        s.close();
    }
}
