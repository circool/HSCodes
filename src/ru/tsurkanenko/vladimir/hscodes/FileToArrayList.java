package ru.tsurkanenko.vladimir.hscodes;

import java.io.*;
import java.util.ArrayList;
/**
 * @version 0.1
 * @author Vladimir Tsurkanenko
 * Читает строки из файла и заносит их в список AttayList
 */
public class FileToArrayList {
    private final ArrayList<String> arrayList;
    /**
     * Конструктор создает ArrayList, читая строки из файла, определенного параметром fileName
     * @param fileName Имя файла для чтения
     */
    public FileToArrayList(String fileName) {
        arrayList = new ArrayList<>();
        String topic;
        try (BufferedReader sourceFile =
                     new BufferedReader(new FileReader(fileName))) {
            while ((topic = sourceFile.readLine()) != null)
                arrayList.add(topic);
        } catch (IOException exception) {
            //TODO В случае отсутствия файла необходимо обеспечить его скачивание из интернета
            System.out.println("Ошибка чтения файла " + fileName);
            System.out.println("Попытка загрузить исходный файл");
        }
    }
    /**
     * Возвращает весь список
     * @return Массив со всеми строками
     */
    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    /**
     * Возврашает элемент списка
     * @param arg индекс возвращаемого элемента
     * @return элемент списка
     */
    public String getTopic(int arg) {
        int totalTopics = arrayList.size();
        if((totalTopics >= arg) && (arg > 0))
            return arrayList.get(arg - 1);
        else
            return "Out of range";
    }
}