package ru.tsurkanenko.vladimir.hscodes.database;

class TovPozScopeDemo{
    public static void main(String[] args) {
        TovPozScope demo = new TovPozScope("dic/TNVED3.TXT");
        for (TovPoz currTovPos:demo.tovPosScope
        ) {
            if(!currTovPos.isActual())
                System.out.println(currTovPos.toString() + " is " + currTovPos.isActual());
        }
    }
}