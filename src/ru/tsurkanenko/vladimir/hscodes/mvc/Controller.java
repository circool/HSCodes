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
    TreeView<String> mainTreeView; // элемент в view.fxml
    //TreeView<String> rootTreeView;
    //TreeItem<String> rootTreeItem;
    //MultipleSelectionModel<TreeItem<String>> selectionModel;
    MenuItem menuShowNote;

    @FXML
    public Label helpMessageLabel, helpDetailsLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        model= new Model();
        // Создание корневого узла дерева
        TreeItem<String> rootTreeItem = model.getTreeIterable();
        // раскрываем дерево
        rootTreeItem.setExpanded(true);
        // устанавливаем корневой узел для TreeView
        TreeView<String> rootTreeView = new TreeView<>(rootTreeItem);
        // делаем корневой rootTreeView узел корневым для mainTreeView
        mainTreeView.setRoot(rootTreeView.getRoot());
        // скрываем корневой узел дерева
        mainTreeView.setShowRoot(false);
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
        // для выбора элемента сначала получаем модель дерева
        SelectionModel<TreeItem<String>> treeSelectionModel = mainTreeView.getSelectionModel();
        // передать в модель выбраный пункт дерева
        model.setActiveSection(treeSelectionModel.getSelectedItem().getValue());
    }

    @FXML
    void menuShowNoteOnAction() {
        //TODO Сделать модальное окно
        System.out.println("Контроллер: Вызван метод menuShowNoteOnAction");
    }
}
