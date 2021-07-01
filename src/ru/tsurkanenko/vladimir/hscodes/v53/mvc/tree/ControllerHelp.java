package ru.tsurkanenko.vladimir.hscodes.v53.mvc.tree;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;
//TODO попытаться заполнить дерево при помощи рекурсивного вызова

/**
 * Контроллер (Controller) Model-View-Controller
 * интерпретирует действия пользователя, оповещая модель о необходимости изменений
 * Предназначен для представления view.fxml использующего выпадающие списки для отображения данных
 * @author Vladimir Tsurkanenko
 * @version 0.5.3
 * @since 0.4
 */
public class ControllerHelp implements Initializable {
    // Элементы Представления, состояние которых требуется менять или обновлять


// --Commented out by Inspection START (02/07/2021, 01:44):
//    @FXML
//    MenuItem getNote;
// --Commented out by Inspection STOP (02/07/2021, 01:44)

// --Commented out by Inspection START (02/07/2021, 01:44):
//    @FXML
//    Scene help;
// --Commented out by Inspection STOP (02/07/2021, 01:44)
    Stage primaryStage ;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    // Обработка элементов управления Представления
    @FXML void buttonCloseOnAction(){
        primaryStage.hide();
    }

}
