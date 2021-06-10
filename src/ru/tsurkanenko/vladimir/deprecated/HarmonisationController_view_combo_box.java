package ru.tsurkanenko.vladimir.deprecated;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import ru.tsurkanenko.vladimir.hscodes.HarmonisationModel_view_flexi_combo_box;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Контроллер MVC для представления Harmonisation_view_combo_box.fxml и модели HarmonisationModel_view_combo_box
 * @author Vladimir Tsurkanenko
 * @version 0.1
 */
public class HarmonisationController_view_combo_box implements Initializable {
    HarmonisationModel_view_flexi_combo_box model;
    @FXML private ComboBox<String> comboBoxSection,comboBoxGroup, comboBoxPosition,comboBoxItem;
    @FXML private Label labelSectionNote, labelGroupNote, labelItemDescription;

    @FXML void onActionButtonClose(){
        System.exit(0);
    }

    /**
     * Действия выполняемые при изменении раздела
     */
    @FXML void onActionComboBoxSection(){
        model.selectSection(comboBoxSection.getValue());
        comboBoxGroup.getItems().setAll(model.getGroupList());
        comboBoxGroup.setValue(comboBoxGroup.getItems().get(model.getSelectedGroup()));
        labelSectionNote.setText(model.getSectionNote());
    }
    /**
     * Действия выполняемые при изменении группы
     */
    @FXML void onActionComboBoxGroup(){
        model.selectGroup(comboBoxGroup.getValue());
        comboBoxPosition.getItems().setAll(model.getPositionList());
        comboBoxPosition.setValue(comboBoxPosition.getItems().get(model.getSelectedPosition()));
        labelGroupNote.setText(model.getGroupNote());

    }
    @FXML void onActionComboBoxPosition(){
        model.selectPosition(comboBoxPosition.getValue());
        comboBoxItem.getItems().setAll(model.getItemList());
        comboBoxItem.setValue(comboBoxItem.getItems().get(model.getSelectedItem()));
    }
    @FXML void onActionComboBoxItem(){
        model.selectItem(comboBoxItem.getValue());
        labelItemDescription.setText(model.getItemDescription());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new HarmonisationModel_view_flexi_combo_box();

        comboBoxSection.getItems().setAll(model.getSectionList());
        comboBoxSection.setValue(model.getSectionList()[model.selectedSection]);
        labelSectionNote.setText(model.getSectionNote());

        comboBoxGroup.getItems().setAll(model.getGroupList());
        comboBoxGroup.setValue(model.getGroupList()[model.selectedGroup]);
        labelGroupNote.setText(model.getGroupNote());

        comboBoxPosition.getItems().setAll(model.getPositionList());
        comboBoxPosition.setValue(model.getPositionList()[model.selectedPosition]);

        comboBoxItem.getItems().setAll(model.getItemList());
        comboBoxItem.setValue(model.getItemList()[model.selectedItem]);
        labelItemDescription.setText(model.getItemDescription());
    }
}
