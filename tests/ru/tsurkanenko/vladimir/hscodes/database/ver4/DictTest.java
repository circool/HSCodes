package ru.tsurkanenko.vladimir.hscodes.database.ver4;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

class DictTest {
    Dict testDictionary;
    DateFormat format;

    @BeforeEach
    void setUp() {
        testDictionary = new Dict();
        format = new SimpleDateFormat("dd.MM.yyyy");
    }

    @Test
    public void testDict() {
        for (Razdel currRazdel: testDictionary.getRazdel()
             ) {
            assertTrue(currRazdel.isActual());
            assertTrue(currRazdel.getRazdelCode().matches("\\d{2}"));
            assertTrue(currRazdel.getNaim().matches("[A-Z0-9А-Я()\\- ,.;]+"));
            for (Gruppa currGruppa:testDictionary.getChildrenGruppa(currRazdel.getRazdelCode())){
                MatcherAssert.assertThat(currGruppa.isActual(), is (true));
                assertTrue(currGruppa.getGruppaCode().matches("\\d{2}"));
                assertTrue(currGruppa.getParentRazdelCode().matches("\\d{2}"));
                assertFalse(currGruppa.getNaim().matches(".*[|].*"));
                assertEquals(currGruppa, testDictionary.getGruppa(currGruppa.getGruppaCode()));
                for (TovPoz currTovPos:testDictionary.getChildrenTovPoz(currGruppa.getGruppaCode())){
                    assertTrue(currTovPos.isActual());
                    assertTrue(currTovPos.getGruppaCode().matches("\\d{2}"));
                    assertTrue(currTovPos.getTovPozCode().matches("\\d{2}"));
                    assertEquals(currTovPos, testDictionary.getTovPoz(currGruppa.getGruppaCode(), currTovPos.getTovPozCode()));
                    for (TovSubPoz currTovSubPos: testDictionary.getChildrenTovSubPoz(currGruppa.getGruppaCode(),currTovPos.getTovPozCode())){
                        assertTrue(currTovSubPos.isActual());
                        assertTrue(currTovSubPos.getTovPozCode().matches("\\d{2}"));
                        assertTrue(currTovSubPos.getTovSubPozCode().matches("\\d{6}"));
                        assertEquals(currTovSubPos, testDictionary.getTovSubPoz(currGruppa.getGruppaCode(), currTovPos.getTovPozCode(), currTovSubPos.getTovSubPozCode()));
                    }
                }
            }
        }

        assertEquals(testDictionary.getRazdel("01"), testDictionary.getRazdel(0));
        assertEquals(testDictionary.getRazdel("22"), testDictionary.getRazdel(testDictionary.getRazdel().length - 1));

        assertEquals(testDictionary.getGruppa("01"), testDictionary.getGruppa()[0]);
        assertEquals(testDictionary.getGruppa("99"), testDictionary.getGruppa()[testDictionary.getGruppa().length - 1]);
        assertEquals(testDictionary.getGruppa("01", "01"), testDictionary.getGruppa()[0]);
        assertEquals(testDictionary.getGruppa("22", "99"), testDictionary.getGruppa()[testDictionary.getGruppa().length - 1]);

        assertEquals(testDictionary.getTovSubPoz("01", "01", "210000"), testDictionary.getTovSubPoz()[0]);
        assertEquals(testDictionary.getTovSubPoz("99", "99", "999999"), testDictionary.getTovSubPoz()[testDictionary.getTovSubPoz().length - 1]);
    }

    @Test
    public void testRazdel() throws Exception{
        Razdel[] testRazdel = testDictionary.getRazdel();
        int lastIndex = testRazdel.length-1;
        MatcherAssert.assertThat(lastIndex, is(21));
        MatcherAssert.assertThat(testRazdel[0].getRazdelCode(), is("01"));
        MatcherAssert.assertThat(testRazdel[0].getNaim(), is("ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ"));
        MatcherAssert.assertThat(testRazdel[0].getPrim(), is("1. Любая ссылка в этом разделе на конкретный род или вид животного, если не оговорено иное, относится также к молодняку этого рода или вида.\n2. Во всей Номенклатуре термин \"сушеные\" продукты, если не оговорено иное, означает также продукты, подвергнутые обезвоживанию, выпариванию или сублимационной сушке."));
        MatcherAssert.assertThat(testRazdel[0].toString(), is("01 ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ"));
        MatcherAssert.assertThat(testRazdel[0].getStartData(), is(format.parse("01.01.2017")));
        MatcherAssert.assertThat(testRazdel[0].getEndData(), is(format.parse("01.01.0000")));

        MatcherAssert.assertThat(testRazdel[lastIndex].getRazdelCode(), is("22"));
        MatcherAssert.assertThat(testRazdel[lastIndex].getNaim(), is("FIFA2018"));
        MatcherAssert.assertThat(testRazdel[lastIndex].getPrim(), is("товары для FIFA"));
        MatcherAssert.assertThat(testRazdel[lastIndex].toString(), is("22 FIFA2018"));
        MatcherAssert.assertThat(testRazdel[lastIndex].getStartData(), is(format.parse("01.07.2018")));
        MatcherAssert.assertThat(testRazdel[lastIndex].getEndData(), is(format.parse("01.01.0000")));
    }

