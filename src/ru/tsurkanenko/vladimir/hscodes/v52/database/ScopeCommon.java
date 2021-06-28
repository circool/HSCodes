package ru.tsurkanenko.vladimir.hscodes.v52.database;

import java.util.ArrayList;

/**
 * Класс инкапсулирующий параметры, общие для всех массивов элементов справочника
 * @author Vladimir Tsurkanenko
 * @version 0.5.2
 * @since 0.5.1
 */

public abstract class ScopeCommon<T> implements ScopeCommonCompatible<T> {
    T[] scope;
    T[] searchResult;
    final private int[][] codeIndex = {{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};

    @Override
    public T[] get() {
        return scope;
    }

    @Override
    public T[] startsWith(String str) {
        ArrayList<T> result;
        result = new ArrayList<>();
        for (int i = this.firstIndexOf(str); i <= this.lastIndexOf(str); i++) {
            if (scope[i].toString().startsWith(str))
                result.add(scope[i]);
        }
        return result.toArray(searchResult);
    }

    @Override
    public int lastIndexOf(String s) {
        return codeIndex[1][Integer.parseInt(s.substring(0, 1))];
    }

    @Override
    public int firstIndexOf(String s) {
        return codeIndex[0][Integer.parseInt(s.substring(0, 1))];
    }

    /**
     * Создает начальные и конечные индексы для элементов массива и заносит их
     * в массив codeIndex[][].
     */
    @Override
    public void makeScopeIndex() {
        for (int i = 0; i < scope.length; i++) {
            int firstChar = Integer.parseInt(scope[i].toString().substring(0, 1));
            if (codeIndex[0][firstChar] < 0)
                codeIndex[0][firstChar] = i;
            codeIndex[1][firstChar] = i;
        }
    }
}
