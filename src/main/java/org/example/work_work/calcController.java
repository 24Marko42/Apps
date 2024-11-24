package org.example.work_work;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class calcController {

    @FXML
    private TextField display;

    private String currentInput = "";
    private String operator = "";
    private double firstOperand = 0;
    private boolean startNewInput = true;

    @FXML
    public void handleButtonClick(javafx.event.ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();

        if (buttonText.matches("[0-9.]")) {
            if (startNewInput) {
                currentInput = buttonText;
                startNewInput = false;
            } else {
                currentInput += buttonText;
            }
            display.setText(currentInput);
        } else if (buttonText.matches("[+\\-*/]")) {
            if (!currentInput.isEmpty()) {
                firstOperand = Double.parseDouble(currentInput);
                operator = buttonText;
                startNewInput = true;
            }
        }
    }

    @FXML
    public void handleEqual(javafx.event.ActionEvent event) {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            double secondOperand = Double.parseDouble(currentInput);
            double result = 0;

            switch (operator) {
                case "+" -> result = firstOperand + secondOperand;
                case "-" -> result = firstOperand - secondOperand;
                case "*" -> result = firstOperand * secondOperand;
                case "/" -> {
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        display.setText("Error");
                        return;
                    }
                }
            }
            display.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
            operator = "";
            startNewInput = true;
        }
    }

    @FXML
    public void handleClear(javafx.event.ActionEvent event) {
        currentInput = "";
        operator = "";
        firstOperand = 0;
        startNewInput = true;
        display.setText("");
    }

    @FXML
    public void handleBackspace(javafx.event.ActionEvent event) {
        if (!currentInput.isEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            display.setText(currentInput);
        }
    }
}
