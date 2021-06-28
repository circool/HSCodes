package ru.tsurkanenko.vladimir.hscodes.v50.database;

/**
 * Объект инкапсулирующий данные о товарной позиции, субпозиции, подсубпозиции или полного кода ТНВЭД
 * @author Vladimir Tsurkanenko
 * @version 0.5
 * @since 0.5
 */
public class Items extends DictCommon implements DictItemsInterface {
    final private int nestlingLevel;

    public Items(){
        super();
        nestlingLevel = -1;
    }
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
