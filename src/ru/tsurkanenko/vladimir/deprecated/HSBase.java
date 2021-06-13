package ru.tsurkanenko.vladimir.deprecated;

/**
 * @version 0.1
 * @author Vladimir Tsurkanenko
 * Объект, инкапсулирующий перечни разделов, групп, подгрупп и товарных позиций справочника ТНВЭД
 * Данные справочника получены из файлов dic/TNVED?.TXT
 * Справочник доступен по адресу https://www.nalog.gov.ru/rn77/program/5961290/
 */
@Deprecated
public class HSBase {
    private final HSGroup section;
    private final HSGroup group;
    private final HSGroup subgroup;
    private final HSGroup item;
    private final HSChapter chapter;

    /**
     * Конструктор создает 4 объекта HSGroup, для каждого из файлов справочника
     */
    public HSBase() {
        section = new HSGroup("dic/TNVED1.TXT");
        group = new HSGroup("dic/TNVED2.TXT");
        subgroup = new HSGroup("dic/TNVED3.TXT");
        item = new HSGroup("dic/TNVED4.TXT");
        chapter = new HSChapter("dic/TNVED4.TXT");
    }

    /**
     * Метод возвращает объект типа HSGroup
     * @return Объект инкапсулирующий номер, описание и комментарии к разделам ТНФЭД
     */
    public HSGroup getSection() {
        return section;
    }
    /**
     * Метод возвращает объект типа HSGroup
     * @return Объект инкапсулирующий номер, описание и комментарии к группам ТНФЭД
     */
    public HSGroup getGroup() {
        return group;
    }
    /**
     * Метод возвращает объект типа HSGroup
     * @return Объект инкапсулирующий номер, описание и комментарии к подгруппам ТНФЭД
     */
    public HSGroup getSubGroup() {
        return subgroup;
    }
    /**
     * Метод возвращает объект типа HSGroup
     * @return Объект инкапсулирующий номер, описание и комментарии к товарным позициям ТНФЭД
     */
    public HSGroup getItem() {
        return item;
    }

    public HSChapter getChapter() {return chapter; }
}
