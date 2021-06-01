package ru.tsurkanenko.vladimir.hscodes;

/**
 * Базовый элемент справочника кодов ТНВЭД - отдельный код
 */
public class HarmItem {
    private String code;
    private String description;
    final String regexCode = "^([0-9]+)\\|([0-9]*)\\|*([0-9]*)\\|*.*$";
    final String regexDescription = "^[0-9|]+(.*?)\\|.*";

    /**
     * Конструктор, создающий из сырой строки отдельные элементы - описание и товарный код
     * @param rawData
     */
    public HarmItem(String rawData) {
        this.code = rawData.replaceAll(regexCode,"$1$2$3");
        this.description = rawData.replaceAll(regexDescription,"$1");
    }

    /**
     * Метод возвращает строку с кодом элемента
     * @return
     */
    public String getCode() {
        return code;
    }
    /**
     * Метод возвращает строку с описанием элемента
     * @return
     */
    public String getDescription() {
        return description;
    }
}
