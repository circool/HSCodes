package ru.tsurkanenko.vladimir.deprecated.combobox;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Контроллер (ControllerComboBoxViewV1) ModelForComboBox-View-Controller
 * В качестве представления используется viewcomboboxviewv1.fxml
 * интерпретирует действия пользователя, оповещая модель о необходимости изменений
 * @author Vladimir Tsurkanenko
 * @version 0.1
 */
public class ControllerComboBoxViewV1 implements Initializable {
    @FXML private ComboBox<String> comboBoxSection,comboBoxGroup, comboBoxSubGroup,comboBoxItem;
    @FXML private Label labelSectionNote, labelGroupNote, labelItemDescription;
    private final ModelForComboBox modelForComboBox = new ModelForComboBox();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        modelForComboBox.setSectionList();
        comboBoxSection.getItems().setAll(modelForComboBox.getSectionList());
        comboBoxSection.setValue(modelForComboBox.getSelectedSection());
        labelSectionNote.setText(modelForComboBox.getSectionNote());
        comboBoxGroup.getItems().setAll(modelForComboBox.getGroupList());
        comboBoxGroup.setValue(modelForComboBox.getSelectedGroup());
        labelGroupNote.setText(modelForComboBox.getGroupNote());
        comboBoxSubGroup.getItems().setAll(modelForComboBox.getSubGroupList());
        comboBoxSubGroup.setValue(modelForComboBox.getSelectedSubGroup());
        comboBoxItem.getItems().setAll(modelForComboBox.getItemList());
        comboBoxItem.setValue(modelForComboBox.getSelectedItem());
        labelItemDescription.setText(modelForComboBox.getItemDescription());
    }

    /**
     *  Действия, выполняемые при изменении состояния выпадающего списка Разделы
     */
    @FXML public void onActionComboBoxSection(){
        modelForComboBox.setSelectedSection(comboBoxSection.getValue());
        labelSectionNote.setText(modelForComboBox.getSectionNote());
        comboBoxGroup.getItems().setAll(modelForComboBox.getGroupList());
        comboBoxGroup.setValue(modelForComboBox.getSelectedGroup());
    }
    /**
     *  Действия, выполняемые при изменении состояния выпадающего списка Группы
     */
    @FXML public void onActionComboBoxGroup(){
        modelForComboBox.setSelectedGroup(comboBoxGroup.getValue());
        labelGroupNote.setText(modelForComboBox.getGroupNote());
        comboBoxSubGroup.getItems().setAll(modelForComboBox.getSubGroupList());
        comboBoxSubGroup.setValue(modelForComboBox.getSelectedSubGroup());
    }
    /**
     *  Действия, выполняемые при изменении состояния выпадающего списка Подгруппы
     */
    @FXML public void onActionComboBoxSubGroup(){
        modelForComboBox.setSelectedSubGroup(comboBoxSubGroup.getValue());
        comboBoxItem.getItems().setAll(modelForComboBox.getItemList());
        comboBoxItem.setValue(modelForComboBox.getSelectedItem());
    }
    /**
     *  Действия, выполняемые при изменении состояния выпадающего списка Товарные позиции
     */
    @FXML public void onActionComboBoxItem(){
        modelForComboBox.setSelectedItem(comboBoxItem.getValue());
        labelItemDescription.setText(modelForComboBox.getItemDescription());
    }
    @FXML public void onActionButtonClose(){
        System.exit(0);
    }

}


