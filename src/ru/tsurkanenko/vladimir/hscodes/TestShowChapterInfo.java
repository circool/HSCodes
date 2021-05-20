package ru.tsurkanenko.vladimir.hscodes;

public class TestShowChapterInfo {
    public static void main(String[] args) {
        int sampleChapter = 17;
        String fileName = "dic/hs_chapters.txt";
        String fileNameGroups = "dic/hs_groups.txt";
        System.out.print("РАЗДЕЛ " + sampleChapter + ": ");
        HsChapter sample = new HsChapter(fileName);
        FileToArrayList groups = new FileToArrayList(fileNameGroups);
        for(int n = 1; n <= sample.maxIndex(); n++){
            System.out.println(sample.getDescription(n));
            for (int i = sample.getBegin(n); i <= sample.getEnd(n); i++) {
                System.out.println("\t" + i +  "-- -- --- - \t " + groups.getTopic(i));
            }
        }
    }
}

