package ru.tsurkanenko.vladimir.hscodes;

/**
 * Инструменты для работы со строками
 */
public class StringTools {
    static String toHuman(String str){
        return str.substring(0,4) + " " +
                str.substring(4,6) + " " +
                str.substring(6,9) + " " +
                str.charAt(9) + " " +
                str.substring(10);
    }

}
