package sample;

import javafx.event.ActionEvent;
import java.io.IOException;

public class HomeController {
    public void changePressed(ActionEvent ae) throws IOException {
        Common.loadWindow(ae, "ChangePassword.fxml");
    }

    public void logoutPressed(ActionEvent ae) throws IOException {
        Common.loadWindow(ae, "Login.fxml");
    }
}
