package ru.tsurkanenko.vladimir.hscodes;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Представление (View) модели Model-View-Controller
 * Отвечает за отображение данных пользователю
 */
public class View {
    @FXML
    private Label lblSectionDescr, lblGroupDescr, lblFinalDescr;
    @FXML
    private ComboBox<String> comboBoxSection, comboBoxGroup, comboBoxSubGroup, comboBoxItem;
    @FXML
    private ObservableList<String> listSection, listGroup, listSubGroup, listItem;

    /**
     * Изменяет комментарии к разделу
     * @param text Текст комментария
     */
    public void setViewLabelSectionDescr(String text) {
        lblSectionDescr.setText(text);
    }
    /**
     * Изменяет комментарии к группе
     * @param text Текст комментария
     */
    public void setViewLabelGroupDescr(String text) {
        lblGroupDescr.setText(text);
    }
    /**
     * Изменяет окончательное описание товарной позиции
     * @param text Текст описания
     */
    public void setViewLabelFinalDescr(String text) {
        lblFinalDescr.setText(text);
    }

    /**
     * Изменяет содержимое выпадающего списка Раздел
     * @param list Список актуальных разделов
     */
    public void setViewComboBoxSection(ObservableList<String> list){
        comboBoxSection.setItems(list);
        comboBoxSection.setValue(list.get(0));
    }

    /**
     * Определяет состояние выпадающего списка Раздел
     * @return Первые 2 цифры выбранного раздела
     */
    public String getComboBoxSection(){
        return comboBoxSection.getValue().substring(0,2);
    }

    /**
     * Изменяет содержимое выпадающего списка Группа
     * @param list Список актуальных групп
     */
    public void setViewComboBoxGroup(ObservableList<String> list){
        comboBoxGroup.setItems(list);
        comboBoxGroup.setValue(list.get(0));
    }

    /**
     * Определяет состояние выпадающего списка Группа
     * @return Первые 4 цифры выбранной группы
     */
    public String getComboBoxGroup(){
        if(comboBoxGroup.getValue()!=null)
            return comboBoxGroup.getValue().substring(0,4);
        else
            return "0101";
    }

    /**
     * Изменяет содержимое выпадающего списка Подгруппа
     * @param list Список актуальных подгрупп
     */
    public void setViewComboBoxSubGroup(ObservableList<String> list){
        comboBoxSubGroup.setItems(list);
        comboBoxSubGroup.setValue(list.get(0));
    }

    /**
     * Определяет состояние выпадающего списка Подгруппа
     * @return Первые 4 цифры выбранной подгруппы
     */
    public String getComboBoxSubGroup() {
        if(comboBoxSubGroup.getValue()!=null)
            return comboBoxSubGroup.getValue().substring(0,4);
        else
            return "0101";
    }

    /**
     * Изменяет содержимое выпадающего списка Товарные позиции
     * @param list Список актуальных товарных позиций
     */
    public void setViewComboBoxItem(ObservableList<String> list){
        comboBoxItem.setItems(list);
        comboBoxItem.setValue(list.get(0));
    }

    /**
     * Определяет состояние выпадающего списка Товарные позиции
     * @return Первые 10 цифр выбранной товарной позиции
     */
    public String getComboBoxItem() {
        if(comboBoxItem.getValue()!=null)
            return comboBoxItem.getValue().substring(0, 10);
        else
            return "";
    }

    /**
     * Завершение приложения
     */
    public void exit(){
        System.exit(0);
    }
}