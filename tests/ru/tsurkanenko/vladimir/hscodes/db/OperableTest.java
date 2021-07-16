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

        Item[] result;

        Item[] arrSection = section.get();
        Item[] arrGroup = group.get();
        Item[] arrSubgroup = subgroup.get();
        Item[] arrPosition = position.get();


        Item parent = position.items[position.items.length-1];
        result = position.getChildren(parent);
        System.out.println(parent.toString() + " : " + parent.getNestingLevel());
        for (Item singleItem:result
             ) {
            System.out.println(singleItem + " : " + singleItem.getNestingLevel());
        }




    }
}