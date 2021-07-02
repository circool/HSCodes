package ru.tsurkanenko.vladimir.hscodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Массив для товарных позиций, субпозиций и подсубпозиций
 * @author Vladimir Tsurkanenko
 * @version 0.5.3
 * @since 0.5.1
 */
public class ScopeItems extends ScopeCommon<Items> {

    /**
     * Создает новый массив объектов Items из файла
     * @param fileName Имя файла с данными
     */
    public ScopeItems(String fileName) {
        super();
        searchResult = new Items[0];
        String[] rawLines = new RawLines(fileName).get();
        scope = new Items[rawLines.length];
        for (int i = 0; i < scope.length; i++) {
            scope[i] = new Items(rawLines[i]);
        }
        makeScopeIndex();
    }

    /**
     * Добавляет в массив данные из файла
     * @param fileName Имя файла с данными
     */
    public void add(String fileName){
        ArrayList<Items> result = new ArrayList<>(Arrays.asList(scope));
        String[] rawLines = new RawLines(fileName).get();
        for (String currNew:rawLines
        ) {
            result.add(new Items(currNew));
        }
        // Стандартная сортировка списка
        Collections.sort(result);
        // Дополнительная сортировка списка с учетом уровней вложенности для одинаковых кодов
        result.sort((o1, o2) -> {
            if (o1.getCode().equals(o2.getCode())) {
                return o1.getNestlingLevel() - o2.getNestlingLevel();
            } else
                return o1.compareTo(o2);
        });
        scope = new Items[result.size()];
        scope = result.toArray(new Items[0]);
        makeScopeIndex();
    }

    /**
     * Возвращает массив элементов заданного уровня вложенности
     * @param str Символы, с которых должны начинаться возвращаемые элементы
     * @param nestingLevel уровень вложенности возвращаемых элементов
     * @return Массив элементов
     * @since 0.5.3
     */
    @Deprecated
    //  Исключается ввиду наличия метода getChild
    public Items[] startsWith(String str, int nestingLevel) {
        ArrayList<Items> result = new ArrayList<>();
        for (int i = this.firstIndexOf(str); i <= this.lastIndexOf(str); i++) {
            if (scope[i].toString().startsWith(str) & scope[i].getNestlingLevel() == nestingLevel)
                result.add(scope[i]);
        }
        return result.toArray(searchResult);
    }

    /**
     * Возвращает индекс элемента в массиве
     * @param parent Искомый элемент
     * @return индекс элемента
     * @since 0.5.3
     */
    int getIndex(Items parent){
        for (int i = 0; i < scope.length; i++) {
            if(scope[i].compareTo(parent)==0)
                return i;
        }
        return -1;
    }

    /**
     * Возвращает массив элементов являющихся для искомого элемента дочерними
     * @param parent Искомый элемент
     * @return массив дочерних элементов
     * @since 0.5.3
     */
    public Items[] getChild(Items parent){
        int parentNesting = parent.getNestlingLevel();
        ArrayList<Items> result = new ArrayList<>();
        int startIndex = this.getIndex(parent);


        if (scope.length <= startIndex+1)
                return new Items[0];
        while (scope[startIndex+1].getNestlingLevel() > parentNesting) {
            startIndex++;
            if(scope[startIndex].getNestlingLevel() <= parent.getNestlingLevel() || !scope[startIndex].getCode().substring(0, 4).equals(parent.getCode().substring(0, 4)))
                break;
            if (scope[startIndex].getNestlingLevel() == parent.getNestlingLevel()+1)
                result.add(scope[startIndex]);
        }
        return result.toArray(searchResult);
    }
}
