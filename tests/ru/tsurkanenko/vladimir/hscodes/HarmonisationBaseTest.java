package ru.tsurkanenko.vladimir.hscodes;

/**
 * Код для проверки классов HarmonisationBase, HarmonisationItem и HarmonisationGroup
 */
class HarmonisationBaseTest {
    public static void main(String[] args) {
        int index = 0;
        HarmonisationBase test = new HarmonisationBase();

        // Получение одиночного элемента
        // получить один раздел и его примечание
        System.out.println(test.getSections().getCode(index));
        System.out.println(test.getSections().getDescription(index));
        System.out.println(test.getSections().getNote(index));
        System.out.println();
        // получить одну товарную группу и ее примечание
        System.out.println(test.getGroups().getItem(index));
        System.out.println(test.getGroups().getNote(index));
        // получить одну товарную позицию
        System.out.println(test.getPositions().getItem(index));
        // получить один товарный код
        System.out.println(test.getItems().getItem(index));

        System.out.println("Получение списка элементов");
        String[] list = test.getGroups().getItems("2");
        for (String oneLine:list
             ) {
            System.out.println(oneLine);
        }

    }
}