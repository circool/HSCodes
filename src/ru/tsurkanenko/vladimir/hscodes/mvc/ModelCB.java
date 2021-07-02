package ru.tsurkanenko.vladimir.hscodes.mvc;

import ru.tsurkanenko.vladimir.hscodes.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Модель MVC (Model-View-Controller)
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
    private int selectedSection;

    public int getSelectedSection() {
        return selectedSection;
    }

    public int getSelectedGroup() {
        return selectedGroup;
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public int getSelectedSubPosition() {
        return selectedSubPosition;
    }

    private int selectedGroup;
    private int selectedPosition;
    private int selectedSubPosition;
    final ScopeGroups sG1, sG2;
    final ScopeItems sI3, sI4;

    /**
     * Создание новой модели.
     */
    public ModelCB() {
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
    public String[] getSectionList() {
        return this.sectionList;
    }
    /**
     * Получить список текущих групп.
     * Возвращает массив с удобочитаемым перечнем дочерних групп текущего раздела
     * @return массив с группами (строки в формате "ХХХХ НАИМЕНОВАНИЕ ГРУППЫ")
     */
    public String[] getGroupList() {
        Groups[] groups = sG2.startsWith(sectionList[selectedSection].substring(0,2));
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
    public String[] getPositionList() {
        Items[] positions = sI3.startsWith(groupList[selectedGroup].substring(0,2));
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
        // вывести только те позиции, у которых уровень вложенности меньше 2х
        Items[] subPositions = sI4.startsWith(positionList[selectedPosition].substring(0,4));
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
        return sG2.startsWith(sectionList[selectedSection].substring(0,2)+groupList[selectedGroup].substring(0,2))[0].getPrim();
    }
    /**
     * Возвращает примечание для текущего раздела ТНВЭД
     * @return Строка с примечанием (PRIM)
     */
    public String getSectionNote() {
        return sG1.startsWith(sectionList[selectedSection].substring(0,2))[0].getPrim();

    }
    /**
     * Возвращает описание выбранного кода ТНВЭД, включая его родительские субпозицию, позицию и группу
     * @return Строка с описанием кода ТНВЭД
     */
    public String getDescription() {
        return sG1.startsWith(sectionList[selectedSection].substring(0,2))[0].getNaim() + "\n\t" +
                sG2.startsWith(sectionList[selectedSection].substring(0,2)+groupList[selectedGroup].substring(0,2))[0].getNaim() + "\n\t\t" +
                sI3.startsWith(positionList[selectedPosition].substring(0,4))[0].getNaim() + "\n\t\t\t" +
                sI4.startsWith(subPositionList[selectedSubPosition])[0].getNaim();
    }



}
