package ru.tsurkanenko.vladimir.hscodes.database;

import ru.tsurkanenko.vladimir.hscodes.RawLines;

import java.util.ArrayList;
/**
 * Коллекция разделов или товарных групп справочника организованная в виде массива
 * Отличается от SimpleItemsSet тем, что имеет дополнительное поле с комментарием к разделам/группам
 * @see ru.tsurkanenko.vladimir.hscodes.database.SimpleItemsSet
 * @author Vladimir Tsurkanenko
 * @version 0.4
 */
public class SimpleGroupsSet extends SimpleItemsSet {
    private final SimpleItem[] notes;

    public SimpleGroupsSet(String fileName){
        super(fileName);
        String regexCode = "^([0-9]+)\\|([0-9]*)\\|*([0-9]*)\\|*.*$";
        String regexNote = "^[0-9|]*.*?\\|\\s*(.*?)\\|.*$";

        String regexNoteClear = "([;:]|\\.\\d)";

        String regexFormattingWhat = "(\\.)\\s(\\d\\.)";
        String regexFormattingReplace = "$1\n$2";
        String[] dataLines = new RawLines(fileName).getRawData();
        notes = new SimpleItem[dataLines.length];
        for (int i = 0; i < notes.length; i++) {
            String clearedNote = dataLines[i].replaceAll(regexNote, "$1");
            clearedNote = clearedNote.replaceAll("([:;])\\s+(\\S)","$1\n$2");
            clearedNote = clearedNote.replaceAll("\\.\\s+(\\d+\\.)","\n$1");

            notes[i] = new SimpleItem(dataLines[i].replaceAll(regexCode, "$1$2$3"), clearedNote);
        }
    }

    public String[] getAllNotes() {
        String[] result = new String[notes.length];
        for(int i = 0; i < result.length; i++)
            result[i] = notes[i].get();
        return result;
    }
    public SimpleItem getNote(int index) {
        return notes[index];
    }


    public String getNote(String code) {
        //  Обрезать префикс если он длиннее кода в массиве элементов SimpleItem
        if(code.length() > this.notes[0].getCode().length())
            code = code.substring(0, this.notes[0].getCode().length());

        // Получить первую цифру из параметра prefix
        int actualIndex = Integer.parseInt(code.substring(0,1));

        // Сузить границы поиска
        int firstIndex = indexFirstOne[actualIndex];
        int lastIndex = indexLastOne[actualIndex];

        // Найти подходящие коды
        ArrayList<SimpleItem> totalFound = new ArrayList<>();
        for(int i = firstIndex; i <= lastIndex; i++ ){
            if(this.notes[i].getCode().startsWith(code))
                return (notes[i].getDescription());
        }
        return "";
    }
}
