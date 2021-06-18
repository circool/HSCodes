package ru.tsurkanenko.vladimir.hscodes.database.ver2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladimir Tsurkanenko
 * @version 0.2
 * Представляет из себя объект, имплементирующий необработанные строки файла, в которых содержатся и актуальные и устаревшие данные.
 */
@SuppressWarnings("rawtypes")
public class RawLines extends ArrayList {
    private String[] rawData;
    final String regexRawLine = "^\\d+\\|.*?\\|.*?\\|[0-9.]+\\|[0-9.]*\\|$";
    final String regexGarbage = " | Н |\\s\\s+|\\s+\\||\\|\\s+";

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
                singleLine = singleLine.replaceAll(regexGarbage," "); //Удаление артефактов из текста
                if(singleLine.matches(regexRawLine))
                    foundLines.add(singleLine);
            }
            rawData = foundLines.toArray(new String[0]);
        } catch (IOException exception) {
            System.err.println("Ошибка чтения файла " + fileName);
        }
    }

    /**
     * Возвращает инкапсулированный строковый массив с данными.
     *
     * @return строковый массив
     */
    public String[] getRawData() {
        return rawData;
    }
}



