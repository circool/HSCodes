package ru.tsurkanenko.vladimir.hscodes;

/**
 * @deprecated
 */
public class TestHSBase {
    public static void main(String[] args) {
        HSBase demo = new HSBase();
        String sect = "01";

        String[] sample = demo.getSection().getList(sect);
        String[] note = demo.getSection().getNote(sect);
        System.out.println("РАЗДЕЛ" + ":" + sample.length);
        for(int i = 0; i < sample.length; i++)
            System.out.println(sample[i] + "\n" + note[i]);

        System.out.println("ГРУППА");
        sample = demo.getGroup().getList(sect);
        note = demo.getGroup().getNote(sect);
        for(int i = 0; i < sample.length; i++)
            System.out.println(sample[i] + "\n" + note[i]);

        System.out.println("ПОДГРУППА");
        sample = demo.getSubGroup().getList(sect);
        for(String line:sample)
            System.out.println(line);
        System.out.println("ПОЗИЦИЯ");
        sample = demo.getItem().getList(sect);
        for(String line:sample)
            System.out.println(line);

    }
}
