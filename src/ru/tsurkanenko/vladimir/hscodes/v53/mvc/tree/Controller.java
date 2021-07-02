package ru.tsurkanenko.vladimir.hscodes.v53.mvc.tree;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import ru.tsurkanenko.vladimir.hscodes.v53.mvc.model.Model;
import java.net.URL;
import java.util.ResourceBundle;

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
    TreeView<String> rootView;
    TreeItem<String> root;
    MultipleSelectionModel<TreeItem<String>> selectionModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model model= new Model();
        // Создание корневого узла дерева
        root = model.getTree();
        rootView = new TreeView<>(root);

        // передаем корневой узел в компоненту
        mainTree.setRoot(rootView.getRoot());
        mainTree.setShowRoot(false);

        // раскрываем узел
        root.setExpanded(true);
        selectionModel = rootView.getSelectionModel();
        //selectionModel.select(1);
        selectionModel.selectedItemProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                //TODO Сделать обработчик событий
                /*
                String selected = selectionModel.getSelectedIndices().get(1).toString();
                //String selected = "";
                for(TreeItem<String> item : selectionModel.getSelectedItems()){
                    selected += item.getValue() + " ";
                }
                getNote.setText("Selected: " + selected);
                System.out.println("Tree item was selected");
                */
            }
        });
    }


    // Обработка элементов управления Представления
    @FXML void buttonCloseOnAction(){
        System.exit(0);
    }
    @FXML void buttonDetailsMoreOnActions(){
        //TODO Вывести справку о выбранном элементе
    }
    @FXML void mouseClickOnTree(){
        //TODO Сделать обработчик событий
    }
    @FXML void menuShowNote(){
        //TODO Сделать модальное окно
    }
}
