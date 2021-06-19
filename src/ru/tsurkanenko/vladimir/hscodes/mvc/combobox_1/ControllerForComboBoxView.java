package ru.tsurkanenko.vladimir.hscodes.mvc.combobox_1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер (Controller) Model-View-Controller
 * интерпретирует действия пользователя, оповещая модель о необходимости изменений
 * Предназначен для представления view_combo_box.fxml
 * @see Model
 * @author Vladimir Tsurkanenko
 * @version 0.4
 */
public class ControllerForComboBoxView implements Initializable {
    @FXML ComboBox<String> comboBoxSection,comboBoxGroup, comboBoxPosition,comboBoxItem;
    @FXML Label labelSectionNote, labelGroupNote, labelItemDescription;
    final Model modelForComboBox = new Model();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxSection.getItems().setAll(modelForComboBox.getActualSectionList());
        comboBoxSection.setValue(comboBoxSection.getItems().get(0));
        modelForComboBox.setSelectedSection(comboBoxSection.getValue());
        labelSectionNote.setText(modelForComboBox.getSelectedSectionNote());

        comboBoxGroup.getItems().setAll(modelForComboBox.getActualGroupList());
        comboBoxGroup.setValue(comboBoxGroup.getItems().get(0));
        modelForComboBox.setSelectedGroup(comboBoxGroup.getValue());
        labelGroupNote.setText(modelForComboBox.getSelectedGroupNote());

        comboBoxPosition.getItems().setAll(modelForComboBox.getActualPositionList());
        comboBoxPosition.setValue(comboBoxPosition.getItems().get(0));
        modelForComboBox.setSelectedPosition(comboBoxPosition.getValue());

        comboBoxItem.getItems().setAll(modelForComboBox.getActualItemList());
        comboBoxItem.setValue(comboBoxItem.getItems().get(0));
        modelForComboBox.setSelectedItem(comboBoxItem.getValue());
        labelItemDescription.setText(modelForComboBox.getItemDescription());
    }
    public void onActionComboBoxSection(){
        modelForComboBox.setSelectedSection(comboBoxSection.getValue());
        comboBoxGroup.getItems().setAll(modelForComboBox.getActualGroupList());
        comboBoxGroup.setValue(modelForComboBox.getSelectedGroup());
        labelSectionNote.setText(modelForComboBox.getSelectedSectionNote());
    }
    public void onActionComboBoxGroup(){
        modelForComboBox.setSelectedGroup(comboBoxGroup.getValue());
        comboBoxPosition.getItems().setAll(modelForComboBox.getActualPositionList());
        comboBoxPosition.setValue(modelForComboBox.getSelectedPosition());
        labelGroupNote.setText(modelForComboBox.getSelectedGroupNote());
    }
    public void onActionComboBoxPosition(){
        modelForComboBox.setSelectedPosition(comboBoxPosition.getValue());
        comboBoxItem.getItems().setAll(modelForComboBox.getActualItemList());
        comboBoxItem.setValue(comboBoxItem.getItems().get(0));
    }
    public void onActionComboBoxItem(){
        modelForComboBox.setSelectedItem(comboBoxItem.getValue());
        labelItemDescription.setText(modelForComboBox.getItemDescription());
    }
    public void onActionButtonClose(){
        System.exit(1);
    }
}
