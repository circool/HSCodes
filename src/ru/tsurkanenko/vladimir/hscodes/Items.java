package ru.tsurkanenko.vladimir.hscodes;


/**
 * Объект инкапсулирующий данные о товарной позиции, субпозиции, подсубпозиции или полного кода ТНВЭД
 * @author Vladimir Tsurkanenko
 * @version 0.5.2
 * @since 0.5
 */
public class Items extends Common implements Comparable<CommonCompatible> {
    final private int nestlingLevel;

    /**
     * Конструктор для создания объекта из строки с сырыми данными
     * @param rawLine - строка с данными
     */
    Items(String rawLine) {
        super(rawLine);
        nestlingLevel = this.toString().split("-[  ]").length - 1;
    }

    public int getNestlingLevel() {
        return nestlingLevel;
    }



}
