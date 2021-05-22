package ru.tsurkanenko.vladimir.hscodes;

public class TestParseData {
    public static void main(String[] args) {
        String fileRazdel = "dic/TNVED1.TXT";
        String fileGroup = "dic/TNVED2.TXT";
        String fileSubGroup = "dic/TNVED3.TXT";
        String fileSubSubGroup = "dic/TNVED4.TXT";
        String file ="dic/TNVED4.TXT";
        ParseData test = new ParseData(file);
        System.out.println("Файл " + file + " содержит " + test.getSize() + " действительных строк.");
        int ind = 0;
        System.out.println("Строка " + ind + " содержит :");
        System.out.println(test.getCode(ind));
        System.out.println(test.getDescription(ind));
        System.out.println(test.getNotes(ind));
    }
}
