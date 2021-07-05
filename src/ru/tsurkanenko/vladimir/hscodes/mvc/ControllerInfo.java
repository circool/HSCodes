package ru.tsurkanenko.vladimir.hscodes.mvc;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerInfo implements Initializable {
    final String message;
    final String details;

    public ControllerInfo(String helpMessage, String helpDetails) {
        message = helpMessage;
        details = helpDetails;
    }




    @FXML
    private Label helpMessageLabel;

    @FXML
    private Label helpDetailsLabel;

    @FXML
    private Button infoCloseButton;

    void closeWindow(){
        ControllerTree.infoStage.hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        helpMessageLabel.setText(message);
        helpDetailsLabel.setText(details);
        infoCloseButton.setOnAction(e -> closeWindow());
    }
}
