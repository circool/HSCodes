package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerHelp implements Initializable {



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        helpMessageLabel.setText("Раздел");
        helpDetailsLabel.setText("Примечание");
    }


    @FXML
    private Label helpMessageLabel;

    @FXML
    private Label helpDetailsLabel;

    @FXML
    void helpCloseButtonOnAction(ActionEvent event) {
        Controller.helpStage.hide();
    }
}
