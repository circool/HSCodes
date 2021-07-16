

package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 * Представление для MVC использующего tree.fxml
 * @author Vladimir Tsurkanenko
 * @version 0.6
 * @since 0.5.6
 */

public class ViewTree {

    @SuppressWarnings("unused")
    @FXML
    Button buttonDetailsMore;
    @SuppressWarnings("unused")
    @FXML
    TreeView<String> mainTreeView;
    @FXML
    MenuItem menuShowNote;

    /**
     * Включает или выключает отображение элементов, вызывающих показ примечаний
     * @param isEnabled Значение, которое следует установить
     */
    void setNotesIsAvailable(boolean isEnabled){
        menuShowNote.setDisable(!isEnabled);
        buttonDetailsMore.setDisable(!isEnabled);
    }

    /**
     * Рисует полученное дерево в mainTreeView
     * @param treeItem древо, которое нужно отобразить
     */
    void createTree(TreeItem<String> treeItem){
        // раскрываем дерево
        treeItem.setExpanded(true);

        // Создаем TreeView и устанавливаем treeItem в качестве его корневого узла
        TreeView<String> rootTreeView = new TreeView<>(treeItem);

        // Назначаем созданный TreeView в качестве корневого для mainTreeView из tree.fxml
        mainTreeView.setRoot(rootTreeView.getRoot());

        // скрываем корневой узел дерева
        mainTreeView.setShowRoot(false);
    }
}
