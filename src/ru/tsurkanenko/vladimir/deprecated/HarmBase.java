package ru.tsurkanenko.vladimir.deprecated;

/**
 * @version 1.0
 * @author Vladimir Tsurkanenko
 * Объект, инкапсулирующий перечни разделов, групп, подгрупп и товарных позиций справочника ТНВЭД
 * Данные справочника получены из файлов dic/TNVED?.TXT
 * Справочник доступен по адресу https://www.nalog.gov.ru/rn77/program/5961290/
 */
@Deprecated
public class HarmBase {
    private final HarmGroupArray section;
    private final HarmGroupArray subsection;
    private final HarmArray group;
    private final HarmArray item;
    public HarmBase() {
        section = new HarmGroupArray("dic/TNVED1.TXT");
        subsection = new HarmGroupArray("dic/TNVED2.TXT");
        group = new HarmArray("dic/TNVED3.TXT");
        item = new HarmArray("dic/TNVED4.TXT");
    }

    /**
     * Возвращает массив с разделами ТНВЭД
     * @return массив с разделами
     */
    public HarmArray getSections() {
        return section;
    }
    /**
     * Возвращает массив с подразделами ТНВЭД
     * @return массив с подразделами
     */
    public HarmArray getSubSections() {
        return subsection;
    }

    /**
     * Возвращает массив с товарными группами ТНВЭД
     * @return массив с с товарными группами
     */
    public HarmArray getGroups() {
        return group;
    }

    /**
     * Возвращает массив с товарными позициями ТНВЭД
     * @return массив с с товарными позициями
     */
    public HarmArray getItems() {
        return item;
    }
}


