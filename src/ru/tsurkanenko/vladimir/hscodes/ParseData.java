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
public class ParseData {
    private String[] code;
    private String[] description;
    private String[] note;
    private int lineCounter;
    final String lineRegex = "^\\d\\d\\|(.+)\\|.*\\|\\d\\d\\.\\d\\d\\.\\d\\d\\d\\d\\|\\|$";
    final String clearCode = "(\\|)([А-Яа-яA-Za-z\\-].*)$";
    final String clearDescription = "(\\|\\d{2}.\\d{2}\\.\\d{4})|(\\|\\d{2}\\|\\d{6})|(^\\d+)|(\\|\\d{2}\\|)";

    /**
     * Возвращает массив с кодами
     * @return Массив кодов
     */
    public String[] getCode() {
        return code;
    }

    /**
     * Возвращает отдельный код
     * @param index Индекс кода в массиве
     * @return Строковое отображение кода
     */
    public String getCode(int index) {
        return code[index];
    }

    /**
     * Возвращает массив с описаниями
     * @return Массив с описаниями
     */
    public String[] getDescription() {
        return description;
    }

    /**
     * Возвращает описание конкретного элемента
     * @param index Номер элемента
     * @return Описание элемента
     */
    public String getDescription(int index) {
        return description[index];
    }
    /**
     * Возвращает массив с примечаниями
     * @return Массив с примечаниями
     */
    public String[] getNotes() {
        return note;
    }
    /**
     * Возвращает примечание конкретного элемента
     * @param index Номер элемента
     * @return Примечание элемента
     */
    public String getNotes(int index) {
        return note[index];
    }

    /**
     * Возвращает положение в массиве кодов
     * @param codeToFind Искомый код в текстовом формате
     * @return Индекс в массиве
     */
    public int findCodeIndex(String codeToFind){
        int i=0;
        for(String item:code) {
            if (item.equals(codeToFind)) return i;
            i++;
        }
        return -1;
}
    /**
     * Возвращает положение в массиве кодов
     * @param descriptionToFind Искомый код в текстовом формате
     * @return Индекс в массиве
     */
    public int findDescriptionIndex(String descriptionToFind){
        int i=0;
        for(String item:description) {
            if (item.equals(descriptionToFind)) return i;
            i++;
        }
        return -1;
    }
    /**
     * Возвращает количество строк, содержащих действительные данные
     * @return Количество строк с данными
     */
    public int getSize(){
        return lineCounter;
    }
    /**
     * Создает объект получая данные из файла, имя которого передается ему в качестве аргумента
     * @param fileName Имя файла из которого следует получить данные
     */
    public ParseData(String fileName) {
        String singleLine;
        // Получить количество строк
        try {
            BufferedReader sourceFile =
                    new BufferedReader(new FileReader(fileName));
            lineCounter = 0;
            while((singleLine = sourceFile.readLine()) != null){
                if(singleLine.matches(lineRegex)) lineCounter++;
            }
        } catch (IOException exception) {
            System.err.println("Ошибка чтения файла " + fileName);
            return;
        }
        // Инициировать массивы
        code = new String[lineCounter];
        description = new String[lineCounter];
        note = new String[lineCounter];
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


}
