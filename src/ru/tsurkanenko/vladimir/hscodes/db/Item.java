/*
 * MIT License
 *
 * Copyright (c) 2021 Vladimir Tsurkanenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package ru.tsurkanenko.vladimir.hscodes.db;

import org.jetbrains.annotations.NotNull;

/**
 * Объект для хранения информации о отдельном элементе справочника (разделе, товарной группе итд)
 * @author Vladimir Tsurkanenko
 * @version 0.6
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
    public int compareTo(@NotNull Item o) {
        if(this.getCode().equals(o.getCode()))
            return nestingLevel - o.getNestingLevel();
        return this.getCode().compareTo(o.getCode());
    }
}
