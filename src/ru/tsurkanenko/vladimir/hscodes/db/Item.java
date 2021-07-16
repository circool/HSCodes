package ru.tsurkanenko.vladimir.hscodes.db;

import org.jetbrains.annotations.NotNull;

/**
 * Объект для хранения информации о отдельном элементе справочника (разделе, товарной группе итд)
 * @author Vladimir Tsurkanenko
 * @version 0.6.1
 * @since 0.6
 */
public class Item implements Operable {
    final private String code;
    final private String naim;
    final private String prim;
    final private int nestingLevel;

    public Item(String code, String naim, String prim) {
        this.code = code;
        this.naim = naim;
        this.prim = prim;
        this.nestingLevel = naim.split("-[  ]").length - 1;
    }

    /**
     * Возвращает код элемента
     * @return строковое представление кода
     */
    @Override
    public String getCode() {
        return this.code;
    }
    /**
     * Возвращает наименование элемента
     * @return строка с наименованием
     */
    @Override
    public String getNaim() {
        return naim;
    }

    /**
     * Возвращает примечание элемента
     * @return строка с примечанием или null
     */
    @Override
    public String getPrim() {
        return prim;
    }

    /**
     * Возвращает уровень вложенности элемента. У товарных позиций встречается до 10 уровней вложенности
     * Такие позиции в описании предваряются дефисом
     * @return 0 для разделов, групп или подгрупп и числовое значение для товарных позиций
     */
    @Override
    public int getNestingLevel() {
        return nestingLevel;
    }

    /**
     * Возвращает код и наименование элемента одной строкой
     * @return строка с кодом и наименованием через пробел
     */
    @Override
    public String toString() {
        return code + " " + naim;
    }

    /**
     * Сравнивает текущий элемент с аргументом руководствуясь положением элементов в справочнике
     * @return отрицательный, нулевой или положительный результат
     */
    @Override
    public int compareTo(@NotNull Operable o) {
        if(this.getCode().equals(o.getCode()))
            return nestingLevel - o.getNestingLevel();
        return this.getCode().compareTo(o.getCode());
    }
}
