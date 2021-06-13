package ru.tsurkanenko.vladimir.hscodes.tmp;

import ru.tsurkanenko.vladimir.hscodes.RawLines;

import java.util.ArrayList;

public class SimpleGroupsSet extends SimpleItemsSet {
    private SimpleItem[] notes;

    public SimpleGroupsSet(String fileName){
        super(fileName);
        String regexCode = "^([0-9]+)\\|([0-9]*)\\|*([0-9]*)\\|*.*$";
        String regexNote = "^[0-9\\|]*.*?\\|(.*?)\\|.*$";
        String[] dataLines = new RawLines(fileName).getRawData();
        notes = new SimpleItem[dataLines.length];
        for (int i = 0; i < notes.length; i++)
            notes[i] = new SimpleItem(dataLines[i].replaceAll(regexCode,"$1$2$3"), dataLines[i].replaceAll(regexNote,"$1"));
    }

    public SimpleItem[] getAllNotes() {
        return notes;
    }
    public SimpleItem getNote(int index) {
        return notes[index];
    }

    public SimpleItem[] getNotesStartsWith(String prefix) {
        //  Обрезать префикс если он длиннее кода в массиве элементов SimpleItem
        if(prefix.length() > notes[0].code.length())
            prefix = prefix.substring(0, notes[0].code.length());

        // Получить первую цифру из параметра prefix
        int actualIndex = Integer.parseInt(prefix.substring(0,1));

        // Сузить границы поиска
        int firstIndex = indexFirstOne[actualIndex];
        int lastIndex = indexLastOne[actualIndex];

        // Найти подходящие коды
        ArrayList<SimpleItem> totalFound = new ArrayList<>();
        for(int i = firstIndex; i <= lastIndex; i++ ){
            if(notes[i].code.startsWith(prefix))
                totalFound.add(notes[i]);
        }
        // Вернуть результат в виде массива
        SimpleItem[] result = new SimpleItem[totalFound.size()];
        result = totalFound.toArray(result);
        return result;
    }
}
