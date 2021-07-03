package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerHelp implements Initializable {
    @FXML
    public Label helpMessageLabel, helpDetailsLabel;
    Model model;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new Model();
        helpMessageLabel.setText(model.getActiveSection());
        helpDetailsLabel.setText(model.getSectionNote());
    }
    @FXML
    public void helpCloseButtonOnAction(){
        MainAppHelp.hide();
    }


}
