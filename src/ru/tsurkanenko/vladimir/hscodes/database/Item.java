package ru.tsurkanenko.vladimir.hscodes.database;

/**
 * Объект инкапсулирующий данные о товарной позиции, субпозиции, подсубпозиции или полного кода ТНВЭД
 * @author Vladimir Tsurkanenko
 * @version 0.5
 * @since 0.5
 */
public class Item extends DictCommon implements Comparable<Item> {
    String code;
    int nestlingLevel;

    public int getNestlingLevel() {
        return nestlingLevel;
    }

    /**
     * Конструктор для создания объекта из строки с сырыми данными
     *
     * @param rawLine - строка с данными
     */
    public Item(String rawLine) {
        super(rawLine);
        code = rawLine.replaceAll("([\\d]{2})\\|([\\d]{2})\\|([\\d]{6}).*", "$1$2$3");
        String []splitArray = this.getNaim().split("\\-");
        nestlingLevel = splitArray.length - 1;
    }

    public String getFullCode() {
        return code;
    }
    public String getGruppaCode() {
        return code.substring(0,2);
    }
    public String getTovPosCode() {
        return code.substring(2,4);
    }
    public String toString() {
        return code + " " + getNaim();
    }

    @Override
    public int compareTo(Item o) {
        return this.code.compareTo(o.getFullCode());
    }


}
