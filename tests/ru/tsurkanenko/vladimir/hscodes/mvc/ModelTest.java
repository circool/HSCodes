package ru.tsurkanenko.vladimir.hscodes.mvc;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестирование класса Model
 */
class ModelTest {
    Model test;

    @BeforeEach
    void setUp() {
        test = new Model();
    }

    @Test
    void getSectionList() {
        String[] sectionList = test.getSectionList();
        MatcherAssert.assertThat(sectionList.length, is(22));
    }

    @Test
    void getGroupList() {
        test.selectSection("20 РАЗНЫЕ ПРОМЫШЛЕННЫЕ ТОВАРЫ");
        String[] groupList = test.getGroupList();
        MatcherAssert.assertThat(groupList.length, is(3));
        for (String testGroup:groupList
        ) {
            assertTrue(testGroup.startsWith("20"));
        }
    }

    @Test
    void getPositionList() {
        test.selectGroup("2095 ИГРУШКИ, ИГРЫ И СПОРТИВНЫЙ ИНВЕНТАРЬ; ИХ ЧАСТИ И ПРИНАДЛЕЖНОСТИ");
        String[] positionList = test.getPositionList();
        /*
        Начиная с версии 0&5 количество подпунктов может увеличится
        MatcherAssert.assertThat(positionList.length, is(5));
         */
        for (String testPosition:positionList
             ) {
            assertTrue(testPosition.startsWith("95"));
        }
    }

    @Test
    void getSubPositionList() {
        test.selectPosition("2620 ШЛАК, ЗОЛА И ОСТАТКИ (КРОМЕ ОБРАЗУЮЩИХСЯ В ПРОИЗВОДСТВЕ ЧЕРНЫХ МЕТАЛЛОВ), СОДЕРЖАЩИЕ МЕТАЛЛЫ, МЫШЬЯК ИЛИ ИХ СОЕДИНЕНИЯ");
        String[] subPositionList = test.getSubPositionList();
        for (String testPosition:subPositionList
        ) {
            assertTrue(testPosition.startsWith("2620"));
        }
    }

    @Test
    void selectSection() {
        test.selectSection("20 РАЗНЫЕ ПРОМЫШЛЕННЫЕ ТОВАРЫ");
        MatcherAssert.assertThat(test.getSectionList()[test.selectedSection],is("20 РАЗНЫЕ ПРОМЫШЛЕННЫЕ ТОВАРЫ"));
        String[] groupList = test.getGroupList();
        MatcherAssert.assertThat(groupList.length, is(3));
        for (String group:groupList
             ) {
            assertTrue(group.startsWith("20"));
        }
    }

    @Test
    void selectGroup() {
        test.selectSection("20 РАЗНЫЕ ПРОМЫШЛЕННЫЕ ТОВАРЫ");
        test.selectGroup("2096 РАЗНЫЕ ГОТОВЫЕ ИЗДЕЛИЯ");
        MatcherAssert.assertThat(test.getGroupList()[test.selectedGroup], is("2096 РАЗНЫЕ ГОТОВЫЕ ИЗДЕЛИЯ"));

        String[] positionList = test.getPositionList();
        /*
        Начиная с версии 05 количество подпунктов может увеличится
        MatcherAssert.assertThat(positionList.length, is(10));
         */
        for (String position:positionList
        ) {
            assertTrue(position.startsWith("96"));
        }
    }

    @Test
    void selectPosition() {
        test.selectSection("20 РАЗНЫЕ ПРОМЫШЛЕННЫЕ ТОВАРЫ");
        test.selectGroup("2096 РАЗНЫЕ ГОТОВЫЕ ИЗДЕЛИЯ");
        test.selectPosition("9607 ЗАСТЕЖКИ-МОЛНИИ И ИХ ЧАСТИ");
        MatcherAssert.assertThat(test.getPositionList()[test.selectedPosition], is("9607 ЗАСТЕЖКИ-МОЛНИИ И ИХ ЧАСТИ"));
        String[] subPositionList = test.getSubPositionList();
        MatcherAssert.assertThat(subPositionList.length, is(4));
        for (String subPosition:subPositionList
        ) {
            assertTrue(subPosition.startsWith("9607"));
        }
    }

    @Test
    void selectSubPosition() {
        test.selectSection("20 РАЗНЫЕ ПРОМЫШЛЕННЫЕ ТОВАРЫ");
        test.selectGroup("2096 РАЗНЫЕ ГОТОВЫЕ ИЗДЕЛИЯ");
        test.selectPosition("9607 ЗАСТЕЖКИ-МОЛНИИ И ИХ ЧАСТИ");
        test.selectSubPosition("9607209000 - - прочие");
        MatcherAssert.assertThat(test.getSubPositionList()[test.selectedSubPosition],is ("9607209000 - - прочие"));
        MatcherAssert.assertThat(test.getDescription(), is("РАЗНЫЕ ПРОМЫШЛЕННЫЕ ТОВАРЫ\n\tРАЗНЫЕ ГОТОВЫЕ ИЗДЕЛИЯ\n\t\tЗАСТЕЖКИ-МОЛНИИ И ИХ ЧАСТИ\n\t\t\t- - прочие"));
    }

    @Test
    void getGroupNote() {
        test.selectGroup("2299 FIFA2018");
        MatcherAssert.assertThat(test.getGroupNote(), is ("ТОВАРЫ ДЛЯ FIFA2018"));
    }

    @Test
    void getSectionNote() {
        test.selectSection("22 FIFA2018");
        MatcherAssert.assertThat(test.getSectionNote(), is ("товары для FIFA"));
    }

    @Test
    void getDescription() {
        test.selectSection("20 РАЗНЫЕ ПРОМЫШЛЕННЫЕ ТОВАРЫ");
        test.selectGroup("2096 РАЗНЫЕ ГОТОВЫЕ ИЗДЕЛИЯ");
        test.selectPosition("9607 ЗАСТЕЖКИ-МОЛНИИ И ИХ ЧАСТИ");
        test.selectSubPosition("9607209000 - - прочие");
        MatcherAssert.assertThat(test.getDescription(), is("" +
                "РАЗНЫЕ ПРОМЫШЛЕННЫЕ ТОВАРЫ\n" +
                "\tРАЗНЫЕ ГОТОВЫЕ ИЗДЕЛИЯ\n" +
                "\t\tЗАСТЕЖКИ-МОЛНИИ И ИХ ЧАСТИ\n" +
                "\t\t\t- - прочие"));
    }
}