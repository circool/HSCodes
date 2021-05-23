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
                            replaceAll("(;|:)\\s+(\\([А-Яа-я]\\))","$1\n\t$2");
                    i++;
                }
            }
        } catch (IOException exception) {
            System.err.println("Ошибка чтения файла " + fileName);
        }
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
                if (code[i].substring(0, arg.length()).equals(arg))
                    totalFound++;
            }
            result = new String[totalFound];
            int n = 0;
            for (int i = 0; i < size; i++)
                if (code[i].substring(0, arg.length()).equals(arg)) {
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
            result = new String[size];
            for (int i = 0; i < size; i++)
                result[i] = note[i];
        } else {
            int totalFound = 0;
            for (int i = 0; i < size; i++) {
                if (code[i].substring(0, arg.length()).equals(arg))
                    totalFound++;
            }
            result = new String[totalFound];
            int n = 0;
            for (int i = 0; i < size; i++)
                if (code[i].substring(0, arg.length()).equals(arg)) {
                    result[n] = note[i];
                    n++;
                }
        }
        return result;
    }



// Кандидаты на удаление
    /**
     * Возвращает массив с кодами
     * @return Массив кодов
     * @deprecated
     */
    public String[] getCode() {
        return code;
    }

    /**
     * Возвращает отдельный код
     * @param index Индекс кода в массиве
     * @return Строковое отображение кода
     * @deprecated
     */
    public String getCode(int index) {
        return code[index];
    }

    /**
     * Возвращает массив с описаниями
     * @return Массив с описаниями
     * @deprecated
     */
    public String[] getDescription() {
        return description;
    }

    /**
     * Возвращает описание конкретного элемента
     * @param index Номер элемента
     * @return Описание элемента
     * @deprecated
     */
    public String getDescription(int index) {
        return description[index];
    }
    /**
     * Возвращает количество строк, содержащих действительные данные
     *
     * @return Количество строк с данными
     * @deprecated
     */
    public int getSize() {
        return size;
    }

    /**
     * Возвращает массив описаний граниченный начальным и конечным значением
     * @deprecated
     */
    public String[] getScope(int first, int last) {
        String[] result = new String[last - first];
        for (int i = first; i <= last; i++)
            result[i] = description[i];
        return result;
    }

/*
        for(String curLine:this.code){
            if(curLine.substring(0, arg.length()).equals(arg)) totalFound++;
        }
        String[] result = new String[totalFound];
        int i=0;
        for(int n = 0; n < this.code.length; n++){
            if(this.code[n].substring(0, arg.length()).equals(arg)) {
                result[i] = this.code[n] +" "+ this.description[n];
                i++;
            };
        }
        return result;
 */

    /**
     * Ищет первое вхождение кода
     * @deprecated
     */
    public int getFirstCode(int code){
        String strCode = Integer.toString(code);
        if (strCode.length() == 1) strCode = "0" + strCode;
        for(int i = 0; i < this.code.length; i++)
            if(this.code[i].substring(0, 1).equals(strCode) ) return i;
        return -1;
    }

    /**
     * @deprecated
     * @param code
     * @return
     */
    public int getLastCode(int code){
        String strCode = Integer.toString(code);
        if (strCode.length() == 1) strCode = "0" + strCode;
        for(int i = 0; i < this.code.length; i++)
            if(this.code[i].substring(0, 1).equals(strCode) ) {
                while(this.code[i].substring(0, 1).equals(strCode))
                    i++;
                return i;
            }
        return -1;
    }

}
