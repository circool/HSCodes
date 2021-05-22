package ru.tsurkanenko.vladimir.hscodes;

public class HSBase {
    private ParseData section;
    private ParseData group;
    private ParseData subgroup;
    private ParseData subsubgroup;

    public HSBase() {
        section = new ParseData("dic/TNVED1.TXT");
        group = new ParseData("dic/TNVED2.TXT");
        subgroup = new ParseData("dic/TNVED3.TXT");
        subsubgroup = new ParseData("dic/TNVED4.TXT");
    }

    public ParseData getSection() {
        return section;
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
