package ru.tsurkanenko.vladimir.hscodes.database.v52;

/**
 * Объект инкапсулирующий данные о товарной позиции, субпозиции, подсубпозиции или полного кода ТНВЭД
 * @author Vladimir Tsurkanenko
 * @version 0.5.2
 * @since 0.5
 */
public class Items extends Common {
    final private int nestlingLevel;

    /**
     * Конструктор для создания объекта из строки с сырыми данными
     * @param rawLine - строка с данными
     */
    public Items(String rawLine) {
        super(rawLine);
        String []splitArray = this.toString().split("-");
        nestlingLevel = splitArray.length - 1;
    }

    public int getNestlingLevel() {
        return nestlingLevel;
    }
}
