package ru.tsurkanenko.vladimir.hscodes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Представляет из себя объект, имплементирующий необработанные строки файла,
 * в которых содержатся и либо актуальные либо все данные.
 * @author Vladimir Tsurkanenko
 * @version 0.5.3
 * @since 0.5.3
 */
public class RawLines {
    private String[] rawData;

    /**
     * Читает файл, имя которого получено в качестве аргумента и формирует массив, содержащий строки,
     * подходящие под шаблон описанный в regexRawLine.
     *
     * @param fileName имя файла с данными
     */
    public RawLines(String fileName) {
        try {
            BufferedReader sourceFile =
                    new BufferedReader(new FileReader(fileName));
            String singleLine;
            List<String> foundLines = new ArrayList<>();
            while((singleLine = sourceFile.readLine()) != null){
                String regexAllLines = "^[0-9]+\\|.*\\|\\|$";
                if(singleLine.matches(regexAllLines))
                    foundLines.add(singleLine);
            }
            rawData = foundLines.toArray(new String[0]);
        } catch (IOException exception) {
            System.err.println("Ошибка чтения файла " + fileName);
        }
    }

    /**
     * Возвращает строковый массив с актуальными данными.
     * @return строковый массив
     */
    public String[] get() {
        return rawData;
    }
}



