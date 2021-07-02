package ru.tsurkanenko.vladimir.hscodes.mvc;
import ru.tsurkanenko.vladimir.hscodes.*;

/**
 * Демонстрация работы рекурсивного метода NestedChild
 */
class NestedChildDemo {
    public static void main(String[] args) {

        ScopeItems parent = new ScopeItems("dic/TNVED3.TXT");
        parent.add("dic/TNVED3.ADD.TXT");

        ScopeItems data = new ScopeItems("dic/TNVED4.TXT");
        data.add("dic/TNVED4.ADD.TXT");


    }
}