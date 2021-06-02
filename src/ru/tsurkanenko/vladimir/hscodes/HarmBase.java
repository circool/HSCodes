package ru.tsurkanenko.vladimir.hscodes;

/**
 * @version 1.0
 * @author Vladimir Tsurkanenko
 * Объект, инкапсулирующий перечни разделов, групп, подгрупп и товарных позиций справочника ТНВЭД
 * Данные справочника получены из файлов dic/TNVED?.TXT
 * Справочник доступен по адресу https://www.nalog.gov.ru/rn77/program/5961290/
 */

public class HarmBase {
    private HarmArray section, subsection, group, item;
    public HarmBase() {
        section = new HarmArray("dic/TNVED1.TXT");
        subsection = new HarmArray("dic/TNVED2.TXT");
        group = new HarmArray("dic/TNVED3.TXT");
        item = new HarmArray("dic/TNVED4.TXT");
    }

    /**
     * Возвращаем массив с разделами ТНВЭД
     * @return массив с разделами
     */
    public HarmArray getSections() {
        return section;
    }
    /**
     * Возвращаем массив с подразделами ТНВЭД
     * @return массив с подразделами
     */
    public HarmArray getSubSections() {
        return subsection;
    }

    /**
     * Возвращаем массив с товарными группами ТНВЭД
     * @return массив с с товарными группами
     */
    public HarmArray getGroups() {
        return group;
    }

    /**
     * Возвращаем массив с товарными позициями ТНВЭД
     * @return массив с с товарными позициями
     */
    public HarmArray getItems() {
        return item;
    }
}


