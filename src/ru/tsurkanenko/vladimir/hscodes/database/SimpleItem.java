package ru.tsurkanenko.vladimir.hscodes.database;

/**
 * Класс инкапсулирующий связку двух текстовых полей - кода и описания
 * Также используется для хранения связки кода и примечания.
 * Для совместимости с TreeView реализует интерфейс Comparable
 * @version 0.4
 * @author Vladimir Tsurkanenko
 */
public class SimpleItem implements Comparable<SimpleItem> {
    private String code;
    private String description;

    /**
     * Поддерживает конструктор с одним параметром
     * @param rawLine Сырая строка с данными о отдельном разделе, группе, товарной позиции или субпозиции
     */
    public SimpleItem(String rawLine) {
        String regexCode = "^([0-9]+)\\|([0-9]*)\\|*([0-9]*)\\|*.*$";
        String regexDescription = "^[0-9|]+(.*?)\\|.*";
        this.code = rawLine.replaceAll(regexCode,"$1$2$3");
        this.description = rawLine.replaceAll(regexDescription,"$1");
    }
    /**
     * Поддерживает конструктор с двумя параметрами
     * @param code Конечное строковое представление кода
     * @param description Конечное строковое представление описания или примечания
     */
    public SimpleItem(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Возвращает код элемента
     * @return Строковое представление кода
     */
    public String getCode() {
        return code;
    }
    /**
     * Возвращает описание/примечание элемента
     * @return Строковое представление описания/примечания
     */
    public String getDescription() {
        return description;
    }
    /**
     * Возвращает удобочитаемое содержимое элемента
     * @return Строковое код-пробел-описание/примечание
     */
    public String get() {
        return code + " " + description;
    }

    /**
     * Реализация интерфейса Comparable для совместимости с TreeView
     * @param o Объект, с которым нужно сравнить
     * @return Целочисленный результат сравнения: 0 - объекты равны, положительное - текущий объект больше, отрицательное - объект из параметра больше
     */
    @Override
    //
    public int compareTo(SimpleItem o) {
        if(o.equals(this))
            return 0;
        int result = this.code.compareTo(o.code);
        if (result == 0) {
            result = this.description.compareTo(o.description);
        }
        return result;
    }
}

