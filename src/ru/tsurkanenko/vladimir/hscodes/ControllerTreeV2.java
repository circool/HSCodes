package ru.tsurkanenko.vladimir.hscodes;

import javafx.beans.value.*;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * @version 0.1.1
 */
public class ControllerTreeV2 implements Initializable {
    @FXML
    TreeView<String> mainTree;
    //@FXML
    //Button buttonDetailsMore;
    //@FXML
    //Button buttonCancel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ModelV2 model= new ModelV2();
        TreeItem<String> currentSubSectionTreeItem;
        // Создание корневого узда дерева
        TreeItem<String> root = new TreeItem<>("Разделы ТНВЭД");

        int lastSectionTreeItem,lastSubSectionTreeItem, lastGroupTreeView, lastItemTreeView;
        String[] sectionList, subSectionList, groupList, itemList;
// Разделы
        sectionList = model.getSectionList();
// для каждого раздела
        for (String section:sectionList
             ) {
            root.getChildren().add(new TreeItem<>(section));
            lastSectionTreeItem = root.getChildren().size() - 1;
            model.selectSection(section);
            subSectionList = model.getSubSectionList();
// для каждого подраздела
            for (String subSection:subSectionList
                 ) {
                root.getChildren().get(lastSectionTreeItem).getChildren().add(new TreeItem<>(subSection));
                model.selectSubSection(subSection);
                lastSubSectionTreeItem = root.getChildren().get(lastSectionTreeItem).getChildren().size() - 1;
                groupList = model.getGroupList();
// для каждой группы
                for (String group:groupList
                     ) {
                    root.getChildren().get(lastSectionTreeItem).getChildren().get(lastSubSectionTreeItem).getChildren().add(new TreeItem<>(group));
                    model.selectGroup(group);
                    lastGroupTreeView = root.getChildren().get(lastSectionTreeItem).getChildren().get(lastSubSectionTreeItem).getChildren().size()-1;
                    itemList = model.getItemList();
// для каждой товарной позиции
                    for (String item:itemList){
                        root.getChildren().get(lastSectionTreeItem).getChildren().get(lastSubSectionTreeItem).getChildren().get(lastGroupTreeView).getChildren().add(new TreeItem<>(item));
                        //TODO Список товарных позиций формируется без учета вложенности. Нужно разобраться, как это исправить
                    }
                }
            }

            mainTree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {

                @Override
                public void changed(ObservableValue<? extends TreeItem<String>> observable,
                                    TreeItem<String> oldValue, TreeItem<String> newValue) {
                    // newValue represents the selected itemTree
                    // повторяется по 22 раза!!
                    System.out.println(newValue.getValue() );
                }

            });
        }

        // передаем корневой узел в компоненту
        mainTree.setRoot(root);

        // раскрываем узел
        root.setExpanded(true);
    }
    @FXML void buttonCloseOnAction(){
        System.exit(0);
    }
    @FXML void buttonDetailsMoreOnActions(){
        System.exit(0);
    }
}
