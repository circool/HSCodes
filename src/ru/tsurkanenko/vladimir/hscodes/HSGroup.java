package ru.tsurkanenko.vladimir.hscodes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * @version 0.2
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
    final String clearCode = "(\\|)([А-Яа-яA-Za-z\\-].*)$";
    final String clearDescription = "(\\|\\d{2}.\\d{2}\\.\\d{4})|(\\|\\d{2}\\|\\d{6})|(^\\d+)|(\\|\\d{2}\\|)";
    final String regexNotes = "^(\\d+\\|)+(.*)\\|(.*)\\|(\\d\\d\\.\\d\\d\\.\\d{4}\\|+)";

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
                    note[i] = singleLine.replaceAll(regexNotes,"$3").replaceAll("[;:]", "\n").replaceAll(" Н ", " ").replaceAll("(\\.\\s*)(\\d+\\.)","$1\n$2");

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
    /**
     * Возвражает список субпозиций с учетом уровня вложенности
     * @arg level уровень вложенности
     * @return список субпозиций
     */
    public String[] getSubList(String arg, int level){
        String prefix="";
        for(int i = 0; i < level; i++){
            prefix += (char)45;
            prefix += (char)160;
        }



        int totalFound = 0;
        for (int i = 0; i < size; i++) {
            if (code[i].startsWith(arg) && description[i].startsWith(prefix) && (description[i].lastIndexOf(45)==(prefix.length())))
                totalFound++;
        }
        String[] result = new String[totalFound];
        totalFound = 0;
        for (int i = 0; i < size; i++) {
            if (code[i].startsWith(arg) && description[i].startsWith(prefix) && (description[i].lastIndexOf(45)==(prefix.length()))){
                result[totalFound] = description[i];
                totalFound++;
            }
        }
        return result;
    }
}
