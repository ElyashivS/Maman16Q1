import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket s = null;
    public ServerThread(Socket socket) {
        this.s = socket;
    }

    @Override
    public void run() {
        super.run();
        try {
            handleReadAndWrite();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleReadAndWrite() throws Exception {
        OutputStream outputStream = s.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        InputStream inputStream = s.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);


        Message msg;
        msg = (Message) objectInputStream.readObject();
        msg.setMsg(msg.getMsg());
        objectOutputStream.writeObject(s);

        objectInputStream.close();
        inputStream.close();
        objectOutputStream.close();
        outputStream.close();
        s.close();
    }
}
