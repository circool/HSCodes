package ru.tsurkanenko.vladimir.hscodes.db;

import org.junit.Before;
import org.junit.Test;

public class OperableTest {
    Scope section,group,subgroup,position;
    @Before
    public void setUp() {
        section = new Scope("files/TNVED1.TXT");
        group = new Scope("files/TNVED2.TXT");
        subgroup = new Scope("files/TNVED3.TXT");
        subgroup.add("files/TNVED3.ADD.TXT");
        position = new Scope("files/TNVED4.TXT");
        position.add("files/TNVED4.ADD.TXT");
    }


    @Test
    public void getChildrenDebug(){

        Operable[] result;

        Operable[] arrSection = section.get();
        Operable[] arrGroup = group.get();
        Operable[] arrSubgroup = subgroup.get();
        Operable[] arrPosition = position.get();


        Operable parent = position.items[position.items.length-1];
        result = position.getChildren(parent);
        System.out.println(parent + " : " + parent.getNestingLevel());
        for (Operable singleItem:result
             ) {
            System.out.println(singleItem + " : " + singleItem.getNestingLevel());
        }




    }
}
