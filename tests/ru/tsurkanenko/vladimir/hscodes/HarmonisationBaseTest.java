package ru.tsurkanenko.vladimir.hscodes;

import java.util.Arrays;

/**
 * Код для проверки классов HarmonisationBase, HarmonisationItem и HarmonisationGroup
 */
class HarmonisationBaseTest {
    public static void main(String[] args) {
        int index = 0;
        HarmonisationBase test = new HarmonisationBase();

        // Получение одиночного элемента
        // получить один раздел и его примечание
        System.out.println(Arrays.toString(test.getSections().getCode()));
        System.out.println(test.getSections().getDescription(index));
        System.out.println(test.getSections().getNote(index));
        System.out.println();
        // получить одну товарную группу и ее примечание
        System.out.println(test.getGroups().getCodeAndDescription(index));
        System.out.println(test.getGroups().getNote(index));
        // получить одну товарную позицию
        System.out.println(test.getPositions().getCodeAndDescription(index));
        // получить один товарный код
        System.out.println(test.getItems().getCodeAndDescription(index));

        System.out.println("Получение списка элементов");
        String[] list = test.getGroups().startsWith("2");

        for (String oneLine:list
             ) {
            System.out.println(oneLine);
        }
        
    }
}