package ru.tsurkanenko.vladimir.hscodes;

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
    @FXML
    Button buttonDetailsMore;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ModelV2 model= new ModelV2();



        TreeItem<String> currentSubSectionTreeItem;
        // Создание корневого узда дерева
        TreeItem<String> root = new TreeItem<>("Разделы ТНВЭД");

        int lastSectionTreeItem,lastSubSectionTreeItem, lastGroupTreeeView, lastItemTreeVeow;

        String[] sectionList, subSectionList, groupList, itemList;

        sectionList = model.getSectionList();
        //int totalSection = sectionList.length;

        for (String section:sectionList
             ) {
            root.getChildren().add(new TreeItem<>(section));
            model.setSelectedSection(section);

            lastSectionTreeItem = root.getChildren().size() - 1;
            subSectionList = model.getSubSectionList();//hs.getSubSections().getItemsView(section.substring(0,2));
            for (String subSection:subSectionList
                 ) {
                root.getChildren().get(lastSectionTreeItem).getChildren().add(new TreeItem<>(subSection));
                model.setSelectedSubSection(subSection);
                lastSubSectionTreeItem = root.getChildren().get(lastSectionTreeItem).getChildren().size() - 1;
                groupList = model.getGroupList();//hs.getGroups().getItemsView(subSection.substring(2,4));
                for (String group:groupList
                     ) {
                    root.getChildren().get(lastSectionTreeItem).getChildren().get(lastSubSectionTreeItem).getChildren().add(new TreeItem<>(group));
                    model.setSelectedGroup(group);
                    lastGroupTreeeView = root.getChildren().get(lastSectionTreeItem).getChildren().get(lastSubSectionTreeItem).getChildren().size()-1;
                    itemList = model.getItemList(); //hs.getItems().getItemsView(group.substring(0,4));
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
