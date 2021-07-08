package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер для управления информационным окном
 * @version 0.5.6
 * @since 0.4
 * @author Vladimir Tsurkanenko
 */
public class ControllerInfo implements Initializable {
    @FXML
    Button infoCloseButton;
    @FXML
    Label infoMessageLabel;
    @FXML
    Label infoDetailsLabel;

    Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        infoCloseButton.setOnAction(e -> infoCloseButtonOnAction());
    }

    void infoCloseButtonOnAction(){
        stage.close();
    }

    void setStage(Stage stage){
        this.stage=stage;
    }

    void setBody(String body){
        infoDetailsLabel.setText(body);
    }

    void setHeader(String header){
        infoMessageLabel.setText(header);
    }
}
