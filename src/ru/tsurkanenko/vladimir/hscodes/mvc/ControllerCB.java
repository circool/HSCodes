package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер (Controller) Model-View-Controller
 * интерпретирует действия пользователя, оповещая модель о необходимости изменений
 * Предназначен для представления view_cb.fxml использующего выпадающие списки для отображения данных
 * @author Vladimir Tsurkanenko
 * @version 0.5.2
 * @since 0.4
 */
public class ControllerCB implements Initializable {
    @FXML ComboBox<String> comboBoxSection,comboBoxGroup, comboBoxPosition, comboBoxSubPosition;
    @FXML Label labelSectionNote, labelGroupNote, labelDescription;
    ModelCB model;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new ModelCB();
        //Раздел
        comboBoxSection.getItems().setAll(model.getSectionList());
        comboBoxSection.setValue(comboBoxSection.getItems().get(0));
        model.selectSection(comboBoxSection.getValue());
        labelSectionNote.setText(model.getSectionNote());
        //Товарная группа
        comboBoxGroup.getItems().setAll(model.getGroupList());
        comboBoxGroup.setValue(comboBoxGroup.getItems().get(0));
        model.selectGroup(comboBoxSection.getItems().get(0).substring(0,2) + comboBoxGroup.getValue().substring(2));
        labelGroupNote.setText(model.getGroupNote());
        //Товарная позиция
        comboBoxPosition.getItems().setAll(model.getPositionList());
        comboBoxPosition.setValue(comboBoxPosition.getItems().get(0));
        model.selectPosition(comboBoxPosition.getValue());
        //Товарная подпозиция
        comboBoxSubPosition.getItems().setAll(model.getSubPositionList());
        comboBoxSubPosition.setValue(comboBoxSubPosition.getItems().get(0));
        model.selectSubPosition(comboBoxSubPosition.getValue());
        labelDescription.setText(model.getDescription());
    }
    public void onActionComboBoxSection(){
        model.selectSection(comboBoxSection.getValue());
        labelSectionNote.setText(model.getSectionNote());
        comboBoxGroup.getItems().setAll(model.getGroupList());
        comboBoxGroup.setValue(comboBoxGroup.getItems().get(0));
    }
    public void onActionComboBoxGroup(){
        model.selectGroup(comboBoxGroup.getValue());
        labelGroupNote.setText(model.getGroupNote());
        comboBoxPosition.getItems().setAll(model.getPositionList());
        comboBoxPosition.setValue(comboBoxPosition.getItems().get(0));
    }
    public void onActionComboBoxPosition(){
        model.selectPosition(comboBoxPosition.getValue());
        comboBoxSubPosition.getItems().setAll(model.getSubPositionList());
        comboBoxSubPosition.setValue(comboBoxSubPosition.getItems().get(0));
    }
    public void onActionComboBoxItem(){
        model.selectSubPosition(comboBoxSubPosition.getValue());
        labelDescription.setText(model.getDescription());
    }
    public void onActionButtonClose(){
        System.exit(1);
    }
}
