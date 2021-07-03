package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
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
    public static Stage helpStage;

    Model model;
    @FXML
    TreeView<String> mainTreeView;
    @FXML
    MenuItem menuShowNote;

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
        //System.out.println("Контроллер: Вызван метод buttonDetailsMoreOnActions");
        menuShowNoteOnAction();
    }

    @FXML
    void mouseClickOnTree(){
        // для выбора/получения активного элемента сначала получаем модель дерева
        SelectionModel<TreeItem<String>> treeSelectionModel = mainTreeView.getSelectionModel();
        // получаем активный элемент из модели дерева и передаем их в модель MVC
        if(treeSelectionModel.isEmpty()) {
            model.setActiveSection("");
            menuShowNote.setDisable(true);
        }
        else {
            model.setActiveSection(treeSelectionModel.getSelectedItem().getValue());
            menuShowNote.setDisable(false);
        }
        menuShowNote.setText("Примечание для " + model.getActiveSection()) ;
    }

    @FXML
    void menuShowNoteOnAction() {
        try {
            FXMLLoader helpLoader = new FXMLLoader(getClass().getResource("help.fxml"));
            Parent helpRoot = helpLoader.load();
            helpStage = new Stage();
            helpStage.setTitle("Примечания");
            helpStage.setScene(new Scene(helpRoot));
            helpStage.show();
        }
        catch (Exception e) {
            System.err.println("Не удалось открыть окно примечаний");
        }
    }

}
