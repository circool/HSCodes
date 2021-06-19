package ru.tsurkanenko.vladimir.deprecated;

/**
 * @author Vladimir Tsurkanenko
 * @version 1.0
 * Базовый справочника кодов ТНВЭД - отдельная группа
 *
 * @see HarmItem
 */
@Deprecated
public class HarmGroup extends HarmItem{
    private String note;

    /**
     * Конструктор, создающий из сырой строки отдельные элементы - описание, код и примечание
     *
     * @param rawData строка с сырыми данными
     */
    public HarmGroup(String rawData) {
        super(rawData);
        String regexNote = "^[0-9|]*.*?\\|(.*?)\\|.*$";
        this.note = rawData.replaceAll(regexNote,"$1");
        String regexFormattingReplace = "$1\n";
        String regexFormattingWhat = "([;:])";
        this.note = this.note.replaceAll(regexFormattingWhat, regexFormattingReplace);
    }

    /**
     * Метод возвращает строку с примечанием группы/раздела
     *
     * @return примечание
     */
    public String getNote() {
        return note;
    }
}
