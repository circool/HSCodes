package ru.tsurkanenko.vladimir.hscodes.database;
/**
 * Демонстрация класса Razdel
 */
class RazdelDemo {
    public static void main(String[] args) {
        Dict demo = new Dict();
        for (Razdel curRazdel: demo.getRazdel()
             ) {
            System.out.println(curRazdel.getNaim());
        }
    }
}