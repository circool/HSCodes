package ru.tsurkanenko.vladimir.hscodes;

/**
 * Массив элементов разделов/подразделов справочника ТНВЭД
 *
 * @author Vladimir Tsurkanenko
 * @version 1.0
 * @see ru.tsurkanenko.vladimir.hscodes.HarmGroup
 */
public class HarmGroupArray {
    private HarmGroup[] groupArray;
    private final String regexNote = "";

    /**
     * Создание нового раздела/подраздела.
     *
     * @param fileName имя файла, из которого нужно получить данные
     */
    public HarmGroupArray(String fileName) {
        String[] source = new RawLines(fileName).getRawData();
        groupArray = new HarmGroup[source.length];
        int i = 0;
        for (String singleLine: source){
            groupArray[i] = (new HarmGroup(singleLine));
            i++;
        }
    }

    /**
     * Возвращает массив элементов разделов/подразделов
     *
     * @return массив
     */
    public HarmGroup[] getGroupArray() {
        return groupArray;
    }

    /**
     * Возвращает отдельный элемент массива по его индексу
     *
     * @param index индекс элемента
     * @return отдельный элемент массива
     * @deprecated
     */
    public HarmGroup getGroup(int index){
        return this.groupArray[index];
    }

    /**
     * Возвращает отдельный элемент массива по его коду
     *
     * @param code код элемента
     * @return отдельный элемент массива
     */
    public HarmGroup getGroup(String code) {
        //TODO Написать логику метода
        return null;}

}