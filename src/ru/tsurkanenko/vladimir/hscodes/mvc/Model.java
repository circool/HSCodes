package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.scene.control.TreeItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.tsurkanenko.vladimir.hscodes.db.Item;
import ru.tsurkanenko.vladimir.hscodes.db.Operable;
import ru.tsurkanenko.vladimir.hscodes.db.Scope;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Модель MVC (Model-View-Controller)
 * Модель {@link Model} хранит исходные данные и предоставляет их Контроллеру, когда у него возникает в них необходимость
 * Для формирования дерева товарных позиций используется итерационный 10-ти уровневый (getTreeIterable)
 * @author Vladimir Tsurkanenko
 * @version 0.6
 * @since 0.6
 */
class Model {


    /**
     * Хранение активного элемента дерева
     */
    private TreeItem<String> activeTreeItem;
    private final Map<String, String> section_notes;
    private final Map<String, String> group_notes;

    /**
     * Создание новой модели.
     */
    Model() {
        activeTreeItem = null;
        // Создать Map для хранения примечаний к разделам
        section_notes = new HashMap<>();
        for (Operable s:new Scope("files/TNVED1.TXT").get())
            section_notes.put(s.toString(), s.getPrim());

        // Создать Map для хранения примечаний к группам
        group_notes = new HashMap<>();
        for (Operable g:new Scope("files/TNVED2.TXT").get())
            group_notes.put(g.toString().substring(2), g.getPrim());

        // Создать дерево для представления
    }

