package ru.tsurkanenko.vladimir.hscodes.database;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;

class ItemsScopeTest {
    ItemsScope test;

    @BeforeEach
    void setUp() {
        test = new ItemsScope();
    }

    @Test
    void getItem() {
        MatcherAssert.assertThat(test.getItem("0101210000").toString(), is("0101210000 - - чистопородные племенные животные"));
        MatcherAssert.assertThat(test.getItem(0).toString(), is("0101200000 - лошади:"));
    }


    @Test
    void startsWith() {
        MatcherAssert.assertThat(test.startsWith("0101").length, is (7));
        MatcherAssert.assertThat(test.startsWith("0101")[0].toString(), is("0101200000 - лошади:"));
        MatcherAssert.assertThat(test.startsWith("0101")[6].toString(), is("0101900000 - прочие"));
    }
}