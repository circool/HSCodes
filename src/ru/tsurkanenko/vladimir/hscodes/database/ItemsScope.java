package ru.tsurkanenko.vladimir.hscodes.database;

import java.util.*;


/*
2 первые цифры – товарная группа ТН ВЭД:    (84 - Реакторы ядерные, котлы, оборудование и механические устройства; их части);
4 первые цифры – товарная позиция ТН ВЭД:   (8458 - Станки токарные (включая станки токарные многоцелевые) металлорежущие);
6 первых цифр – субпозиция ТН ВЭД:          (845811 - С числовым программным управлением);
8 первых цифр – подсубпозиция ТН ВЭД:       (84581141 - Одношпиндельные);
10 цифр, полный код товара – подсубпозиция ТН ВЭД:
 */

/**
 * Объект инкапсулирующий данные всех товарних позициях, субпозициях, подсубпозициях или полных кодах ТНВЭД
 * Предназначен для формирования списков кодов с учетом их вложенности
 * @author Vladimir Tsurkanenko
 * @version 0.5
 * @since 0.5
 */
public class ItemsScope {
    private final Item[] scope;
    private final int[][] codeIndex = {{-1, -1 , -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1 , -1, -1, -1, -1, -1, -1, -1, -1}};
    public ItemsScope() {
        String[] rawLines = new RawLines("dic/TNVED4.TXT").getActualData();
        String[] addLines = new RawLines("dic/TNVED4.ADD.TXT").getActualData();

        ArrayList<Item> result = new ArrayList<>();
        for (String rawLine : rawLines) {
            result.add(new Item(rawLine));
        }
        for (String rawLine : addLines) {
            result.add(new Item(rawLine));
        }
        result.sort(Comparator.comparing(Item::getFullCode));
        scope = result.toArray(new Item[0]);
        // Составление карты индексов для первой цифры
        for (int i = 0; i< scope.length;i++) {
            int firstChar = Integer.parseInt(scope[i].getGruppaCode().substring(0,1));
            if(codeIndex[0][firstChar] < 0)
                codeIndex[0][firstChar] = i;
            codeIndex[1][firstChar] = i;
        }
    }
    public Item getItem(String code) {
        try{
            this.firstIndexOf(code);
            this.lastIndexOf(code);
        }
        catch (Exception e){
            return new Item("");
        }
        for (int i=firstIndexOf(code); i < lastIndexOf(code); i++)
            if (scope[i].toString().startsWith(code))
                return scope[i];
        return new Item("");
    }

    public Item getItem(int index) {
        return scope[index];
    }

    /**
     * Возвращает массив элементов Item, начинающихся на определенный код
     * @param str Строка, на которую должен начинаться код
     * @return Массив элементов начинающихся на параметр str
     */
    public Item[] startsWith(String str){
        try{
            this.firstIndexOf(str);
            this.lastIndexOf(str);
        }
        catch (Exception e){
            return new Item[0];
        }
        ArrayList<Item> result = new ArrayList<>();
        for (int i = this.firstIndexOf(str); i < this.lastIndexOf(str); i++) {
            if (scope[i].toString().startsWith(str))
                result.add(scope[i]);
        }
        return result.toArray(new Item[0]);
    }

    private int lastIndexOf(String s){
        return codeIndex[1][Integer.parseInt(s.substring(0,1))];
    }

    private int firstIndexOf(String s){
        return codeIndex[0][Integer.parseInt(s.substring(0,1))];
    }

}


