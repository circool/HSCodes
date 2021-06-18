package ru.tsurkanenko.vladimir.hscodes.database;

/**
 * Справочник ТНВЭД
 * @version 0.4
 * @author Vladimir Tsurkanenko
 */
public class SimpleHSScope {
    private final SimpleGroupsSet sections;
    private final SimpleGroupsSet groups;
    private final SimplePositionSet positions;
    private final SimpleItemsSet subPositions;

    public SimpleHSScope() {
        sections = new SimpleGroupsSet("dic/TNVED1.TXT");
        groups = new SimpleGroupsSet("dic/TNVED2.TXT");


        positions = new SimplePositionSet("dic/TNVED3.TXT","dic/TNVED4.TXT");
        subPositions = new SimpleItemsSet("dic/TNVED4.TXT");
    }
    public String[] getSectionItems(){
        return sections.getAllItems();
    }
    public String getSectionNote(String section){
        if (section.length()< 2)
            return "";
        return sections.getNote(section);
    }
    public String getGroupNote(String group){
        if (group.length()< 4)
            return "";
        return groups.getNote(group);
    }
    public String getItemDescription(String item){
        if (item.length() < 10)
            return "";
        return subPositions.getItemsStartsWith(item)[0];
    }
    public String[] getChildrenGroups(String prefix){
        return groups.getItemsStartsWith(prefix.substring(0,2));
    }
    public String[] getChildrenPositions(String prefix){
        return positions.getItemsStartsWith(prefix.substring(0,2));
    }
    public String[] getChildrenItems(String prefix){
        return subPositions.getItemsStartsWith(prefix.substring(0,4));
    }
}

class SimpleHSScopeDemo{
    public static void main(String[] args) {
        SimpleHSScope demo = new SimpleHSScope();
        System.out.println(demo.getSectionNote("02"));
        System.out.println(demo.getGroupNote("0101"));
    }
}
