package ru.tsurkanenko.vladimir.hscodes;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Контроллер (Controller) Model-View-Controller
 * интерпретирует действия пользователя, оповещая модель о необходимости изменений
 */
public class Controller implements Initializable {
    @FXML private ComboBox<String> comboBoxSection,comboBoxGroup, comboBoxSubGroup,comboBoxItem;
    @FXML private Label labelSectionNote, labelGroupNote, labelItemDescription;
    private final Model model = new Model();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model.getSectionList();
        comboBoxSection.getItems().setAll(model.sectionList);
        comboBoxSection.setValue(model.getSelectedSection());
        labelSectionNote.setText(model.getSectionNote());

        comboBoxGroup.getItems().setAll(model.groupList);
        comboBoxGroup.setValue(model.getSelectedGroup());
        labelGroupNote.setText(model.getGroupNote());

        comboBoxSubGroup.getItems().setAll(model.subGroupList);
        comboBoxSubGroup.setValue(model.getSelectedSubGroup());

        comboBoxItem.getItems().setAll(model.itemList);
        comboBoxItem.setValue(model.getSelectedItem());
        labelItemDescription.setText(model.getItemDescription());



    }

    /**
     *  Действия, выполняемые при изменении состояния выпадающего списка Разделы
     */
    @FXML public void onActionComboBoxSection(){
        model.setSelectedSection(comboBoxSection.getValue());
        labelSectionNote.setText(model.getSectionNote());

        comboBoxGroup.getItems().setAll(model.getGroupList());
        comboBoxGroup.setValue(model.getSelectedGroup());
    }
    /**
     *  Действия, выполняемые при изменении состояния выпадающего списка Группы
     */
    @FXML public void onActionComboBoxGroup(){
        model.setSelectedGroup(comboBoxGroup.getValue());
        labelGroupNote.setText(model.getGroupNote());

        comboBoxSubGroup.getItems().setAll(model.getSubGroupList());
        comboBoxSubGroup.setValue(model.getSelectedSubGroup());
    }
    /**
     *  Действия, выполняемые при изменении состояния выпадающего списка Подгруппы
     */
    @FXML public void onActionComboBoxSubGroup(){
        model.setSelectedSubGroup(comboBoxSubGroup.getValue());

        model.setItemList();
        model.setSelectedItem(model.getSelectedItem());
        comboBoxItem.getItems().setAll(model.getItemList());
        comboBoxItem.setValue(model.getSelectedItem());
    }
    /**
     *  Действия, выполняемые при изменении состояния выпадающего списка Товарные позиции
     */
    @FXML public void onActionComboBoxItem(){
        model.setSelectedItem(comboBoxItem.getValue());
        labelItemDescription.setText(model.getItemDescription());
    }

    @FXML public void onActionButtonClose(){
        System.exit(0);
    }
}
