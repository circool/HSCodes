package ru.tsurkanenko.vladimir.hscodes.database.ver4;

class RazdelDemo {
    public static void main(String[] args) {
        Dict demo = new Dict();
        for (Razdel curRazdel: demo.getRazdel()
             ) {
            System.out.println(curRazdel.getNaim());
        }
    }
}