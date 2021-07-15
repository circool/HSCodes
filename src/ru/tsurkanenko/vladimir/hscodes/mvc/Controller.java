/*
 * MIT License
 *
 * Copyright (c) 2021 Vladimir Tsurkanenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер {@link Controller} MVC (Model-View-Controller)
 * интерпретирует действия пользователя,
 * запрашивает данные у модели {@link Model}
 * информирует модель о необходимости изменения данных
 * Предназначен для представления tree.fxml использующего дерево для отображения данных
 * Управление элементами представления выполняется классом {@link TreeView}.
 * @see TreeView
 * @author Vladimir Tsurkanenko
 * @version 0.6
 * @since 0.5.6
 */
public class Controller extends ViewTree implements Initializable {
    Model model;
    @SuppressWarnings("unused")
    InfoWindow infoWindow, aboutWindow;

    @FXML
    public MenuItem menuCopyItemDescription, menuCopyGroupNotes, menuCopySectionNotes;

    @FXML
    Button buttonDetailsMore;

    @FXML
    TreeView<String> mainTreeView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        model= new Model();
        createTree(model.getTree());
        setNotesIsAvailable(false);
        buttonDetailsMore.setTooltip(new Tooltip("Нажмите для отображения примечания"));
        model.setActiveTreeItem(null);
        menuCopyItemDescription.setDisable(true);
        menuCopyGroupNotes.setDisable(true);
        menuCopySectionNotes.setDisable(true);
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

        // Если ни один элемент не выбран
        if(selectedItem == null) {
            model.setActiveTreeItem(null);
            // если никакой элемент не выбран сделать недоступными зависимые элементы сцены
            buttonDetailsMore.setDisable(true);
            menuShowNote.setDisable(true);
            menuCopyItemDescription.setDisable(true);
            menuCopyGroupNotes.setDisable(true);
            menuCopySectionNotes.setDisable(true);
            return;
        }

        // Если выбран уже выбранный элемент, не делаем ничего
        if(selectedItem.equals(model.getActiveTreeItem()))
            return;

        // Если активный элемент изменился, сообщаем об этом модели
        model.setActiveTreeItem(selectedItem);

        // Если у элемента есть примечания, установить кнопку и меню "подробности" как доступные
        setNotesIsAvailable(model.isHaveNotes(selectedItem));
        int treeLevel = model.getNestingLevel(selectedItem);
        menuCopySectionNotes.setDisable(!model.isHaveNotes(model.getParentSection(selectedItem)));
        menuCopyGroupNotes.setDisable(treeLevel < 2);
        menuCopyItemDescription.setDisable(treeLevel < 3);
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
            ClipBoard.put(model.getFinalDescription(model.getActiveTreeItem()));
    }
    @FXML
    void menuCopyGroupNotesOnAction(){
        ClipBoard.put(model.getGroupNote(model.getParentGroup(model.getActiveTreeItem())));
    }
    @FXML
    void menuCopySectionNotesOnAction(){
        ClipBoard.put(model.getSectionNote(model.getParentSection(model.getActiveTreeItem())));

    }

    /**
     * Анализирует обстоятельства и в зависимости от них дает представлению команду вывести информационное окно.
     * Обстоятельства:
     *  1. Если выбран раздел или группа, вывести примечания к ним.
     *  2. Если выбран конечный код (не имеющий дочерних элементов) - показать полное описание для него
     *  3.
     */
    void showInfo(){
        TreeItem<String> activeItem = model.getActiveTreeItem();
        int nestingLevel = model.getNestingLevel(activeItem);

        if(model.isHaveNotes(activeItem ) ) {
            String title = "";
            String body = "";
            String header = activeItem.getValue();
            if (nestingLevel == 1) {
                title = "Примечания к разделу";
                body = model.getSectionNote(activeItem);
            } else if (nestingLevel == 2) {
                title = "Примечания к товарной группе";
                body = model.getGroupNote(activeItem);
            } else if (activeItem.isLeaf()) {
                title = "Информация о коде ТНВЭД";
                body = model.getFinalDescription(activeItem);
            }
            if(infoWindow != null)
                infoWindow.close();
            infoWindow = new InfoWindow(title, header, body, true);
        }
    }

}
