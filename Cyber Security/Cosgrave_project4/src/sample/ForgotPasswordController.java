package sample;

import javafx.event.ActionEvent;
import java.io.IOException;

public class ForgotPasswordController {
    public void forgotPressed(ActionEvent ae) throws IOException {
        Common.loadWindow(ae, "Login.fxml");
    }

    public void cancelPressed(ActionEvent ae) throws IOException {
        Common.loadWindow(ae, "Login.fxml");
    }
}
