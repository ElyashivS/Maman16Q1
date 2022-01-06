import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
    private ServerController cont;
    private String ip;
    private Message num;

    public ClientThread(ServerController cont, String ip, Message num) {
        this.cont = cont;
        this.ip = ip;
        this.num = num;
    }
    public void run() {
        super.run();
        try {
            handleReadAndWrite();
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void handleReadAndWrite() throws IOException, ClassNotFoundException {
        Socket s = new Socket(ip, 7777);

        OutputStream outputStream = s.getOutputStream();
        ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
        InputStream inputStream = s.getInputStream();
        ObjectInputStream objInputStream = new ObjectInputStream(inputStream);

        objOutputStream.writeObject(num);

        num = (Message) objInputStream.readObject();
//        cont.setBinaryNum(num.getBinaryNum());

        outputStream.close();
        objOutputStream.close();
        inputStream.close();
        objInputStream.close();
        s.close();

    }
}
