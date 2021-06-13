package ru.tsurkanenko.vladimir.hscodes.tmp;

import ru.tsurkanenko.vladimir.hscodes.RawLines;

import java.util.ArrayList;

public class SimpleItemsSet {
    private SimpleItem items[];
    final int[] indexFirstOne = new int[10];
    final int[] indexLastOne= new int[10];

    public SimpleItemsSet(String fileName) {
        String[] dataLines = new RawLines(fileName).getRawData();
        items = new SimpleItem[dataLines.length];
        for (int i = 0; i < items.length; i++) {
            items[i] = new SimpleItem(dataLines[i]);
            // Индексация
            String firstOneLetter = items[i].getCode().substring(0,1);
            int curr = Integer.parseInt(firstOneLetter);
            if(curr > 0 && indexFirstOne[curr] == 0)
                indexFirstOne[curr] = i;
            indexLastOne[curr] = i;
        }
    }

    public SimpleItem[] getAllItems() {
        return items;
    }

    public SimpleItem[] getItemsStartsWith(String prefix) {
        //  Обрезать префикс если он длиннее кода в массиве элементов SimpleItem
        if(prefix.length() > items[0].code.length())
            prefix = prefix.substring(0, items[0].code.length());

        // Получить первую цифру из параметра prefix
        int actualIndex = Integer.parseInt(prefix.substring(0,1));

        // Сузить границы поиска
        int firstIndex = indexFirstOne[actualIndex];
        int lastIndex = indexLastOne[actualIndex];

        // Найти подходящие коды
        ArrayList<SimpleItem> totalFound = new ArrayList<SimpleItem>();
        for(int i = firstIndex; i <= lastIndex; i++ ){
            if(items[i].code.substring(0, prefix.length()).equals(prefix))
                totalFound.add(items[i]);
        }
        // Вернуть результат в виде массива
        SimpleItem result[] = new SimpleItem[totalFound.size()];
        result = totalFound.toArray(result);
        return result;
    }

}
