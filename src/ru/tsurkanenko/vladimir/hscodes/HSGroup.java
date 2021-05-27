package ru.tsurkanenko.vladimir.hscodes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * @version 0.1
 * @author Vladimir Tsurkanenko
 * Объект инкапсулирующий данные о разделах, группах или подгруппах:
 * код, описание и примечания
 */
public class HSGroup {
    private String[] code;
    private String[] description;
    private String[] note;
    private int size;
    final String lineRegex = "^\\d\\d\\|(.+)\\|.*\\|\\d\\d\\.\\d\\d\\.\\d\\d\\d\\d\\|\\|$";
    final String  clearCode = "(\\|)([А-Яа-яA-Za-z\\-].*)$";
    final String clearDescription = "(\\|\\d{2}.\\d{2}\\.\\d{4})|(\\|\\d{2}\\|\\d{6})|(^\\d+)|(\\|\\d{2}\\|)";
    /**
     * Создает объект получая данные из файла, имя которого передается ему в качестве аргумента
     * @param fileName Имя файла из которого следует получить данные
     */
    public HSGroup(String fileName) {
        String singleLine;
        // Получить количество строк
        try {
            BufferedReader sourceFile =
                    new BufferedReader(new FileReader(fileName));
            size = 0;
            while((singleLine = sourceFile.readLine()) != null){
                if(singleLine.matches(lineRegex)) size++;
            }
        } catch (IOException exception) {
            System.err.println("Ошибка чтения файла " + fileName);
            return;
        }
        // Инициировать массивы
        code = new String[size];
        description = new String[size];
        note = new String[size];
        // Заполнить массивы данными
        try {
            BufferedReader sourceFile =
                    new BufferedReader(new FileReader(fileName));
            int i = 0;
            while((singleLine = sourceFile.readLine()) != null){
                if(singleLine.matches(lineRegex)) {
                    code[i] = singleLine.replaceAll(clearCode, "").replaceAll("\\|","");
                    description[i] = singleLine.replaceAll(clearDescription, "").replaceAll("^\\|","").replaceAll("\\|.*$","");
                    note[i]=singleLine.replaceAll(clearDescription, "").
                            replaceAll("^\\|","").
                            replaceAll("^.+?\\|","").
                            replaceAll("\\|","").
                            replaceAll("(\\.)(\\s+)(\\d\\.)","$1\n$3" ).
                            replaceAll("([;:])\\s+(\\([А-Яа-я]\\))","$1\n\t$2");
                    i++;
                }
            }
        } catch (IOException exception) {
            System.err.println("Ошибка чтения файла " + fileName);
        }
    }
    /**
     * Возвращает строковый массив, в формате CODE DESCRIPTION
     * @return Все строки массива
     */
    public String[] getList() {
        return this.getList("");
    }
    /**
     * Возвращает строковый массив, в формате CODE DESCRIPTION
     * @param arg Строковый параметр в формате "09234..." или "".
     * @return Если аргумент пустой - все строки массива, иначе - строки для кодов, начинающиеся на arg
     */
    public String[] getList(String arg) {
        String[] result;
        if (arg.length() == 1) arg = "0" + arg;
        if (arg.length() == 0) {
            result = new String[size];
            for (int i = 0; i < size; i++)
                result[i] = code[i] + " " + description[i];
        } else {
            int totalFound = 0;
            for (int i = 0; i < size; i++) {
                if (code[i].startsWith(arg))
                    totalFound++;
            }
            result = new String[totalFound];
            int n = 0;
            for (int i = 0; i < size; i++)
                if (code[i].startsWith(arg)) {
                    result[n] = code[i] + " " + description[i];
                    n++;
                }
        }
        return result;
    }
    /**
     * Возвращает строковый массив c примечаниями
     * @param arg Строковый параметр в формате "09234..." или "".
     * @return Если аргумент пустой - все строки массива, иначе - примечания относящиеся к кодам начинающиеся на arg
     */
    public String[] getNote(String arg) {
        String[] result;
        if (arg.length() == 1) arg = "0" + arg;
        if (arg.length() == 0 ) {
            return note;
        } else {
            int totalFound = 0;
            for (int i = 0; i < size; i++) {
                if (code[i].startsWith(arg))
                    totalFound++;
            }
            result = new String[totalFound];
            int n = 0;
            for (int i = 0; i < size; i++)
                if (code[i].startsWith(arg)) {
                    result[n] = note[i];
                    n++;
                }
        }
        return result;
    }
}
