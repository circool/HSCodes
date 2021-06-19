package ru.tsurkanenko.vladimir.hscodes.database;

import ru.tsurkanenko.vladimir.hscodes.RawLines;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Коллекция элементов справочника организованная в виде массива
 *  @author Vladimir Tsurkanenko
 *  @version 0.4
 */
public class SimplePositionSet {
    private final SimpleItem[] items;
    final int[] indexFirstOne = new int[10];
    final int[] indexLastOne= new int[10];

    public SimplePositionSet(String fileNameGroups, String fileNameItems) {
        ArrayList<SimpleItem> group  = new ArrayList<>();

        String[] dataLines = new RawLines(fileNameGroups).getRawData();
        for (String line : dataLines) {
            group.add(new SimpleItem(line));
        }
        dataLines = new RawLines(fileNameItems).getRawData();
        for (String dataLine : dataLines) {
            //Boolean x = dataLine.substring(6).startsWith("000000");
            if (dataLine.substring(6).startsWith("000000"))
                group.add(new SimpleItem(dataLine.replaceAll("^([0-9]+)\\|([0-9]*)\\|*([0-9]*)\\|*.*$",
                        "$1$2$3").substring(0, 4), dataLine.replaceAll("^[0-9|]+(.*?)\\|.*", "$1")
                ));
        }
        Collections.sort(group);
        items = group.toArray(new SimpleItem[0]);
        // Индексация
        for(int i=0; i<items.length;i++){
            String firstOneLetter = items[i].getCode().substring(0,1);
            int curr = Integer.parseInt(firstOneLetter);
            if(curr > 0 && indexFirstOne[curr] == 0)
                indexFirstOne[curr] = i;
            indexLastOne[curr] = i;
        }

    }

    public String[] getAllItems() {
        String[] result = new String[items.length];
        for(int i = 0; i < result.length; i++)
            result[i] = items[i].get();
        return result;
    }

    @Deprecated
    public String getItem(int index) {
        return items[index].getCode() + " " + items[index].getDescription();
    }

    public String[] getItemsStartsWith(String prefix) {
        //  Обрезать префикс если он длиннее кода в массиве элементов SimpleItem
        if(prefix.length() > this.items[0].getCode().length())
            prefix = prefix.substring(0, this.items[0].getCode().length());

        // Получить первую цифру из параметра prefix
        int actualIndex = Integer.parseInt(prefix.substring(0,1));

        // Сузить границы поиска
        int firstIndex = indexFirstOne[actualIndex];
        int lastIndex = indexLastOne[actualIndex];

        // Найти подходящие коды
        ArrayList<String> totalFound = new ArrayList<>();
        for(int i = firstIndex; i <= lastIndex; i++ ){
            if(this.items[i].getCode().startsWith(prefix))
                totalFound.add(items[i].get());
        }
        // Вернуть результат в виде массива
        String[] result = new String[totalFound.size()];
        result = totalFound.toArray(result);
        return result;
    }

}
