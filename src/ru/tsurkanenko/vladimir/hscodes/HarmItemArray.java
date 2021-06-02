package ru.tsurkanenko.vladimir.hscodes;
/**
 * Массив товарных групп/позиций справочника ТНВЭД
 *
 * @author Vladimir Tsurkanenko
 * @version 1.0
 * @see ru.tsurkanenko.vladimir.hscodes.HarmItem
 */
public class HarmItemArray {
    private HarmItem[] itemArray;

    /**
     * Создание новой товарной группы/позиции.
     *
     * @param fileName имя файла, из которого нужно получить данные
     */
    public HarmItemArray(String fileName) {
        String[] rawData = new RawLines(fileName).getRawData();
        itemArray = new HarmItem[rawData.length];
        int i = 0;
        for (String singleLine: rawData){
            itemArray[i] = (new HarmItem(singleLine));
            i++;
        }
    }
    /**
     * Возвращает массив элементов товарных групп/позиций
     *
     * @return массив
     */
    public HarmItem[] getItemArray() {
        return itemArray;
    }

    /**
     * Возвращает отдельный элемент массива по его индексу
     *
     * @param index индекс элемента
     * @return отдельный элемент массива
     * @deprecated
     */
    public HarmItem getItem(int index){
        return this.itemArray[index];
    }

    /**
     * Возвращает отдельный элемент массива по его коду
     *
     * @param code код элемента
     * @return отдельный элемент массива
     */
    public HarmItem getItem(String code) {
        //TODO Написать логику метода
        return null;}
}
