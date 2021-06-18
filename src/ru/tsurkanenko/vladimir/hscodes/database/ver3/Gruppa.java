package ru.tsurkanenko.vladimir.hscodes.database.ver3;

/**
 * Класс для описания товарных групп ТНВЭД
 * Наследует класс Razdel {@inheritDoc}
 * Расширяет полем gruppa
 * gruppa - Код группы ТНВЭД
 * @version 0.3
 * @author Vladimir Tsurkanenko
 */
class Gruppa extends Razdel{
    private String gruppa;


    Gruppa(){
        super();
    }
    /**
     * Конструктор
     * Создает новый объект инкапсулирующий данные о товарной группе ТНВЭД
     * @param rawLine - строка с данными

     */
    public Gruppa(String rawLine) {
        super(rawLine);
        gruppa = rawLine.replaceAll("^[0-9]{2}\\|([0-9]{2})\\|.*?\\|[0-9.|]*$","$1");
    }

    /**
     * Возвращает наименование группы
     * @return Строка с наименованием
     */
    public String getGruppa() {
        return gruppa;
    }
}
