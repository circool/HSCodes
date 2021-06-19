package ru.tsurkanenko.vladimir.hscodes.mvc.combobox_1;

import ru.tsurkanenko.vladimir.hscodes.database.*;

/**
 * Модель (Model) Model-View-Controller
 * Модель хранит свое состояние и предоставляет данные Представлению (View) реагируя на команды Контроллера (Controller)
 * @author Vladimir Tsurkanenko
 * @version 0.4
 */
public class Model {
    private final SimpleGroupsSet sectionList;
    private final SimpleGroupsSet groupList;
    private final SimpleItemsSet positionList;
    private final SimpleItemsSet itemList;
    private final int selectedPositionIndex;
    private final int selectedItemIndex;
    private String[] actualGroupList;
    private String[] actualPositionList;
    private String[] actualItemList;
    private String selectedSection,selectedGroup,selectedPosition,selectedItem, sectionNote,groupNote,itemDescription;

    public Model() {
        sectionList     = new SimpleGroupsSet("dic/TNVED1.TXT");
        groupList       = new SimpleGroupsSet("dic/TNVED2.TXT");
        positionList    = new SimpleItemsSet("dic/TNVED3.TXT");
        itemList        = new SimpleItemsSet("dic/TNVED4.TXT");
        int selectedGroupIndex;
        int selectedSectionIndex = selectedGroupIndex = selectedPositionIndex = selectedItemIndex = 0;
        String[] actualSectionList = sectionList.getAllItems();
        String actualSectionPrefix = actualSectionList[selectedSectionIndex].substring(0, 2);
        actualGroupList = groupList.getItemsStartsWith(actualSectionPrefix);
        String actualGroupPrefix = actualGroupList[selectedGroupIndex].substring(2, 4);
        actualPositionList = positionList.getItemsStartsWith(actualGroupPrefix);
        String actualPositionPrefix = actualPositionList[selectedPositionIndex].substring(0, 4);
        actualItemList = itemList.getItemsStartsWith(actualPositionPrefix);
    }

    public void setSelectedSection(String sectionName) {
        selectedSection = sectionName;
        for(int i = 0; i < sectionList.getAllNotes().length; i++)
            if(sectionList.getAllItems()[i].startsWith(selectedSection))
            sectionNote = sectionList.getNote(i).getDescription();
        updateGroups();
    }
    public String[] getActualSectionList() {
        return sectionList.getAllItems();
    }
    public String getSelectedSectionNote(){return sectionNote;}

    public void setSelectedGroup(String groupName){
        selectedGroup = groupName;
        for(int i = 0; i < groupList.getAllNotes().length; i++)
            if(groupList.getAllItems()[i].startsWith(selectedGroup))
                groupNote = groupList.getNote(i).getDescription();
        updatePositions();
    }
    public String getSelectedGroup() {
        return selectedGroup;
    }
    public String[] getActualGroupList() {
        String actualSectionPrefix = selectedSection.substring(0,2);
        actualGroupList = groupList.getItemsStartsWith(actualSectionPrefix);
        selectedGroup = actualGroupList[0];
        return actualGroupList;
    }
    public String getSelectedGroupNote(){return groupNote;}

    public void setSelectedPosition(String positionName){
        selectedPosition = positionName;
        updateItems();
    }
    public String getSelectedPosition() {
        return actualPositionList[selectedPositionIndex];
    }
    public String[] getActualPositionList() {
        String actualGroupPrefix = selectedGroup.substring(2, 4);
        actualPositionList = positionList.getItemsStartsWith(actualGroupPrefix);
        return actualPositionList;
    }

    public void setSelectedItem(String itemName){
        this.selectedItem = itemName;
        // TODO После выбора субпозиции необходимо обновить описание субпозиции
        itemDescription = selectedItem;

    }
    public String getSelectedItem() {
        return actualItemList[selectedItemIndex];
    }
    public String[] getActualItemList() {
        String actualPositionPrefix = selectedPosition.substring(0, 4);
        actualItemList = itemList.getItemsStartsWith(actualPositionPrefix);
        return actualItemList;
    }
    public String getItemDescription(){
        //TODO Сформировать описание
        itemDescription = actualItemList[selectedItemIndex];
        return itemDescription;
    }








    void updateGroups(){
        String actualSectionPrefix = selectedSection.substring(0,2);
        actualGroupList = groupList.getItemsStartsWith(actualSectionPrefix);
        selectedGroup = actualGroupList[0];
    }
    void updatePositions(){
        String actualGroupPrefix = selectedGroup.substring(2,4);
        actualPositionList = positionList.getItemsStartsWith(actualGroupPrefix);
        selectedPosition = actualPositionList[0];
    }
    void updateItems(){
        String actualItemsPrefix = selectedPosition.substring(0,4);
        actualPositionList = itemList.getItemsStartsWith(actualItemsPrefix);
        selectedItem = actualItemList[0];
    }

}
