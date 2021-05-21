package ru.tsurkanenko.vladimir.hscodes;

public class TestFileCheck {
    public static void main(String[] args) {
        String fileNameSections = "dic/hs_chapters.txt";
        String fileNameGroups = "dic/hs_groups.txt";
        int a, b;
        if(FileCheck.isExist(fileNameSections)) {
            a = FileCheck.getSize(fileNameSections);
            System.out.println("Файл " + fileNameSections + " состоит из " + a + " строк(и)");
        }
        if(FileCheck.isExist(fileNameGroups)) {
            b = FileCheck.getSize(fileNameGroups);
            System.out.println("Файл " + fileNameGroups + " состоит из " + b + " строк(и)");
        }
    }
}
