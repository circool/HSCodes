package ru.tsurkanenko.vladimir.hscodes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @version 0.1
 * @author Vladimir Tsurkanenko
 * Объект инкапсулирующий данные о разделах, группах или подгруппах:
 * описание раздела и диапазон его подразделов
 */
public class HsArray {
    String[] description;
    int[] firstChild;
    int[] lastChild;
    int arraySize;

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
    public int getSize(){
        return arraySize;
    }

    /**
     * Конструктор создает объект из файла
     * @param fileName Имя исходного файла
     */
    public HsArray(String fileName) throws IOException {
        if(FileCheck.isExist(fileName)){
            arraySize = FileCheck.getSize(fileName);
            description = new String[arraySize];
            firstChild = new int[arraySize];
            lastChild = new int[arraySize];
            String singleLine;
                BufferedReader sourceFile =
                        new BufferedReader(new FileReader(fileName));
            for(int i=0; i < arraySize; i++){
                singleLine = sourceFile.readLine();
                if(singleLine.length() > 6){
                    firstChild[i] = Integer.parseInt(singleLine.substring(0, 2));
                    lastChild[i] = Integer.parseInt(singleLine.substring(3, 5));
                    description[i] = singleLine.substring(6);
                } else {
                    firstChild[i] = 0;
                    lastChild[i] = 0;
                    description[i] = "";
                }
            }
        } else System.err.println("File " + fileName + " not found.");
    }
}