    @Test
    public void testGruppa() throws Exception {
        Gruppa testGr = new Gruppa("21|97|ПРОИЗВЕДЕНИЯ ИСКУССТВА, ПРЕДМЕТЫ КОЛЛЕКЦИОНИРОВАНИЯ И АНТИКВАРИАТ|1. В данную группу не включаются: (а) марки почтовые или марки госпошлин негашеные, почтовые канцелярские принадлежности (гербовая бумага) или аналогичные изделия товарной позиции 4907; (б) театральные декорации, задники для художественных студий или аналогичные предметы из расписанного холста (товарная позиция 5907), за исключением тех, которые могут быть включены в товарную позицию 9706; или (в) жемчуг, природный или культивированный, или драгоценные или полудрагоценные камни (товарные позиции 7101 - 7103). 2. В товарной позиции 9702 термин \"подлинники гравюр, эстампов и литографий\" означает оттиски черно-белые или цветные, выполненные автором с одной или нескольких досок вручную, независимо от используемой автором техники или материала, за исключением механического или фотомеханического способа. 3. В товарную позицию 9703 не включаются репродукции крупносерийного производства или изделия ремесленного производства коммерческого характера, даже если эти товары нарисованы или созданы художниками. 4. (А) При условии соблюдения положений вышеуказанных примечаний 1 - 3 изделия данной группы включаются именно в данную группу, а не в какую-либо иную группу Номенклатуры. (Б) К товарной позиции 9706 не относятся товары, включаемые в предыдущие товарные позиции данной группы. 5. Рамы для картин, рисунков, пастелей, коллажей или других декоративных изображений, гравюр, эстампов или литографий должны быть отнесены к тем же позициям, что и сами произведения искусства в том случае, если характер и стоимость рам соответствуют этим произведениям. Рамы, характер и стоимость которых не соответствуют произведениям искусства, перечисленным в данном примечании, должны классифицироваться отдельно.|01.01.2017||");
        MatcherAssert.assertThat(testGr.getParentRazdelCode(), is("21"));
        MatcherAssert.assertThat(testGr.getGruppaCode(), is("97"));
        MatcherAssert.assertThat(testGr.getNaim(), is("ПРОИЗВЕДЕНИЯ ИСКУССТВА, ПРЕДМЕТЫ КОЛЛЕКЦИОНИРОВАНИЯ И АНТИКВАРИАТ"));
        MatcherAssert.assertThat(testGr.getPrim(), is("1. В данную группу не включаются:\n(а) марки почтовые или марки госпошлин негашеные, почтовые канцелярские принадлежности (гербовая бумага) или аналогичные изделия товарной позиции 4907;\n(б) театральные декорации, задники для художественных студий или аналогичные предметы из расписанного холста (товарная позиция 5907), за исключением тех, которые могут быть включены в товарную позицию 9706; или\n(в) жемчуг, природный или культивированный, или драгоценные или полудрагоценные камни (товарные позиции 7101 - 7103).\n2. В товарной позиции 9702 термин \"подлинники гравюр, эстампов и литографий\" означает оттиски черно-белые или цветные, выполненные автором с одной или нескольких досок вручную, независимо от используемой автором техники или материала, за исключением механического или фотомеханического способа.\n3. В товарную позицию 9703 не включаются репродукции крупносерийного производства или изделия ремесленного производства коммерческого характера, даже если эти товары нарисованы или созданы художниками.\n4.\n(А) При условии соблюдения положений вышеуказанных примечаний 1 - 3 изделия данной группы включаются именно в данную группу, а не в какую-либо иную группу Номенклатуры.\n(Б) К товарной позиции 9706 не относятся товары, включаемые в предыдущие товарные позиции данной группы.\n5. Рамы для картин, рисунков, пастелей, коллажей или других декоративных изображений, гравюр, эстампов или литографий должны быть отнесены к тем же позициям, что и сами произведения искусства в том случае, если характер и стоимость рам соответствуют этим произведениям. Рамы, характер и стоимость которых не соответствуют произведениям искусства, перечисленным в данном примечании, должны классифицироваться отдельно."));
        MatcherAssert.assertThat(testGr.toString(), is("2197 ПРОИЗВЕДЕНИЯ ИСКУССТВА, ПРЕДМЕТЫ КОЛЛЕКЦИОНИРОВАНИЯ И АНТИКВАРИАТ"));

        Gruppa[] testGruppa = testDictionary.getGruppa();
        int lastIndex = testGruppa.length-1;

        MatcherAssert.assertThat(testGruppa[0].getParentRazdelCode(), is("01"));
        MatcherAssert.assertThat(testGruppa[0].getGruppaCode(), is("01"));
        MatcherAssert.assertThat(testGruppa[0].getNaim(), is("ЖИВЫЕ ЖИВОТНЫЕ"));
        MatcherAssert.assertThat(testGruppa[0].getPrim(), is("1. В данную группу включаются все живые животные, кроме:\n(а) рыб, ракообразных, моллюсков и прочих водных беспозвоночных товарной позиции 0301, 0306, 0307 или 0308;\n(б) культур микроорганизмов и других продуктов товарной позиции 3002; и\n(в) животных товарной позиции 9508."));
        MatcherAssert.assertThat(testGruppa[0].getStartData(), is(format.parse("01.01.2017")));
        MatcherAssert.assertThat(testGruppa[0].getEndData(), is(format.parse("01.01.0000")));

        MatcherAssert.assertThat(testGruppa[lastIndex].getParentRazdelCode(), is("22"));
        MatcherAssert.assertThat(testGruppa[lastIndex].getGruppaCode(), is("99"));
        MatcherAssert.assertThat(testGruppa[lastIndex].getNaim(), is("FIFA2018"));
        MatcherAssert.assertThat(testGruppa[lastIndex].getPrim(), is("ТОВАРЫ ДЛЯ FIFA2018"));
        MatcherAssert.assertThat(testGruppa[lastIndex].getStartData(), is(format.parse("01.07.2018")));
        MatcherAssert.assertThat(testGruppa[lastIndex].getEndData(), is(format.parse("01.01.0000")));
    }

