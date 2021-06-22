package ru.tsurkanenko.vladimir.hscodes.mvc;

import ru.tsurkanenko.vladimir.hscodes.database.*;
import ru.tsurkanenko.vladimir.hscodes.mvc.tree.Controller;
import java.util.Arrays;

/**
 * Модель MVC (Model-View-Controller)
 * Модель хранит исходные данные и предоставляет их Контроллеру, когда у него возникает в них необходимость
 * @see Dict
 * @see Controller
 * @author Vladimir Tsurkanenko
 * @version 0.4
 * @since 0.4
 */
public class Model {
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
        sectionList = new String[sections.length];
        for (int i=0; i < sectionList.length; i++){
            sectionList[i] = sections[i].toString();
        }
        // Список товарных групп
        Gruppa[] groups = hs.getGruppa();
        groupList = new String[groups.length];
        for (int i = 0; i < groupList.length; i++){
            groupList[i] = groups[i].toString();
        }
        // Список товарных позиций
        TovPoz[] positions = hs.getTovPoz();
        positionList = new String[positions.length];
        for (int i = 0; i < positionList.length; i++){
            positionList[i] = positions[i].toString();
        }
        // Список товарных подпозиций
        TovSubPoz[] subPositions = hs.getTovSubPoz();
        subPositionList = new String[subPositions.length];
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
        return positionList;
    }
    /**
     * Получить список текущих товарных подпозиций
     * Возвращает массив с удобочитаемым перечнем дочерних товарных подпозиций для текущей товарной позиции
     * @return массив с товарными подпозициями (строки в формате "ХХХХХХ наименование товарной подпозиции")
     */
    public String[] getSubPositionList() {
        TovSubPoz[] subPositions = hs.getChildrenTovSubPoz(
                positionList[selectedPosition].substring(0,2),
                positionList[selectedPosition].substring(2,4)
        );
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
        groupList = getGroupList();
    }
    /**
     * Выбрать активный(текущий) подраздел (группу)
     *
     */
    public void selectGroup(String item) {
        selectedGroup = Arrays.asList(groupList).indexOf(item);
        positionList = getPositionList();
    }
    /**
     * Выбрать активную(текущую) группу
     */
    public void selectPosition(String item){
        this.selectedPosition = Arrays.asList(positionList).indexOf(item);
        subPositionList = getSubPositionList();
    }
    /**
     * Выбрать активную(текущую) товарную позицию.
     *
     */
    public void selectSubPosition(String item) {
        selectedSubPosition = Arrays.asList(subPositionList).indexOf(item);
    }

    /**
     * Возвращает примечание для текущей группы ТНВЭД
     * @return Строка с примечанием (PRIM)
     */
    public String getGroupNote() {
        return hs.getGruppa(selectedGroup).getPrim();
    }
    /**
     * Возвращает примечание для текущего раздела ТНВЭД
     * @return Строка с примечанием (PRIM)
     */
    public String getSectionNote() {
        return hs.getRazdel(selectedSection).getPrim();
    }
    /**
     * Возвращает описание выбранного кода ТНВЭД, включая его родительские субпозицию, позицию и группу
     * @return Строка с описанием кода ТНВЭД
     */
    public String getDescription() {

        return hs.getRazdel(sectionList[selectedSection].substring(0, 2)).getNaim() + "\n\t" +
                hs.getGruppa(groupList[selectedGroup].substring(2, 4)).getNaim() + "\n\t\t" +
                hs.getTovPoz(
                        positionList[selectedPosition].substring(0, 2),
                        positionList[selectedPosition].substring(2, 4))
                        .getNaim() + "\n\t\t\t" +
                hs.getTovSubPoz(
                        positionList[selectedPosition].substring(0, 2),
                        positionList[selectedPosition].substring(2, 4),
                        subPositionList[selectedSubPosition].substring(4, 10)
                ).getNaim();
    }
}
