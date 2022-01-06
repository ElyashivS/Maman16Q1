import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ServerController {
    Message s;

    @FXML
    public void initialize() {
        s = new Message("");
    }

    @FXML
    private TextArea textArea;

    @FXML
    private TextField textField;

    @FXML
    void connectButton(ActionEvent event) {

    }

    @FXML
    void logoutButton(ActionEvent event) {

    }

    @FXML
    void sendButton(ActionEvent event) {
        Message msg = new Message(textField.getText());
        new ClientThread(this, "127.0.0.1", msg).start();
    }

    public void setTextArea(String message) {
        textArea.setText(textArea.getText() + message);
    }
}
