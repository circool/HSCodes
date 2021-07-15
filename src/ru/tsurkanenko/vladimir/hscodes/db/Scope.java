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

import ru.tsurkanenko.vladimir.hscodes.io.FileToArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Массив элементов справочника реализующий необходимые инструменты для работы с элементами
 * Предназначен для формирования разделов, групп, товарных позиций
 * @version 0.6
 * @since 0.6
 * @author Vladimir Tsurkanenko
 */
public class Scope {
    Item[] items;
    final private int[] codeIndex = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    public Scope(String fileName) {
        String[] rawLines = FileToArray.get(fileName);
        String regexMatch = "^([0-9]+)\\|*([0-9]*)\\|*([0-9 ]*)\\|(.+?)\\|(.*?)\\|*([0-9.]+)\\|\\|$";
        ArrayList<Item> result = new ArrayList<>();
        for (String singleLine:rawLines
        ) {
            if(singleLine.matches(regexMatch))
                result.add(
                    new Item(
                            singleLine.replaceAll(regexMatch, "$1$2$3"),
                            singleLine.replaceAll(regexMatch, "$4"),
                            singleLine.replaceAll(regexMatch, "$5")
                    )
            );
        }
        items = result.toArray(new Item[0]);
        rebuildIndexes();
    }

    /**
     * Добавляет в массив данные из файла
     * @param fileName файл из которого следует добавить данные
     */
    public void add(String fileName){
        ArrayList<Item> result = new ArrayList<>(Arrays.asList(items));
        Scope newScope = new Scope(fileName);
        result.addAll(Arrays.asList(newScope.get()));
        Collections.sort(result);
        items = result.toArray(new Item[0]);
        rebuildIndexes();
    }

    /**
     * Возвращает весь массив
     * @return массив элементов
     */
    public Item[] get() {
        return items;
    }

    /**
     * Предназначен для поиска подчиненных элементов.
     * Ищет в своем массиве items элементы, которые являются дочерними для элемента, переданного в качестве аргумента
     * @param parent Элемент, для которого нужно найти дочерние элементы
     * @return массив элементов класса Item
     *
     */
    public Item[] getChildren(Item parent){
        // заносим в переменные часто используемые константы
        String parentCode = parent.getCode();
        int parentNestingLevel = parent.getNestingLevel();
        ArrayList<Item> result = new ArrayList<>();
        // возможное начало области поиска
        int startInd = getFirstIndexOf(String.valueOf(parent.getCode().charAt(0)));
        // определить конец области поиска
        int lastInd = items.length - 1;

        //ищем первое вхождение. Для всех вариантов это либо сам parent, либо его подгруппы
        while(!items[startInd].getCode().startsWith(parentCode)) {
            startInd++;
        }
        if(parentNestingLevel==0){
            // для групп
            while(lastInd >= startInd && items[startInd].getCode().startsWith(parentCode)) {
                if(items[startInd].getNestingLevel() - parentNestingLevel <= 1)
                    result.add(items[startInd]);
                startInd++;
            }
        } else {
            // для элементов
            startInd++;
            while (items[startInd].getNestingLevel() > parentNestingLevel){
                if(items[startInd].getNestingLevel() - parentNestingLevel == 1)
                    result.add(items[startInd]);
                startInd++;
            }
        }
        return result.toArray(new Item[0]);
    }

    /**
     * Индексирует массив по первому символу сохраняя первый индекс для каждой цифры
     */
    private void rebuildIndexes(){
        for (int i = 0; i < items.length; i++) {
            int firstChar = Integer.parseInt(items[i].toString().substring(0, 1));
            if (codeIndex[firstChar] < 0)
                codeIndex[firstChar] = i;
        }
    }

    /**
     * Возвращает индекс массива, с которого идут элементы с кодом, начинающимся на первую цифру из строки аргумента
     * @param s строка, по первой цифре которого ведется поиск
     * @return индекс первого элемента или -1 если элемент не найден
     */
    private int getFirstIndexOf(String s) {
        if(s.matches("^[0-9].*"))
            return codeIndex[Integer.parseInt(s.substring(0, 1))];
        return -1;
    }
}
