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
 * Предназначен для представления tree.fxml использующего дерево для отображения данных
 * Управление элементами представления выполняется классом TreeView.
 * @see TreeView
 * @author Vladimir Tsurkanenko
 * @version 0.5.6
 * @since 0.5.6
 */
public class ControllerTree extends ViewTree implements Initializable {
    public static Stage infoStage;

    ModelTree model;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        model= new ModelTree();
        createTree(model.getTreeIterable());
        notesIsAvailable(false);
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

    /**
     * Метод выполняется при взаимодействии с древом кодов ТНВЭД
     */
    @FXML
    void mainTreeViewOnAction(){
        // для выбора/получения активного элемента сначала получаем модель дерева
        SelectionModel<TreeItem<String>> treeSelectionModel = mainTreeView.getSelectionModel();
        // получаем выбранный элемент дерева
        TreeItem<String> selectedItem = treeSelectionModel.getSelectedItem();
        /*
        Теперь разбираемся, что делать дальше:
            1. Если выбранный элемент не изменился: не делаем ничего
                2. Отметить или снять в модели отметку о выбранном элементе
                2.0 если никакой элемент не выбран сделать недоступной кнопку и меню "подробности"
                2.1 иначе установить элемент как активный
                    2.1.1 Если у выбранного элемента нет дочерних элементов: вывести полное описание элемента
                    2.1.2. Если у выбранного элемента есть дети:
                        2.1.2.1. Если это раздел или группа: вывести соответствующее примечание если оно есть
                        2.1.2.2. Если нет - ничего не делать
         */
        if(selectedItem!=null) {
            if (!model.getActiveTree().equals(treeSelectionModel.getSelectedItem().getValue())) {
                String selectedItemValue = selectedItem.getValue();
                // получаем активный элемент из модели дерева и передаем их в модель MVC
                model.mouseClickOnTreeAction(selectedItem);
                int codeLength = selectedItemValue.indexOf(" ");
                if (codeLength == 2)
                    notesIsAvailable(true);
                else
                    buttonDetailsMore.setDisable(selectedItem.getParent().getValue().indexOf(" ") != 2);
            }
        } else {
            notesIsAvailable(false);
        }

        if(treeSelectionModel.getSelectedItem().getChildren().size()==0)
            showItemDescription(treeSelectionModel.getSelectedItem());
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

    /**
     * Отображает окно с информацией о выбранном коде
     * @param selectedItem Выбранный элемент дерева
     */
    void showItemDescription(TreeItem<String> selectedItem){
        try{infoStage.close();}
        catch (Exception e){
            System.out.println("Попытка закрыть несуществующее окно");
        }
        try {
            FXMLLoader infoLoader = new FXMLLoader(getClass().getResource("info_dialog.fxml"));
            String header = "Полное описание:";
            String descr = model.getFinalDescription();
            infoLoader.setController(new ControllerInfo(header, model.getNote()));

            Parent infoRoot = infoLoader.load();
            infoStage = new Stage();
            infoStage.setTitle("Подробности");
            infoStage.setScene(new Scene(infoRoot));
            infoStage.show();
        }
        catch (Exception e) {
            System.err.println("Не удалось открыть окно примечаний");
            }

    }
}
