package ru.tsurkanenko.vladimir.deprecated;
/**
 * Массив товарных групп/позиций справочника ТНВЭД
 * @deprecated
 * @author Vladimir Tsurkanenko
 * @version 1.0
 * @see HarmItem
 */

public class HarmItemArray extends HarmArray {

    /**
     * Создание новой товарной группы/позиции.
     *
     * @param fileName имя файла, из которого нужно получить данные
     */
    public HarmItemArray(String fileName) {
        super(fileName);
    }

}

