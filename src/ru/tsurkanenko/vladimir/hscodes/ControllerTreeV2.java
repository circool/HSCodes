package ru.tsurkanenko.vladimir.hscodes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTreeV2 implements Initializable {
    @FXML
    TreeView<String> mainTree;
    @FXML
    Button buttonDetailsMore;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HarmBase hs = new HarmBase();
        String[] sections = hs.getSections().getItemsView();
        HarmItem[] subsections = hs.getSubSections().getArray();
        HarmItem[] groups = hs.getGroups().getArray();
        HarmItem[] items = hs.getItems().getArray();

        ModelV2 model= new ModelV2();

        //int totalSections = sections.length;
        TreeItem<String> currentSubSectionTreeItem;
        // Создание корневого узда дерева
        TreeItem<String> root = new TreeItem<>("Разделы ТНВЭД");

        int lastSectionTreeItem,lastSubSectionTreeItem, lastGroupTreeeView, lastItemTreeVeow;

        String[] sectionList, subSectionList, groupList, itemList;

        sectionList = hs.getSections().getItemsView();
        int totalSection = sectionList.length;

        for (String section:sectionList
             ) {
            root.getChildren().add(new TreeItem<>(section));
            lastSectionTreeItem = root.getChildren().size() - 1;
            subSectionList = hs.getSubSections().getItemsView(section.substring(0,2));
            for (String subSection:subSectionList
                 ) {
                root.getChildren().get(lastSectionTreeItem).getChildren().add(new TreeItem<>(subSection));
                lastSubSectionTreeItem = root.getChildren().get(lastSectionTreeItem).getChildren().size() - 1;
                groupList = hs.getGroups().getItemsView(subSection.substring(2,4));
                for (String group:groupList
                     ) {
                    root.getChildren().get(lastSectionTreeItem).getChildren().get(lastSubSectionTreeItem).getChildren().add(new TreeItem<>(group));
                    lastGroupTreeeView = root.getChildren().get(lastSectionTreeItem).getChildren().get(lastSubSectionTreeItem).getChildren().size()-1;
                    itemList = hs.getItems().getItemsView(group.substring(0,4));
                    for (String item:itemList){
                        root.getChildren().get(lastSectionTreeItem).getChildren().get(lastSubSectionTreeItem).getChildren().get(lastGroupTreeeView).getChildren().add(new TreeItem<>(item));
                        //TODO Список товарных позицтй формируется без учета вложенности. Нужно разобраться, как это исправить
                    }
                }
            }
        }







        // передаем корневой узел в компоненту
        mainTree.setRoot(root);

        // раскрываем узел
        root.setExpanded(true);
    }
    @FXML void buttonCloseOnAction(){
        System.exit(0);
    }
    @FXML
    void buttonDetailsMoreOnActions(){
        System.exit(0);
    }
}
