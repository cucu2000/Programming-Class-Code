package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private Label lblHighLow;
    @FXML private Label lblNumberOfGuesses;
    @FXML private TextField txtInputGuess;
    @FXML private Button btnGuess;

    private Guess guess1 = new Guess();

    @FXML protected void btnGuessPressed(ActionEvent btnGuessPressed){
        String textFieldGuess = txtInputGuess.getText();
        int guessedNumber = Integer.parseInt(textFieldGuess);

        String result = guess1.compare(guessedNumber);
        lblHighLow.setText(result);


        Integer numGuessed = guess1.getNumberOfGuesses();
        lblNumberOfGuesses.setText(numGuessed.toString());
    }



}
