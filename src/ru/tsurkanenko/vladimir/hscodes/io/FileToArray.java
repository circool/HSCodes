

package ru.tsurkanenko.vladimir.hscodes.io;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактный класс с фабричным методом, возвращающим массив с актуальными строками, прочитанными из файла.
 * @author Vladimir Tsurkanenko
 * @version 0.6
 * @since 0.6
 */
public abstract class FileToArray {
    /**
     * Читает файл и отдает массив строк, содержащих актуальные данные справочника
     * @param fileName имя файла из которого следует читать строки
     * @return массив строк, содержащий только актуальные данные справочника ТНВЭД
     */
    public static String @NotNull [] get(String fileName) {
        try {
            BufferedReader sourceFile =
                    new BufferedReader(new FileReader(fileName));
            String singleLine;
            List<String> foundLines = new ArrayList<>();
            while((singleLine = sourceFile.readLine()) != null)
                if(singleLine.matches(".*?\\|\\|$"))
                    foundLines.add(singleLine);
            return foundLines.toArray(new String[0]);
        } catch (IOException exception) {
            System.err.println("Ошибка чтения файла " + fileName);
        }
        return new String[0];
    }
}
