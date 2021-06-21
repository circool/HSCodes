package ru.tsurkanenko.vladimir.hscodes.database;

class SubPosDemo {
    public static void main(String[] args) {
        Dict test = new Dict();
        System.out.println("TovPos");
        System.out.println("getTovGruppa: " + test.getTovPoz(5).getGruppaCode());
        System.out.println("getTovPoz: " + test.getTovPoz(5).getTovPozCode());
        System.out.println("getNaim: " + test.getTovPoz(5).getNaim());
        System.out.println();
        System.out.println("TovSubPos");
        System.out.println("getTovGruppa: " + test.getTovSubPoz(9).getGruppaCode());
        System.out.println("getTovPoz: " + test.getTovSubPoz(9).getTovPozCode());
        System.out.println("getTovSubPoz: " + test.getTovSubPoz(9).getTovSubPozCode());
        System.out.println("getNaim: " + test.getTovSubPoz(9).getNaim());


    }
}
