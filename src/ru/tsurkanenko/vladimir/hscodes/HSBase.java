package ru.tsurkanenko.vladimir.hscodes;

public class HSBase {
    private final HSGroup section;
    private final HSGroup group;
    private final HSGroup subgroup;
    private final HSGroup item;

    public HSBase() {
        section = new HSGroup("dic/TNVED1.TXT");
        group = new HSGroup("dic/TNVED2.TXT");
        subgroup = new HSGroup("dic/TNVED3.TXT");
        item = new HSGroup("dic/TNVED4.TXT");
    }

    public HSGroup getSection() {
        return section;
    }

    public HSGroup getGroup() {
        return group;
    }

    public HSGroup getSubGroup() {
        return subgroup;
    }

    public HSGroup getItem() {
        return item;
    }
}
