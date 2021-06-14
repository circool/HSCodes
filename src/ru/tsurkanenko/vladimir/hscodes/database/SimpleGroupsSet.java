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

    public String[] getAllNotes() {
        String[] result = new String[notes.length];
        for(int i = 0; i < result.length; i++)
            result[i] = notes[i].get();
        return result;
    }
    public SimpleItem getNote(int index) {
        return notes[index];
    }

    public String[] getNotesStartsWith(String prefix) {
        //  Обрезать префикс если он длиннее кода в массиве элементов SimpleItem
        if(prefix.length() > this.notes[0].getCode().length())
            prefix = prefix.substring(0, this.notes[0].getCode().length());

        // Получить первую цифру из параметра prefix
        int actualIndex = Integer.parseInt(prefix.substring(0,1));

        // Сузить границы поиска
        int firstIndex = indexFirstOne[actualIndex];
        int lastIndex = indexLastOne[actualIndex];

        // Найти подходящие коды
        ArrayList<SimpleItem> totalFound = new ArrayList<>();
        for(int i = firstIndex; i <= lastIndex; i++ ){
            if(this.notes[0].getCode().startsWith(prefix))
                totalFound.add(notes[i]);
        }
        // Вернуть результат в виде массива
        String[] result = new String[totalFound.size()];
        result = totalFound.toArray(result);
        return result;
    }
}
