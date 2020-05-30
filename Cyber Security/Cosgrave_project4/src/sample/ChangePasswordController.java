package sample;

import javafx.event.ActionEvent;
import java.io.IOException;

public class ChangePasswordController {

    public void changePressed(ActionEvent ae) throws IOException {
        Common.loadWindow(ae, "Home.fxml");
    }

    public void cancelPressed(ActionEvent ae) throws IOException {
        Common.loadWindow(ae, "Home.fxml");
    }
}
