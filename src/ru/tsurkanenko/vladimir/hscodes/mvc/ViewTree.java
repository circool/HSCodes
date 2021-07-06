package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

/**
 * Представление для MVC использующего tree.fxml
 * @author Vladimir Tsurkanenko
 * @version 0.5.6
 * @since 0.5.6
 */
public class ViewTree {
    @FXML
    TreeView<String> mainTreeView;
    @FXML
    MenuItem menuShowNote;
    @FXML
    Button buttonDetailsMore;
    Stage infoStage;

    /**
     * Включает или выключает отображение элементов, вызывающих показ примечаний
     * @param isEnabled
     */
    void notesIsAvailable(boolean isEnabled){
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

    /**
     * Создает и отображает информационное окно
     * @param title Заголовок окна
     * @param header Заголовок сообщения
     * @param body Тело сообщения
     */
    void showInfo(String title, String header, String body){
        try{infoStage.close();}
        catch (Exception e){
            System.out.println("Попытка закрыть несуществующее окно");
        }
        try {
            FXMLLoader infoLoader = new FXMLLoader(getClass().getResource("info_dialog.fxml"));
            infoLoader.setController(new ControllerInfo(header, body));
            Parent infoRoot = infoLoader.load();
            infoStage = new Stage();
            infoStage.setTitle(title);
            infoStage.setScene(new Scene(infoRoot));
            infoStage.show();
        }
        catch (Exception e) {
            System.err.println("Не удалось открыть окно примечаний");
        }
    }
}
