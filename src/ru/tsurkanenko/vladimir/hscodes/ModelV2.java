package ru.tsurkanenko.vladimir.hscodes;

import java.util.Arrays;

/**
 * Модель (Model) Model-View-Controller
 * Модель хранит свое состояние и предоставляет данные Представлению (View) реагируя на команды Контроллера (Controller)
 * @author Vladimir Tsurkanenko
 * @version 0.2
 */
public class ModelV2 {
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
    final HarmBase hs = new HarmBase();

    /**
     * Создание новой модели.
     */
    public ModelV2() {
        //HarmBase hs = new HarmBase();
        this.sectionList = hs.getSections().getItemsView();
        this.selectedSection = 0;
        this.subSectionList = hs.getSubSections().getItemsView(sectionList[selectedSection].substring(0,2));
        this.selectedSubSection = 0;
        this.groupList = hs.getGroups().getItemsView(subSectionList[selectedSubSection].substring(2,4));
        this.selectedGroup = 0;
        this.itemList = hs.getItems().getItemsView(groupList[selectedGroup].substring(0,4));
        selectedItem = 0;

        //setItemList();
        //setSectionNote();
        //setGroupNote();
        //setItemDescription();

    }

    /**
     * Получить список разделов [ ].
     *
     */
    public String[] getSectionList() {
        return this.sectionList;
    }
    /**
     * Получить список подразделов(групп) [ ].
     *
     * @return список подразделов
     */
    public String[] getSubSectionList() {
        this.subSectionList = hs.getSubSections().getItemsView(sectionList[selectedSection].substring(0,2)); //getSubSections[selectedSection];
        selectedSubSection = 0;
        return subSectionList;
    }
    /**
     * Получить список подгрупп [ ].
     *
     * @return список подгрупп [ ]
     */
    public String[] getGroupList() {
        this.groupList = hs.getGroups().getItemsView(subSectionList[selectedSubSection].substring(2,4));
        selectedGroup = 0;
        return groupList;
    }
    /**
     * Получить список товарных позиций [ ].
     *
     * @return список товарных позиций [ ]
     */
    public String[] getItemList() {
        this.itemList = hs.getItems().getItemsView(groupList[selectedGroup].substring(0,4));
        return itemList;
    }

    /**
     * Выбрать раздел.
     *
     */
    public void selectSection(String item) {
        this.selectedSection = Arrays.asList(sectionList).indexOf(item);
        //this.setSectionNote();
        this.getSubSectionList();
    }
    /**
     * Выбрать подраздел (группу)
     *
     */
    public void selectSubSection(String item) {
        this.selectedSubSection = Arrays.asList(subSectionList).indexOf(item);
        //this.setGroupNote();
        this.getGroupList();
        //this.selectedGroup = 0;
    }
    /**
     * Выбрать группу
     */
    public void selectGroup(String item){
        this.selectedGroup = Arrays.asList(groupList).indexOf(item);
        //this.selectedItem = 0;
    }

    /**
     * Выбрать товарную позицию.
     *
     */
    public void selectItem(String item) {
        this.selectedItem = Arrays.asList(itemList).indexOf(item);
        //this.setItemDescription();
    }




    // Разделы
// Список разделов
    /**
     * Сформировать список разделов.
     *
     */
 /*   public void setSectionList() {
        this.sectionList = hs.getSections().getItemsView();
    }

// Выбор текущего раздела

    /**
     * Получить выбранный раздел
     *
     * @return выбранный раздел
     */
/*    public String getSelectedSection() {
        return sectionList[selectedSection];
    }
// Примечание
    /**
     * Сформировать примечание к выбранному разделу
     *
     */
/*    public void setSectionNote() {
        //TODO
        this.sectionNote = hs.getSections()[0]   ;  //getSection().getNote(sectionList[selectedSection].substring(0,2))[0];
    }
    /**
     * Получить примечание к выбранному разделу.
     *
     * @return примечание к разделу
     */
/*    public String getSectionNote() {
        return sectionNote;
    }











    /**
     * Получить примечание к выбранной группе
     *
     * @return примечание к группе
     */
 /*   public String getGroupNote() {
        return groupNote;
    }





    /**
     * Сформировать список подразделов.
     *
     */
 /*   public void setSubSectionList() {
        this.subSectionList = hs.getSubSections().getItemsView(sectionList[selectedSection].substring(0,2));
        selectedSubSection = 0;
    }








    /**
     * Получить выбранную группу
     *
     * @return выбранная группа
     */
 /*   public String getSelectedSubSection() {
        return subSectionList[selectedSubSection];
    }



    /**
     * Получить выбранную подгруппу
     *
     * @return выбранная подгруппа
     */
/*    public String getSelectedSubGroup() {
        return subGroupList[selectedSubGroup];
    }



    /**
     * Получить выбранную товарную позицию
     *
     * @return выбранная товарная позиция
     */
/*    public String getSelectedItem() {
        if(selectedItem < itemList.length)
            selectedItem = 0;
        return itemList[selectedItem];
    }





    /**
     * Сформировать примечание к выбранной группе
     */
 /*   public void setGroupNote() {
        //TODO
        //this.groupNote = hs.getGroup().getNote(groupList[selectedGroup].substring(0,4))[0];
    }

    /**
     * Получить описание выбранной товарной позиции.
     *
     * @return описание товарной позиции
     */
/*    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Сформировать описание товарной позиции
     */
 /*   public void setItemDescription() {
        this.itemDescription =
                sectionList[selectedSection] + "\n\t" +
                        subSectionList[selectedSubSection] + "\n\n" +
                        subGroupList[selectedSubGroup] + "\n\t" +
                        itemList[selectedItem];
    }


    /**
     * Выбрать подгруппу
     *
     */
 /*   public void setSelectedSubGroup(String item) {
        this.selectedSubGroup = Arrays.asList(subGroupList).indexOf(item);

        this.setItemList();
        this.selectedItem = 0;
        this.setItemDescription();
    }




    /**
     * Сформировать список подгрупп
     *
     */
/*    public void setSubGroupList() {
        this.subGroupList = hs.getSubSections().getItemsView(subSectionList[selectedSubSection].substring(2,4));
    }



    /**
     * Установить список товарных позиций.
     */
 /*   public void setItemList() {
        String[] result;
        result = hs.getItems().getItemsView(subGroupList[selectedSubGroup].substring(0,4));
        if(result.length == 0)
            this.itemList = hs.getItems().getItemsView(subGroupList[selectedSubGroup].substring(0,4));
        else
            this.itemList = result;
    }

    public String[] getSubSectionsList(){
        return hs.getSections().getItemsView();
    }

    public String[] getSubSections(String code){
        subSectionList = hs.getSubSections().getItemsView();
        int totalFound = 0;

        for (String subsection: subSectionList) {
            if (subsection.substring(0,2).equals(code))
                totalFound++;
        }
        String[] result = new String[totalFound];
        totalFound = 0;
        for (String subsection: subSectionList) {
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
/*    String[] getSubPositions(String code, int nestlingLevel){
        String[] result = null;
        //TODO Разобнатся с необходимостью такого метода
        /*
        while((result = hs.getChapter().getList(code, nestlingLevel)).length == 0 || nestlingLevel < 10)
            nestlingLevel++;

         */
 /*       return result;
    }

  */
}
