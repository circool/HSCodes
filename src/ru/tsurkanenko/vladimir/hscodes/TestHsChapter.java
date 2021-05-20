package ru.tsurkanenko.vladimir.hscodes;

public class TestHsChapter {
    public static void main(String[] args) {
        HsChapter sample = new HsChapter("dic/hs_chapters.txt");
        System.out.println("Разделы (всего " + sample.maxIndex() + "):");
        for(int i=1; i <= sample.maxIndex() ; i++){
            System.out.println("Раздел " + i + ": "
                    + sample.getDescription(i) + "\n начинается с "
                    + sample.getBegin(i) + ", заканчивается " + sample.getEnd(i));
        }
    }
}
