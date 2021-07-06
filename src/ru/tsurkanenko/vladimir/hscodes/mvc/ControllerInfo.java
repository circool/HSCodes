package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerInfo extends ViewInfo implements Initializable {
    final String message;
    final String details;

    public ControllerInfo(String helpMessage, String helpDetails) {
        message = helpMessage;
        details = helpDetails;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        helpMessageLabel.setText(message);
        helpDetailsLabel.setText(details);
        infoCloseButton.setOnAction(e -> closeWindow());
    }
    void closeWindow(){
        try{infoStage.close();}
        catch (Exception e){
            System.out.println("Попытка закрыть несуществующее окно");
        }
    }
}
