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
