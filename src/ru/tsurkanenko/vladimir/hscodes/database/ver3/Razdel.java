package ru.tsurkanenko.vladimir.hscodes.database.ver3;

/**
 * Класс для описания разделов ТНВЭД
 * Наследует класс DictCommon {@inheritDoc}
 * Расширяет полями naim и prim
 * naim - Наименование NAIM
 * prim - Примечание PRIM
 * @version 0.3
 * @author Vladimir Tsurkanenko
 */
class Razdel extends DictCommon {
    private String prim;

    public Razdel(){
        super();
    }

    /**
     * Конструктор
     * Создает новый объект инкапсулирующий данные о разделе ТНВЭД
     * @param rawLine - строка с данными
     */

    public Razdel(String rawLine)  {
        super(rawLine);
        prim = rawLine.replaceAll("^[0-9|]+([^|]*?)\\|([^|]*)\\|[0-9.]+\\|[0-9.]*\\|$","$2");
        // Форматирование и очистка
        prim = prim.replaceAll("([:;])\\s+((\\()*[а-яА-Я0-9]\\)|\\.)","$1\n$2");
        prim = prim.replaceAll("([.:;])\\s+(\\d+\\.)","$1\n$2");
        prim = prim.replaceAll("(; или)+\\s(\\([а-я]\\))","$1\n$2");
    }


    /**
     * Возвращает примечание к разделу
     * @return Строка с примечанием
     */
    public String getPrim() {
        return prim;
    }
}