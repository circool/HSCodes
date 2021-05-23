package ru.tsurkanenko.vladimir.hscodes;

public class HSBase {
    private final ParseData section;
    private final ParseData group;
    private final ParseData subgroup;
    private final ParseData subsubgroup;

    public HSBase() {
        section = new ParseData("dic/TNVED1.TXT");
        group = new ParseData("dic/TNVED2.TXT");
        subgroup = new ParseData("dic/TNVED3.TXT");
        subsubgroup = new ParseData("dic/TNVED4.TXT");
    }

    public ParseData getSection() {
        return section;
    }
    public String[] getSectionList(){
        String[] list = new String[section.getSize()];
        for(int n=0; n < list.length; n++)
            list[n] = section.getCode(n) + " " + section.getDescription(n);
        return list;
    }

    public ParseData getGroup() {
        return group;
    }

    public ParseData getSubgroup() {
        return subgroup;
    }

    public ParseData getSubsubgroup() {
        return subsubgroup;
    }
}
