package ru.tsurkanenko.vladimir.hscodes;

public class TestHSBase {
    public static void main(String[] args) {
        HSBase demo = new HSBase();
        int sect = 0;

        System.out.println(demo.getSection().getCode(sect));
        for(String codes:demo.getGroup().getCode())
            if(codes.matches(("^" + demo.getSection().getCode(sect)) + ".*")) {
                //System.out.println(codes);
                //System.out.println(demo.getGroup().getDescription());
            }

    }
}
