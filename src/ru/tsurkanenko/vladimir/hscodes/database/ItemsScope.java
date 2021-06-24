package ru.tsurkanenko.vladimir.hscodes.database;

import java.util.*;

/**
 * Объект инкапсулирующий данные всех товарних позициях, субпозициях, подсубпозициях или полных кодах ТНВЭД
 * Предназначен для формирования списков кодов с учетом их вложенности
 * @author Vladimir Tsurkanenko
 * @version 0.5
 * @since 0.5
 */

/*
2 первые цифры – товарная группа ТН ВЭД:    (84 - Реакторы ядерные, котлы, оборудование и механические устройства; их части);
4 первые цифры – товарная позиция ТН ВЭД:   (8458 - Станки токарные (включая станки токарные многоцелевые) металлорежущие);
6 первых цифр – субпозиция ТН ВЭД:          (845811 - С числовым программным управлением);
8 первых цифр – подсубпозиция ТН ВЭД:       (84581141 - Одношпиндельные);
10 цифр, полный код товара – подсубпозиция ТН ВЭД:
 */

public class ItemsScope {
    Item[] scope;
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
    }
    public Item[] getAll() {
        return scope;
    }

}


