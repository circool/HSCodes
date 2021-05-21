package ru.tsurkanenko.vladimir.hscodes;


import java.io.IOException;

public class TestHsArray {
    public static void main(String[] args) throws IOException {
        String fileNameSections = "dic/hs_chapters.txt";
        String fileNameGroups = "dic/hs_groups.txt";
        HsGroup section = new HsGroup(fileNameSections);
        HsGroup group = new HsGroup(fileNameGroups,1);
        for(int i =0; i < section.getSize(); i++){
            System.out.println(section.getNestingLevel());
            System.out.println("Раздел " + (i+1) + ": " + section.getDescription(i) + "\nПодразделы " + section.getFirstChild(i) + "-" + section.getLastChild(i));
        }
        for(int i =0; i < group.getSize(); i++){
            System.out.println(group.getNestingLevel());
            System.out.println("Раздел " + (i+1) + ": " + group.getDescription(i) + "\nПодразделы " + group.getFirstChild(i) + "-" + group.getLastChild(i));
        }
    }
}
