package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML private Button btn9;
    @FXML private Button btn8;
    @FXML private Button btn7;
    @FXML private Button btn6;
    @FXML private Button btn5;
    @FXML private Button btn4;
    @FXML private Button btn3;
    @FXML private Button btn2;
    @FXML private Button btn1;
    @FXML private Button btn0;
    @FXML private Button btnAdd;
    @FXML private Button btnMinus;
    @FXML private Button btnMultiply;
    @FXML private Button btnDivide;
    @FXML private Button btnEquals;
    @FXML private Label lblResult;
    private String operator;
    public double firstNum;
    public double secondNum;
    public double finalNum;

    Calc calc = new Calc();

    @FXML
    protected void btn9Pressed(ActionEvent btn9Pressed) {
        String lblStart = lblResult.getText();
        lblStart += "9";
        lblResult.setText(lblStart);

    }

    @FXML
    protected void btn8Pressed(ActionEvent btn8Pressed) {
        String lblStart = lblResult.getText();
        lblStart += "8";
        lblResult.setText(lblStart);

    }

    @FXML
    protected void btn7Pressed(ActionEvent btn7Pressed) {
        String lblStart = lblResult.getText();
        lblStart += "7";
        lblResult.setText(lblStart);

    }

    @FXML
    protected void btn6Pressed(ActionEvent btn6Pressed) {
        String lblStart = lblResult.getText();
        lblStart += "6";
        lblResult.setText(lblStart);

    }

    @FXML
    protected void btn5Pressed(ActionEvent btn5Pressed) {
        String lblStart = lblResult.getText();
        lblStart += "5";
        lblResult.setText(lblStart);

    }

    @FXML
    protected void btn4Pressed(ActionEvent btn4Pressed) {
        String lblStart = lblResult.getText();
        lblStart += "4";
        lblResult.setText(lblStart);

    }

    @FXML
    protected void btn3Pressed(ActionEvent btn3Pressed) {
        String lblStart = lblResult.getText();
        lblStart += "3";
        lblResult.setText(lblStart);

    }

    @FXML
    protected void btn2Pressed(ActionEvent btn2Pressed) {
        String lblStart = lblResult.getText();
        lblStart += "2";
        lblResult.setText(lblStart);

    }

    @FXML
    protected void btn1Pressed(ActionEvent btn1Pressed) {
        String lblStart = lblResult.getText();
        lblStart += "1";
        lblResult.setText(lblStart);

    }

    @FXML
    protected void btn0Pressed(ActionEvent btn0Pressed) {
        String lblStart = lblResult.getText();
        lblStart += "0";
        lblResult.setText(lblStart);

    }

    @FXML
    protected void btnAddPressed(ActionEvent btnAddPressed) {
        this.operator = "add";
        if (lblResult.getText().equals("")) {
            this.firstNum = 0;
        }
        String firstSNum = lblResult.getText();
        this.firstNum = Double.parseDouble(firstSNum);
        lblResult.setText("");


    }

    @FXML
    protected void btnMinusPressed(ActionEvent btnMinusPressed) {
        this.operator = "subtract";
        if (lblResult.getText().equals("")) {
            this.firstNum = 0;
        }
        String firstSNum = lblResult.getText();
        this.firstNum = Double.parseDouble(firstSNum);
        lblResult.setText("");


    }

    @FXML
    protected void btnDividePressed(ActionEvent btnDividePressed) {
        this.operator = "divide";
        if (lblResult.getText().equals("")) {
            this.firstNum = 0;
        }
        String firstSNum = lblResult.getText();
        this.firstNum = Double.parseDouble(firstSNum);
        lblResult.setText("");


    }

    @FXML
    protected void btnMultiplyPressed(ActionEvent btnMultiplyPressed) {
        this.operator = "multiply";
        if (lblResult.getText().equals("")) {
            this.firstNum = 0;
        }
        String firstSNum = lblResult.getText();
        this.firstNum = Double.parseDouble(firstSNum);
        lblResult.setText("");


    }

    @FXML
    protected void btnDecimalPressed(ActionEvent btnDecimalPressed) {
        String lblStart = lblResult.getText();
        lblStart += ".";
        lblResult.setText(lblStart);
    }

    @FXML
    protected void btnEqualsPressed(ActionEvent btnEqualsPressed) {
        if (lblResult.getText().equals("")) {
            this.secondNum = 0;
        }
            String secondSNum = lblResult.getText();
            this.secondNum = Double.parseDouble(secondSNum);
            String finalSNum;
            switch (this.operator) {
                case "add":
                    this.finalNum = calc.add(this.firstNum, this.secondNum);
                    finalSNum = Double.toString(this.finalNum);
                    lblResult.setText(finalSNum);
                    break;
                case "subtract":
                    this.finalNum = calc.subtract(this.firstNum, this.secondNum);
                    finalSNum = Double.toString(this.finalNum);
                    lblResult.setText(finalSNum);
                    break;
                case "multiply":
                    this.finalNum = calc.multiply(this.firstNum, this.secondNum);
                    finalSNum = Double.toString(this.finalNum);
                    lblResult.setText(finalSNum);
                    break;
                case "divide":
                    this.finalNum = calc.divide(this.firstNum, this.secondNum);
                    if (secondNum == 0) {
                        lblResult.setText("err: division by 0");
                        System.exit(1);
                    }
                    finalSNum = Double.toString(this.finalNum);
                    lblResult.setText(finalSNum);
                    break;
            }
        }
}