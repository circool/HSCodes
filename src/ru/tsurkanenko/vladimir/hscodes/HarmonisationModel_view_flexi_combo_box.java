package ru.tsurkanenko.vladimir.hscodes;

import java.util.Arrays;

/**
 * Модель MVC для контроллера HarmonisationController_view_combo_box и представления Harmonisation_view_flexi_combo_box.fxml
 * @author Vladimir Tsurkanenko
 * @version 0.1
 */
public class HarmonisationModel_view_flexi_combo_box {
    final public HarmonisationBase base;
    public int selectedSection, selectedGroup, selectedPosition, selectedItem;
    public final String[] sectionList;
    public String[] groupList;
    public String[] positionList;
    public String[] itemList;
    public String[] groupNotes;
    public String fullDescription;

    public HarmonisationModel_view_flexi_combo_box() {
        // Начальная инициализация всех выпадающих списков
        base = new HarmonisationBase();
        sectionList = base.getSections().getCodesAndDescriptions();
        selectedSection = 0;
        //groupList = base.getGroups().startWith(sectionList[selectedSection].substring(0,2));
        selectedGroup = 0;
        //positionList = base.getPositions().startWith(groupList[selectedGroup].substring(2,4));
        selectedPosition = 0;
        //itemList = base.getItems().startWith(positionList[selectedPosition].substring(0,4));
        selectedItem = 0;
        fullDescription = base.getSections().getDescription(selectedSection) + "\n\t" +
                groupList[selectedGroup].substring(5) +  "\n\t\t" +
                positionList[selectedPosition] + "\n\t\t\t" +
                itemList[selectedItem];
    }

// Работа с разделами
    void selectSection(String selItem){
        selectedSection = Arrays.asList(sectionList).indexOf(selItem);
        updateGroupList();
    }
    String[] getSectionList(){
        return base.getSections().getCodesAndDescriptions();
    }
    String getSectionNote(){
        return base.getSections().getNote(selectedSection);
    }
// Работа с группами
    void updateGroupList(){
        //groupList = base.getGroups().startWith(sectionList[selectedSection].substring(0,2));
        selectedGroup = 0;
        updatePositionList();
    }
    void selectGroup(String selItem){
        selectedGroup = Arrays.asList(groupList).indexOf(selItem);
        updatePositionList();
    }
    String[] getGroupList(){
        return groupList;
    }
    int getSelectedGroup(){
        return selectedGroup;
    }
    String getGroupNote(){
        groupNotes = base.getGroups().getNotes(sectionList[selectedSection].substring(0,2));
        return groupNotes[selectedGroup];
    }
// Работа с позициями
    void updatePositionList(){
        //positionList = base.getPositions().startWith(groupList[selectedGroup].substring(2,4));
        selectedPosition = 0;
    }
    void selectPosition(String selItem){
        selectedPosition = Arrays.asList(positionList).indexOf(selItem);
        updateItemList();
    }
    String[] getPositionList() {
        return positionList;
    }
    int getSelectedPosition() {return selectedPosition;}
// Работа с кодами
    void updateItemList(){
        //itemList = base.getItems().startWith(positionList[selectedPosition].substring(0,4));
        selectedItem = 0;
    }
    void selectItem(String selItem){
        selectedItem = Arrays.asList(itemList).indexOf(selItem);
        fullDescription = base.getSections().getDescription(selectedSection) + "\n\t" +
                groupList[selectedGroup].substring(5) +  "\n\t\t" +
                positionList[selectedPosition] + "\n\t\t\t" +
                itemList[selectedItem];
    }
    String[] getItemList(){
        return itemList;
    }
    int getSelectedItem() {return selectedItem;}
    String getItemDescription(){
        return fullDescription;
    }
}
