package ru.tsurkanenko.vladimir.hscodes.v53.mvc.model;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тестирование класса Model
 * @author Vladimir Tsurkanenko
 * @version 0.5.3
 * @since 0.4
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
        test.selectSection("01 ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ");
        MatcherAssert.assertThat(test.getGroupList().length, is(5));
        test.selectSection("02 ПРОДУКТЫ РАСТИТЕЛЬНОГО ПРОИСХОЖДЕНИЯ");
        MatcherAssert.assertThat(test.getGroupList().length, is(9));
        test.selectSection("03 ЖИРЫ И МАСЛА ЖИВОТНОГО ИЛИ РАСТИТЕЛЬНОГО ПРОИСХОЖДЕНИЯ И ПРОДУКТЫ ИХ РАСЩЕПЛЕНИЯ; ГОТОВЫЕ ПИЩЕВЫЕ ЖИРЫ; ВОСКИ ЖИВОТНОГО ИЛИ РАСТИТЕЛЬНОГО ПРОИСХОЖДЕНИЯ");
        MatcherAssert.assertThat(test.getGroupList().length, is(1));
        test.selectSection("04 ГОТОВЫЕ ПИЩЕВЫЕ ПРОДУКТЫ; АЛКОГОЛЬНЫЕ И БЕЗАЛКОГОЛЬНЫЕ НАПИТКИ И УКСУС; ТАБАК И ЕГО ЗАМЕНИТЕЛИ");
        MatcherAssert.assertThat(test.getGroupList().length, is(9));
        test.selectSection("05 МИНЕРАЛЬНЫЕ ПРОДУКТЫ");
        MatcherAssert.assertThat(test.getGroupList().length, is(3));
        test.selectSection("06 ПРОДУКЦИЯ ХИМИЧЕСКОЙ И СВЯЗАННЫХ С НЕЙ ОТРАСЛЕЙ ПРОМЫШЛЕННОСТИ");
        MatcherAssert.assertThat(test.getGroupList().length, is(11));
        test.selectSection("07 ПЛАСТМАССЫ И ИЗДЕЛИЯ ИЗ НИХ; КАУЧУК, РЕЗИНА И ИЗДЕЛИЯ ИЗ НИХ");
        MatcherAssert.assertThat(test.getGroupList().length, is(2));
        test.selectSection("08 НЕОБРАБОТАННЫЕ ШКУРЫ, ВЫДЕЛАННАЯ КОЖА, НАТУРАЛЬНЫЙ МЕХ И ИЗДЕЛИЯ ИЗ НИХ; ШОРНО-СЕДЕЛЬНЫЕ ИЗДЕЛИЯ И УПРЯЖЬ; ДОРОЖНЫЕ ПРИНАДЛЕЖНОСТИ, СУМКИ И АНАЛОГИЧНЫЕ ИМ ТОВАРЫ; ИЗДЕЛИЯ ИЗ ВНУТРЕННИХ ОРГАНОВ ЖИВОТНЫХ (КРОМЕ ШЕЛКООТДЕЛИТЕЛЬНЫХ ЖЕЛЕЗ ШЕЛКОПРЯДА)");
        MatcherAssert.assertThat(test.getGroupList().length, is(3));
        test.selectSection("09 ДРЕВЕСИНА И ИЗДЕЛИЯ ИЗ НЕЕ; ДРЕВЕСНЫЙ УГОЛЬ; ПРОБКА И ИЗДЕЛИЯ ИЗ НЕЕ; ИЗДЕЛИЯ ИЗ СОЛОМЫ, АЛЬФЫ ИЛИ ИЗ ПРОЧИХ МАТЕРИАЛОВ ДЛЯ ПЛЕТЕНИЯ; КОРЗИНОЧНЫЕ И ДРУГИЕ ПЛЕТЕНЫЕ ИЗДЕЛИЯ");
        MatcherAssert.assertThat(test.getGroupList().length, is(3));
        test.selectSection("10 МАССА ИЗ ДРЕВЕСИНЫ ИЛИ ИЗ ДРУГИХ ВОЛОКНИСТЫХ ЦЕЛЛЮЛОЗНЫХ МАТЕРИАЛОВ; РЕГЕНЕРИРУЕМЫЕ БУМАГА ИЛИ КАРТОН (МАКУЛАТУРА И ОТХОДЫ); БУМАГА, КАРТОН И ИЗДЕЛИЯ ИЗ НИХ");
        MatcherAssert.assertThat(test.getGroupList().length, is(3));
        test.selectSection("11 ТЕКСТИЛЬНЫЕ МАТЕРИАЛЫ И ТЕКСТИЛЬНЫЕ ИЗДЕЛИЯ");
        MatcherAssert.assertThat(test.getGroupList().length, is(14));
        test.selectSection("12 ОБУВЬ, ГОЛОВНЫЕ УБОРЫ, ЗОНТЫ, СОЛНЦЕЗАЩИТНЫЕ ЗОНТЫ, ТРОСТИ, ТРОСТИ-СИДЕНЬЯ, ХЛЫСТЫ, КНУТЫ И ИХ ЧАСТИ; ОБРАБОТАННЫЕ ПЕРЬЯ И ИЗДЕЛИЯ ИЗ НИХ; ИСКУССТВЕННЫЕ ЦВЕТЫ; ИЗДЕЛИЯ ИЗ ЧЕЛОВЕЧЕСКОГО ВОЛОСА");
        MatcherAssert.assertThat(test.getGroupList().length, is(4));
        test.selectSection("13 ИЗДЕЛИЯ ИЗ КАМНЯ, ГИПСА, ЦЕМЕНТА, АСБЕСТА, СЛЮДЫ ИЛИ АНАЛОГИЧНЫХ МАТЕРИАЛОВ; КЕРАМИЧЕСКИЕ ИЗДЕЛИЯ; СТЕКЛО И ИЗДЕЛИЯ ИЗ НЕГО");
        MatcherAssert.assertThat(test.getGroupList().length, is(3));
        test.selectSection("14 ЖЕМЧУГ ПРИРОДНЫЙ ИЛИ КУЛЬТИВИРОВАННЫЙ, ДРАГОЦЕННЫЕ ИЛИ ПОЛУДРАГОЦЕННЫЕ КАМНИ, ДРАГОЦЕННЫЕ МЕТАЛЛЫ, МЕТАЛЛЫ, ПЛАКИРОВАННЫЕ ДРАГОЦЕННЫМИ МЕТАЛЛАМИ, И ИЗДЕЛИЯ ИЗ НИХ; БИЖУТЕРИЯ; МОНЕТЫ");
        MatcherAssert.assertThat(test.getGroupList().length, is(1));
        test.selectSection("15 НЕДРАГОЦЕННЫЕ МЕТАЛЛЫ И ИЗДЕЛИЯ ИЗ НИХ");
        MatcherAssert.assertThat(test.getGroupList().length, is(11));
        test.selectSection("16 МАШИНЫ, ОБОРУДОВАНИЕ И МЕХАНИЗМЫ; ЭЛЕКТРОТЕХНИЧЕСКОЕ ОБОРУДОВАНИЕ; ИХ ЧАСТИ; ЗВУКОЗАПИСЫВАЮЩАЯ И ЗВУКОВОСПРОИЗВОДЯЩАЯ АППАРАТУРА, АППАРАТУРА ДЛЯ ЗАПИСИ И ВОСПРОИЗВЕДЕНИЯ ТЕЛЕВИЗИОННОГО ИЗОБРАЖЕНИЯ И ЗВУКА, ИХ ЧАСТИ И ПРИНАДЛЕЖНОСТИ");
        MatcherAssert.assertThat(test.getGroupList().length, is(2));
        test.selectSection("17 СРЕДСТВА НАЗЕМНОГО ТРАНСПОРТА, ЛЕТАТЕЛЬНЫЕ АППАРАТЫ, ПЛАВУЧИЕ СРЕДСТВА И ОТНОСЯЩИЕСЯ К ТРАНСПОРТУ УСТРОЙСТВА И ОБОРУДОВАНИЕ");
        MatcherAssert.assertThat(test.getGroupList().length, is(4));
        test.selectSection("18 ИНСТРУМЕНТЫ И АППАРАТЫ ОПТИЧЕСКИЕ, ФОТОГРАФИЧЕСКИЕ, КИНЕМАТОГРАФИЧЕСКИЕ, ИЗМЕРИТЕЛЬНЫЕ, КОНТРОЛЬНЫЕ, ПРЕЦИЗИОННЫЕ, МЕДИЦИНСКИЕ ИЛИ ХИРУРГИЧЕСКИЕ; ЧАСЫ ВСЕХ ВИДОВ; МУЗЫКАЛЬНЫЕ ИНСТРУМЕНТЫ; ИХ ЧАСТИ И ПРИНАДЛЕЖНОСТИ");
        MatcherAssert.assertThat(test.getGroupList().length, is(3));
        test.selectSection("19 ОРУЖИЕ И БОЕПРИПАСЫ; ИХ ЧАСТИ И ПРИНАДЛЕЖНОСТИ");
        MatcherAssert.assertThat(test.getGroupList().length, is(1));
        test.selectSection("20 РАЗНЫЕ ПРОМЫШЛЕННЫЕ ТОВАРЫ");
        MatcherAssert.assertThat(test.getGroupList().length, is(3));
        test.selectSection("21 ПРОИЗВЕДЕНИЯ ИСКУССТВА, ПРЕДМЕТЫ КОЛЛЕКЦИОНИРОВАНИЯ И АНТИКВАРИАТ");
        MatcherAssert.assertThat(test.getGroupList().length, is(1));
        test.selectSection("22 FIFA2018");
        MatcherAssert.assertThat(test.getGroupList().length, is(1));
    }

    @Test
    void getPositionList() {
        test.selectSection("01 ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ");
        test.selectGroup("01 ЖИВЫЕ ЖИВОТНЫЕ");
        MatcherAssert.assertThat(test.getPositionList().length, is(6));
        test.selectGroup("05 ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ, В ДРУГОМ МЕСТЕ НЕ ПОИМЕНОВАННЫЕ ИЛИ НЕ ВКЛЮЧЕННЫЕ");
        MatcherAssert.assertThat(test.getPositionList().length, is(5));

        test.selectSection("02 ПРОДУКТЫ РАСТИТЕЛЬНОГО ПРОИСХОЖДЕНИЯ");
        test.selectGroup("06 ЖИВЫЕ ДЕРЕВЬЯ И ДРУГИЕ РАСТЕНИЯ; ЛУКОВИЦЫ, КОРНИ И ПРОЧИЕ АНАЛОГИЧНЫЕ ЧАСТИ РАСТЕНИЙ; СРЕЗАННЫЕ ЦВЕТЫ И ДЕКОРАТИВНАЯ ЗЕЛЕНЬ");
        MatcherAssert.assertThat(test.getPositionList().length, is(4));
        test.selectGroup("14 РАСТИТЕЛЬНЫЕ МАТЕРИАЛЫ ДЛЯ ИЗГОТОВЛЕНИЯ ПЛЕТЕНЫХ ИЗДЕЛИЙ; ПРОЧИЕ ПРОДУКТЫ РАСТИТЕЛЬНОГО ПРОИСХОЖДЕНИЯ, В ДРУГОМ МЕСТЕ НЕ ПОИМЕНОВАННЫЕ ИЛИ НЕ ВКЛЮЧЕННЫЕ");
        MatcherAssert.assertThat(test.getPositionList().length, is(2));

        test.selectSection("03 ЖИРЫ И МАСЛА ЖИВОТНОГО ИЛИ РАСТИТЕЛЬНОГО ПРОИСХОЖДЕНИЯ И ПРОДУКТЫ ИХ РАСЩЕПЛЕНИЯ; ГОТОВЫЕ ПИЩЕВЫЕ ЖИРЫ; ВОСКИ ЖИВОТНОГО ИЛИ РАСТИТЕЛЬНОГО ПРОИСХОЖДЕНИЯ");
        test.selectGroup("15 ЖИРЫ И МАСЛА ЖИВОТНОГО ИЛИ РАСТИТЕЛЬНОГО ПРОИСХОЖДЕНИЯ И ПРОДУКТЫ ИХ РАСЩЕПЛЕНИЯ; ГОТОВЫЕ ПИЩЕВЫЕ ЖИРЫ; ВОСКИ ЖИВОТНОГО ИЛИ РАСТИТЕЛЬНОГО ПРОИСХОЖДЕНИЯ");
        MatcherAssert.assertThat(test.getPositionList().length, is(14));

        test.selectSection("04 ГОТОВЫЕ ПИЩЕВЫЕ ПРОДУКТЫ; АЛКОГОЛЬНЫЕ И БЕЗАЛКОГОЛЬНЫЕ НАПИТКИ И УКСУС; ТАБАК И ЕГО ЗАМЕНИТЕЛИ");
        test.selectGroup("16 ГОТОВЫЕ ПРОДУКТЫ ИЗ МЯСА, РЫБЫ ИЛИ РАКООБРАЗНЫХ, МОЛЛЮСКОВ ИЛИ ПРОЧИХ ВОДНЫХ БЕСПОЗВОНОЧНЫХ");
        MatcherAssert.assertThat(test.getPositionList().length, is(3));
        test.selectGroup("24 ТАБАК И ПРОМЫШЛЕННЫЕ ЗАМЕНИТЕЛИ ТАБАКА");
        MatcherAssert.assertThat(test.getPositionList().length, is(3));

        test.selectSection("05 МИНЕРАЛЬНЫЕ ПРОДУКТЫ");
        test.selectGroup("25 СОЛЬ; СЕРА; ЗЕМЛИ И КАМЕНЬ; ШТУКАТУРНЫЕ МАТЕРИАЛЫ, ИЗВЕСТЬ И ЦЕМЕНТ");
        MatcherAssert.assertThat(test.getPositionList().length, is(20));
        test.selectGroup("27 ТОПЛИВО МИНЕРАЛЬНОЕ, НЕФТЬ И ПРОДУКТЫ ИХ ПЕРЕГОНКИ; БИТУМИНОЗНЫЕ ВЕЩЕСТВА; ВОСКИ МИНЕРАЛЬНЫЕ");
        MatcherAssert.assertThat(test.getPositionList().length, is(9));

        test.selectSection("06 ПРОДУКЦИЯ ХИМИЧЕСКОЙ И СВЯЗАННЫХ С НЕЙ ОТРАСЛЕЙ ПРОМЫШЛЕННОСТИ");
        test.selectGroup("28 ПРОДУКТЫ НЕОРГАНИЧЕСКОЙ ХИМИИ; СОЕДИНЕНИЯ НЕОРГАНИЧЕСКИЕ ИЛИ ОРГАНИЧЕСКИЕ ДРАГОЦЕННЫХ МЕТАЛЛОВ, РЕДКОЗЕМЕЛЬНЫХ МЕТАЛЛОВ, РАДИОАКТИВНЫХ ЭЛЕМЕНТОВ ИЛИ ИЗОТОПОВ");
        MatcherAssert.assertThat(test.getPositionList().length, is(40));
        test.selectGroup("38 ПРОЧИЕ ХИМИЧЕСКИЕ ПРОДУКТЫ");
        MatcherAssert.assertThat(test.getPositionList().length, is(13));

        test.selectSection("07 ПЛАСТМАССЫ И ИЗДЕЛИЯ ИЗ НИХ; КАУЧУК, РЕЗИНА И ИЗДЕЛИЯ ИЗ НИХ");
        test.selectGroup("39 ПЛАСТМАССЫ И ИЗДЕЛИЯ ИЗ НИХ");
        MatcherAssert.assertThat(test.getPositionList().length, is(24));
        test.selectGroup("40 КАУЧУК, РЕЗИНА И ИЗДЕЛИЯ ИЗ НИХ");
        MatcherAssert.assertThat(test.getPositionList().length, is(13));

        test.selectSection("08 НЕОБРАБОТАННЫЕ ШКУРЫ, ВЫДЕЛАННАЯ КОЖА, НАТУРАЛЬНЫЙ МЕХ И ИЗДЕЛИЯ ИЗ НИХ; ШОРНО-СЕДЕЛЬНЫЕ ИЗДЕЛИЯ И УПРЯЖЬ; ДОРОЖНЫЕ ПРИНАДЛЕЖНОСТИ, СУМКИ И АНАЛОГИЧНЫЕ ИМ ТОВАРЫ; ИЗДЕЛИЯ ИЗ ВНУТРЕННИХ ОРГАНОВ ЖИВОТНЫХ (КРОМЕ ШЕЛКООТДЕЛИТЕЛЬНЫХ ЖЕЛЕЗ ШЕЛКОПРЯДА)");
        test.selectGroup("41 НЕОБРАБОТАННЫЕ ШКУРЫ (КРОМЕ НАТУРАЛЬНОГО МЕХА) И ВЫДЕЛАННАЯ КОЖА");
        MatcherAssert.assertThat(test.getPositionList().length, is(10));
        test.selectGroup("43 НАТУРАЛЬНЫЙ И ИСКУССТВЕННЫЙ МЕХ; ИЗДЕЛИЯ ИЗ НЕГО");
        MatcherAssert.assertThat(test.getPositionList().length, is(3));

        test.selectSection("09 ДРЕВЕСИНА И ИЗДЕЛИЯ ИЗ НЕЕ; ДРЕВЕСНЫЙ УГОЛЬ; ПРОБКА И ИЗДЕЛИЯ ИЗ НЕЕ; ИЗДЕЛИЯ ИЗ СОЛОМЫ, АЛЬФЫ ИЛИ ИЗ ПРОЧИХ МАТЕРИАЛОВ ДЛЯ ПЛЕТЕНИЯ; КОРЗИНОЧНЫЕ И ДРУГИЕ ПЛЕТЕНЫЕ ИЗДЕЛИЯ");
        test.selectGroup("44 ДРЕВЕСИНА И ИЗДЕЛИЯ ИЗ НЕЕ; ДРЕВЕСНЫЙ УГОЛЬ");
        MatcherAssert.assertThat(test.getPositionList().length, is(16));
        test.selectGroup("46 ИЗДЕЛИЯ ИЗ СОЛОМЫ, АЛЬФЫ ИЛИ ПРОЧИХ МАТЕРИАЛОВ ДЛЯ ПЛЕТЕНИЯ; КОРЗИНОЧНЫЕ ИЗДЕЛИЯ И ПЛЕТЕНЫЕ ИЗДЕЛИЯ");
        MatcherAssert.assertThat(test.getPositionList().length, is(2));

        test.selectSection("10 МАССА ИЗ ДРЕВЕСИНЫ ИЛИ ИЗ ДРУГИХ ВОЛОКНИСТЫХ ЦЕЛЛЮЛОЗНЫХ МАТЕРИАЛОВ; РЕГЕНЕРИРУЕМЫЕ БУМАГА ИЛИ КАРТОН (МАКУЛАТУРА И ОТХОДЫ); БУМАГА, КАРТОН И ИЗДЕЛИЯ ИЗ НИХ");
        test.selectGroup("47 МАССА ИЗ ДРЕВЕСИНЫ ИЛИ ИЗ ДРУГИХ ВОЛОКНИСТЫХ ЦЕЛЛЮЛОЗНЫХ МАТЕРИАЛОВ; РЕГЕНЕРИРУЕМЫЕ БУМАГА ИЛИ КАРТОН (МАКУЛАТУРА И ОТХОДЫ)");
        MatcherAssert.assertThat(test.getPositionList().length, is(4));
        test.selectGroup("49 ПЕЧАТНЫЕ КНИГИ, ГАЗЕТЫ, РЕПРОДУКЦИИ И ДРУГИЕ ИЗДЕЛИЯ ПОЛИГРАФИЧЕСКОЙ ПРОМЫШЛЕННОСТИ; РУКОПИСИ, МАШИНОПИСНЫЕ ТЕКСТЫ И ПЛАНЫ");
        MatcherAssert.assertThat(test.getPositionList().length, is(5));

        test.selectSection("11 ТЕКСТИЛЬНЫЕ МАТЕРИАЛЫ И ТЕКСТИЛЬНЫЕ ИЗДЕЛИЯ");
        test.selectGroup("50 ШЕЛК");
        MatcherAssert.assertThat(test.getPositionList().length, is(1));
        test.selectGroup("63 ПРОЧИЕ ГОТОВЫЕ ТЕКСТИЛЬНЫЕ ИЗДЕЛИЯ; НАБОРЫ; ОДЕЖДА И ТЕКСТИЛЬНЫЕ ИЗДЕЛИЯ, БЫВШИЕ В УПОТРЕБЛЕНИИ; ТРЯПЬЕ");
        MatcherAssert.assertThat(test.getPositionList().length, is(8));

        test.selectSection("12 ОБУВЬ, ГОЛОВНЫЕ УБОРЫ, ЗОНТЫ, СОЛНЦЕЗАЩИТНЫЕ ЗОНТЫ, ТРОСТИ, ТРОСТИ-СИДЕНЬЯ, ХЛЫСТЫ, КНУТЫ И ИХ ЧАСТИ; ОБРАБОТАННЫЕ ПЕРЬЯ И ИЗДЕЛИЯ ИЗ НИХ; ИСКУССТВЕННЫЕ ЦВЕТЫ; ИЗДЕЛИЯ ИЗ ЧЕЛОВЕЧЕСКОГО ВОЛОСА");
        test.selectGroup("64 ОБУВЬ, ГЕТРЫ И АНАЛОГИЧНЫЕ ИЗДЕЛИЯ; ИХ ДЕТАЛИ");
        MatcherAssert.assertThat(test.getPositionList().length, is(6));
        test.selectGroup("67 ОБРАБОТАННЫЕ ПЕРЬЯ И ПУХ И ИЗДЕЛИЯ ИЗ ПЕРЬЕВ ИЛИ ПУХА; ИСКУССТВЕННЫЕ ЦВЕТЫ; ИЗДЕЛИЯ ИЗ ЧЕЛОВЕЧЕСКОГО ВОЛОСА");
        MatcherAssert.assertThat(test.getPositionList().length, is(2));

        test.selectSection("13 ИЗДЕЛИЯ ИЗ КАМНЯ, ГИПСА, ЦЕМЕНТА, АСБЕСТА, СЛЮДЫ ИЛИ АНАЛОГИЧНЫХ МАТЕРИАЛОВ; КЕРАМИЧЕСКИЕ ИЗДЕЛИЯ; СТЕКЛО И ИЗДЕЛИЯ ИЗ НЕГО");
        test.selectGroup("68 ИЗДЕЛИЯ ИЗ КАМНЯ, ГИПСА, ЦЕМЕНТА, АСБЕСТА, СЛЮДЫ ИЛИ АНАЛОГИЧНЫХ МАТЕРИАЛОВ");
        MatcherAssert.assertThat(test.getPositionList().length, is(12));
        test.selectGroup("70 СТЕКЛО И ИЗДЕЛИЯ ИЗ НЕГО");
        MatcherAssert.assertThat(test.getPositionList().length, is(14));

        test.selectSection("14 ЖЕМЧУГ ПРИРОДНЫЙ ИЛИ КУЛЬТИВИРОВАННЫЙ, ДРАГОЦЕННЫЕ ИЛИ ПОЛУДРАГОЦЕННЫЕ КАМНИ, ДРАГОЦЕННЫЕ МЕТАЛЛЫ, МЕТАЛЛЫ, ПЛАКИРОВАННЫЕ ДРАГОЦЕННЫМИ МЕТАЛЛАМИ, И ИЗДЕЛИЯ ИЗ НИХ; БИЖУТЕРИЯ; МОНЕТЫ");
        test.selectGroup("71 ЖЕМЧУГ ПРИРОДНЫЙ ИЛИ КУЛЬТИВИРОВАННЫЙ, ДРАГОЦЕННЫЕ ИЛИ ПОЛУДРАГОЦЕННЫЕ КАМНИ, ДРАГОЦЕННЫЕ МЕТАЛЛЫ, МЕТАЛЛЫ, ПЛАКИРОВАННЫЕ ДРАГОЦЕННЫМИ МЕТАЛЛАМИ, И ИЗДЕЛИЯ ИЗ НИХ; БИЖУТЕРИЯ; МОНЕТЫ");
        MatcherAssert.assertThat(test.getPositionList().length, is(15));

        test.selectSection("15 НЕДРАГОЦЕННЫЕ МЕТАЛЛЫ И ИЗДЕЛИЯ ИЗ НИХ");
        test.selectGroup("72 ЧЕРНЫЕ МЕТАЛЛЫ");
        MatcherAssert.assertThat(test.getPositionList().length, is(27));
        test.selectGroup("83 ПРОЧИЕ ИЗДЕЛИЯ ИЗ НЕДРАГОЦЕННЫХ МЕТАЛЛОВ");
        MatcherAssert.assertThat(test.getPositionList().length, is(8));

        test.selectSection("16 МАШИНЫ, ОБОРУДОВАНИЕ И МЕХАНИЗМЫ; ЭЛЕКТРОТЕХНИЧЕСКОЕ ОБОРУДОВАНИЕ; ИХ ЧАСТИ; ЗВУКОЗАПИСЫВАЮЩАЯ И ЗВУКОВОСПРОИЗВОДЯЩАЯ АППАРАТУРА, АППАРАТУРА ДЛЯ ЗАПИСИ И ВОСПРОИЗВЕДЕНИЯ ТЕЛЕВИЗИОННОГО ИЗОБРАЖЕНИЯ И ЗВУКА, ИХ ЧАСТИ И ПРИНАДЛЕЖНОСТИ");
        test.selectGroup("84 РЕАКТОРЫ ЯДЕРНЫЕ, КОТЛЫ, ОБОРУДОВАНИЕ И МЕХАНИЧЕСКИЕ УСТРОЙСТВА; ИХ ЧАСТИ");
        MatcherAssert.assertThat(test.getPositionList().length, is(83));
        test.selectGroup("85 ЭЛЕКТРИЧЕСКИЕ МАШИНЫ И ОБОРУДОВАНИЕ, ИХ ЧАСТИ; ЗВУКОЗАПИСЫВАЮЩАЯ И ЗВУКОВОСПРОИЗВОДЯЩАЯ АППАРАТУРА, АППАРАТУРА ДЛЯ ЗАПИСИ И ВОСПРОИЗВЕДЕНИЯ ТЕЛЕВИЗИОННОГО ИЗОБРАЖЕНИЯ И ЗВУКА, ИХ ЧАСТИ И ПРИНАДЛЕЖНОСТИ");
        MatcherAssert.assertThat(test.getPositionList().length, is(44));

        test.selectSection("17 СРЕДСТВА НАЗЕМНОГО ТРАНСПОРТА, ЛЕТАТЕЛЬНЫЕ АППАРАТЫ, ПЛАВУЧИЕ СРЕДСТВА И ОТНОСЯЩИЕСЯ К ТРАНСПОРТУ УСТРОЙСТВА И ОБОРУДОВАНИЕ");
        test.selectGroup("86 ЖЕЛЕЗНОДОРОЖНЫЕ ЛОКОМОТИВЫ ИЛИ МОТОРНЫЕ ВАГОНЫ ТРАМВАЯ, ПОДВИЖНОЙ СОСТАВ И ИХ ЧАСТИ; ПУТЕВОЕ ОБОРУДОВАНИЕ И УСТРОЙСТВА ДЛЯ ЖЕЛЕЗНЫХ ДОРОГ ИЛИ ТРАМВАЙНЫХ ПУТЕЙ И ИХ ЧАСТИ; МЕХАНИЧЕСКОЕ (ВКЛЮЧАЯ ЭЛЕКТРОМЕХАНИЧЕСКОЕ) СИГНАЛЬНОЕ ОБОРУДОВАНИЕ ВСЕХ ВИДОВ");
        MatcherAssert.assertThat(test.getPositionList().length, is(5));
        test.selectGroup("89 СУДА, ЛОДКИ И ПЛАВУЧИЕ КОНСТРУКЦИИ");
        MatcherAssert.assertThat(test.getPositionList().length, is(5));

        test.selectSection("18 ИНСТРУМЕНТЫ И АППАРАТЫ ОПТИЧЕСКИЕ, ФОТОГРАФИЧЕСКИЕ, КИНЕМАТОГРАФИЧЕСКИЕ, ИЗМЕРИТЕЛЬНЫЕ, КОНТРОЛЬНЫЕ, ПРЕЦИЗИОННЫЕ, МЕДИЦИНСКИЕ ИЛИ ХИРУРГИЧЕСКИЕ; ЧАСЫ ВСЕХ ВИДОВ; МУЗЫКАЛЬНЫЕ ИНСТРУМЕНТЫ; ИХ ЧАСТИ И ПРИНАДЛЕЖНОСТИ");
        test.selectGroup("90 ИНСТРУМЕНТЫ И АППАРАТЫ ОПТИЧЕСКИЕ, ФОТОГРАФИЧЕСКИЕ, КИНЕМАТОГРАФИЧЕСКИЕ, ИЗМЕРИТЕЛЬНЫЕ, КОНТРОЛЬНЫЕ, ПРЕЦИЗИОННЫЕ, МЕДИЦИНСКИЕ ИЛИ ХИРУРГИЧЕСКИЕ; ИХ ЧАСТИ И ПРИНАДЛЕЖНОСТИ");
        MatcherAssert.assertThat(test.getPositionList().length, is(28));
        test.selectGroup("92 ИНСТРУМЕНТЫ МУЗЫКАЛЬНЫЕ; ИХ ЧАСТИ И ПРИНАДЛЕЖНОСТИ");
        MatcherAssert.assertThat(test.getPositionList().length, is(6));

        test.selectSection("19 ОРУЖИЕ И БОЕПРИПАСЫ; ИХ ЧАСТИ И ПРИНАДЛЕЖНОСТИ");
        test.selectGroup("93 ОРУЖИЕ И БОЕПРИПАСЫ; ИХ ЧАСТИ И ПРИНАДЛЕЖНОСТИ");
        MatcherAssert.assertThat(test.getPositionList().length, is(4));

        test.selectSection("20 РАЗНЫЕ ПРОМЫШЛЕННЫЕ ТОВАРЫ");
        test.selectGroup("94 МЕБЕЛЬ; ПОСТЕЛЬНЫЕ ПРИНАДЛЕЖНОСТИ, МАТРАЦЫ, ОСНОВЫ МАТРАЦНЫЕ, ДИВАННЫЕ ПОДУШКИ И АНАЛОГИЧНЫЕ НАБИВНЫЕ ПРИНАДЛЕЖНОСТИ МЕБЕЛИ; ЛАМПЫ И ОСВЕТИТЕЛЬНОЕ ОБОРУДОВАНИЕ, В ДРУГОМ МЕСТЕ НЕ ПОИМЕНОВАННЫЕ ИЛИ НЕ ВКЛЮЧЕННЫЕ; СВЕТОВЫЕ ВЫВЕСКИ, СВЕТОВЫЕ ТАБЛИЧКИ С ИМЕНЕМ ИЛИ НАЗВАНИЕМ, ИЛИ АДРЕСОМ И АНАЛОГИЧНЫЕ ИЗДЕЛИЯ; СБОРНЫЕ СТРОИТЕЛЬНЫЕ КОНСТРУКЦИИ");
        MatcherAssert.assertThat(test.getPositionList().length, is(6));
        test.selectGroup("96 РАЗНЫЕ ГОТОВЫЕ ИЗДЕЛИЯ");
        MatcherAssert.assertThat(test.getPositionList().length, is(11));

        test.selectSection("21 ПРОИЗВЕДЕНИЯ ИСКУССТВА, ПРЕДМЕТЫ КОЛЛЕКЦИОНИРОВАНИЯ И АНТИКВАРИАТ");
        test.selectGroup("97 ПРОИЗВЕДЕНИЯ ИСКУССТВА, ПРЕДМЕТЫ КОЛЛЕКЦИОНИРОВАНИЯ И АНТИКВАРИАТ");
        MatcherAssert.assertThat(test.getPositionList().length, is(1));
        test.selectSection("22 FIFA2018");
        test.selectGroup("99 FIFA2018");
        MatcherAssert.assertThat(test.getPositionList().length, is(1));
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
        MatcherAssert.assertThat(test.getSectionList()[test.getSelectedSection()],is("20 РАЗНЫЕ ПРОМЫШЛЕННЫЕ ТОВАРЫ"));
        String[] groupList = test.getGroupList();
        MatcherAssert.assertThat(groupList.length, is(3));
        /*
        не актуально для версии 0.4.1
        for (String group:groupList

             ) {
            assertTrue(group.startsWith("20"));
        }
        */
    }

    @Test
    void selectGroup() {
        test.selectSection("20 РАЗНЫЕ ПРОМЫШЛЕННЫЕ ТОВАРЫ");
        test.selectGroup("96 РАЗНЫЕ ГОТОВЫЕ ИЗДЕЛИЯ");
        MatcherAssert.assertThat(test.getGroupList()[test.getSelectedGroup()], is("96 РАЗНЫЕ ГОТОВЫЕ ИЗДЕЛИЯ"));

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
        test.selectGroup("96 РАЗНЫЕ ГОТОВЫЕ ИЗДЕЛИЯ");
        test.selectPosition("9607 ЗАСТЕЖКИ-МОЛНИИ И ИХ ЧАСТИ");
        MatcherAssert.assertThat(test.getPositionList()[test.getSelectedPosition()], is("9607 ЗАСТЕЖКИ-МОЛНИИ И ИХ ЧАСТИ"));

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
        test.selectGroup("96 РАЗНЫЕ ГОТОВЫЕ ИЗДЕЛИЯ");
        test.selectPosition("9607 ЗАСТЕЖКИ-МОЛНИИ И ИХ ЧАСТИ");
        test.selectSubPosition("9607209000 - - прочие");
        MatcherAssert.assertThat(test.getSubPositionList()[test.getSelectedSubPosition()],is ("9607209000 - - прочие"));
        MatcherAssert.assertThat(test.getDescription(), is(
                "РАЗНЫЕ ПРОМЫШЛЕННЫЕ ТОВАРЫ\n" +
                        "\tРАЗНЫЕ ГОТОВЫЕ ИЗДЕЛИЯ\n" +
                        "\t\tЗАСТЕЖКИ-МОЛНИИ И ИХ ЧАСТИ\n" +
                        "\t\t\t- - прочие"
        ));
    }

    @Test
    void getGroupNote() {
        test.selectSection("22 FIFA2018");
        test.selectGroup("99 FIFA2018");
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
        test.selectGroup("96 РАЗНЫЕ ГОТОВЫЕ ИЗДЕЛИЯ");
        test.selectPosition("9607 ЗАСТЕЖКИ-МОЛНИИ И ИХ ЧАСТИ");
        test.selectSubPosition("9607209000 - - прочие");
        MatcherAssert.assertThat(test.getDescription(), is("" +
                "РАЗНЫЕ ПРОМЫШЛЕННЫЕ ТОВАРЫ\n" +
                "\tРАЗНЫЕ ГОТОВЫЕ ИЗДЕЛИЯ\n" +
                "\t\tЗАСТЕЖКИ-МОЛНИИ И ИХ ЧАСТИ\n" +
                "\t\t\t- - прочие"));
    }
}