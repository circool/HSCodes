package ru.tsurkanenko.vladimir.hscodes.database.scope;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import ru.tsurkanenko.vladimir.hscodes.database.RawLines;

import static org.hamcrest.CoreMatchers.is;

class ItemsTest {
    Items[] test;
    RawLines items;


    @Test
    void createItem(){
        items = new RawLines("dic/TNVED4.TXT");
        String[] actualItems = items.getActualData();
        test = new Items[actualItems.length];
        for (int i = 0; i < actualItems.length; i++) {
            test[i]=new Items(actualItems[i]);
        }
        MatcherAssert.assertThat(test[0].getNestlingLevel(), is(2));

    }
}