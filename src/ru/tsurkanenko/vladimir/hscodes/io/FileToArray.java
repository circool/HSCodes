/*
 * MIT License
 *
 * Copyright (c) 2021 Vladimir Tsurkanenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

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
     * Читает файл и отдает масив строк, содержищих актуальные данные справочника
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
