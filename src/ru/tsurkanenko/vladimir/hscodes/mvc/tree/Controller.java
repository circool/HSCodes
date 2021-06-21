package ru.tsurkanenko.vladimir.hscodes.mvc.tree;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import ru.tsurkanenko.vladimir.hscodes.mvc.Model;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер MVC (Model-View-Controller)
 * Предназначен для представления, реализующего древовидное представление данных справочника
 * Контроллер отслеживает изменения элементов управления Представления и передает ему обновленные данные,
 * получая их от Модели
 * @see Model
 * @author Vladimir Tsurkanenko
 * @version 0.4
 * @since 0.4
 */
public class Controller implements Initializable {
    // Элементы Представления, состояние которых требуется менять или обновлять
    @FXML
    TreeView<String> mainTree;

    // Внутренние переменные
    TreeItem<String> selectedTreeItem;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model model= new Model();
        // Создание корневого узла дерева
        TreeItem<String> root = new TreeItem<>("Разделы ТНВЭД");
        int lastSectionTreeItem,lastSubSectionTreeItem, lastGroupTreeView;
        String[] sectionList, subSectionList, groupList, itemList;
        sectionList = model.getSectionList();
        // для каждого раздела
        for (String section:sectionList
             ) {
            root.getChildren().add(new TreeItem<>(section));
            lastSectionTreeItem = root.getChildren().size() - 1;
            model.selectSection(section);
            subSectionList = model.getGroupList();
            // для каждого подраздела
            for (String subSection:subSectionList
                 ) {
                root.getChildren().get(lastSectionTreeItem).getChildren().add(new TreeItem<>(subSection));
                model.selectGroup(subSection);
                lastSubSectionTreeItem = root.getChildren().get(lastSectionTreeItem).getChildren().size() - 1;
                groupList = model.getPositionList();
                // для каждой группы
                for (String group:groupList
                     ) {
                    root.getChildren().get(lastSectionTreeItem).getChildren().get(lastSubSectionTreeItem).getChildren().add(new TreeItem<>(group));
                    model.selectPosition(group);
                    lastGroupTreeView = root.getChildren().get(lastSectionTreeItem).getChildren().get(lastSubSectionTreeItem).getChildren().size()-1;
                    itemList = model.getSubPositionList();
                    // для каждой товарной позиции
                    for (String item:itemList){
                        root.getChildren().get(lastSectionTreeItem).getChildren().get(lastSubSectionTreeItem).getChildren().get(lastGroupTreeView).getChildren().add(new TreeItem<>(item));
                    }
                }
            }
            selectedTreeItem = new TreeItem<>();
            mainTree.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                // чтобы не повторялось по 22 раза!!
                if(!selectedTreeItem.equals(newValue)) {
                    selectedTreeItem = newValue;
                }
            });
        }

        // передаем корневой узел в компоненту
        mainTree.setRoot(root);

        // раскрываем узел
        root.setExpanded(true);
    }
    // Обработка элементов управления Представления
    @FXML void buttonCloseOnAction(){
        System.exit(0);
    }
    @FXML void buttonDetailsMoreOnActions(){
        System.exit(0);
    }
}
