package ru.tsurkanenko.vladimir.hscodes;

/**
 * @version 1.0
 * @author Vladimir Tsurkanenko
 * Объект, инкапсулирующий перечни разделов, групп, подгрупп и товарных позиций справочника ТНВЭД
 * Данные справочника получены из файлов dic/TNVED?.TXT
 * Справочник доступен по адресу https://www.nalog.gov.ru/rn77/program/5961290/
 */
public class HarmBase {
    private HarmGroupArray section, subsection;
    private HarmItemArray group, item;
    public HarmBase() {
        section = new HarmGroupArray("dic/TNVED1.TXT");
        subsection = new HarmGroupArray("dic/TNVED2.TXT");
        group = new HarmItemArray("dic/TNVED3.TXT");
        item = new HarmItemArray("dic/TNVED4.TXT");
    }

    /**
     * Возвращаем массив с разделами ТНВЭД
     * @return массив с разделами
     */
    public HarmGroupArray getSections() {
        return section;
    }
    /**
     * Возвращаем массив с подразделами ТНВЭД
     * @return массив с подразделами
     */
    public HarmGroupArray getSubSections() {
        return subsection;
    }
    /**
     * Возвращаем массив с товарными группами ТНВЭД
     * @return массив с с товарными группами
     */
    public HarmItemArray getGroups() {
        return group;
    }

    /**
     * Возвращаем массив с товарными позициями ТНВЭД
     * @return массив с с товарными позициями
     */
    public HarmItemArray getItems() {
        return item;
    }

    /**
     * Возвращаем массив разделов/подразделов ТНВЭД с совпадающими кодами
     * @return отдельный раздел/подраздел
     */
    public HarmGroupArray getSections(String code) {
        return null;
        //TODO Написать логику метода
    }
    /**
     * Возвращаем массив с товарными позициями ТНВЭД с совпадающими кодами
     * @return массив с товарными позициями
     */
    public HarmItemArray getItems(String code) {
        //TODO Написать логику метода
        return item;
    }
}
