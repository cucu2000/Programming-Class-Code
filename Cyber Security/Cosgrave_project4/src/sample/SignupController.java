package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SignupController {

    @FXML
    public TextField txtName;
    @FXML
    public TextField txtEmail;
    @FXML
    public TextField txtUsername;
    @FXML
    public TextField txtPassword;
    @FXML
    public TextField txtConfirm;

    public void signupPressed(ActionEvent ae) throws IOException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        User user = new User();
        Hash hash = new Hash();
        user.setName(txtName.getText());
        user.setEmail(txtEmail.getText());
        user.setUserName(txtUsername.getText());

        byte [] salt = hash.getSalt();
        String password = hash.getHash(txtPassword.getText(), salt);


        user.setPassword(password);
        String saltString = Base64.getEncoder().encodeToString(salt);
        user.setSalt(saltString);

        Main.users.add(user);

        Encryption enc = new Encryption();
        for (int x=0; x<Main.users.size(); x++){
            String encName = enc.encrypt(Main.users.get(x).getName(), "ABC123");
            Main.users.get(x).setName(encName);
        }

        JSONFile.Save(Main.users);

        Common.loadWindow(ae, "Home.fxml");
    }

    public void cancelPressed(ActionEvent ae) throws IOException {
        Common.loadWindow(ae, "Login.fxml");
    }
}
