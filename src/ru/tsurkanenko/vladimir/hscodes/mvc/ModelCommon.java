package ru.tsurkanenko.vladimir.hscodes.mvc;

/**
 * Модель MVC (Model-View-ControllerTree) - методы, общие для всех моделей независимо от их реализации
 * @author Vladimir Tsurkanenko
 * @version 0.5.6
 * @since 0.5.5
 */
public class ModelCommon {
    // Строковое представление выбранного раздела и выбранной группы (без учета кода раздела)
    private String activeSectionValue, activeGroupValue;

    /**
     * Конструктор для создания новой модели
     *
     */
    public ModelCommon() {
        activeSectionValue = "";
        activeGroupValue = "";
    }

    // Методы, общие для всех моделей, работающих с справочником ТНВЭД, независимо от реализации

    /**
     * Устанавливает выбранный раздел как текущий
     * @param selection Строковое представление текущего раздела
     */
    public void setActiveSectionValue(String selection) {
        activeSectionValue = selection;
    }

    /**
     * Возвращает текущий активный раздел
     * @return Строковое представление текущего раздела
     */
    public String getActiveSectionValue() {
        return activeSectionValue;
    }

    /**
     * Устанавливает выбранную группу как текущую
     * @param group Строковое представление текущей группы
     */
    public void setActiveGroupValue(String group) {
        activeGroupValue = group;
    }

    /**
     * Возвращает текущую активную группу
     * @return Строковое представление текущей группы
     */
    public String getActiveGroupValue() {
        return activeGroupValue;
    }
}
