package ru.tsurkanenko.vladimir.hscodes;

import java.io.IOException;

public class TestHsArray {
    public static void main(String[] args) throws IOException {
        String fileNameSections = "dic/hs_chapters.txt";
        String fileNameGroups = "dic/hs_groups.txt";
        HsArray section = new HsArray(fileNameGroups);
        for(int i =0; i < section.getSize(); i++){
            System.out.println("Раздел " + (i+1) + ": " + section.getDescription(i) + "\nПодразделы " + section.getFirstChild(i) + "-" + section.getLastChild(i));
        }
    }
}
