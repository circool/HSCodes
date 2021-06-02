package ru.tsurkanenko.vladimir.hscodes;
/**
 * Массив товарных групп/позиций справочника ТНВЭД
 * @deprecated
 * @author Vladimir Tsurkanenko
 * @version 1.0
 * @see ru.tsurkanenko.vladimir.hscodes.HarmItem
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

