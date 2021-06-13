package ru.tsurkanenko.vladimir.hscodes.tmp;

class SimpleItem {
    String code;
    String description;

    public SimpleItem(String rawLine) {
        String regexCode = "^([0-9]+)\\|([0-9]*)\\|*([0-9]*)\\|*.*$";
        String regexDescription = "^[0-9|]+(.*?)\\|.*";
        this.code = rawLine.replaceAll(regexCode,"$1$2$3");
        this.description = rawLine.replaceAll(regexDescription,"$1");
    }

    public SimpleItem(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String get() {
        return code + " " + description;
    }
}
