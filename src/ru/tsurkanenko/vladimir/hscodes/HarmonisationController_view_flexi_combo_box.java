package ru.tsurkanenko.vladimir.hscodes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Контроллер MVC для представления Harmonisation_view_combo_box.fxml и модели HarmonisationModel_view_flexi_combo_box
 * @author Vladimir Tsurkanenko
 * @version 0.1
 */
public class HarmonisationController_view_flexi_combo_box implements Initializable {
    HarmonisationModel_view_flexi_combo_box model;
    @FXML private ComboBox<String> flexi_comboBoxSection,flexi_comboBoxGroup, flexi_comboBoxPosition,flexi_comboBoxItem;
    @FXML private Label flexi_labelSectionNote, flexi_labelGroupNote, flexi_labelItemDescription;

    /**
     * Действия выполняемые при нажатии кнопки Close
     */
    @FXML void flexi_onActionButtonClose(){
        System.exit(0);
    }

    /**
     * Действия выполняемые при изменении раздела
     */
    @FXML void flexi_onActionComboBoxSection(){
        model.selectSection(flexi_comboBoxSection.getValue());
        flexi_comboBoxGroup.getItems().setAll(model.getGroupList());
        flexi_comboBoxGroup.setValue(flexi_comboBoxGroup.getItems().get(model.getSelectedGroup()));
        flexi_labelSectionNote.setText(model.getSectionNote());
    }

    /**
     * Действия выполняемые при изменении группы
     */
    @FXML void flexi_onActionComboBoxGroup(){
        model.selectGroup(flexi_comboBoxGroup.getValue());
        flexi_comboBoxPosition.getItems().setAll(model.getPositionList());
        flexi_comboBoxPosition.setValue(flexi_comboBoxPosition.getItems().get(model.getSelectedPosition()));
        flexi_labelGroupNote.setText(model.getGroupNote());

    }

    /**
     * Действия выполняемые при изменении товарной позиции
     */
    @FXML void flexi_onActionComboBoxPosition(){
        model.selectPosition(flexi_comboBoxPosition.getValue());
        flexi_comboBoxItem.getItems().setAll(model.getItemList());
        flexi_comboBoxItem.setValue(flexi_comboBoxItem.getItems().get(model.getSelectedItem()));
    }

    /**
     * Действия выполняемые при изменении субпозиции/кода
     */
    @FXML void flexi_onActionComboBoxItem(){
        model.selectItem(flexi_comboBoxItem.getValue());
        flexi_labelItemDescription.setText(model.getItemDescription());
    }

    /**
     * Инициализация представления и модели
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new HarmonisationModel_view_flexi_combo_box();
        // Раздел
        flexi_comboBoxSection.getItems().setAll(model.getSectionList());
        flexi_comboBoxSection.setValue(model.getSectionList()[model.selectedSection]);
        flexi_labelSectionNote.setText(model.getSectionNote());
        // Группа
        flexi_comboBoxGroup.getItems().setAll(model.getGroupList());
        flexi_comboBoxGroup.setValue(model.getGroupList()[model.selectedGroup]);
        flexi_labelGroupNote.setText(model.getGroupNote());
        // Позиция
        flexi_comboBoxPosition.getItems().setAll(model.getPositionList());
        flexi_comboBoxPosition.setValue(model.getPositionList()[model.selectedPosition]);
        // Субпозиция/элемент
        flexi_comboBoxItem.getItems().setAll(model.getItemList());
        flexi_comboBoxItem.setValue(model.getItemList()[model.selectedItem]);
        flexi_labelItemDescription.setText(model.getItemDescription());
    }
}
