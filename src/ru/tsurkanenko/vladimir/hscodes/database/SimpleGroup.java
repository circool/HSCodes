package ru.tsurkanenko.vladimir.hscodes.database;

class SimpleGroup extends SimpleItem {
    String note;

    public SimpleGroup(String code, String description, String note) {
        super(code, description);
        this.note = note;
    }

    public SimpleGroup(String rawLine) {
        super(rawLine);
        String regexNote = "^[0-9\\|]*.*?\\|(.*?)\\|.*$";
        this.note = rawLine.replaceAll(regexNote, "$1");
    }

    public String getNote () {
        return note;
    }
}
