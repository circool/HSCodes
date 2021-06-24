package ru.tsurkanenko.vladimir.hscodes.database;

/**
 * Демонстрация класса TovPoz
 */
class TovPozDemo {
    public static void main(String[] args) {
        Dict test = new Dict();
        String code = "96";

        for (TovPoz x : test.getTovPoz()) {
            System.out.println(x.toString());
        }
    }
}