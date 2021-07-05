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
 * Контроллер (ControllerTree) Model-View-ControllerTree
 * интерпретирует действия пользователя, оповещая модель о необходимости изменений
 * Предназначен для представления view.fxml использующего дерево для отображения данных
 * @author Vladimir Tsurkanenko
 * @version 0.5.5
 * @since 0.5.5
 */
public class ControllerTree implements Initializable {
    public static Stage infoStage;

    ModelTree model;
    @FXML
    TreeView<String> mainTreeView;
    @FXML
    MenuItem menuShowNote;
    @FXML
    public Button buttonDetailsMore;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        model= new ModelTree();
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
        buttonDetailsMore.setDisable(true);
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
        if(treeSelectionModel.getSelectedItem()!=null) {
            if (!model.getActiveTree().equals(treeSelectionModel.getSelectedItem().getValue())) {
                String selectedItem = treeSelectionModel.getSelectedItem().getValue();
                // получаем активный элемент из модели дерева и передаем их в модель MVC
                model.mouseClickOnTreeAction(treeSelectionModel.getSelectedItem());
                int codeLength = selectedItem.indexOf(" ");
                if (codeLength == 2)
                    buttonDetailsMore.setDisable(false);
                else
                    buttonDetailsMore.setDisable(treeSelectionModel.getSelectedItem().getParent().getValue().indexOf(" ") != 2);
            }
        } else {
            buttonDetailsMore.setDisable(true);
        }
    }

    @FXML
    void menuShowNoteOnAction() {
        try{infoStage.close();}
        catch (Exception e){
            System.out.println("Попытка закрыть несуществующее окно");
        }
        if( !model.getNote().equals("")){
            try {
                FXMLLoader infoLoader = new FXMLLoader(getClass().getResource("info_dialog.fxml"));
                String header, prim;
                if((model.getActiveGroup() != "") || (model.getActiveSection() != "")) {
                    header = model.getActiveGroup() + model.getActiveSection();
                    infoLoader.setController(new ControllerInfo(header, model.getNote()));
                }

                Parent infoRoot = infoLoader.load();
                infoStage = new Stage();
                infoStage.setTitle("Примечания");
                infoStage.setScene(new Scene(infoRoot));
                infoStage.show();
            }
            catch (Exception e) {
                System.err.println("Не удалось открыть окно примечаний");
            }
        }
    }
}
