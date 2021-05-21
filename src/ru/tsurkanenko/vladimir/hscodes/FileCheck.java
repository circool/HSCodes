package ru.tsurkanenko.vladimir.hscodes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Класс для проверки наличия внешнего файла и его размера
 */
class FileCheck {
    /**
     * Статический метод, возвращающий количество строк файла
     * @param fileName Имя проверяемого файла
     * @return Количество строк
     */
    static int getSize(String fileName){
        int lineCounter = 0;
        try (BufferedReader sourceFile =
                     new BufferedReader(new FileReader(fileName))) {
            String singleLine;
            while ((singleLine = sourceFile.readLine()) != null)
                    if(!singleLine.matches("(#|/).*")) lineCounter++;
        } catch (IOException exception) {
            System.out.println("Ошибка чтения файла " + fileName);
        }
        return lineCounter;
    }

    /**
     * Статический метод, возвращающий наличие определенного в параметре файла
     * @param fileName Имя проверяемого файла
     * @return Наличие файла
     */
    static boolean isExist(String fileName){
        boolean exist;
        try (BufferedReader sourceFile =
                     new BufferedReader(new FileReader(fileName))) {
            exist = true;
        } catch (IOException exception) {
            exist = false;
        }
        return exist;
    }
}
