package ru.tsurkanenko.vladimir.hscodes;
import java.util.ArrayList;
/**
 * Тестирование класса FileToArrayList
 * @deprecated
 */
public class TestFileToArrayList {
    public static void main(String[] args) {
        FileToArrayList sample = new FileToArrayList("dic/hs_groups.txt");
        int topic = 96;
        System.out.println("Наименование группы " + topic + ": " + sample.getTopic(topic));
        ArrayList<String> sampleArrayList = sample.getArrayList();
        System.out.println("Полный список:");
        for (String curTopic:sampleArrayList) System.out.println(curTopic);
    }
}
