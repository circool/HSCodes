package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер для управления элементами информационного окна, запускаемого классом InfoWindow
 * Для отображения представления используется info_dialog.fxml
 * @see InfoWindow
 * @version 0.5.6
 * @since 0.4
 * @author Vladimir Tsurkanenko
 */
public class ControllerInfo implements Initializable {
    @SuppressWarnings("unused")
    @FXML
    Button infoCloseButton;
    @SuppressWarnings("unused")
    @FXML
    Label infoMessageLabel, infoDetailsLabel;
    Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        infoCloseButton.setOnAction(e -> infoCloseButtonOnAction());
    }

    /**
     * Вызывается при нажатии кнопки infoCloseButton и закрывает текущее окно
     */
    void infoCloseButtonOnAction(){
        stage.close();
    }

    /**
     * Устанавливает ссылку на текущую сцену для возможности дальтейшего управления сценой из этого контроллера
     */
    void setStage(Stage stage){
        this.stage=stage;
    }

    /**
     * Устанавливает текст метки infoDetailsLabel отображающей основной текст выводимого сообщения
     */
    void setBody(String body){
        infoDetailsLabel.setText(body);
    }

    /**
     * Устанавливает текст метки infoMessageLabel отображающей заголовок выводимого сообщения
     */
    void setHeader(String header){
        infoMessageLabel.setText(header);
    }
}
