package ru.tsurkanenko.vladimir.hscodes.database;



class SimpleHSScopeTest {
    public static void main(String[] args) {
        SimpleHSScope test = new SimpleHSScope();
        String[] x = test.getChildrenPositions("97");
        for (String y:x
             ) {
            System.out.println(y);
        }

    }
}