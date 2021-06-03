package ru.tsurkanenko.vladimir.hscodes;

import java.util.Arrays;

/**
 * Модель (Model) Model-View-Controller
 * Модель хранит свое состояние и предоставляет данные Представлению (View) реагируя на команды Контроллера (Controller)
 * @author Vladimir Tsurkanenko
 * @version 1.0
 */
public class ModelV2 {
    /**
     * Комментарий к выбранному разделу
     */
    private String sectionNote, /**
     * Комментарий к выбранной группе
     */
    groupNote, /**
     * Полное описание выбранной товарной позиции
     */
    itemDescription;
    /**
     * Список разделов
     */
    private String[] sectionList, /**
     * Список группп
     */
    groupList, /**
     * Список подгрупп
     */
    subGroupList, /**
     * Список товарных позиций
     */
    itemList;
    /**
     * Выбранный раздел
     */
    private int selectedSection, /**
     * Выбранная группа
     */
    selectedGroup, /**
     * Выбранная подгруппа
     */
    selectedSubGroup, /**
     * Выбранная товарная позиция
     */
    selectedItem;
    final HarmBase hs = new HarmBase();

    /**
     * Создание новой модели.
     */
    public ModelV2() {
        setSectionList();
        setGroupList();
        setSubGroupList();
        setItemList();
        setSectionNote();
        setGroupNote();
        setItemDescription();
    }
    /**
     * Получить выбранный раздел
     *
     * @return выбранный раздел
     */
    public String getSelectedSection() {
        return sectionList[selectedSection];
    }

    /**
     * Выбрать раздел.
     *
     */
    public void setSelectedSection(String item) {
        this.selectedSection = Arrays.asList(sectionList).indexOf(item);
        this.setGroupList();
        this.selectedGroup = 0;
        this.setGroupNote();
        this.setSectionNote();
    }

    /**
     * Получить выбранную группу
     *
     * @return выбранная группа
     */
    public String getSelectedGroup() {
        return groupList[selectedGroup];
    }

    /**
     * Выбрать группу
     *
     */
    public void setSelectedGroup(String item) {
        this.selectedGroup = Arrays.asList(groupList).indexOf(item);
        this.setGroupNote();

        this.setSubGroupList();
        this.selectedSubGroup = 0;
    }

    /**
     * Получить выбранную подгруппу
     *
     * @return выбранная подгруппа
     */
    public String getSelectedSubGroup() {
        return subGroupList[selectedSubGroup];
    }

    /**
     * Выбрать подгруппу
     *
     */
    public void setSelectedSubGroup(String item) {
        this.selectedSubGroup = Arrays.asList(subGroupList).indexOf(item);

        this.setItemList();
        this.selectedItem = 0;
        this.setItemDescription();
    }

    /**
     * Получить выбранную товарную позицию
     *
     * @return выбранная товарная позиция
     */
    public String getSelectedItem() {
        if(selectedItem < itemList.length)
            selectedItem = 0;
        return itemList[selectedItem];
    }

    /**
     * Выбрать товарную позицию.
     *
     */
    public void setSelectedItem(String item) {
        this.selectedItem = Arrays.asList(itemList).indexOf(item);
        this.setItemDescription();
    }

    /**
     * Получить примечание к выбранному разделу.
     *
     * @return примечание к разделу
     */
    public String getSectionNote() {
        return sectionNote;
    }

    /**
     * Сформировать примечание к выбранному разделу
     *
     */
    public void setSectionNote() {
        //TODO
        //this.sectionNote = hs.getSection().getNote(sectionList[selectedSection].substring(0,2))[0];
    }

    /**
     * Получить примечание к выбранной группе
     *
     * @return примечание к группе
     */
    public String getGroupNote() {
        return groupNote;
    }

    /**
     * Сформировать примечание к выбранной группе
     */
    public void setGroupNote() {
        //TODO
        //this.groupNote = hs.getGroup().getNote(groupList[selectedGroup].substring(0,4))[0];
    }

    /**
     * Получить описание выбранной товарной позиции.
     *
     * @return описание товарной позиции
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Сформировать описание товарной позиции
     */
    public void setItemDescription() {
        this.itemDescription =
                sectionList[selectedSection] + "\n\t" +
                        groupList[selectedGroup] + "\n\n" +
                        subGroupList[selectedSubGroup] + "\n\t" +
                        itemList[selectedItem];
    }

    /**
     * Получить список разделов [ ].
     *
     */
    public String[] getSectionList() {
        return this.sectionList;
    }

    /**
     * Сформировать список разделов.
     *
     */
    public void setSectionList() {
        sectionList =  hs.getSections().getItemsView();
    }

    /**
     * Получить список групп [ ].
     *
     * @return список групп [ ]
     */
    public String[] getGroupList() {
        return groupList;
    }

    /**
     * Сформировать список групп.
     *
     */
    public void setGroupList() {
        this.groupList = hs.getGroups().getItemsView(sectionList[selectedSection].substring(0,2));
    }

    /**
     * Получить список подгрупп [ ].
     *
     * @return список подгрупп [ ]
     */
    public String[] getSubGroupList() {
        return subGroupList;
    }

    /**
     * Сформировать список подгрупп
     *
     */
    public void setSubGroupList() {
        this.subGroupList = hs.getSubSections().getItemsView(groupList[selectedGroup].substring(2,4));
    }

    /**
     * Получить список товарных позиций [ ].
     *
     * @return список товарных позиций [ ]
     */
    public String[] getItemList() {
        return itemList;
    }

    /**
     * Установить список товарных позиций.
     */
    public void setItemList() {
        String[] result;
        result = hs.getItems().getItemsView(subGroupList[selectedSubGroup].substring(0,4));
        if(result.length == 0)
            this.itemList = hs.getItems().getItemsView(subGroupList[selectedSubGroup].substring(0,4));
        else
            this.itemList = result;
    }
    public String[] getSubSections(String code){
        groupList = hs.getSubSections().getItemsView();
        int totalFound = 0;

        for (String subsection:groupList) {
            if (subsection.substring(0,2).equals(code))
                totalFound++;
        }
        String[] result = new String[totalFound];
        totalFound = 0;
        for (String subsection:groupList) {
            if (subsection.substring(0, 2).equals(code)) {
                result[totalFound] = subsection;
                totalFound++;
            }
        }
        return result;
    }

    /**
     * Возвращает список позиций указанного уровня вложенности
     * @param code для каких кодов выдать список
     * @param nestlingLevel уровень вложенности
     * @return список
     */
    String[] getSubPositions(String code, int nestlingLevel){
        String[] result = null;
        //TODO Разобнатся с необходимостью такого метода
        /*
        while((result = hs.getChapter().getList(code, nestlingLevel)).length == 0 || nestlingLevel < 10)
            nestlingLevel++;

         */
        return result;
    }
}
