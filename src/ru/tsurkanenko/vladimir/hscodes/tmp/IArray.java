package ru.tsurkanenko.vladimir.hscodes.tmp;


import ru.tsurkanenko.vladimir.hscodes.RawLines;

import java.util.ArrayList;

public class IArray {
    SimpleItem[] simpleItems;
    String[] dataLines;
    final int[] indexFirstOne = new int[10];
    final int[] indexLastOne= new int[10];


    public IArray(String fileName) {
        dataLines = new RawLines(fileName).getRawData();
        String regexCode = "^([0-9]+)\\|([0-9]*)\\|*([0-9]*)\\|*.*$";
        String regexDescription = "^[0-9|]+(.*?)\\|.*";
        String regexNote = "^[0-9\\|]*.*?\\|(.*?)\\|.*$";
        simpleItems = new SimpleItem[dataLines.length];
        String currentCode,currentDescription,firstOneLetter;
        for(int i = 0; i< simpleItems.length; i++){
            currentCode = dataLines[i].replaceAll(regexCode,"$1$2$3");
            currentDescription = dataLines[i].replaceAll(regexDescription,"$1");
            simpleItems[i] = new SimpleItem(currentCode,currentDescription);
            // Индексация
            firstOneLetter = currentCode.substring(0,1);
            int curr = Integer.parseInt(firstOneLetter);
            if(curr > 0 && indexFirstOne[curr] == 0)
                indexFirstOne[curr] = i;
            indexLastOne[curr] = i;
        }
    }
    public SimpleItem[] getItems() {
        return simpleItems;
    }

    public SimpleItem[] startsWith(String prefix) {
        // Подготовить массив для результатов
        ArrayList<SimpleItem> totalFound = new ArrayList<SimpleItem>();
        //  Обрезать префикс если он длиннее кода в массиве элементов SimpleItem
        if(prefix.length() > simpleItems[0].code.length())
            prefix = prefix.substring(0, simpleItems[0].code.length());
        // Получить первую цифру из параметра prefix
        int actualIndex = Integer.parseInt(prefix.substring(0,1));
        // Сузить границы поиска
        int firstIndex = indexFirstOne[actualIndex];
        int lastIndex = indexLastOne[actualIndex];
        // Найти подходящие коды
        for(int i = firstIndex; i <= lastIndex; i++ ){
            if(simpleItems[i].code.substring(0, prefix.length()).equals(prefix))
                totalFound.add(simpleItems[i]);
        }
        // Вернуть результат в виде массива
        SimpleItem result[] = new SimpleItem[totalFound.size()];
        result = totalFound.toArray(result);
        return result;
    }
}
