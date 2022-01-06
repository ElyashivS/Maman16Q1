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
    void sendButton(ActionEvent event) {
        textArea.setText(textArea.getText() + textField.getText());
    }
}
