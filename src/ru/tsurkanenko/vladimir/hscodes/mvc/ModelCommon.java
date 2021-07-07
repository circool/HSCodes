package ru.tsurkanenko.vladimir.hscodes.mvc;
import ru.tsurkanenko.vladimir.hscodes.ScopeGroups;
import ru.tsurkanenko.vladimir.hscodes.ScopeItems;
/**
 * Модель MVC (Model-View-ControllerTree) - методы, общие для всех моделей независимо от их реализации
 * @author Vladimir Tsurkanenko
 * @version 0.5.5
 * @since 0.5.5
 */
public class ModelCommon {

    // Массивы с данными о разделах, группах, товарных позициях и товарных под-суб-позициях и товарных кодах
    private final ScopeGroups sections, groups;
    private final ScopeItems positions, items;

    // Строковое представление выбранного раздела и выбранной группы (без учета кода раздела)
    private String activeSectionValue, activeGroupValue;

    /**
     * Конструктор для создания новой модели
     *
     */
    public ModelCommon() {
        sections = new ScopeGroups("dic/TNVED1.TXT");
        groups = new ScopeGroups("dic/TNVED2.TXT");
        positions = new ScopeItems("dic/TNVED3.TXT");
        positions.add("dic/TNVED3.ADD.TXT");
        items = new ScopeItems("dic/TNVED4.TXT");
        items.add("dic/TNVED4.ADD.TXT");
        activeSectionValue = "";
        activeGroupValue = "";
    }

    // Методы, общие для всех моделей, работающих с справочником ТНВЭД, независимо от реализации

    /**
     * Возвращает массив с разделами ТНВЭД
     * @return массив с разделами
     */
    public ScopeGroups getSections() {
        return sections;
    }

    /**
     * Возвращает массив с группами ТНВЭД
     * @return массив с группами
     */
    public ScopeGroups getGroups() {
        return groups;
    }

    /**
     * Возвращает массив с товарными позициями ТНВЭД
     * @return массив с товарными позициями
     */
    public ScopeItems getPositions() {
        return positions;
    }

    /**
     * Возвращает массив с товарными позициями, подпозициями и субподпозициями ТНВЭД
     * @return массив с конечными элементами справочника
     */
    public ScopeItems getItems() {
        return items;
    }

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
     * Возвращает примечание для текущего раздела ТНВЭД
     * @return Строка с примечанием (PRIM)
     */
    public String getSectionNote() {
        if(sections.startsWith(getActiveSectionValue()).length==1)
            return sections.startsWith(getActiveSectionValue())[0].getPrim();
        return "";
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

    /**
     * Возвращает примечание к текущей группе
     * @return Строка с примечаниями
     */
    public String getGroupNote() {

        if(getGroups().startsWith(getActiveGroupValue()).length==1)
            return getGroups().startsWith(getActiveGroupValue())[0].getPrim();
        return "";
    }
}
