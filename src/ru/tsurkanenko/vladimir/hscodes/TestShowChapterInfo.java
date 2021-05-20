package ru.tsurkanenko.vladimir.hscodes;

/**
 * Выводит список разделов и групп
 */
public class TestShowChapterInfo {
    public static void main(String[] args) {

        String fileNameSections = "dic/hs_chapters.txt";
        String fileNameGroups = "dic/hs_groups.txt";
        HsChapter section = new HsChapter(fileNameSections);
        HsChapter group = new HsChapter(fileNameGroups);

        for(int sectionNumber = 1; sectionNumber <= section.maxIndex(); sectionNumber++){
            System.out.println(sectionNumber + ". " + section.getDescription(sectionNumber));
            for (int groupNumber = section.getBegin(sectionNumber); groupNumber <= section.getEnd(sectionNumber); groupNumber++) {
                if(groupNumber < 10) // Для цифр 1-9 добавить лидирующий ноль
                    System.out.println("\t" + "0" + groupNumber +  "-- -- --- - \t " + group.getDescription(groupNumber));
                else
                    System.out.println("\t" + groupNumber +  "-- -- --- - \t " + group.getDescription(groupNumber));
            }
        }
    }
}

