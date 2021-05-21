package ru.tsurkanenko.vladimir.hscodes;

import java.io.IOException;

/**
 * Выводит список разделов и групп
 */

public class TestShowChapterInfo {
    public static void main(String[] args) throws IOException {

        String fileNameSections = "dic/hs_chapters.txt";
        String fileNameGroups = "dic/hs_groups.txt";
        HsGroup section = new HsGroup(fileNameSections);
        HsGroup group = new HsGroup(fileNameGroups);

        for(int sectionNumber = 1; sectionNumber <= section.getSize() ; sectionNumber++){
            System.out.println(sectionNumber + ". " + section.getDescription(sectionNumber));
            for (int groupNumber = section.getFirstChild(sectionNumber); groupNumber <= section.getLastChild(sectionNumber); groupNumber++) {
                if(groupNumber < 10) // Для цифр 1-9 добавить лидирующий ноль
                    System.out.println("\t" + "0" + groupNumber +  "-- -- --- - \t " + group.getDescription(groupNumber));
                else
                    System.out.println("\t" + groupNumber +  "-- -- --- - \t " + group.getDescription(groupNumber));
            }
        }
    }
}

