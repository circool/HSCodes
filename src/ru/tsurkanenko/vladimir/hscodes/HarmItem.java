package ru.tsurkanenko.vladimir.hscodes;

/**
 * @author Vladimir Tsurkanenko
 * @version 1.0
 * Базовый элемент справочника кодов ТНВЭД - отдельный код
 */
public class HarmItem {
    private String code;
    private String description;
    final String regexCode = "^([0-9]+)\\|([0-9]*)\\|*([0-9]*)\\|*.*$";
    final String regexDescription = "^[0-9|]+(.*?)\\|.*";

    /**
     * Конструктор, создающий из сырой строки отдельные элементы - описание и товарный код
     * @param rawData неразобранная строка
     */
    public HarmItem(String rawData) {
        this.code = rawData.replaceAll(regexCode,"$1$2$3");
        this.description = rawData.replaceAll(regexDescription,"$1");
    }

    /**
     * Метод возвращает строку с кодом элемента
     * @return код элемента
     */
    public String getCode() {
        return code;
    }
    /**
     * Метод возвращает строку с описанием элемента
     * @return описание элемента
     */
    public String getDescription() {
        return description;
    }
}
