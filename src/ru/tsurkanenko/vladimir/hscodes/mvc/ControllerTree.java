package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
    ModelTree model;
    InfoWindow infoWindow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        model= new ModelTree();
        createTree(model.getTreeIterable());
        notesIsAvailable(false);
    }

    /**
     * Выполняется при нажатии кнопки buttonClose
     */
    @FXML
    void buttonCloseOnAction(){
        System.exit(0);
    }

    /**
     * Выполняется при нажатии кнопки buttonDetailsMore
     */
    @FXML
    void buttonDetailsMoreOnActions() {
        showInfo();
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
        if(selectedItem == null) {
            model.setActiveTreeItem(null);
            // если никакой элемент не выбран сделать недоступной кнопку и меню "подробности"
            notesIsAvailable(false);
        }
        else
        if(!selectedItem.equals(model.getActiveTreeItem())) {
            // Если активный элемент изменился, сообщаем об этом модели
            model.setActiveTreeItem(selectedItem);
            // Если у элемента есть примечания, установить кнопку и меню "подробности" как доступные
            notesIsAvailable(model.activeSelectionIsHaveNote());
        }
    }

    @FXML
    void menuShowNoteOnAction() {
        showInfo();
    }

    /**
     * Анализирует обстоятельства и в зависимости от них дает представлению команду вывести информационное окно.
     * Обстоятельства:
     *  1. Если выбран раздел или группа, вывести примечания к ним.
     *  2. Если выбран конечный код (не имеющий дочерних элементов) - показать полное описание для него
     *  3.
     */
    void showInfo(){
        if(model.activeSelectionIsHaveNote()) {
            String title = "";
            String body = "";
            String header = model.getActiveTreeItem().getValue();
            if (header.equals(model.getActiveSectionValue())) {
                title = "Примечания к разделу";
                body = model.getSectionNote();
            } else if (header.equals(model.getActiveGroupValue())) {
                title = "Примечания к товарной группе";
                body = model.getGroupNote();
            } else if (model.activeSelectionIsItem()) {
                title = "Информация о коде ТНВЭД";
                body = model.getFinalDescription(model.getActiveTreeItem());
            }
            if(infoWindow != null)
                infoWindow.close();
            infoWindow = new InfoWindow(title, header, body);
        }
    }

}
