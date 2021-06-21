package ru.tsurkanenko.vladimir.hscodes.mvc.combobox;

import ru.tsurkanenko.vladimir.hscodes.database.ver4.*;
import ru.tsurkanenko.vladimir.hscodes.mvc.tree.Controller;

import java.util.Arrays;

/**
 * Модель MVC (Model-View-Controller)
 * Модель хранит исходные данные и предоставляет их Контроллеру, когда у него возникает в них необходимость
 * @see Dict
 * @see Controller
 *
 * @author Vladimir Tsurkanenko
 * @version 0.4
 * @since 0.4
 */
public class Model {
    private String sectionNote, groupNote, itemDescription;
    private final String[] sectionList;
    private String[] groupList;
    private String[] positionList;
    private String[] subPositionList;

    public int selectedSection;
    public int selectedGroup;
    public int selectedPosition;
    public int selectedSubPosition;
    final Dict hs;

    /**
     * Создание новой модели.
     */
    public Model() {
        hs = new Dict();
        // Список разделов
        Razdel[] sections = hs.getRazdel();
        this.sectionList = new String[sections.length];
        for (int i=0; i < sectionList.length; i++){
            sectionList[i] = sections[i].toString();
        }
        // Список товарных групп
        Gruppa[] groups = hs.getGruppa();
        this.groupList = new String[groups.length];
        for (int i = 0; i < groupList.length; i++){
            groupList[i] = groups[i].toString();
        }
        // Список товарных позиций
        TovPoz[] positions = hs.getTovPoz();
        this.positionList = new String[positions.length];
        for (int i = 0; i < positionList.length; i++){
            positionList[i] = positions[i].toString();
        }
        // Список товарных подпозиций
        TovSubPoz[] subPositions = hs.getTovSubPoz();
        this.subPositionList = new String[subPositions.length];
        for (int i = 0; i < subPositionList.length; i++){
            subPositionList[i] = subPositions[i].toString();
        }
    }
    /**
     * Получить список разделов.
     * Возвращает массив с удобочитаемым перечнем разделов стравочника
     * @return массив с разделами (строки в формате "ХХ НАИМЕНОВАНИЕ РАЗДЕЛА")
     */
    public String[] getSectionList() {
        return this.sectionList;
    }
    /**
     * Получить список текущих групп.
     * Возвращает массив с удобочитаемым перечнем дочерних групп текущего раздела
     * @return массив с группами (строки в формате "ХХХХ НАИМЕНОВАНИЕ ГРУППЫ")
     */
    public String[] getGroupList() {
        Gruppa[] groups = hs.getChildrenGruppa(sectionList[selectedSection].substring(0,2));
        groupList = new String[groups.length];
        for (int i = 0; i < groupList.length; i++){
            groupList[i] = groups[i].toString();
        }
        selectedGroup = 0;
        return groupList;
    }
    /**
     * Получить список текущих товарных позиций
     * Возвращает массив с удобочитаемым перечнем дочерних товарных позиций текущей группы
     * @return массив с подгруппами (строки в формате "ХХХХ НАИМЕНОВАНИЕ ТОВАРНОЙ ПОЗИЦИИ")
     */
    public String[] getPositionList() {
        TovPoz[] positions = hs.getChildrenTovPoz(groupList[selectedGroup].substring(2,4));
        this.positionList = new String[positions.length];
        for (int i = 0; i < positionList.length; i++){
            positionList[i] = positions[i].toString();
        }
        selectedPosition = 0;
        return positionList;
    }
    /**
     * Получить список текущих товарных подпозиций
     * Возвращает массив с удобочитаемым перечнем дочерних товарных подпозиций для текущей товарной позиции
     * @return массив с товарными подпозициями (строки в формате "ХХХХХХ наименование товарной подпозиции")
     */
    public String[] getSubPositionList() {
        TovSubPoz[] subPositions = hs.getChildrenTovSubPoz(positionList[selectedPosition].substring(0,2), positionList[selectedPosition].substring(2,4));
        subPositionList = new String[subPositions.length];
        for (int i = 0; i < subPositionList.length; i++){
            subPositionList[i] = subPositions[i].toString();
        }
        return subPositionList;
    }

    /**
     * Выбрать активный(текущий) раздел.
     *
     */
    public void selectSection(String item) {
        this.selectedSection = Arrays.asList(sectionList).indexOf(item);
        this.getGroupList();
        // TODO Добавить обработку комментариев
    }
    /**
     * Выбрать активный(текущий) подраздел (группу)
     *
     */
    public void selectGroup(String item) {
        this.selectedGroup = Arrays.asList(groupList).indexOf(item);
        this.getPositionList();
        // TODO Добавить обработку комментариев
    }
    /**
     * Выбрать активную(текущую) группу
     */
    public void selectPosition(String item){
        this.selectedPosition = Arrays.asList(positionList).indexOf(item);
    }
    /**
     * Выбрать активную(текущую) товарную позицию.
     *
     */
    public void selectSubPosition(String item) {
        selectedSubPosition = Arrays.asList(subPositionList).indexOf(item);
    }

    public String getGroupNote() {
        this.groupNote = "TODO";
        return groupNote;
    }

    public String getSectionNote() {
        this.sectionNote = "TODO";
        return sectionNote;
    }

    public String getDescription() {
        this.itemDescription = "TODO";
        return itemDescription;
    }
}