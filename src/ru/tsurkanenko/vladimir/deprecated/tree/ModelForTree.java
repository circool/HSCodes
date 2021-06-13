package ru.tsurkanenko.vladimir.deprecated.tree;
import ru.tsurkanenko.vladimir.deprecated.HarmBase;

import java.util.Arrays;
@Deprecated
/**
 * Модель (ModelForComboBox) ModelForComboBox-View-Controller для варианта, использующего View с древовидным списком.
 * Модель хранит свое состояние и предоставляет данные Представлению (View) реагируя на команды Контроллера (Controller)
 * @author Vladimir Tsurkanenko
 * @version 0.2 WOF
 */
public class ModelForTree {
    /**
     * Комментарий к выбранному разделу
     */
    private String sectionNote,
    /**
     * Комментарий к выбранной группе
     */
    groupNote,
    /**
     * Полное описание выбранной товарной позиции
     */
    itemDescription;
    /**
     * Список разделов
     */
    private String[] sectionList,
    /**
     * Список группп
     */
    subSectionList,
    /**
     * Список подгрупп
     */
    groupList,
    /**
     * Список товарных позиций
     */
    itemList;
    /**
     * Выбранный раздел
     */
    private int selectedSection,
    /**
     * Выбранный подраздел (группа)
     */
    selectedSubSection,
    /**
     * Выбранная подгруппа
     */
    selectedGroup,
    /**
     * Выбранная товарная позиция
     */
    selectedItem;
    HarmBase hs;

    /**
     * Создание новой модели.
     */
    public ModelForTree() {
        hs = new HarmBase();
        this.sectionList = hs.getSections().getItemsView();
        this.subSectionList = hs.getSubSections().getItemsView(sectionList[selectedSection].substring(0,2));
        this.groupList = hs.getGroups().getItemsView(subSectionList[selectedSubSection].substring(2,4));
        this.itemList = hs.getItems().getItemsView(groupList[selectedGroup].substring(0,4));
    }
    /**
     * Получить список разделов.
     *
     * @return массив с разделами
     */
    public String[] getSectionList() {
        return this.sectionList;
    }
    /**
     * Получить список подразделов(групп).
     *
     * @return массив с подразделами
     */
    public String[] getSubSectionList() {
        this.subSectionList = hs.getSubSections().getItemsView(sectionList[selectedSection].substring(0,2));
        selectedSubSection = 0;
        return subSectionList;
    }
    /**
     * Получить список подгрупп.
     *
     * @return массив с подгруппами
     */
    public String[] getGroupList() {
        this.groupList = hs.getGroups().getItemsView(subSectionList[selectedSubSection].substring(2,4));
        selectedGroup = 0;
        return groupList;
    }
    /**
     * Получить список товарных позиций.
     *
     * @return массив с товарнми позициями
     */
    public String[] getItemList() {
        this.itemList = hs.getItems().getItemsView(groupList[selectedGroup].substring(0,4));
        return itemList;
    }
    /**
     * Выбрать активный(текущий) раздел.
     *
     */
    public void selectSection(String item) {
        this.selectedSection = Arrays.asList(sectionList).indexOf(item);
        this.getSubSectionList();
        // TODO Добавить обработку комментариев
    }
    /**
     * Выбрать активный(текущий) подраздел (группу)
     *
     */
    public void selectSubSection(String item) {
        this.selectedSubSection = Arrays.asList(subSectionList).indexOf(item);
        this.getGroupList();
        // TODO Добавить обработку комментариев
    }
    /**
     * Выбрать активную(текущую) группу
     */
    public void selectGroup(String item){
        this.selectedGroup = Arrays.asList(groupList).indexOf(item);
    }
    /**
     * Выбрать активную(текущую) товарную позицию.
     *
     */
    public void selectItem(String item) {
        this.selectedItem = Arrays.asList(itemList).indexOf(item);
    }
}
