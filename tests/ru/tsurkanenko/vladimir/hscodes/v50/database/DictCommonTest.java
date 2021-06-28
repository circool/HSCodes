package ru.tsurkanenko.vladimir.hscodes.v50.database;

import org.hamcrest.MatcherAssert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.tsurkanenko.vladimir.hscodes.RawLines;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

class DictCommonTest {
    DictCommon[] test;
    DateFormat format;
    RawLines sections;

    @BeforeEach
    void setUp() {

        format = new SimpleDateFormat("dd.MM.yyyy");
    }

    @Test
    void createSection() throws ParseException {
    sections = new RawLines("dic/TNVED1.TXT");
    String[] actualSections = sections.getActualData();

    test = new DictCommon[actualSections.length];
    for (int i = 0; i < actualSections.length; i++) {
        test[i]=new DictCommon(actualSections[i]);
    }
    MatcherAssert.assertThat(test[0].toString(), is ("01 ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ"));
    MatcherAssert.assertThat(test[0].getNaim(), is ("ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ"));
    MatcherAssert.assertThat(test[0].getStartData(), is(format.parse("01.01.2017")));
    MatcherAssert.assertThat(test[0].getEndData(), is(format.parse("01.01.0000")));
    assertTrue(test[0].isActual());

    MatcherAssert.assertThat(test[test.length-1].toString(), is ("22 FIFA2018"));
    MatcherAssert.assertThat(test[test.length-1].getNaim(), is ("FIFA2018"));
    MatcherAssert.assertThat(test[test.length-1].getStartData(), is(format.parse("01.07.2018")));
    MatcherAssert.assertThat(test[test.length-1].getEndData(), is(format.parse("01.01.0000")));
    assertTrue(test[test.length-1].isActual());
    }

    @Test
    void createGroup() throws ParseException {
        sections = new RawLines("dic/TNVED2.TXT");
        String[] actualSections = sections.getActualData();

        test = new DictCommon[actualSections.length];
        for (int i = 0; i < actualSections.length; i++) {
            test[i]=new DictCommon(actualSections[i]);
        }
        MatcherAssert.assertThat(test[0].toString(), is ("0101 ЖИВЫЕ ЖИВОТНЫЕ"));
        MatcherAssert.assertThat(test[0].getNaim(), is ("ЖИВЫЕ ЖИВОТНЫЕ"));
        MatcherAssert.assertThat(test[0].getStartData(), is(format.parse("01.01.2017")));
        MatcherAssert.assertThat(test[0].getEndData(), is(format.parse("01.01.0000")));
        assertTrue(test[0].isActual());

        MatcherAssert.assertThat(test[test.length-1].toString(), is ("2299 FIFA2018"));
        MatcherAssert.assertThat(test[test.length-1].getNaim(), is ("FIFA2018"));
        MatcherAssert.assertThat(test[test.length-1].getStartData(), is(format.parse("01.07.2018")));
        MatcherAssert.assertThat(test[test.length-1].getEndData(), is(format.parse("01.01.0000")));
        assertTrue(test[test.length-1].isActual());
    }

    @Test
    void createPosition() throws ParseException {
        sections = new RawLines("dic/TNVED3.TXT");
        String[] actualSections = sections.getActualData();

        test = new DictCommon[actualSections.length];
        for (int i = 0; i < actualSections.length; i++) {
            test[i]=new DictCommon(actualSections[i]);
        }
        MatcherAssert.assertThat(test[0].toString(), is ("0101 ЛОШАДИ, ОСЛЫ, МУЛЫ И ЛОШАКИ ЖИВЫЕ"));
        MatcherAssert.assertThat(test[0].getNaim(), is ("ЛОШАДИ, ОСЛЫ, МУЛЫ И ЛОШАКИ ЖИВЫЕ"));
        MatcherAssert.assertThat(test[0].getStartData(), is(format.parse("01.01.2017")));
        MatcherAssert.assertThat(test[0].getEndData(), is(format.parse("01.01.0000")));
        assertTrue(test[0].isActual());

        MatcherAssert.assertThat(test[test.length-1].toString(), is ("9999 FIFA2018"));
        MatcherAssert.assertThat(test[test.length-1].getNaim(), is ("FIFA2018"));
        MatcherAssert.assertThat(test[test.length-1].getStartData(), is(format.parse("01.07.2018")));
        MatcherAssert.assertThat(test[test.length-1].getEndData(), is(format.parse("01.01.0000")));
        assertTrue(test[test.length-1].isActual());
    }

    @Test
    void createItem() throws ParseException {
        sections = new RawLines("dic/TNVED4.TXT");
        String[] actualSections = sections.getActualData();

        test = new DictCommon[actualSections.length];
        for (int i = 0; i < actualSections.length; i++) {
            test[i]=new DictCommon(actualSections[i]);
        }
        MatcherAssert.assertThat(test[0].toString(), is ("0101210000 - - чистопородные племенные животные"));
        MatcherAssert.assertThat(test[0].getNaim(), is ("- - чистопородные племенные животные"));
        MatcherAssert.assertThat(test[0].getStartData(), is(format.parse("01.01.2017")));
        MatcherAssert.assertThat(test[0].getEndData(), is(format.parse("01.01.0000")));
        assertTrue(test[0].isActual());

        MatcherAssert.assertThat(test[test.length-1].toString(), is ("9999999999 FIFA2018"));
        MatcherAssert.assertThat(test[test.length-1].getNaim(), is ("FIFA2018"));
        MatcherAssert.assertThat(test[test.length-1].getStartData(), is(format.parse("01.07.2018")));
        MatcherAssert.assertThat(test[test.length-1].getEndData(), is(format.parse("01.01.0000")));
        assertTrue(test[test.length-1].isActual());
    }
}