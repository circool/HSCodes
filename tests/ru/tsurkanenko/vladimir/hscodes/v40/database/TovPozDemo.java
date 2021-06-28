package ru.tsurkanenko.vladimir.hscodes.v40.database;



/**
 * Демонстрация класса TovPoz
 * @version 0.4
 */
class TovPozDemo {
    public static void main(String[] args) {
        Dict test = new Dict();

        for (TovPoz x : test.getTovPoz()) {
            System.out.println(x.toString());
        }
    }
}