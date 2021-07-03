package ru.tsurkanenko.vladimir.hscodes.mvc;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер (Controller) Model-View-Controller
 * интерпретирует действия пользователя, оповещая модель о необходимости изменений
 * Предназначен для представления view.fxml использующего дерево для отображения данных
 * @author Vladimir Tsurkanenko
 * @version 0.5.5
 * @since 0.5.5
 */
public class Controller implements Initializable {
    Model model;
    @FXML
    TreeView<String> mainTree, rootView;
    TreeItem<String> rootTreeItem;
    MultipleSelectionModel<TreeItem<String>> selectionModel;
    MenuItem menuShowNote;

    @FXML
    public Label helpMessageLabel, helpDetailsLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        model= new Model();
        // Создание корневого узла дерева
        rootTreeItem = model.getTreeIterable();
        rootView = new TreeView<>(rootTreeItem);
        // передаем корневой узел в компоненту
        mainTree.setRoot(rootView.getRoot());
        mainTree.setShowRoot(false);
        model.setActiveSection(mainTree.getRoot().getChildren().get(0).getValue());
        // раскрываем узел
        rootTreeItem.setExpanded(true);
        selectionModel = rootView.getSelectionModel();
        /*
        selectionModel.selectedItemProperty().addListener(o -> {
            //TODO Сделать обработчик событий


        });

         */
        selectionModel.selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>(){
            public void changed(ObservableValue<? extends TreeItem<String>> changed, TreeItem<String> oldValue, TreeItem<String> newValue){
                model.setActiveSection(newValue.getValue());
            }
        });
    }

    @FXML
    void buttonCloseOnAction(){
        System.exit(0);
    }

    @FXML
    void buttonDetailsMoreOnActions() {
        System.out.println("Контроллер: Вызван метод buttonDetailsMoreOnActions");
        menuShowNoteOnAction();
    }

    @FXML
    void mouseClickOnTree(){
        System.out.println("Контроллер: Вызван метод mouseClickOnTree");
        //TODO Сделать обработчик событий
    }

    @FXML
    void menuShowNoteOnAction() {
        //TODO Сделать модальное окно
        System.out.println("Контроллер: Вызван метод menuShowNoteOnAction");
    }
}
