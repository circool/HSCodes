package ru.tsurkanenko.vladimir.hscodes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Контроллер (Controller) Model-View-Controller
 * интерпретирует действия пользователя, оповещая модель о необходимости изменений
 * @author Vladimir Tsurkanenko
 * @version 1.0
 */
public class Controller2 implements Initializable {
    @FXML private ComboBox<String> comboBoxSection,comboBoxGroup, comboBoxSubGroup,comboBoxItem;
    @FXML private Label labelShortSectionNote, labelShortGroupNote, labelFullCodeDesctiption;
    private final Model model = new Model();

    @FXML private ComboBox<String> comboBoxSections,comboBoxGroups, comboBoxLevel1,comboBoxLevel2,comboBoxLevel3,comboBoxLevel4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model.setSectionList();
        comboBoxSections.getItems().setAll(model.getSectionList());
        comboBoxSections.setValue(model.getSelectedSection());
        labelShortSectionNote.setText(model.getSectionNote());
        comboBoxGroups.getItems().setAll(model.getGroupList());
        comboBoxGroups.setValue(model.getSelectedGroup());
        labelShortGroupNote.setText(model.getGroupNote());
        //comboBoxSubGroup.getItems().setAll(model.getSubGroupList());
        //comboBoxSubGroup.setValue(model.getSelectedSubGroup());
        //comboBoxItem.getItems().setAll(model.getItemList());
        //comboBoxItem.setValue(model.getSelectedItem());
        //labelItemDescription.setText(model.getItemDescription());
    }

    /**
     *  Действия, выполняемые при изменении состояния выпадающего списка Разделы
     */
    @FXML public void onActionComboBoxSection(){
        model.setSelectedSection(comboBoxSection.getValue());
        labelShortSectionNote.setText(model.getSectionNote());
        comboBoxGroups.getItems().setAll(model.getGroupList());
        comboBoxGroups.setValue(model.getSelectedGroup());
    }
    /**
     *  Действия, выполняемые при изменении состояния выпадающего списка Группы
     */
    @FXML public void onActionComboBoxGroup(){
        model.setSelectedGroup(comboBoxGroup.getValue());
        labelShortGroupNote.setText(model.getGroupNote());
        comboBoxSubGroup.getItems().setAll(model.getSubGroupList());
        comboBoxSubGroup.setValue(model.getSelectedSubGroup());
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

    // Для Представления view.fxml
    @FXML public void onActionComboBoxLevel1(){
        model.setSelectedSubGroup(comboBoxLevel1.getValue());
        comboBoxLevel2.getItems().setAll(model.getItemList());
        comboBoxLevel2.setValue(model.getSelectedItem());

    }
    @FXML public void onActionComboBoxLevel2(){
        model.setSelectedItem(comboBoxItem.getValue());
        labelFullCodeDesctiption.setText(model.getItemDescription());
    }
    @FXML public void onActionComboBoxLevel3(){

    }
    @FXML public void onActionComboBoxLevel4(){

    }

    @FXML public void onActionComboBoxSections(){
        model.setSelectedSection(comboBoxSections.getValue());
        labelShortSectionNote.setText(model.getSectionNote());
        comboBoxGroups.getItems().setAll(model.getGroupList());
        comboBoxGroups.setValue(model.getSelectedGroup());
    }
    @FXML public void onActionComboBoxGroups(){
        model.setSelectedGroup(comboBoxGroups.getValue());
        labelShortGroupNote.setText(model.getGroupNote());
        comboBoxLevel1.getItems().setAll(model.getSubGroupList());
        comboBoxLevel1.setValue(model.getSelectedSubGroup());
    }
    @FXML public void onActionButtonSectionNote(){

    }
    @FXML public void onActionButtonGroupNote(){

    }
}


