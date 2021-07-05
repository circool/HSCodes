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
    private final ScopeGroups sections, groups;
    private final ScopeItems positions;
    private final ScopeItems items;
    private String activeSection;
    private String activeGroup;

    public ModelCommon() {
        sections = new ScopeGroups("dic/TNVED1.TXT");
        groups = new ScopeGroups("dic/TNVED2.TXT");
        positions = new ScopeItems("dic/TNVED3.TXT");
        positions.add("dic/TNVED3.ADD.TXT");
        items = new ScopeItems("dic/TNVED4.TXT");
        items.add("dic/TNVED4.ADD.TXT");
        activeSection = "";
        activeGroup = "";
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
    public void setActiveSection(String selection) {
        activeSection = selection;
    }

    /**
     * Устанавливает выбранную группу как текущую
     * @param group Строковое представление текущей группы
     */
    public void setActiveGroup(String group) {
        this.activeGroup = group;
    }

    /**
     * Возвращает текущий активный раздел
     * @return Строковое представление текущего раздела
     */
    public String getActiveSection() {
        return activeSection;
    }

    /**
     * Возвращает текущую активную группу
     * @return Строковое представление текущей группы
     */
    public String getActiveGroup() {
        return activeGroup;
    }

    /**
     * Возвращает примечание к текущей группе
     * @return Строка с примечаниями
     */
    public String getGroupNote() {
        if(groups.startsWith(activeGroup).length==1)
            return groups.startsWith(activeSection)[0].getPrim();
        return "";
    }

    /**
     * Возвращает примечание для текущего раздела ТНВЭД
     * @return Строка с примечанием (PRIM)
     */
    public String getSectionNote() {
        if(sections.startsWith(activeSection).length==1)
            return sections.startsWith(activeSection)[0].getPrim();
        return "";
    }
    /**
     * Возвращает примечание для текущего раздела или группы ТНВЭД
     * @return Строка с примечанием (PRIM)
     */
    public String getNote() {
        if (activeGroup != "")
            return groups.startsWith(activeGroup)[0].getPrim();
        if (activeSection != "")
            return sections.startsWith(activeSection)[0].getPrim();
        return "";
    }

    /**
     * Возвращает полное описание выбранного кода ТНВЭД
     * @return Строка описаниями родителей и выбранного кода
     */
    public String getFinalDescription() {
        //TODO Сделать правильный ответ
        System.out.println("Вызван метод getFinalDescription");
        return null;
    }
}
