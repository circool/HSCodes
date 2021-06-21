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
    private String[] subSectionList;
    private String[] groupList;
    private String[] itemList;

    private int selectedSection;
    private int selectedSubSection;
    private int selectedGroup;
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
        this.subSectionList = new String[subSections.length];
        for (int i=0; i < subSectionList.length; i++){
            subSectionList[i] = subSections[i].toString();
        }
        // Список товарных позиций
        TovPoz[] tovPos = hs.getTovPoz();
        this.groupList = new String[tovPos.length];
        for (int i=0; i < groupList.length; i++){
            groupList[i] = tovPos[i].toString();
        }
        // Список товарных подпозиций
        TovSubPoz[] tovSubPoz = hs.getTovSubPoz();
        this.itemList = new String[tovSubPoz.length];
        for (int i=0; i < itemList.length; i++){
            itemList[i] = tovSubPoz[i].toString();
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
    public String[] getSubSectionList() {
        Gruppa[] subSections = hs.getChildrenGruppa(sectionList[selectedSection].substring(0,2));
        subSectionList = new String[subSections.length];
        for (int i=0; i < subSectionList.length; i++){
            subSectionList[i] = subSections[i].toString();
        }
        selectedSubSection = 0;
        return subSectionList;
    }
    /**
     * Получить список текущих товарных позиций
     * Возвращает массив с удобочитаемым перечнем дочерних товарных позиций текущей группы
     * @return массив с подгруппами (строки в формате "ХХХХ НАИМЕНОВАНИЕ ТОВАРНОЙ ПОЗИЦИИ")
     */
    public String[] getGroupList() {
        TovPoz[] tovPoz = hs.getChildrenTovPoz(subSectionList[selectedSubSection].substring(2,4));
        this.groupList = new String[tovPoz.length];
        for (int i=0; i < groupList.length; i++){
            groupList[i] = tovPoz[i].toString();
        }
        selectedGroup = 0;
        return groupList;
    }
    /**
     * Получить список текущих товарных подпозиций
     * Возвращает массив с удобочитаемым перечнем дочерних товарных подпозиций для текущей товарной позиции
     * @return массив с товарными подпозициями (строки в формате "ХХХХХХ наименование товарной подпозиции")
     */
    public String[] getItemList() {
        TovSubPoz[] tovSubPoz = hs.getChildrenTovSubPoz(groupList[selectedGroup].substring(0,2),groupList[selectedGroup].substring(2,4));
        itemList = new String[tovSubPoz.length];
        for (int i=0; i < itemList.length; i++){
            itemList[i] = tovSubPoz[i].toString();
        }
        return itemList;
    }

    /**
     * Выбрать активный(текущий) раздел.
     *
     */
    public void selectSection(String item) {
        this.selectedSection = Arrays.asList(sectionList).indexOf(item);
        this.getSubSectionList();
        // TODO Добавить обработку комментариев
    }
    /**
     * Выбрать активный(текущий) подраздел (группу)
     *
     */
    public void selectSubSection(String item) {
        this.selectedSubSection = Arrays.asList(subSectionList).indexOf(item);
        this.getGroupList();
        // TODO Добавить обработку комментариев
    }
    /**
     * Выбрать активную(текущую) группу
     */
    public void selectGroup(String item){
        this.selectedGroup = Arrays.asList(groupList).indexOf(item);
    }
    /**
     * Выбрать активную(текущую) товарную позицию.
     *
     */
    public void selectItem(String item) {
        int selectedItem = Arrays.asList(itemList).indexOf(item);
    }
}