    /**
     * Возвращает дерево сформированное из дочерних элементов справочника.
     * Использует итерационный способ обхода всех уровней вложенности справочника
     * Всего в товарных позициях найдено 10 уровней вложенности.
     * @return Дерево с корневым узлом parent и его дочерними элементами (и их дочерними элементами, вплоть до последнего листа)
     */
    TreeItem<String> getTree() {
        //System.out.println("Start getTreeIterable");
        TreeItem<String> result = new TreeItem<>();
        result.setValue("Справочник ТН ВЭД");

        Scope sections = new Scope("files/TNVED1.TXT");
        Scope groups = new Scope("files/TNVED2.TXT");
        Scope positions = new Scope("files/TNVED3.TXT");
        positions.add("files/TNVED3.ADD.TXT");
        Scope items = new Scope("files/TNVED4.TXT");
        items.add("files/TNVED4.ADD.TXT");

        // Разделы XX
        for (Operable currSection : sections.get()) {
            result.getChildren().add(new TreeItem<>(currSection.toString()));
            int i0 = result
                    .getChildren().size() - 1;

            // Товарные группы ХХ ХХ
            for (Operable currGroup : groups.getChildren(currSection)) {
                result.getChildren().get(i0).getChildren().add(new TreeItem<>(currGroup.toString().substring(2)));
                int i1 = result
                        .getChildren().get(i0)
                        .getChildren().size() - 1;

                // Товарные позиции ХХХХ
                // так как у группы лишние две цифры в коде, подменяем ее на безымянный обьект, в котором код укорочен
                for (Operable currPosition : positions.getChildren(new Item(currGroup.getCode().substring(2),currGroup.getNaim(),null))) {
                    result
                            .getChildren().get(i0)
                            .getChildren().get(i1)
                            .getChildren().add(new TreeItem<>(currPosition.toString()));
                    int i2 = result
                            .getChildren().get(i0)
                            .getChildren().get(i1)
                            .getChildren().size() - 1;

                    // Товарные подсубпозиции 1-го уровня вложенности
                    for (Operable l1 : items.getChildren(currPosition)) {
                        result
                                .getChildren().get(i0)
                                .getChildren().get(i1)
                                .getChildren().get(i2)
                                .getChildren()
                                .add(new TreeItem<>(l1.toString()));
                        int i3 = result
                                .getChildren().get(i0)
                                .getChildren().get(i1)
                                .getChildren().get(i2)
                                .getChildren()
                                .size() - 1;
                        // Товарные подсубпозиции 2-го уровня вложенности
                        for (Operable l2 : items.getChildren(l1)) {
                            result
                                    .getChildren().get(i0)
                                    .getChildren().get(i1)
                                    .getChildren().get(i2)
                                    .getChildren().get(i3)
                                    .getChildren()
                                    .add(new TreeItem<>(l2.toString()));
                            int i4 = result
                                    .getChildren().get(i0)
                                    .getChildren().get(i1)
                                    .getChildren().get(i2)
                                    .getChildren().get(i3)
                                    .getChildren()
                                    .size() - 1;
                            // Товарные подсубпозиции 3-го уровня вложенности
                            for (Operable l3 : items.getChildren(l2)) {
                                result
                                        .getChildren().get(i0)
                                        .getChildren().get(i1)
                                        .getChildren().get(i2)
                                        .getChildren().get(i3)
                                        .getChildren().get(i4)
                                        .getChildren()
                                        .add(new TreeItem<>(l3.toString()));
                                int i5 = result
                                        .getChildren().get(i0)
                                        .getChildren().get(i1)
                                        .getChildren().get(i2)
                                        .getChildren().get(i3)
                                        .getChildren().get(i4)
                                        .getChildren()
                                        .size() - 1;
                                // Товарные подсубпозиции 4-го уровня вложенности
                                for (Operable l4 : items.getChildren(l3)) {
                                    result
                                            .getChildren().get(i0)
                                            .getChildren().get(i1)
                                            .getChildren().get(i2)
                                            .getChildren().get(i3)
                                            .getChildren().get(i4)
                                            .getChildren().get(i5)
                                            .getChildren()
                                            .add(new TreeItem<>(l4.toString()));
                                    int i6 = result
                                            .getChildren().get(i0)
                                            .getChildren().get(i1)
                                            .getChildren().get(i2)
                                            .getChildren().get(i3)
                                            .getChildren().get(i4)
                                            .getChildren().get(i5)
                                            .getChildren()
                                            .size() - 1;
                                    // Товарные подсубпозиции 5-го уровня вложенности
                                    for (Operable l5 : items.getChildren(l4)) {
                                        result
                                                .getChildren().get(i0)
                                                .getChildren().get(i1)
                                                .getChildren().get(i2)
                                                .getChildren().get(i3)
                                                .getChildren().get(i4)
                                                .getChildren().get(i5)
                                                .getChildren().get(i6)
                                                .getChildren()
                                                .add(new TreeItem<>(l5.toString()));
                                        int i7 = result
                                                .getChildren().get(i0)
                                                .getChildren().get(i1)
                                                .getChildren().get(i2)
                                                .getChildren().get(i3)
                                                .getChildren().get(i4)
                                                .getChildren().get(i5)
                                                .getChildren().get(i6)
                                                .getChildren()
                                                .size() - 1;
                                        // Товарные подсубпозиции 6-го уровня вложенности
                                        for (Operable l6 : items.getChildren(l5)) {
                                            result
                                                    .getChildren().get(i0)
                                                    .getChildren().get(i1)
                                                    .getChildren().get(i2)
                                                    .getChildren().get(i3)
                                                    .getChildren().get(i4)
                                                    .getChildren().get(i5)
                                                    .getChildren().get(i6)
                                                    .getChildren().get(i7)
                                                    .getChildren()
                                                    .add(new TreeItem<>(l6.toString()));
                                            int i8 = result
                                                    .getChildren().get(i0)
                                                    .getChildren().get(i1)
                                                    .getChildren().get(i2)
                                                    .getChildren().get(i3)
                                                    .getChildren().get(i4)
                                                    .getChildren().get(i5)
                                                    .getChildren().get(i6)
                                                    .getChildren().get(i7)
                                                    .getChildren()
                                                    .size() - 1;
                                            // Товарные подсубпозиции 7-го уровня вложенности
                                            for (Operable l7 : items.getChildren(l6)) {
                                                result
                                                        .getChildren().get(i0)
                                                        .getChildren().get(i1)
                                                        .getChildren().get(i2)
                                                        .getChildren().get(i3)
                                                        .getChildren().get(i4)
                                                        .getChildren().get(i5)
                                                        .getChildren().get(i6)
                                                        .getChildren().get(i7)
                                                        .getChildren().get(i8)
                                                        .getChildren()
                                                        .add(new TreeItem<>(l7.toString()));
                                                int i9 = result
                                                        .getChildren().get(i0)
                                                        .getChildren().get(i1)
                                                        .getChildren().get(i2)
                                                        .getChildren().get(i3)
                                                        .getChildren().get(i4)
                                                        .getChildren().get(i5)
                                                        .getChildren().get(i6)
                                                        .getChildren().get(i7)
                                                        .getChildren().get(i8)
                                                        .getChildren()
                                                        .size() - 1;
                                                // Товарные подсубпозиции 8-го уровня вложенности
                                                for (Operable l8 : items.getChildren(l7)) {
                                                    result
                                                            .getChildren().get(i0)
                                                            .getChildren().get(i1)
                                                            .getChildren().get(i2)
                                                            .getChildren().get(i3)
                                                            .getChildren().get(i4)
                                                            .getChildren().get(i5)
                                                            .getChildren().get(i6)
                                                            .getChildren().get(i7)
                                                            .getChildren().get(i8)
                                                            .getChildren().get(i9)
                                                            .getChildren()
                                                            .add(new TreeItem<>(l8.toString()));
                                                    int i10 = result
                                                            .getChildren().get(i0)
                                                            .getChildren().get(i1)
                                                            .getChildren().get(i2)
                                                            .getChildren().get(i3)
                                                            .getChildren().get(i4)
                                                            .getChildren().get(i5)
                                                            .getChildren().get(i6)
                                                            .getChildren().get(i7)
                                                            .getChildren().get(i8)
                                                            .getChildren().get(i9)
                                                            .getChildren()
                                                            .size() - 1;
                                                    // Товарные подсубпозиции 9-го уровня вложенности
                                                    for (Operable l9 : items.getChildren(l8)) {
                                                        result
                                                                .getChildren().get(i0)
                                                                .getChildren().get(i1)
                                                                .getChildren().get(i2)
                                                                .getChildren().get(i3)
                                                                .getChildren().get(i4)
                                                                .getChildren().get(i5)
                                                                .getChildren().get(i6)
                                                                .getChildren().get(i7)
                                                                .getChildren().get(i8)
                                                                .getChildren().get(i9)
                                                                .getChildren().get(i10)
                                                                .getChildren()
                                                                .add(new TreeItem<>(l9.toString()));
                                                        int i11 = result
                                                                .getChildren().get(i0)
                                                                .getChildren().get(i1)
                                                                .getChildren().get(i2)
                                                                .getChildren().get(i3)
                                                                .getChildren().get(i4)
                                                                .getChildren().get(i5)
                                                                .getChildren().get(i6)
                                                                .getChildren().get(i7)
                                                                .getChildren().get(i8)
                                                                .getChildren().get(i9)
                                                                .getChildren().get(i10)
                                                                .getChildren()
                                                                .size() - 1;
                                                        // Товарные подсубпозиции 10-го уровня вложенности
                                                        for (Operable l10 : items.getChildren(l9)) {
                                                            result
                                                                    .getChildren().get(i0)
                                                                    .getChildren().get(i1)
                                                                    .getChildren().get(i2)
                                                                    .getChildren().get(i3)
                                                                    .getChildren().get(i4)
                                                                    .getChildren().get(i5)
                                                                    .getChildren().get(i6)
                                                                    .getChildren().get(i7)
                                                                    .getChildren().get(i8)
                                                                    .getChildren().get(i9)
                                                                    .getChildren().get(i10)
                                                                    .getChildren().get(i11)
                                                                    .getChildren()
                                                                    .add(new TreeItem<>(l10.toString()));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //System.out.println("End getTreeIterable");
        return result;
    }

    /**
     * Возвращает элемент дерева, выбранный как активный
     * @return Ссылка на активный TreeItem
     */
    TreeItem<String> getActiveTreeItem(){
        return activeTreeItem;
    }

    /**
     * Сохраняет у себя информацию о выбранном элементе дерева
     * @param treeItem Ссылка на активный TreeItem
     */
    void setActiveTreeItem(TreeItem<String> treeItem){
        activeTreeItem = treeItem;
    }

    /**
     * Определяет, есть ли у элемента дерева примечание
     * или является ли выбранный элемент последним в иерархии
     * @return Истина если есть, ложь - если нет
     */
    boolean isHaveNotes(@NotNull TreeItem<String> element){
        int nestingLevel = getNestingLevel(element);
        String activeItemValue = element.getValue();
        if(nestingLevel == 2)
            return (group_notes.get(activeItemValue).length() > 0);
        if(nestingLevel == 1)
            return (section_notes.get(activeItemValue).length() > 0);
        return element.isLeaf();
    }

    /**
     * Возвращает полное описание выбранного кода ТНВЭД
     * @return Строка описаниями родителей и выбранного кода
     */
    public String getFinalDescription(@NotNull TreeItem<String> treeItem) {
        String result = treeItem.getValue();
        if(treeItem.getParent().getParent() != null)
            result = getFinalDescription(treeItem.getParent()) + "\n" + result;
        else
            return result ;
        return result;
    }

    /**
     * Возвращает уровень вложенности элемента древа
     * @param treeItem Элемент дерева, уровень которого нужно получить
     * @return Целое число с уровнем вложенности
     */
    int getNestingLevel(@Nullable TreeItem<String> treeItem){
        if(treeItem != null){
            int result = 0;
            TreeItem<String> tmp = treeItem;
            while(tmp.getParent() != null){
                result++;
                tmp = tmp.getParent();
            }
            return result;
        }
        return -1;
        /* или так:
        while(tmp != null){
            result++;
            tmp = tmp.getParent();
        }*/
    }

    /**
     * Возвращает родительский раздел для элемента дерева
     *
     * @param treeItem элемент, для которого нужно найти раздел
     * @return раздел, являющийся для элемента родительским или сам элемент,
     * если для него нельзя получить раздел (например, если он сам раздел)
     */
    @NotNull TreeItem<String> getParentSection(@NotNull TreeItem<String> treeItem){
        int nestingLevel = getNestingLevel(treeItem);
        for(int i = 1; i < nestingLevel; i++)
            treeItem = treeItem.getParent();
        return treeItem;
    }
    /**
     * Возвращает родительскую группу для элемента дерева
     *
     * @param treeItem элемент, для которого нужно найти группу
     * @return группа, являющаяся для элемента родительской
     * или сам элемент, если для него нельзя получить группу (например, если он сам группа), или null, если элеменр - раздел
     */
    @NotNull TreeItem<String> getParentGroup(@NotNull TreeItem<String> treeItem){
        int nestingLevel = getNestingLevel(treeItem);
        if(nestingLevel < 2) return treeItem;
        for(int i = 2; i < nestingLevel; i++)
            treeItem = treeItem.getParent();
        return treeItem;
    }

    public String getGroupNote(@NotNull TreeItem<String> treeItem) {
        //TreeItem<String> parent = getParentGroup(treeItem);
        //if(parent != null)
        return group_notes.get(Objects.requireNonNull(getParentGroup(treeItem)).getValue());
        //return "";
    }

    public String getSectionNote(@NotNull TreeItem<String> treeItem) {
        return section_notes.get(getParentSection(treeItem).getValue());
    }
}
