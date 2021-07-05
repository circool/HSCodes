package ru.tsurkanenko.vladimir.hscodes.mvc;

import ru.tsurkanenko.vladimir.hscodes.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Модель MVC (Model-View-ControllerTree)
 * Модель хранит исходные данные и предоставляет их Контроллеру, когда у него возникает в них необходимость
 * @author Vladimir Tsurkanenko
 * @version 0.5.3
 * @since 0.5.1
 */
public class ModelCB {
    private final String[] sectionList;
    private String[] groupList;
    private String[] positionList;
    private String[] subPositionList;
    private int activeSection;

    int getActiveSection() {
        return activeSection;
    }

    int getActiveGroup() {
        return activeGroup;
    }

    int getActivePosition() {
        return activePosition;
    }

    int getActiveSubPosition() {
        return activeSubPosition;
    }

    private int activeGroup;
    private int activePosition;
    private int activeSubPosition;
    final ScopeGroups sG1, sG2;
    final ScopeItems sI3, sI4;

    /**
     * Создание новой модели.
     */
    ModelCB() {
        sG1 = new ScopeGroups("dic/TNVED1.TXT");
        sG2 = new ScopeGroups("dic/TNVED2.TXT");
        sI3 = new ScopeItems("dic/TNVED3.TXT");
        sI3.add("dic/TNVED3.ADD.TXT");
        sI4 = new ScopeItems("dic/TNVED4.TXT");
        sI4.add("dic/TNVED4.ADD.TXT");

        // Список разделов
        Groups[] sections = sG1.get();
        sectionList = new String[sections.length];
        for (int i=0; i < sectionList.length; i++){
            sectionList[i] = sections[i].toString();
        }
        // Список товарных групп
        Groups[] groups = sG2.get();
        groupList = new String[groups.length];
        for (int i = 0; i < groupList.length; i++){
            groupList[i] = groups[i].toString();
        }
        // Список товарных позиций
        Items[] positions = sI3.get();
        positionList = new String[positions.length];
        for (int i = 0; i < positionList.length; i++){
            positionList[i] = positions[i].toString();
        }
        // Список товарных подпозиций
        Items[] subPositions = sI4.get();
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
    String[] getSectionList() {
        return this.sectionList;
    }

    /**
     * Получить список текущих групп.
     * Возвращает массив с удобочитаемым перечнем дочерних групп текущего раздела
     * @return массив с группами (строки в формате "ХХХХ НАИМЕНОВАНИЕ ГРУППЫ")
     */
    String[] getGroupList() {
        Groups[] groups = sG2.startsWith(sectionList[activeSection].substring(0,2));
        groupList = new String[groups.length];
        for (int i = 0; i < groupList.length; i++){
            groupList[i] = groups[i].toString().substring(2);
        }
        return groupList;
    }

    /**
     * Получить список текущих товарных позиций
     * Возвращает массив с удобочитаемым перечнем дочерних товарных позиций текущей группы
     * @return массив с подгруппами (строки в формате "ХХХХ НАИМЕНОВАНИЕ ТОВАРНОЙ ПОЗИЦИИ")
     */
    String[] getPositionList() {
        Items[] positions = sI3.startsWith(groupList[activeGroup].substring(0,2));
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
    String[] getSubPositionList() {
        // вывести только те позиции, у которых уровень вложенности меньше 2х
        Items[] subPositions = sI4.startsWith(positionList[activePosition].substring(0,4));
        ArrayList<String> sp = new ArrayList<>();
        for (Items currSp:subPositions) {
            if (currSp.getNestlingLevel()<2)
                    sp.add(currSp.toString());
        }
        subPositionList = new String[sp.size()];
        return sp.toArray(subPositionList);
    }

    /**
     * Выбрать активный(текущий) раздел.
     *
     */
    void setActiveSection(String item) {
        this.activeSection = Arrays.asList(sectionList).indexOf(item);
        groupList = getGroupList();
    }

    /**
     * Выбрать активный(текущий) подраздел (группу)
     *
     */
    void setActiveGroup(String item) {
        activeGroup = Arrays.asList(groupList).indexOf(item);
        positionList = getPositionList();
    }

    /**
     * Выбрать активную(текущую) группу
     */
    void setActivePosition(String item){
        this.activePosition = Arrays.asList(positionList).indexOf(item);
        subPositionList = getSubPositionList();
    }

    /**
     * Выбрать активную(текущую) товарную позицию.
     *
     */
    void setActiveSubPosition(String item) {
        activeSubPosition = Arrays.asList(subPositionList).indexOf(item);
    }

    /**
     * Возвращает примечание для текущей группы ТНВЭД
     * @return Строка с примечанием (PRIM)
     */
    String getGroupNote() {
        return sG2.startsWith(sectionList[activeSection].substring(0,2)+groupList[activeGroup].substring(0,2))[0].getPrim();
    }

    /**
     * Возвращает примечание для текущего раздела ТНВЭД
     * @return Строка с примечанием (PRIM)
     */
    String getSectionNote() {
        return sG1.startsWith(sectionList[activeSection].substring(0,2))[0].getPrim();

    }

    /**
     * Возвращает описание выбранного кода ТНВЭД, включая его родительские субпозицию, позицию и группу
     * @return Строка с описанием кода ТНВЭД
     */
    String getFinalDescription() {
        return sG1.startsWith(sectionList[activeSection].substring(0,2))[0].getNaim() + "\n\t" +
                sG2.startsWith(sectionList[activeSection].substring(0,2)+groupList[activeGroup].substring(0,2))[0].getNaim() + "\n\t\t" +
                sI3.startsWith(positionList[activePosition].substring(0,4))[0].getNaim() + "\n\t\t\t" +
                sI4.startsWith(subPositionList[activeSubPosition])[0].getNaim();
    }
}
