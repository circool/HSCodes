package ru.tsurkanenko.vladimir.hscodes.database.ver4;

import static org.junit.jupiter.api.Assertions.*;

class RazdelDemo {
    public static void main(String[] args) {
        Dict demo = new Dict();
        Razdel test = demo.getRazdel(10);
        System.out.println(test.toString());
    }
}