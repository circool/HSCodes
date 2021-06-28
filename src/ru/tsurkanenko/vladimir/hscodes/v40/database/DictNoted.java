package ru.tsurkanenko.vladimir.hscodes.v40.database;

/**
 * Класс для описания элементов ТНВЭД, содержащих примечания
 * Наследует класс Common {@inheritDoc}
 * Расширяет полем prim
 * prim - Примечание PRIM
 * @version 0.4
 * @since 0.4
 * @author Vladimir Tsurkanenko
 */
public class DictNoted extends DictCommon {
    private String prim;



    public DictNoted(String rawLine) {
        super(rawLine);
        prim = rawLine.replaceAll("^[0-9|]+([^|]*?)\\|([^|]*)\\|[0-9.]+\\|[0-9.]*\\|\n*","$2");
        // Форматирование и очистка
        prim = prim.replaceAll("([:;])\\s+((\\()*[а-яА-Я0-9]\\)|\\.)","$1\n$2");
        prim = prim.replaceAll("([.:;])\\s+(\\d+\\.)","$1\n$2");
        prim = prim.replaceAll("(; [ил]+)+\\s+(\\([а-я]\\))","$1\n$2");
        prim = prim.replaceAll("(\\.)\\s(\\([А-Я]\\))","$1\n$2");
        prim = prim.replaceAll("^ (.*)","$1");
        prim = prim.replaceAll(" Н "," ");
        prim = prim.replaceAll("\\s\\s+", " ");
        prim = prim.replaceAll("^(\\s)","");
    }
    /**
     * Возвращает примечание
     * @return Строка с примечанием
     */
    public String getPrim() {
        return prim;
    }
}
