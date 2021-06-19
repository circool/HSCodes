package ru.tsurkanenko.vladimir.deprecated;

import ru.tsurkanenko.vladimir.hscodes.RawLines;

/**
 * Массив элементов разделов/подразделов справочника ТНВЭД
 *
 * @author Vladimir Tsurkanenko
 * @version 1.0
 * @see HarmGroup
 */
@Deprecated
public class HarmGroupArray extends HarmArray {
    private final String[] notes;

    /**
     * Создание нового раздела/подраздела.
     *
     * @param fileName имя файла, из которого нужно получить данные
     */
    public HarmGroupArray(String fileName) {
        super(fileName);
        notes = new String[itemsArray.length];
        String[] rawData = new RawLines(fileName).getRawData();

        int i = 0;
        for (String singleLine: rawData){
            itemsArray[i] = (new HarmItem(singleLine));
            i++;
        }
        //TODO Заполнить массив примечаниями
    }
    public String getNote(String code){
        return notes[this.getFirstIndex(code)];
    }
}
