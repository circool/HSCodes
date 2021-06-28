package ru.tsurkanenko.vladimir.hscodes.database.v40;

/**
 * Класс для описания товарных групп ТНВЭД
 * Наследует класс DictNoted {@inheritDoc}
 * Расширяет полем gruppa
 * gruppa - Код группы ТНВЭД  {C2}
 * @version 0.4
 * @since 0.4
 * @author Vladimir Tsurkanenko
 */
public class Gruppa extends DictNoted {
    private final String parentRazdel;
    private final String gruppa;

    /**
     * Конструктор
     * Создает новый объект инкапсулирующий данные о товарной группе ТНВЭД
     * @param rawLine - строка с данными
     */
    public Gruppa(String rawLine) {
        super(rawLine);
        parentRazdel = rawLine.replaceAll("^([0-9]+)\\|.*","$1");
        gruppa = rawLine.replaceAll("^[0-9]+\\|([0-9]+)\\|.*","$1");
    }

    /**
     * Возвращает код раздела, к которому относится данная группа
     * @return Код раздела
     */
    public String getParentRazdelCode() {
        return parentRazdel;
    }

    /**
     * Возвращает наименование группы
     * @return Строка с наименованием
     */
    public String getGruppaCode() {
        return gruppa;
    }

    public String toString(){
        return parentRazdel + gruppa + " " + this.getNaim();
    }

}
