package ru.tsurkanenko.vladimir.hscodes.database.ver2;


/**
 * Класс для описания товарных под-позиций ТНВЭД
 * Наследует класс TovPos {@inheritDoc}
 * Переопределяет поле naim (укорачивает до 200 симв)
 * Расширяет полем tov_SubPoz
 * tov_SubPoz - Код товарной под-позиции ТНВЭД
 * @version 0.2
 * @author Vladimir Tsurkanenko
 */
class TovSubPos extends TovPos{
    char[] tov_SubPoz;

    /**
     * Конструктор
     * Создает новый объект инкапсулирующий данные о товарной позиции ТНВЭД
     * @param rawLine - строка с данными
     * @param regexSearch - regex последовательность для поиска полей
     * @param regexGruppa - regex последовательность указывающая на GRUPPA
     * @param tovPos - regex последовательность указывающая на TOV_POZ
     * @param tovSubPos - regex последовательность указывающая на SUB_POZ
     * @param regexNaim - regex последовательность указывающая на наименование KR_NAIM
     * @param regexStartDate - regex последовательность указывающая на DATE
     * @param regexEndDate - regex последовательность указывающая на DATE
     */
    public TovSubPos(
            String rawLine,
            String regexSearch,
            String regexGruppa,
            String tovPos,
            String tovSubPos,
            String regexNaim,
            String regexStartDate,
            String regexEndDate
    ) {
        super(
                rawLine,
                regexSearch,
                regexGruppa,
                tovPos,
                regexNaim,
                regexStartDate,
                regexEndDate
        );
        naim = new char[200];
        tov_SubPoz = new char[6];
        naim = rawLine.replaceAll(regexSearch,regexNaim).toCharArray();
        tov_SubPoz = rawLine.replaceAll(regexSearch,tovSubPos).toCharArray();
    }
    /**
     * Возвращает код товарной под-позиции
     * @return Массив с кодом
     */
    public char[] getTov_SubPoz() {
        return tov_SubPoz;
    }
}