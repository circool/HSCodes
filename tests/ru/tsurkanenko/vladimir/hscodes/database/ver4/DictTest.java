package ru.tsurkanenko.vladimir.hscodes.database.ver4;

import org.hamcrest.MatcherAssert;
import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DictTest {




    @Test
    public void whenCreateDict() throws Exception {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Dict test = new Dict();
        MatcherAssert.assertThat(test.getRazdel(0).isActual(), is(true));
    }


    @Test
    public void whenCreateNewDict() throws Exception {
        Dict test = new Dict();
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        MatcherAssert.assertThat(test.getRazdel(0).getRazdelCode(), is("01"));
        MatcherAssert.assertThat(test.getRazdel(0).getNaim(), is("ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ"));
        MatcherAssert.assertThat(test.getRazdel(0).getPrim(), is("1. Любая ссылка в этом разделе на конкретный род или вид животного, если не оговорено иное, относится также к молодняку этого рода или вида.\n2. Во всей Номенклатуре термин \"сушеные\" продукты, если не оговорено иное, означает также продукты, подвергнутые обезвоживанию, выпариванию или сублимационной сушке."));
        MatcherAssert.assertThat(test.getRazdel(0).getStartData(), is(format.parse("01.01.2017")));
        MatcherAssert.assertThat(test.getRazdel(0).getEndData(), is(format.parse("01.01.0000")));

        Gruppa gruppa = test.getGruppa(0);
        MatcherAssert.assertThat(gruppa.getParentRazdelCode(), is("01"));
        MatcherAssert.assertThat(gruppa.getGruppaCode(), is("01"));
        MatcherAssert.assertThat(gruppa.getNaim(), is("ЖИВЫЕ ЖИВОТНЫЕ"));
        MatcherAssert.assertThat(gruppa.getPrim(), is("1. В данную группу включаются все живые животные, кроме:\n(а) рыб, ракообразных, моллюсков и прочих водных беспозвоночных товарной позиции 0301, 0306, 0307 или 0308;\n(б) культур микроорганизмов и других продуктов товарной позиции 3002; и\n(в) животных товарной позиции 9508."));
        MatcherAssert.assertThat(gruppa.getStartData(), is(format.parse("01.01.2017")));
        MatcherAssert.assertThat(gruppa.getEndData(), is(format.parse("01.01.0000")));




        for (Razdel currRazdel: test.getRazdel()
             ) {
            MatcherAssert.assertThat(currRazdel.isActual(), is (true));
            MatcherAssert.assertThat(currRazdel.getRazdelCode().matches("\\d{2}"), is (true));
            String primErrors = currRazdel.getPrim();
            MatcherAssert.assertThat(primErrors.matches("\\([а-я]\\)"), is (false));
        }
        for (Gruppa currGruppa: test.getGruppa()
        ) {
            MatcherAssert.assertThat(currGruppa.isActual(), is (true));
            MatcherAssert.assertThat(currGruppa.getGruppaCode().matches("\\d{2}"), is (true));
        }
        for (TovPoz currTovPos: test.getTovPoz()){
            MatcherAssert.assertThat(currTovPos.isActual(), is (true));
            MatcherAssert.assertThat(currTovPos.ParentGruppaCode().matches("\\d{2}"), is (true));
            MatcherAssert.assertThat(currTovPos.getTovPozCode().matches("\\d{2}"), is (true));
        }
        for (TovSubPoz currTovSubPos: test.getTovSubPoz()){
            MatcherAssert.assertThat(currTovSubPos.isActual(), is (true));
            MatcherAssert.assertThat(currTovSubPos.getParentTovPozCode().matches("\\d{2}"), is (true));
            MatcherAssert.assertThat(currTovSubPos.getTovSubPozCode().matches("\\d{6}"), is (true));

        }
    }



    @Test
    public void whenCreateNewRazdel() throws Exception {


    }

    @Test
    public void whenCreateNewGruppa() throws Exception {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Dict test = new Dict();

        //Gruppa gruppa = new Gruppa("01|01|ЖИВЫЕ ЖИВОТНЫЕ|1. В данную группу включаются все живые животные, Н кроме: (а) рыб, ракообразных, моллюсков и прочих водных Н беспозвоночных товарной позиции 0301, 0306, 0307 или Н 0308; (б) культур микроорганизмов и других продуктов Н товарной позиции 3002; и (в) животных товарной позиции Н 9508.|01.01.2017||\n");
        Gruppa gruppa = test.getGruppa(0);
        MatcherAssert.assertThat(gruppa.getParentRazdelCode(), is("01"));
        MatcherAssert.assertThat(gruppa.getGruppaCode(), is("01"));
        MatcherAssert.assertThat(gruppa.getNaim(), is("ЖИВЫЕ ЖИВОТНЫЕ"));
        MatcherAssert.assertThat(gruppa.getPrim(), is("1. В данную группу включаются все живые животные, кроме:\n(а) рыб, ракообразных, моллюсков и прочих водных беспозвоночных товарной позиции 0301, 0306, 0307 или 0308;\n(б) культур микроорганизмов и других продуктов товарной позиции 3002; и\n(в) животных товарной позиции 9508."));
        MatcherAssert.assertThat(gruppa.getStartData(), is(format.parse("01.01.2017")));
        MatcherAssert.assertThat(gruppa.getEndData(), is(format.parse("01.01.0000")));
    }

    @org.junit.jupiter.api.Test
    void getRazdel() {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Dict test = new Dict();
        MatcherAssert.assertThat(test.getRazdel(0).getRazdelCode(), is("01"));
        MatcherAssert.assertThat(test.getRazdel(0).getNaim(), is("ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ"));
        MatcherAssert.assertThat(test.getRazdel(0).getPrim(), is("1. Любая ссылка в этом разделе на конкретный род или вид животного, если не оговорено иное, относится также к молодняку этого рода или вида.\n2. Во всей Номенклатуре термин \"сушеные\" продукты, если не оговорено иное, означает также продукты, подвергнутые обезвоживанию, выпариванию или сублимационной сушке."));
        try {
            MatcherAssert.assertThat(test.getRazdel(0).getStartData(), is(format.parse("01.01.2017")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            MatcherAssert.assertThat(test.getRazdel(0).getEndData(), is(format.parse("01.01.0000")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        MatcherAssert.assertThat(test.getRazdel(0).isActual(), is(true));
    }

    @org.junit.jupiter.api.Test
    void testGetRazdel() {
    }

    @org.junit.jupiter.api.Test
    void testGetRazdel1() {
    }

    @org.junit.jupiter.api.Test
    void getGruppa() {
    }

    @org.junit.jupiter.api.Test
    void testGetGruppa() {
    }

    @org.junit.jupiter.api.Test
    void testGetGruppa1() {
    }

    @org.junit.jupiter.api.Test
    void getChildrenGruppa() {
    }

    @org.junit.jupiter.api.Test
    void getTovPoz() {
    }

    @org.junit.jupiter.api.Test
    void testGetTovPoz() {
    }

    @org.junit.jupiter.api.Test
    void testGetTovPoz1() {
    }

    @org.junit.jupiter.api.Test
    void getChildrenTovPos() {
    }

    @org.junit.jupiter.api.Test
    void getTovSubPoz() {
    }

    @org.junit.jupiter.api.Test
    void getTovSubPos() {
    }

    @org.junit.jupiter.api.Test
    void testGetTovSubPos() {
    }
}