package ru.tsurkanenko.vladimir.hscodes.tmp;


import ru.tsurkanenko.vladimir.hscodes.tmp.HGroup;
import ru.tsurkanenko.vladimir.hscodes.tmp.IArray;

public class GArray extends IArray {
    HGroup[] hGroups;

    public GArray(String fileName) {
        super(fileName);
        String regexNote = "^[0-9\\|]*.*?\\|(.*?)\\|.*$";
        hGroups = new HGroup[dataLines.length];
        String currentCode, currentDescription, currentNote, firstOneLetter;
        for(int i=0; i< hItems.length; i++){
            currentCode = hItems[i].code;
            currentDescription = hItems[i].description;
            currentNote = dataLines[i].replaceAll(regexNote,"$1");
            hGroups[i] = new HGroup(currentCode,currentDescription,currentNote);
        }
    }
    public HGroup[] getItems() {
        return hGroups;
    }
}
