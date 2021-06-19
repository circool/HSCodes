package ru.tsurkanenko.vladimir.hscodes.mvc.comnobox_2;

import ru.tsurkanenko.vladimir.hscodes.database.SimpleHSScope;

public class Model {
    final SimpleHSScope model_HsScope;
    String selectedSection;
    String selectedGroup;
    String selectedPosition;
    String selectedItem;

    public Model() {
        model_HsScope = new SimpleHSScope();
        selectedSection = model_HsScope.getSectionItems()[0];
    }

    public String[] getSections(){
        return model_HsScope.getSectionItems();
    }
    public void setSection(String sectionName){selectedSection=sectionName;
    }
    public String getSectionNote(){
        return model_HsScope.getSectionNote(selectedSection);
    }
    public String[] getGroups(){
        String[] result = model_HsScope.getChildrenGroups(selectedSection);
        for(int i =0; i < result.length; i++)
            result[i] = result[i].substring(2);
        return result;
    }
    public void setGroup(String groupName){
        selectedGroup = groupName;
    }
    public String getGroupNote(){
        return model_HsScope.getGroupNote(selectedGroup);
    }
    public String[] getPositions(){
        return model_HsScope.getChildrenPositions(selectedGroup.substring(2));
    }
    public void setPosition(String positionName){selectedPosition = positionName;}
    public String[] getItems(){
        return model_HsScope.getChildrenItems(selectedPosition);
    }
    public void setItem(String itemName){selectedItem = itemName;}
    public String getItemNote(){
        return model_HsScope.getItemDescription(selectedItem);
    }
}
