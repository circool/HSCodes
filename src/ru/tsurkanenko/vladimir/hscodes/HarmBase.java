package ru.tsurkanenko.vladimir.hscodes;

public class HarmBase {
    private HarmGroupArray section, subsection;
    private HarmItemArray group, item;
    public HarmBase() {
        section = new HarmGroupArray("dic/TNVED1.TXT");
        subsection = new HarmGroupArray("dic/TNVED2.TXT");
        group = new HarmItemArray("dic/TNVED3.TXT");
        item = new HarmItemArray("dic/TNVED4.TXT");
    }

    public HarmGroupArray getSections() {
        return section;
    }

    public HarmGroupArray getSections(String code) {
        return section;
    }

    public HarmGroupArray getSubSections() {
        return subsection;
    }

    public HarmItemArray getGroups() {
        return group;
    }

    public HarmItemArray getItems() {
        return item;
    }
}
