package ru.tsurkanenko.vladimir.hscodes.database.ver4;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.hamcrest.CoreMatchers.is;

class DictTest {
    Dict testDictionary;
    DateFormat format;

    @BeforeEach
    void setUp() {
        testDictionary = new Dict();
        format = new SimpleDateFormat("dd.MM.yyyy");
    }

    @Test
    public void whenCreateNewDict() throws Exception {
        for (Razdel currRazdel: testDictionary.getRazdel()
             ) {
            MatcherAssert.assertThat(currRazdel.isActual(), is (true));
            MatcherAssert.assertThat(currRazdel.getRazdelCode().matches("\\d{2}"), is (true));
            MatcherAssert.assertThat(currRazdel.getNaim().matches("[A-Z0-9А-Я()\\- ,.;]+"), is (true));
            for (Gruppa currGruppa:testDictionary.getChildrenGruppa(currRazdel.getRazdelCode())){
                MatcherAssert.assertThat(currGruppa.isActual(), is (true));
                MatcherAssert.assertThat(currGruppa.getGruppaCode().matches("\\d{2}"), is (true));
                MatcherAssert.assertThat(currGruppa.getParentRazdelCode().matches("\\d{2}"), is (true));
                MatcherAssert.assertThat(currGruppa.getNaim().matches(".*[|].*"),is (false));
                for (TovPoz currTovPos:testDictionary.getChildrenTovPos(currGruppa.getGruppaCode())){
                    MatcherAssert.assertThat(currTovPos.isActual(), is (true));
                    MatcherAssert.assertThat(currTovPos.getParentGruppaCode().matches("\\d{2}"), is (true));
                    MatcherAssert.assertThat(currTovPos.getTovPozCode().matches("\\d{2}"), is (true));
                    for (TovSubPoz currTovSubPos: testDictionary.getChildrenTovSubPos(currGruppa.getGruppaCode(),currTovPos.getTovPozCode())){
                        MatcherAssert.assertThat(currTovSubPos.isActual(), is (true));
                        MatcherAssert.assertThat(currTovSubPos.getParentTovPozCode().matches("\\d{2}"), is (true));
                        MatcherAssert.assertThat(currTovSubPos.getTovSubPozCode().matches("\\d{6}"), is (true));
                    }
                }
            }
        }
    }


    @Test
    public void whenCreateNewRazdel() {
        Razdel testTazdel = testDictionary.getRazdel(0);
        MatcherAssert.assertThat(testTazdel.getRazdelCode(), is("01"));
        MatcherAssert.assertThat(testTazdel.getNaim(), is("ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ"));
        MatcherAssert.assertThat(testTazdel.getPrim(), is("1. Любая ссылка в этом разделе на конкретный род или вид животного, если не оговорено иное, относится также к молодняку этого рода или вида.\n2. Во всей Номенклатуре термин \"сушеные\" продукты, если не оговорено иное, означает также продукты, подвергнутые обезвоживанию, выпариванию или сублимационной сушке."));

    }

    @Test
    public void whenCreateNewGruppa() throws Exception {
        Gruppa testGruppa = testDictionary.getGruppa(0);
        MatcherAssert.assertThat(testGruppa.getParentRazdelCode(), is("01"));
        MatcherAssert.assertThat(testGruppa.getGruppaCode(), is("01"));
        MatcherAssert.assertThat(testGruppa.getNaim(), is("ЖИВЫЕ ЖИВОТНЫЕ"));
        MatcherAssert.assertThat(testGruppa.getPrim(), is("1. В данную группу включаются все живые животные, кроме:\n(а) рыб, ракообразных, моллюсков и прочих водных беспозвоночных товарной позиции 0301, 0306, 0307 или 0308;\n(б) культур микроорганизмов и других продуктов товарной позиции 3002; и\n(в) животных товарной позиции 9508."));
        MatcherAssert.assertThat(testGruppa.getStartData(), is(format.parse("01.01.2017")));
        MatcherAssert.assertThat(testGruppa.getEndData(), is(format.parse("01.01.0000")));
    }

