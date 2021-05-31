package ru.tsurkanenko.vladimir.hscodes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTree implements Initializable {
    @FXML
    TreeView<String> mainTree;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HSBase hs = new HSBase();
        String[] sections = hs.getSection().getList();
        TreeItem<String> root = new TreeItem<String>("Разделы ТНВЭД");
        for(int i = 0; i < sections.length; i++)
            root.getChildren().add(
                    new TreeItem<String>("Раздел " + (i + 1) + ". " + sections[i].substring(3))
                    );
        Integer x=1;
        for(TreeItem<String> section:root.getChildren()){

            for(String currentSection:hs.getGroup().getList(x.toString())){
                section.getChildren().add(new TreeItem<>(x + ": " + currentSection.substring(5)));

            }
            x++;
        }
        // передаем корневой узел в компоненту
        mainTree.setRoot(root);

        // раскрываем узел
        root.setExpanded(true);
    }
}
