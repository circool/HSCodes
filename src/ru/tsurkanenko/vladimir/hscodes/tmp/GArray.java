package ru.tsurkanenko.vladimir.hscodes.tmp;


public class GArray extends IArray {
    SimpleGroup[] hGroups;

    public GArray(String fileName) {
        super(fileName);
        String regexNote = "^[0-9\\|]*.*?\\|(.*?)\\|.*$";
        hGroups = new SimpleGroup[dataLines.length];
        String currentCode, currentDescription, currentNote, firstOneLetter;
        for(int i = 0; i< simpleItems.length; i++){
            currentCode = simpleItems[i].code;
            currentDescription = simpleItems[i].description;
            currentNote = dataLines[i].replaceAll(regexNote,"$1");
            hGroups[i] = new SimpleGroup(currentCode,currentDescription,currentNote);
        }
    }
    public SimpleGroup[] getItems() {
        return hGroups;
    }
}
