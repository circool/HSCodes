package ru.tsurkanenko.vladimir.hscodes.database;

public class TovSubPozDemo {
    public static void main(String[] args) {
        Dict demo = new Dict();
        String gr = "88";
        String tp = "03";
        int nl = 1;
        TovSubPoz[] result = demo.getNestledTovSubPoz(gr, tp, nl);
        for (TovSubPoz x:result
             ) {
            System.out.println(x.toString());
        }
    }
}
