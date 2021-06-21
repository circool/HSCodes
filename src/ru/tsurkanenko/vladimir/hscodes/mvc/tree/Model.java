package ru.tsurkanenko.vladimir.hscodes.mvc.tree;

import ru.tsurkanenko.vladimir.hscodes.database.ver4.*;
import java.util.Arrays;

/**
 * Модель MVC (Model-View-Controller)
 * Модель хранит исходные данные и предоставляет их Контроллеру, когда у него возникает в них необходимость
 * @see ru.tsurkanenko.vladimir.hscodes.database.ver4.Dict
 * @see ru.tsurkanenko.vladimir.hscodes.mvc.tree.Controller
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

    private int selectedSection;
    private int selectedGroup;
    private int selectedPosition;
    private int selectedSubPosition;
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
        Gruppa[] subSections = hs.getGruppa();
        this.groupList = new String[subSections.length];
        for (int i = 0; i < groupList.length; i++){
            groupList[i] = subSections[i].toString();
        }
        // Список товарных позиций
        TovPoz[] tovPos = hs.getTovPoz();
        this.positionList = new String[tovPos.length];
        for (int i = 0; i < positionList.length; i++){
            positionList[i] = tovPos[i].toString();
        }
        // Список товарных подпозиций
        TovSubPoz[] tovSubPoz = hs.getTovSubPoz();
        this.subPositionList = new String[tovSubPoz.length];
        for (int i = 0; i < subPositionList.length; i++){
            subPositionList[i] = tovSubPoz[i].toString();
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
        Gruppa[] subSections = hs.getChildrenGruppa(sectionList[selectedSection].substring(0,2));
        groupList = new String[subSections.length];
        for (int i = 0; i < groupList.length; i++){
            groupList[i] = subSections[i].toString();
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
        TovPoz[] tovPoz = hs.getChildrenTovPoz(groupList[selectedGroup].substring(2,4));
        this.positionList = new String[tovPoz.length];
        for (int i = 0; i < positionList.length; i++){
            positionList[i] = tovPoz[i].toString();
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
        TovSubPoz[] tovSubPoz = hs.getChildrenTovSubPoz(positionList[selectedPosition].substring(0,2), positionList[selectedPosition].substring(2,4));
        subPositionList = new String[tovSubPoz.length];
        for (int i = 0; i < subPositionList.length; i++){
            subPositionList[i] = tovSubPoz[i].toString();
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
        sectionNote = getSectionNote();
    }

    private String getSectionNote() {
        sectionNote = "TODO";
        return sectionNote;
    }

    /**
     * Выбрать активный(текущий) подраздел (группу)
     *
     */
    public void selectGroup(String item) {
        this.selectedGroup = Arrays.asList(groupList).indexOf(item);
        groupNote = getGroupNote();
        this.getPositionList();
        // TODO Добавить обработку комментариев
    }

    private String getGroupNote() {
        groupNote = "TODO";
        return groupNote;
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
        itemDescription = getDescription();
    }

    private String getDescription() {
        itemDescription = "TODO";
        return itemDescription;
    }
}
