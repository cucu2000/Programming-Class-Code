package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class LoginController {

    @FXML
    public TextField txtUsername;
    @FXML
    public TextField txtPassword;
    @FXML
    public Label lblOutput;

    public void loginPressed(ActionEvent ae) throws IOException, NoSuchAlgorithmException {
        User user = new User();

        for(int x = 0; x < Main.users.size(); x++){
            if(Main.users.get(x).getUserName().equals(txtUsername.getText())){
                user = Main.users.get(x);
                continue;
            }else{
                lblOutput.setText("User not found");
            }
        }

        if(user != null){
            Hash hash = new Hash();
            byte [] saltByte = Base64.getDecoder().decode(user.getSalt());

            String hashedPassword = hash.getHash(txtPassword.getText(), saltByte);
            if(user.getPassword().equals(hashedPassword)){
                Common.loadWindow(ae, "Home.fxml");
            }else{
                lblOutput.setText("Incorrect Password");
            }
        }


    }

    public void signupPressed(ActionEvent ae) throws IOException{
        Common.loadWindow(ae, "Signup.fxml");
    }

    public void forgotPressed(ActionEvent ae) throws IOException {
        Common.loadWindow(ae, "ForgotPassword.fxml");
    }
}
