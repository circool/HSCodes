package ru.tsurkanenko.vladimir.hscodes.database.ver3;


/**
 * Класс для описания товарных позиций ТНВЭД
 * Наследует класс DictCommon {@inheritDoc}
 * Расширяет полями tov_poz и naim
 * tov_poz - Код товарной позиции ТНВЭД
 * naim - Наименование товарной позиции
 * @version 0.3
 * @author Vladimir Tsurkanenko
 */
class TovPos extends DictCommon{
    private String tov_poz;

    TovPos(){
        super();
    }
    /**
     * Конструктор
     * Создает новый объект инкапсулирующий данные о товарной позиции ТНВЭД
     * @param rawLine - строка с данными
     */
    public TovPos(String rawLine) {
        super(rawLine);
        tov_poz = rawLine.replaceAll("^[0-9]{2}\\|([0-9]{2})+\\|[0-9]+\\|.*?\\|[0-9.|]+$","$1");
    }
    /**
     * Возвращает код товарной позиции TOV_POZ
     * @return Код товарной позиции
     */
    public String getTov_poz() {
        return tov_poz;
    }

}

