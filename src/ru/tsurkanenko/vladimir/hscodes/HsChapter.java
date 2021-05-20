package ru.tsurkanenko.vladimir.hscodes;

import java.util.ArrayList;

/**
 * @version 0.1
 * @author Vladimir Tsurkanenko
 * Объект инкапсулирует информацию о разделе, группе или подгруппе ТНВЭД и номерах относящмхся к ним подразделов
 */
public class HsChapter {
    /**
     * Массивы для хранения информации о разделах и относящихся к ним подразделам
     */
    private final String[] chapterDescription = new String[22];
    private final int[] chaptersBegin = new int[22];
    private final int[] chaptersEnd = new int[22];
    /**
     * В переменной total содержится индекс последней записи
     */
    private final int total;

    /**
     * Конструктор экземпляра класса
     * @param fileName Имя файла, в котором содержится информация о разделах и принадлежажих к ним подразделов
     */
    public HsChapter(String fileName) {
        ArrayList<String> source = new FileToArrayList(fileName).getArrayList();
        int i = 0;
        for(String singleLine:source){
            chaptersBegin[i] = Integer.parseInt(singleLine.substring(0, 2));
            chaptersEnd[i] = Integer.parseInt(singleLine.substring(3, 5));
            chapterDescription[i] = singleLine.substring(6);
            i++;
        }
        total = i;
    }

    /**
     * Возвращает номер первого входящего в раздел подраздела
     * @param index Номер раздела, для которого требуется получить справку
     * @return Числовой номер первого подраздела, относящегося к разделу index
     */
    public int getBegin(int index){
        index--;
        if(index <= total && index >= 0)
            return chaptersBegin[index];
        return -1;
    }

    /**
     * Возвращает номер последнего входящего в раздел подраздела
     * @param index Номер раздела, для которого требуется получить справку
     * @return Числовой номер последнего подраздела, относящегося к разделу index
     */
    public int getEnd(int index){
        index--;
        if(index <= total && index >= 0)
            return chaptersEnd[index];
        return -1;
    }

    /**
     * Возвращает описание раздела
     * @param index порядковый номер раздела
     * @return Текстовое описание раздела
     */
    public String getDescription(int index){
        index--;
        if(index <= total && index >= 0)
            return chapterDescription[index];
        return "";
    }

    /**
     * Возвражает общее количество разделов
     * @return Количество разделов
     */
    public int maxIndex(){
        return total;
    }
}
