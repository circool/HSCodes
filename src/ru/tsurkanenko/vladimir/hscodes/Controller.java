package ru.tsurkanenko.vladimir.hscodes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер (Controller) Model-View-Controller
 * интерпретирует действия пользователя, оповещая модель о необходимости изменений
 */
public class Controller extends View implements Initializable  {
    public HSBase hs = new HSBase();
    @FXML
    ObservableList<String> listSection, listGroup, listSubGroup, listItem;
    @FXML
    private ComboBox<String> comboBoxSection,comboBoxGroup, comboBoxSubGroup,comboBoxItem;

    /**
     *  Действия, выполняемые при изменении состояния выпадающего списка Разделы
     */
    private void comboBoxSectionChanged(){
        listGroup.clear();
        listGroup.addAll(hs.getGroup().getList(getComboBoxSection()));
        setViewComboBoxGroup(listGroup);
        setViewLabelSectionDescr(hs.getSection().getNote(getComboBoxSection())[0]);
    }
    /**
     *  Действия, выполняемые при изменении состояния выпадающего списка Группы
     */
    private void comboBoxGroupChanged(){
        listSubGroup.clear();
        listSubGroup.addAll(hs.getSubGroup().getList(getComboBoxGroup().substring(2)));
        setViewComboBoxSubGroup(listSubGroup);
        setViewLabelGroupDescr(hs.getGroup().getNote(getComboBoxGroup())[0]);
    }
    /**
     *  Действия, выполняемые при изменении состояния выпадающего списка Подгруппы
     */
    private void comboBoxSubGroupChanged(){
        listItem.clear();
        listItem.addAll(hs.getItem().getList(getComboBoxSubGroup()));
        setViewComboBoxItem(listItem);
    }
    /**
     *  Действия, выполняемые при изменении состояния выпадающего списка Товарные позиции
     */
    private void comboBoxItemChanged(){
        setViewLabelFinalDescr(
                hs.getSection().getList(getComboBoxSection())[0].substring(3)
                        + "\n\t" + hs.getGroup().getList(getComboBoxGroup())[0].substring(5)
                        + "\n\t\t" + hs.getSubGroup().getList(getComboBoxSubGroup())[0].substring(5)
                        + "\n\t\t\t" + hs.getItem().getList(getComboBoxItem())[0]
        );
    }
    /**
     *  Инициализация модели
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listSection = FXCollections.observableArrayList(hs.getSection().getList());
        setViewComboBoxSection(listSection);
        setViewLabelSectionDescr(hs.getSection().getNote(getComboBoxSection())[0]);
        listGroup = FXCollections.observableArrayList(hs.getGroup().getList(getComboBoxSection()));
        setViewLabelGroupDescr(hs.getGroup().getNote(getComboBoxGroup())[0]);

        setViewComboBoxGroup(listGroup);
        listSubGroup = FXCollections.observableArrayList(hs.getSubGroup().getList(getComboBoxGroup().substring(2)));

        setViewComboBoxSubGroup(listSubGroup);
        listItem = FXCollections.observableArrayList(hs.getItem().getList(getComboBoxSubGroup()));

        setViewComboBoxItem(listItem);
        setViewLabelFinalDescr(
                hs.getSection().getList(getComboBoxSection())[0].substring(3)
                        + "\n\t" + hs.getGroup().getList(getComboBoxGroup())[0].substring(5)
                        + "\n\t\t" + hs.getSubGroup().getList(getComboBoxSubGroup())[0].substring(5)
                        + "\n\t\t\t" + hs.getItem().getList(getComboBoxItem())[0]
        );
        comboBoxSection.setOnAction(event -> comboBoxSectionChanged());
        comboBoxGroup.setOnAction(event -> comboBoxGroupChanged());
        comboBoxSubGroup.setOnAction(event -> comboBoxSubGroupChanged());
        comboBoxItem.setOnAction(event -> comboBoxItemChanged());
        System.out.println();
    }
}
