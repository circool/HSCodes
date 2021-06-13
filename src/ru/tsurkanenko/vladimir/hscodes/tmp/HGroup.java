package ru.tsurkanenko.vladimir.hscodes.tmp;

class HGroup extends HItem{
    String note;

    HGroup(String code, String description, String note) {
        super(code,description);
        this.note = note;
    }

    String getNote() {
        return note;
    }
}
