package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер (ControllerTree) Model-View-ControllerTree
 * интерпретирует действия пользователя, оповещая модель о необходимости изменений
 * Предназначен для представления tree.fxml использующего дерево для отображения данных
 * Управление элементами представления выполняется классом TreeView.
 * @see TreeView
 * @author Vladimir Tsurkanenko
 * @version 0.5.7
 * @since 0.5.6
 */
public class ControllerTree extends ViewTree implements Initializable {
    ModelTree model;
    InfoWindow infoWindow, aboutWindow;

    @FXML
    Button buttonDetailsMore;

    @FXML
    TreeView<String> mainTreeView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        model= new ModelTree();
        createTree(model.getTreeIterable());
        notesIsAvailable(false);
        buttonDetailsMore.setTooltip(new Tooltip("Нажмите для отображения примечания"));
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

    /**
     * Метод выполняется при выборе меню Show Notes
     */
    @FXML
    void menuShowNoteOnAction() {
        showInfo();
    }

    /**
     * Отображает информацию о программе
     */
    @FXML
    void menuAboutOnAction(){
        aboutWindow = new InfoWindow("О программе", "HS Code",
                "Программа предназначена для отображения справочника ТНВЭД в древовихной форме");
    }

    @FXML
    void menuCopyItemDescriptionOnAction(){
        if(model.getActiveTreeItem()!=null)
            putToClipboard(model.getFinalDescription(model.getActiveTreeItem()));
    }
    @FXML
    void menuCopyGroupNotesOnAction(){
        if(model.getActiveTreeItem()!=null){
            int level = model.getNestingLevel(model.getActiveTreeItem());
            if (level > 1){
                TreeItem<String> tmp = model.getActiveTreeItem();
                while(2 != model.getNestingLevel((tmp)))
                    tmp = tmp.getParent();
                putToClipboard(model.getGroupNote(tmp));
            }
        }
    }
    @FXML
    void menuCopySectionNotesOnAction(){
        if(model.getActiveTreeItem()!=null){
            int level = model.getNestingLevel(model.getActiveTreeItem());
            TreeItem<String> tmp = model.getActiveTreeItem();
            while(model.getNestingLevel((tmp)) != 1)
                tmp = tmp.getParent();
            putToClipboard(model.getSectionNote(tmp));
        }

    }
    void putToClipboard(String s){
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(s);
        clipboard.setContent(content);
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
            } else if (model.getActiveTreeItem().isLeaf()) {
                title = "Информация о коде ТНВЭД";
                body = model.getFinalDescription(model.getActiveTreeItem());
            }
            if(infoWindow != null)
                infoWindow.close();
            infoWindow = new InfoWindow(title, header, body);
        }
    }

}
