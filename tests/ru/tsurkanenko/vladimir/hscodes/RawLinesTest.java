package ru.tsurkanenko.vladimir.hscodes;

public class RawLinesTest {
    public static void main(String[] args) {
        RawLines demo = new RawLines("dic/TNVED1.TXT");

        String[] sections = new RawLines("dic/TNVED1.TXT").getRawData();
        for (String section:sections
             ) {
            System.out.println(section.substring(0,10));
        }
        System.out.println("Всего " + sections.length + " строк");
    }
}