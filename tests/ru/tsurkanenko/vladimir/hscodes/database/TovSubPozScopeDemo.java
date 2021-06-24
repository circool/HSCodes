package ru.tsurkanenko.vladimir.hscodes.database;



class TovSubPozScopeDemo {
    public static void main(String[] args) {
        TovSubPozScope demo = new TovSubPozScope("dic/TNVED4.TXT");
        TovSubPoz[] scope = demo.getAll();
        for (TovSubPoz currTovSubPoz:scope
             ) {
            System.out.println(currTovSubPoz.toString());
        }
    }

}