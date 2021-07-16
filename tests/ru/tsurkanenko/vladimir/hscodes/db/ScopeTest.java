

package ru.tsurkanenko.vladimir.hscodes.db;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@SuppressWarnings("deprecation")
public class ScopeTest {


    @Test
    public void ItemToString() {
        Operable[] test;
        test = new Scope("files/TNVED1.TXT").get();
        Assert.assertThat(test[0].toString(), is("01 ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ"));
        assertThat(test[test.length - 1].toString(), is("22 FIFA2018"));

        test = new Scope("files/TNVED1.TXT").get();
        Assert.assertThat(test[0].toString(), is("01 ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ"));
        assertThat(test[test.length - 1].toString(), is("22 FIFA2018"));
    }

    @Test
    public void HSElementGetNaim() {
        Operable[] test;
        test = new Scope("files/TNVED1.TXT").get();
        assertThat(test[test.length - 1].getNaim(), is("FIFA2018"));

        test = new Scope("files/TNVED1.TXT").get();
        assertThat(test[test.length - 1].getNaim(), is("FIFA2018"));
    }

    @Test
    public void HSElementGetCode() {
        Operable[] test;
        test = new Scope("files/TNVED1.TXT").get();
        assertThat(test[test.length - 1].getCode(), is("22"));

        test = new Scope("files/TNVED1.TXT").get();
        assertThat(test[test.length - 1].getCode(), is("22"));
    }

    @Test
    public void HSElementGetNestingLevel() {
        Operable[] test;
        test = new Scope("files/TNVED1.TXT").get();
        assertThat(test[test.length - 1].getNestingLevel(), is(0));

        test = new Scope("files/TNVED4.TXT").get();

        assertThat(test[test.length - 7].getNestingLevel(), is(1));
    }

    @Test
    public void HSElementGetPrim() {
        Operable[] test;
        test = new Scope("files/TNVED1.TXT").get();
        assertThat(test[test.length - 1].getPrim(), is("товары для FIFA"));
    }


    @Test
    public void getNestingLevelTest(){
        Item b = new Item("9620000008","- - - из углеродных волокон или прочих углеродистых материалов",null);
        assertThat(b.getNestingLevel(), is(3));
        b = new Item("9621000008","- - - - из углеродных волокон или прочих углеродистых материалов",null);
        assertThat(b.getNestingLevel(), is(4));
    }

    @Test
    public void getChildrenDemo(){
        Scope parent = new Scope("files/TNVED1.TXT");
        Scope children = new Scope("files/TNVED2.TXT");
        Operable p = parent.get()[0];
        Operable[] result = children.getChildren(p);
        assertThat(result.length, is(5));
        System.out.println(p + " (" + p.getNestingLevel() + "):");

        for (Operable m:result
             ) {
            System.out.println("\t" + m.toString()+ " (" + m.getNestingLevel() + ")");

        }
    }

    @Test
    public void compareTest(){
        Scope scope = new Scope("files/TNVED4.TXT");
        scope.add("files/TNVED4.ADD.TXT");
        for (int i = 0; i < 5; i++) {
            System.out.println(scope.get()[i]);
        }

        assertTrue(scope.get()[0].compareTo(scope.get()[1]) < 0);
    }

    @Test
    public void startWithTest(){
        Scope position = new Scope("files/TNVED1.TXT");
        //position.put("files/TNVED1.ADD.TXT");
        Scope items = new Scope("files/TNVED2.TXT");
        //items.put("files/TNVED2.ADD.TXT");

        Operable parent = position.get()[0];
        Operable[] children = items.getChildren(parent);
        assertThat(children.length, is(5));
        System.out.println(parent + ":");
        for (Operable result:children
             ) {
            System.out.println("\t" + result);
        }
    }

}
