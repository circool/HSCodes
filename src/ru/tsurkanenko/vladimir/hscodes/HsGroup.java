package ru.tsurkanenko.vladimir.hscodes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @version 0.1
 * @author Vladimir Tsurkanenko
 * Объект инкапсулирующий данные о разделах, группах или подгруппах:
 * описание раздела и диапазон его подразделов
 */
public class HsGroup {
    /**
     * Массивы с данными о разделах, группах или подгруппах
     */
    String[] description;
    int[] firstChild;
    int[] lastChild;
    /**
     * Переменная для хранения размера массива
     */
    int arraySize;
    /**
     * Уровень вложенности раздела, группы или подгруппы
     */
    int nestingLevel;

    /**
     * Конструктор создает объект из файла
     * @param fileName Имя исходного файла
     */
    public HsGroup(String fileName) throws IOException {
        if(FileCheck.isExist(fileName)){
            arraySize = FileCheck.getSize(fileName);
            description = new String[arraySize];
            firstChild = new int[arraySize];
            lastChild = new int[arraySize];
            String singleLine;
            BufferedReader sourceFile =
                    new BufferedReader(new FileReader(fileName));
            int index = 0;
            while ((singleLine = sourceFile.readLine()) != null){
                if(!singleLine.matches("(#|/).*") ){
                    if(singleLine.length() > 6){
                        firstChild[index] = Integer.parseInt(singleLine.substring(0, 2));
                        lastChild[index] = Integer.parseInt(singleLine.substring(3, 5));
                        description[index] = singleLine.substring(6);
                    } else {
                        firstChild[index] = 0;
                        lastChild[index] = 0;
                        description[index] = "";
                    }
                    index++;
                }
            }
            /*
            for(int i=0; i < arraySize; i++){
                singleLine = sourceFile.readLine();
                if((singleLine.length() > 6) & !singleLine.startsWith("#")){
                    firstChild[i] = Integer.parseInt(singleLine.substring(0, 2));
                    lastChild[i] = Integer.parseInt(singleLine.substring(3, 5));
                    description[i] = singleLine.substring(6);
                } else {
                    firstChild[i] = 0;
                    lastChild[i] = 0;
                    description[i] = "";
                }
            }*/
        } else System.err.println("File " + fileName + " not found.");
    }

    /**
     * Конструктор позволяющий установиить уровень вложенности при создании объекта
     * @param fileName Имя файла из которого нужно читать данные
     * @param nestingLevel Уровень вложенности группы
     */
    public HsGroup(String fileName, int nestingLevel) throws IOException {
        this(fileName);
        this.nestingLevel = nestingLevel;
    }

    /**
     * Возвращает уровень вложенности
     * @return Уровень вложенности
     */
    public int getNestingLevel() {
        return nestingLevel;
    }
    /**
     * Позволяет установить уровень вложенности
     */
    public void setNestingLevel(int nestingLevel) {
        this.nestingLevel = nestingLevel;
    }

    /**
     * Возвращает весь массив с описаниями разделов, групп или подгрупп
     * @return Массив с описаниями разделов, групп или подгрупп
     */
    public String[] getDescription() {
        return description;
    }

    /**
     * Возвращает массив с описаниями в диапазоне от первого аргумента до второго
     * @param first Начальная позиция диаразона
     * @param last Конечная позиция диапазона
     * @return Масссив заполненый значениями
     */
    public String[] getScope(int first, int last){
        String[] scope = new String[last - first+1];
        for(int i=0; i <= (last - first); i++)
            scope[i] = this.getDescription(i+first-1);
        return scope;
    }

    /**
     * Возвращает описание (наименование) запрошенного раздела
     * @param index Номер запрашиваемого раздела
     * @return Текстовое описание
     */
    public String getDescription(int index) {
        return description[index];
    }

    /**
     * Возвращает номер первого подраздела запрошенного раздела
     * @param index Номер запрашиваемого раздела
     * @return Номер подраздела
     */
    public int getFirstChild(int index) {
        return firstChild[index];
    }
    /**
     * Возвращает номер последнего подраздела запрошенного раздела
     * @param index Номер запрашиваемого раздела
     * @return Номер подраздела
     */
    public int getLastChild(int index) {
        return lastChild[index];
    }
    /**
     * Возвращает размер массива данных
     * @return Размер массива
     */
    public int getSize(){
        return arraySize;
    }
}
