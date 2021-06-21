package ru.tsurkanenko.vladimir.hscodes.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Представляет из себя объект, имплементирующий необработанные строки файла,
 * в которых содержатся и либо актуальные либо все данные.
 * @author Vladimir Tsurkanenko
 * @version 0.4
 * @since 0.4
 */

public class RawLines {

    private String[] rawData;


    //private final String regexGarbage = " | Н |\\s{2,}+";

    /**
     * Читает файл, имя которого получено в качестве аргумента и формирует массив, содержащий строки,
     * подходящие под шаблон описанный в regexRawLine.
     *
     * @param fileName имя файла с данными
     */
    RawLines(String fileName) {
        try {
            BufferedReader sourceFile =
                    new BufferedReader(new FileReader(fileName));
            String singleLine;
            List<String> foundLines = new ArrayList<>();
            while((singleLine = sourceFile.readLine()) != null){
                //singleLine = singleLine.replaceAll(regexGarbage," "); //Удаление артефактов из текста
                String regexAllLines = "^\\d+\\|.*?\\|.*?\\|[0-9.]+\\|[0-9.]*\\|$";
                if(singleLine.matches(regexAllLines))
                    foundLines.add(singleLine);
            }
            rawData = foundLines.toArray(new String[0]);
        } catch (IOException exception) {
            System.err.println("Ошибка чтения файла " + fileName);
        }
    }



    /**
     * Возвращает инкапсулированный строковый массив с данными, включая устаревшие.
     * @return строковый массив
     */
    public String[] getRawData() {
        return rawData;
    }
    /**
     * Возвращает инкапсулированный строковый массив с актуальными данными.
     * @return строковый массив
     */
    public String[] getActualData() {
        List<String> foundLines = new ArrayList<>();
        for (String singleLine:rawData
             ) {
            String regexActualLines = "^\\d+\\|.*?\\|.*?\\|[0-9.]+\\|\\|$";
            if(singleLine.matches(regexActualLines))
                foundLines.add(singleLine);
        }
        return foundLines.toArray(new String[0]);
    }
}



