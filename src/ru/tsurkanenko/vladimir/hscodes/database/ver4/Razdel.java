package ru.tsurkanenko.vladimir.hscodes.database.ver4;

/**
 * Класс для описания разделов ТНВЭД
 * Наследует класс DictCommon {@inheritDoc}
 * Расширяет полем razdel
 * razdel - Код раздела RAZDEL  {C2}
 * @version 0.4
 * @since 0.4
 * @author Vladimir Tsurkanenko
 */
public class Razdel extends DictNoted {
    private String razdel;

    //public Razdel(){
        //super();
    //}

    /**
     * Конструктор
     * Создает новый объект инкапсулирующий данные о разделе ТНВЭД
     * @param rawLine - строка с данными
     */
    public Razdel(String rawLine)  {
        super(rawLine);
        razdel = rawLine.replaceAll("^(\\d{2})[0-9|]*(.*?)\\|.*?\\|([0-9.]+)\\|([0-9.]*)\\|\n*","$1");
    }

    /**
     * Возвращает код раздела ТНВЭД
     * @return Строка с кодом раздела
     */
    public String getRazdelCode() {
        return razdel;
    }

    public String toString(){
        return razdel + " " + this.getNaim();
    }
}