package ru.tsurkanenko.vladimir.hscodes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTree implements Initializable {
    @FXML
    TreeView<String> mainTree;
    @FXML
    Button buttonDetails;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HarmBase hs = new HarmBase();
        HarmGroup[] sections = hs.getSections().getGroupArray();
        HarmGroup[] subsections = hs.getSubSections().getGroupArray();
        HarmItem[] groups = hs.getGroups().getItemArray();
        HarmItem[] items = hs.getItems().getItemArray();

        int totalSections = sections.length;
        TreeItem<String> currentSubSectionTreeItem;
        // Создание корневого узда дерева
        TreeItem<String> root = new TreeItem<>("Разделы ТНВЭД");

        for(int i = 0; i < totalSections; i++) {
            // для каждой секции ТНВЭД:
            // добавить в корневой узел новый узел с разделом ТНВЭД
            root.getChildren().add(new TreeItem<>(sections[i].getCode() + " " + sections[i].getDescription()));

            // в каждый добавленый узел с разделом добавить подразделы ТНВЭД
            for(HarmGroup currentSubSection:subsections){
                if(currentSubSection.getCode().startsWith(root.getChildren().get(i).getValue().substring(0, 2))) {
                    root.getChildren().get(i).getChildren().add(new TreeItem<>(currentSubSection.getCode() + " " + currentSubSection.getDescription()));
                    // в каждый их добавленных подразделов добавить подчиненные группы
                    currentSubSectionTreeItem = root.getChildren().get(i).getChildren().get(root.getChildren().get(i).getChildren().size()-1);
                    for (HarmItem currentGroup:groups) {
                        String currentSubSectionValue = currentSubSectionTreeItem.getValue().substring(2, 4);
                        if(currentGroup.getCode().startsWith(currentSubSectionValue)) {
                            currentSubSectionTreeItem.getChildren().add(new TreeItem<>(currentGroup.getCode() + " " + currentGroup.getDescription()));
                        }
                    }
                }
            }
        }

        // передаем корневой узел в компоненту
        mainTree.setRoot(root);

        // раскрываем узел
        root.setExpanded(true);
    }
    void buttonCloseOnAction(){
        System.exit(0);
    }
    void buttonDetailsOnAction(){
        System.exit(0);
    }
}
