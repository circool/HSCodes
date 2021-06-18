package ru.tsurkanenko.vladimir.hscodes.mvc2;

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
 * @see ru.tsurkanenko.vladimir.hscodes.mvc2.Model
 * @author Vladimir Tsurkanenko
 * @version 0.4
 */
public class Controller implements Initializable {
    @FXML ComboBox<String> comboBoxSection,comboBoxGroup, comboBoxPosition,comboBoxItem;
    @FXML Label labelSectionNote, labelGroupNote, labelItemDescription;
    final Model model = new Model();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxSection.getItems().setAll(model.getSections());
        comboBoxSection.setValue(comboBoxSection.getItems().get(0));
        model.setSection(comboBoxSection.getValue());
        labelSectionNote.setText(model.getSectionNote());
        comboBoxGroup.getItems().setAll(model.getGroups());
        comboBoxGroup.setValue(comboBoxGroup.getItems().get(0));
        model.setGroup(comboBoxSection.getItems().get(0).substring(0,2) + comboBoxGroup.getValue());
        labelGroupNote.setText(model.getGroupNote());
        comboBoxPosition.getItems().setAll(model.getPositions());
        comboBoxPosition.setValue(comboBoxPosition.getItems().get(0));
        model.setPosition(comboBoxPosition.getValue());
        comboBoxItem.getItems().setAll(model.getItems());
        comboBoxItem.setValue(comboBoxItem.getItems().get(0));
        model.setItem(comboBoxItem.getValue());
        labelItemDescription.setText(
                model.selectedSection.substring(3) + "\n\t" +
                        model.selectedGroup.substring(5) + "\n\t\t" +
                        model.selectedPosition.substring(5) + "\n\t\t\t" +
                        model.getItemNote());
    }
    public void onActionComboBoxSection(){
        model.setSection(comboBoxSection.getValue());
        labelSectionNote.setText(model.getSectionNote());
        comboBoxGroup.getItems().setAll(model.getGroups());
        comboBoxGroup.setValue(comboBoxGroup.getItems().get(0));
    }
    public void onActionComboBoxGroup(){
        model.setGroup(comboBoxSection.getValue().substring(0,2) + comboBoxGroup.getValue());
        labelGroupNote.setText(model.getGroupNote());
        comboBoxPosition.getItems().setAll(model.getPositions());
        comboBoxPosition.setValue(comboBoxPosition.getItems().get(0));
    }
    public void onActionComboBoxPosition(){
        model.setPosition(comboBoxPosition.getValue());
        comboBoxItem.getItems().setAll(model.getItems());
        comboBoxItem.setValue(comboBoxItem.getItems().get(0));
    }
    public void onActionComboBoxItem(){
        model.setItem(comboBoxItem.getValue());
        labelItemDescription.setText(
                model.selectedSection.substring(3) + "\n\t" +
                        model.selectedGroup.substring(5) + "\n\t\t" +
                        model.selectedPosition.substring(5) + "\n\t\t\t" +
                        model.getItemNote());
    }
    public void onActionButtonClose(){
        System.exit(1);
    }
}