    @Test
    public void testTovPoz() throws ParseException {
        TovPoz[] tovPoz = testDictionary.getTovPoz();
        int lastIndex = tovPoz.length-1;

        MatcherAssert.assertThat(tovPoz[0].getGruppaCode(), is("01"));
        MatcherAssert.assertThat(tovPoz[0].getTovPozCode(), is("01"));
        MatcherAssert.assertThat(tovPoz[0].getNaim(), is("ЛОШАДИ, ОСЛЫ, МУЛЫ И ЛОШАКИ ЖИВЫЕ"));
        MatcherAssert.assertThat(tovPoz[0].toString(), is("0101 ЛОШАДИ, ОСЛЫ, МУЛЫ И ЛОШАКИ ЖИВЫЕ"));
        MatcherAssert.assertThat(tovPoz[0].getStartData(), is(format.parse("01.01.2017")));
        MatcherAssert.assertThat(tovPoz[0].getEndData(), is(format.parse("01.01.0000")));

        MatcherAssert.assertThat(tovPoz[lastIndex].getGruppaCode(), is("99"));
        MatcherAssert.assertThat(tovPoz[lastIndex].getTovPozCode(), is("99"));
        MatcherAssert.assertThat(tovPoz[lastIndex].getNaim(), is("FIFI2018"));
        MatcherAssert.assertThat(tovPoz[lastIndex].toString(), is("9999 FIFI2018"));
        MatcherAssert.assertThat(tovPoz[lastIndex].getStartData(), is(format.parse("01.07.2018")));
        MatcherAssert.assertThat(tovPoz[lastIndex].getEndData(), is(format.parse("01.01.0000")));
    }

    @Test
    public void testTovSubPoz(){
        TovSubPoz[] tovSubPoz = testDictionary.getTovSubPoz();
        int lastIndex = tovSubPoz.length-1;
        MatcherAssert.assertThat( tovSubPoz[0].getGruppaCode(),is("01"));
        MatcherAssert.assertThat(tovSubPoz[0].getTovPozCode(),is("01"));
        MatcherAssert.assertThat(tovSubPoz[0].getTovSubPozCode(),is("210000"));
        MatcherAssert.assertThat(tovSubPoz[0].getNaim(), is("- - чистопородные племенные животные"));
        MatcherAssert.assertThat(tovSubPoz[0].toString(),is ("0101210000 - - чистопородные племенные животные"));

        MatcherAssert.assertThat( tovSubPoz[lastIndex].getGruppaCode(),is("99"));
        MatcherAssert.assertThat(tovSubPoz[lastIndex].getTovPozCode(),is("99"));
        MatcherAssert.assertThat(tovSubPoz[lastIndex].getTovSubPozCode(),is("999999"));
        MatcherAssert.assertThat(tovSubPoz[lastIndex].getNaim(), is("FIFA2018"));
        MatcherAssert.assertThat(tovSubPoz[lastIndex].toString(),is ("9999999999 FIFA2018"));
    }

    @Test
    public void testRawLines(){
        RawLines testLines1 = new RawLines("dic/TNVED1.TXT");
        MatcherAssert.assertThat(testLines1.getRawData()[0],is("01|ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ|Примечания:   1. Любая ссылка в этом разделе на конкретный род или вид животного,          если не оговорено иное, относится также к молодняку этого рода или          вида.   2. Во всей Номенклатуре теpмин \"сушеные\" продукты, если не оговорено          иное, означает также продукты, подвергнутые обезвоживанию,          выпариванию или сублимационной сушке.     |01.01.2002|31.12.2006|"));
        MatcherAssert.assertThat(testLines1.getActualData()[0],is("01|ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ| 1. Любая ссылка в этом разделе на конкретный род или вид животного, если не оговорено иное, относится также к молодняку этого рода или вида. 2. Во всей Номенклатуре термин \"сушеные\" продукты, если не оговорено иное, означает также продукты, подвергнутые обезвоживанию, выпариванию или сублимационной сушке.|01.01.2017||"));
    }
}