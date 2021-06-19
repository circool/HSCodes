package ru.tsurkanenko.vladimir.deprecated.combobox;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Контроллер (Controller) ModelForComboBox-View-Controller
 * интерпретирует действия пользователя, оповещая модель о необходимости изменений
 * @author Vladimir Tsurkanenko
 * @version 0.2
 */
@Deprecated
public class ControllerComboBoxViewV2 implements Initializable {
    @FXML private ComboBox<String> comboBoxSection,comboBoxGroup, comboBoxSubGroup,comboBoxItem;
    @FXML private Label labelShortSectionNote, labelShortGroupNote, labelFullCodeDescription;
    private final ModelForComboBox modelForComboBox = new ModelForComboBox();

    @FXML private ComboBox<String> comboBoxSections,comboBoxGroups, comboBoxLevel1,comboBoxLevel2,comboBoxLevel3,comboBoxLevel4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        modelForComboBox.setSectionList();
        comboBoxSections.getItems().setAll(modelForComboBox.getSectionList());
        comboBoxSections.setValue(modelForComboBox.getSelectedSection());
        labelShortSectionNote.setText(modelForComboBox.getSectionNote());
        comboBoxGroups.getItems().setAll(modelForComboBox.getGroupList());
        comboBoxGroups.setValue(modelForComboBox.getSelectedGroup());
        labelShortGroupNote.setText(modelForComboBox.getGroupNote());
        comboBoxLevel1.getItems().setAll(modelForComboBox.getSubGroupList());
        comboBoxLevel1.setValue(modelForComboBox.getSelectedSubGroup());
        comboBoxLevel2.getItems().setAll(modelForComboBox.getItemList());
        comboBoxLevel2.setValue(modelForComboBox.getSelectedItem());
        //labelItemDescription.setText(modelForComboBox.getItemDescription());
    }

    /**
     *  Действия, выполняемые при изменении состояния выпадающего списка Подгруппы
     */
    @FXML public void onActionComboBoxSubGroup(){

    }
    /**
     *  Действия, выполняемые при изменении состояния выпадающего списка Товарные позиции
     */
    @FXML public void onActionComboBoxItem(){

    }

    @FXML public void onActionButtonClose(){
        System.exit(0);
    }

    // Для Представления viewcomboboxviewv2.fxml
    @FXML public void onActionComboBoxLevel1(){
        modelForComboBox.setSelectedSubGroup(comboBoxLevel1.getValue());
        comboBoxLevel2.getItems().setAll(modelForComboBox.getItemList());
        comboBoxLevel2.setValue(modelForComboBox.getSelectedItem());

    }
    @FXML public void onActionComboBoxLevel2(){
        modelForComboBox.setSelectedItem(comboBoxItem.getValue());
        labelFullCodeDescription.setText(modelForComboBox.getItemDescription());
    }
    @FXML public void onActionComboBoxLevel3(){

    }
    @FXML public void onActionComboBoxLevel4(){

    }

    @FXML public void onActionComboBoxSections(){
        modelForComboBox.setSelectedSection(comboBoxSections.getValue());
        labelShortSectionNote.setText(modelForComboBox.getSectionNote());
        comboBoxGroups.getItems().setAll(modelForComboBox.getGroupList());
        comboBoxGroups.setValue(modelForComboBox.getSelectedGroup());
    }
    @FXML public void onActionComboBoxGroups(){
        modelForComboBox.setSelectedGroup(comboBoxGroups.getValue());
        labelShortGroupNote.setText(modelForComboBox.getGroupNote());
        comboBoxLevel1.getItems().setAll(modelForComboBox.getSubGroupList());
        comboBoxLevel1.setValue(modelForComboBox.getSelectedSubGroup());
    }
    @FXML public void onActionButtonSectionNote(){

    }
    @FXML public void onActionButtonGroupNote(){

    }
}


