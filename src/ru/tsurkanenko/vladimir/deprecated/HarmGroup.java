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
    final private String regexNote = "^[0-9\\|]*.*?\\|(.*?)\\|.*$";
    final private String regexFormattingWhat = "([;:])";
    final private String regexFormattingReplace = "$1\n";

    /**
     * Конструктор, создающий из сырой строки отдельные элементы - описание, код и примечание
     *
     * @param rawData строка с сырыми данными
     */
    public HarmGroup(String rawData) {
        super(rawData);
        this.note = rawData.replaceAll(regexNote,"$1");
        this.note = this.note.replaceAll(regexFormattingWhat,regexFormattingReplace);
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
