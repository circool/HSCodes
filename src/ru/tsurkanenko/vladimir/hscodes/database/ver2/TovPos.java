package ru.tsurkanenko.vladimir.hscodes.database.ver2;


/**
 * Класс для описания товарных позиций ТНВЭД
 * Наследует класс DictCommon {@inheritDoc}
 * Расширяет полями tov_poz и naim
 * tov_poz - Код товарной позиции ТНВЭД
 * naim - Наименование товарной позиции
 * @version 0.2
 * @author Vladimir Tsurkanenko
 */
class TovPos extends DictCommon{
    char[] tov_poz;
    char[] naim;

    /**
     * Конструктор
     * Создает новый объект инкапсулирующий данные о товарной позиции ТНВЭД
     * @param rawLine - строка с данными
     * @param regexSearch - regex последовательность для поиска полей
     * @param regexGruppa - regex последовательность указывающая на GRUPPA
     * @param tovPos - regex последовательность указывающая на TOV_POZ
     * @param regexNaim - regex последовательность указывающая на наименование NAIM
     * @param regexStartDate - regex последовательность указывающая на DATE
     * @param regexEndDate - regex последовательность указывающая на DATE
     */
    public TovPos(
            String rawLine,
            String regexSearch,
            String regexGruppa,
            String tovPos,
            String regexNaim,
            String regexStartDate,
            String regexEndDate
    ) {
        super(rawLine,regexSearch,regexGruppa,regexStartDate,regexEndDate);
        tov_poz = new char[2];
        naim = new char[4000];
        try{
            tov_poz = rawLine.replaceAll(regexSearch,tovPos).toCharArray();
            naim = rawLine.replaceAll(regexSearch,regexNaim).toCharArray();
        }catch (Exception e){
            System.err.println("Ошибка парсинга данных");
            tov_poz = new char[0];
            naim = new char[0];
        }
    }
    /**
     * Возвращает код товарной позиции TOV_POZ
     * @return Код товарной позиции
     */
    public char[] getTov_poz() {
        return tov_poz;
    }
    /**
     * Возвращает наименование товарной позиции
     * @return Строка с наименованием
     */
    public String getNaim() {
        return String.copyValueOf(naim);
    }
}

