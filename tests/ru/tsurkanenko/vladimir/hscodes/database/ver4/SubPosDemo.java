package ru.tsurkanenko.vladimir.hscodes.database.ver4;

import java.time.LocalDate;
import java.util.Date;

class SubPosDemo {
    public static void main(String[] args) {
        Dict test = new Dict();
        System.out.println("TovPos");
        System.out.println("getTovGruppa: " + test.getTovPoz(5).ParentGruppaCode());
        System.out.println("getTovPoz: " + test.getTovPoz(5).getTovPozCode());
        System.out.println("getNaim: " + test.getTovPoz(5).getNaim());
        System.out.println();
        System.out.println("TovSubPos");
        System.out.println("getTovGruppa: " + test.getTovSubPos(9).ParentGruppaCode());
        System.out.println("getTovPoz: " + test.getTovSubPos(9).getTovPozCode());
        System.out.println("getTovSubPoz: " + test.getTovSubPos(9).getTovSubPozCode());
        System.out.println("getNaim: " + test.getTovSubPos(9).getNaim());

        Date isDate = test.getRazdel(0).getStartData();
        System.out.println(LocalDate.of(1990, 3, 17));
    }
}