    @Test
    public void whenCreateNewTovPoz(){

    }
    @Test
    public void whenCreateNewTovSubPoz(){

    }

    @Test
    public void whenCreateNewRawLines(){
        RawLines testLines1 = new RawLines("dic/TNVED1.TXT");
        MatcherAssert.assertThat(testLines1.getRawData()[0],is("01|ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ|Примечания:   1. Любая ссылка в этом разделе на конкретный род или вид животного,          если не оговорено иное, относится также к молодняку этого рода или          вида.   2. Во всей Номенклатуре теpмин \"сушеные\" продукты, если не оговорено          иное, означает также продукты, подвергнутые обезвоживанию,          выпариванию или сублимационной сушке.     |01.01.2002|31.12.2006|"));
        MatcherAssert.assertThat(testLines1.getActualData()[0],is("01|ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ| 1. Любая ссылка в этом разделе на конкретный род или вид животного, если не оговорено иное, относится также к молодняку этого рода или вида. 2. Во всей Номенклатуре термин \"сушеные\" продукты, если не оговорено иное, означает также продукты, подвергнутые обезвоживанию, выпариванию или сублимационной сушке.|01.01.2017||"));
    }

    @Test
    void testGetRazdel() {
        Razdel testRazdel = testDictionary.getRazdel(0);
        MatcherAssert.assertThat(testRazdel.getRazdelCode(), is("01"));
        MatcherAssert.assertThat(testRazdel.getNaim(), is("ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ"));
        MatcherAssert.assertThat(testRazdel.getPrim(), is("1. Любая ссылка в этом разделе на конкретный род или вид животного, если не оговорено иное, относится также к молодняку этого рода или вида.\n2. Во всей Номенклатуре термин \"сушеные\" продукты, если не оговорено иное, означает также продукты, подвергнутые обезвоживанию, выпариванию или сублимационной сушке."));
        try {
            MatcherAssert.assertThat(testRazdel.getStartData(), is(format.parse("01.01.2017")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            MatcherAssert.assertThat(testRazdel.getEndData(), is(format.parse("01.01.0000")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        MatcherAssert.assertThat(testRazdel.isActual(), is(true));
    }



@Test void Other() throws ParseException {
    Razdel testRazdel = testDictionary.getRazdel(0);
    MatcherAssert.assertThat(testRazdel.getRazdelCode(), is("01"));
    MatcherAssert.assertThat(testRazdel.getNaim(), is("ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ"));
    MatcherAssert.assertThat(testRazdel.getPrim(), is("1. Любая ссылка в этом разделе на конкретный род или вид животного, если не оговорено иное, относится также к молодняку этого рода или вида.\n2. Во всей Номенклатуре термин \"сушеные\" продукты, если не оговорено иное, означает также продукты, подвергнутые обезвоживанию, выпариванию или сублимационной сушке."));
    MatcherAssert.assertThat(testRazdel.getStartData(), is(format.parse("01.01.2017")));
    MatcherAssert.assertThat(testRazdel.getEndData(), is(format.parse("01.01.0000")));
    Gruppa testGruppa = testDictionary.getGruppa(0);
    MatcherAssert.assertThat(testGruppa.getParentRazdelCode(), is("01"));
    MatcherAssert.assertThat(testGruppa.getGruppaCode(), is("01"));
    MatcherAssert.assertThat(testGruppa.getNaim(), is("ЖИВЫЕ ЖИВОТНЫЕ"));
    MatcherAssert.assertThat(testGruppa.getPrim(), is("1. В данную группу включаются все живые животные, кроме:\n(а) рыб, ракообразных, моллюсков и прочих водных беспозвоночных товарной позиции 0301, 0306, 0307 или 0308;\n(б) культур микроорганизмов и других продуктов товарной позиции 3002; и\n(в) животных товарной позиции 9508."));
    MatcherAssert.assertThat(testGruppa.getStartData(), is(format.parse("01.01.2017")));
    MatcherAssert.assertThat(testGruppa.getEndData(), is(format.parse("01.01.0000")));
}

}