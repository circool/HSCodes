package ru.tsurkanenko.vladimir.hscodes.database.ver3;


/**
 * Класс для описания товарных под-позиций ТНВЭД
 * Наследует класс TovPos {@inheritDoc}
 * Переопределяет поле naim (укорачивает до 200 симв)
 * Расширяет полем tov_SubPoz
 * tov_SubPoz - Код товарной под-позиции ТНВЭД
 * @version 0.3
 * @author Vladimir Tsurkanenko
 */
class TovSubPos extends TovPos {
    private String tov_SubPoz;

    TovSubPos(){
        super();
    }

    /**
     * Конструктор
     * Создает новый объект инкапсулирующий данные о товарной позиции ТНВЭД
     * @param rawLine - строка с данными

     */
    public TovSubPos(String rawLine) {
        super(rawLine);
        String regexSearch = "^[0-9]{2}\\|[0-9]{2}+\\|([0-9]{6})\\|.*?\\|[0-9.|]+$";

        //naim = rawLine.replaceAll(regexSearch,regexNaim);
        tov_SubPoz = rawLine.replaceAll(regexSearch,"$1");
    }
    /**
     * Возвращает код товарной под-позиции
     * @return Массив с кодом
     */
    public String getTov_SubPoz() {
        return tov_SubPoz;
    }
}