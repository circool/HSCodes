package ru.tsurkanenko.vladimir.hscodes;

/**
 * Массив элементов разделов/подразделов справочника ТНВЭД
 *
 * @author Vladimir Tsurkanenko
 * @version 1.0
 * @see ru.tsurkanenko.vladimir.hscodes.HarmGroup
 */
public class HarmGroupArray extends HarmArray {
    private String[] notes;
    //private final String regexNote = "";

    /**
     * Создание нового раздела/подраздела.
     *
     * @param fileName имя файла, из которого нужно получить данные
     */
    public HarmGroupArray(String fileName) {
        super(fileName);
        notes = new String[itemsArray.length];
        //TODO Заполнить массив примечаниями
    }
    public String getNote(String code){
        return notes[this.getFirstIndex(code)];
    }
}
