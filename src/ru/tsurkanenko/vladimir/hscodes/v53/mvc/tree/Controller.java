package ru.tsurkanenko.vladimir.hscodes.v53.mvc.tree;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
import ru.tsurkanenko.vladimir.hscodes.v53.mvc.model.Model;

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
public class Controller implements Initializable {
    // Элементы Представления, состояние которых требуется менять или обновлять
    @FXML
    TreeView<String> mainTree;

    @FXML
    MenuItem getNote;

// --Commented out by Inspection START (02/07/2021, 01:44):
//    // Внутренние переменные
//    TreeItem<String> selectedTreeItem;
// --Commented out by Inspection STOP (02/07/2021, 01:44)

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model model= new Model();
        // Создание корневого узла дерева
        TreeItem<String> root = model.getTree();


        // передаем корневой узел в компоненту
        mainTree.setRoot(root);
        mainTree.setShowRoot(false);
        // раскрываем узел
        root.setExpanded(true);
    }


    // Обработка элементов управления Представления
    @FXML void buttonCloseOnAction(){
        System.exit(0);
    }
    @FXML void buttonDetailsMoreOnActions(){
        //TODO Вывести справку о выбранном элементе
    }
    @FXML void mouseClickOnTree(){
        //TODO Вывести справку о выбранном элементе
    }
    @FXML void menuShowNote(){
            //getNote.setVisible(!getNote.isVisible());
            HelpApp x = new HelpApp();
        try {
            x.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
