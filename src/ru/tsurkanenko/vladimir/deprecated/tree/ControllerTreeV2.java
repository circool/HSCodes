package ru.tsurkanenko.vladimir.deprecated.tree;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;
@Deprecated
/**
 * Контроллер для варианта, использующего View с древовидным списком.
 * @version 0.2
 */
public class ControllerTreeV2 implements Initializable {
    @FXML
    TreeView<String> mainTree;
    TreeItem<String> selectedTreeItem;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ModelForTree model= new ModelForTree();
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
            selectedTreeItem = new TreeItem<>();
            mainTree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {

                @Override
                public void changed(ObservableValue<? extends TreeItem<String>> observable,
                                    TreeItem<String> oldValue, TreeItem<String> newValue) {
                    // чтобы не повторялось по 22 раза!!
                    if(!selectedTreeItem.equals(newValue)) {
                        selectedTreeItem = newValue;
                        //System.out.println(newValue.getValue());
                    }
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
