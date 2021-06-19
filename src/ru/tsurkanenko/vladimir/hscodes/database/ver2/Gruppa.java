package ru.tsurkanenko.vladimir.hscodes.database.ver2;

/**
 * Класс для описания товарных групп ТНВЭД
 * Наследует класс Razdel {@inheritDoc}
 * Расширяет полем gruppa
 * gruppa - Код группы ТНВЭД
 * @version 0.2
 * @author Vladimir Tsurkanenko
 */
class Gruppa extends Razdel{
    private char[] gruppa;

    /**
     * Конструктор
     * Создает новый объект инкапсулирующий данные о товарной группе ТНВЭД
     * @param rawLine - строка с данными
     * @param regexSearch - regex последовательность для поиска полей
     * @param regexRazdel - regex последовательность указывающая на RAZDEL
     * @param regexGruppa - regex последовательность указывающая на GRUPPA
     * @param regexNaim - regex последовательность указывающая на наименование NAIM
     * @param regexPrim - regex последовательность указывающая на примечание PRIM
     * @param regexStartDate - regex последовательность указывающая на DATE
     * @param regexEndDate - regex последовательность указывающая на DATE
     */
    public Gruppa(String rawLine,
                  String regexSearch,
                  String regexRazdel,
                  String regexGruppa,
                  String regexNaim,
                  String regexPrim,
                  String regexStartDate,
                  String regexEndDate
    ) {
        super(rawLine,
                regexSearch,
                regexRazdel,
                regexNaim,
                regexPrim,
                regexStartDate,
                regexEndDate);
        gruppa = new char[2];
        try{
            gruppa = rawLine.replaceAll(regexSearch,regexGruppa).toCharArray();
        } catch (Exception e){
            System.err.println("Ошибка парсинга");
            gruppa = new char[0];
        }

    }

    /**
     * Возвращает наименование группы
     * @return Строка с наименованием
     */
    public char[] getGruppa() {
        return gruppa;
    }
}
