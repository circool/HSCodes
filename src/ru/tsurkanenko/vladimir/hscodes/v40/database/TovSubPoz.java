package ru.tsurkanenko.vladimir.hscodes.v40.database;


/**
 * Класс для описания товарных подпозиций ТНВЭД
 * Наследует класс TovPos {@inheritDoc}
 * Расширяет полем tovSubPoz
 * tovSubPoz - Код товарной подпозиции ТНВЭД  {C6}
 * @version 0.4
 * @since 0.4
 * @author Vladimir Tsurkanenko
 */
public class TovSubPoz extends TovPoz {
    private final String tovSubPoz;


    /**
     * Конструктор
     * Создает новый объект инкапсулирующий данные о товарной подпозиции ТНВЭД
     * @param rawLine - строка с данными
     */
    public TovSubPoz(String rawLine) {
        super(rawLine);
        String regexSearch = "^[0-9]{2}\\|[0-9]{2}+\\|([0-9]{6})\\|.*?\\|[0-9.|]+$";
        tovSubPoz = rawLine.replaceAll(regexSearch,"$1");
    }

    /**
     * Возвращает код товарной подпозиции
     * @return Строка с кодом подпозиции
     */
    public String getTovSubPozCode() {
        return tovSubPoz;
    }
    /*public String getParentTovPozCode() {return this.getTovPozCode();}*/
    public String toString() {
        return this.getGruppaCode() + this.getTovPozCode() + tovSubPoz + " " + getNaim();
    }
}