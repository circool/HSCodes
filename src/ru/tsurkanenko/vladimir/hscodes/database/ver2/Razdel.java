package ru.tsurkanenko.vladimir.hscodes.database.ver2;


/**
 * Класс для описания разделов ТНВЭД
 * Наследует класс DictCommon {@inheritDoc}
 * Расширяет полями naim и prim
 * naim - Наименование NAIM
 * prim - Примечание PRIM
 * @version 0.2
 * @author Vladimir Tsurkanenko
 */
class Razdel extends DictCommon {
    char[] naim;
    char[] prim;

    /**
     * Конструктор
     * Создает новый объект инкапсулирующий данные о разделе ТНВЭД
     * @param rawLine - строка с данными
     * @param regexSearch - regex последовательность для поиска полей
     * @param regexRazdel - regex последовательность указывающая на RAZDEL или GRUPPA
     * @param regexNaim - regex последовательность указывающая на наименование NAIM
     * @param regexPrim - regex последовательность указывающая на примечание PRIM
     * @param regexStartDate - regex последовательность указывающая на DATE
     * @param regexEndDate - regex последовательность указывающая на DATE
     */
    public Razdel(
            String rawLine,
            String regexSearch,
            String regexRazdel,
            String regexNaim,
            String regexPrim,
            String regexStartDate,
            String regexEndDate
    )  {
        super(rawLine, regexSearch,regexRazdel,regexStartDate,regexEndDate);
        naim = new char[4000];
        prim = new char[4000];
        naim = rawLine.replaceAll(regexSearch,regexNaim).toCharArray();
        prim = rawLine.replaceAll(regexSearch,regexPrim).toCharArray();
    }

    /**
     * Возвращает наименование раздела
     * @return Строка с наименованием
     */
    public String getNaim() {
        return String.copyValueOf(naim);
    }
    /**
     * Возвращает примечание к разделу
     * @return Строка с примечанием
     */
    public String getPrim() {
        return String.copyValueOf(prim);
    }
}