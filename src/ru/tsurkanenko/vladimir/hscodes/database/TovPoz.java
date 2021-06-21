package ru.tsurkanenko.vladimir.hscodes.database;


/**
 * Класс для описания товарных позиций ТНВЭД
 * Наследует класс DictCommon {@inheritDoc}
 * Расширяет полями tovGruppa и tovPoz
 * tovGruppa - Код товарной группы {C2}
 * tovPoz - Код товарной позиции {C2}
 * @version 0.4
 * @since 0.4
 * @author Vladimir Tsurkanenko
 */
public class TovPoz extends DictCommon{
    private final String tovGruppa;
    private final String tovPoz;


    /**
     * Конструктор
     * Создает новый объект инкапсулирующий данные о товарной позиции ТНВЭД
     * @param rawLine - строка с данными
     */
    public TovPoz(String rawLine) {
        super(rawLine);
        tovGruppa = rawLine.replaceAll("^([0-9]{2})\\|[0-9]{2}.*$","$1");
        tovPoz = rawLine.replaceAll("^[0-9]{2}\\|([0-9]{2}).*$","$1");
    }

    /**
     * Возвращает код товарной группы GRUPPA
     * @return Код товарной  группы
     */
    public String getGruppaCode() {
        return tovGruppa;
    }

    /**
     * Возвращает код товарной позиции TOV_POZ
     * @return Код товарной позиции
     */
    public String getTovPozCode() {
        return tovPoz;
    }

    public String toString() {
        return tovGruppa + tovPoz + " " + getNaim();
    }

}

