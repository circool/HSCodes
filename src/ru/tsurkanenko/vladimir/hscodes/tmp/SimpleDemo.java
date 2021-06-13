package ru.tsurkanenko.vladimir.hscodes.tmp;

public class SimpleDemo {
    public static void main(String[] args) {
        SimpleGroupsSet section = new SimpleGroupsSet("dic/TNVED1.TXT");
        SimpleGroupsSet group = new SimpleGroupsSet("dic/TNVED2.TXT");
        SimpleItemsSet position = new SimpleItemsSet("dic/TNVED3.TXT");
        SimpleItemsSet item = new SimpleItemsSet("dic/TNVED4.TXT");

        for (SimpleItem x:item.getItemsStartsWith("01012")
             )
            System.out.println(x.get());


    }
}
