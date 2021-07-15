
/*
 * MIT License
 *
 * Copyright (c) 2021 Vladimir Tsurkanenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package ru.tsurkanenko.vladimir.hscodes.db;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@SuppressWarnings("deprecation")
public class ScopeItemsTest {


    @Test
    public void ItemToString() {
        Item[] test;
        test = new Scope("files/TNVED1.TXT").get();
        Assert.assertThat(test[0].toString(), is("01 ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ"));
        assertThat(test[test.length - 1].toString(), is("22 FIFA2018"));

        test = new Scope("files/TNVED1.TXT").get();
        Assert.assertThat(test[0].toString(), is("01 ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ"));
        assertThat(test[test.length - 1].toString(), is("22 FIFA2018"));
    }

    @Test
    public void HSElementGetNaim() {
        Item[] test;
        test = new Scope("files/TNVED1.TXT").get();
        assertThat(test[test.length - 1].getNaim(), is("FIFA2018"));

        test = new Scope("files/TNVED1.TXT").get();
        assertThat(test[test.length - 1].getNaim(), is("FIFA2018"));
    }

    @Test
    public void HSElementGetCode() {
        Item[] test;
        test = new Scope("files/TNVED1.TXT").get();
        assertThat(test[test.length - 1].getCode(), is("22"));

        test = new Scope("files/TNVED1.TXT").get();
        assertThat(test[test.length - 1].getCode(), is("22"));
    }

    @Test
    public void HSElementGetNestingLevel() {
        Item[] test;
        test = new Scope("files/TNVED1.TXT").get();
        assertThat(test[test.length - 1].getNestingLevel(), is(0));

        test = new Scope("files/TNVED4.TXT").get();

        assertThat(test[test.length - 7].getNestingLevel(), is(1));
    }

    @Test
    public void HSElementGetPrim() {
        Item[] test;
        test = new Scope("files/TNVED1.TXT").get();
        assertThat(test[test.length - 1].getPrim(), is("товары для FIFA"));
    }

    @Test
    public void HSElementIsHavePrim(){
        Item[] test;
        test = new Scope("files/TNVED1.TXT").get();
        //assertThat(test[21].isHavePrim(), is(true));
        //assertThat(test[20].isHavePrim(), is(false));

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
        Item p = parent.get()[0];
        Item[] result = children.getChildren(p);
        assertThat(result.length, is(5));
        System.out.println(p + " (" + p.getNestingLevel() + "):");

        for (Item m:result
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

        Item parent = position.get()[0];
        Item[] children = items.getChildren(parent);
        assertThat(children.length, is(5));
        System.out.println(parent + ":");
        for (Item result:children
             ) {
            System.out.println("\t" + result);
        }
    }

}
