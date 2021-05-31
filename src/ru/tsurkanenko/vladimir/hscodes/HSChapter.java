package ru.tsurkanenko.vladimir.hscodes;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HSChapter {
    private String[] code;
    private String[] description;
    private int size;
    final String lineRegex = "^[0-9\\|]+.+?\\|[0-9\\.]+\\|{2}$";
    final String codeRegex = "^(\\d\\d)\\|(\\d\\d)\\|(\\d*)(.*)";
    final String DescriptionRegex = "(^[0-9\\|]+)(.+?)(\\|[0-9\\|.]+)$";
    final String dateRegex = "(\\d{2}\\.\\d{2}\\.\\d{4}\\|)+$";

    public HSChapter(String fileName){
        String singleLine;
        ArrayList<String> actualCode = new ArrayList<String>();
        ArrayList<String> actualDescription = new ArrayList<String>();
        // Получить количество строк
        try {
            BufferedReader sourceFile =
                    new BufferedReader(new FileReader(fileName));

            while((singleLine = sourceFile.readLine()) != null){
                if(singleLine.matches(lineRegex)) {
                    actualCode.add(singleLine.replaceAll(codeRegex, "$1$2$3"));
                    actualDescription.add(singleLine.replaceAll(DescriptionRegex, "$2"));
                    size++;
                }
            }
        } catch (IOException exception) {
            System.err.println("Ошибка чтения файла " + fileName);
            return;
        }
        code = new String[actualCode.size()];
        description = new String[actualCode.size()];
        actualCode.toArray(code);
        actualDescription.toArray(description);


    }
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
}