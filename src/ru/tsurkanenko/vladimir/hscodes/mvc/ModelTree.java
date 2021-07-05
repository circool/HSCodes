package ru.tsurkanenko.vladimir.hscodes.mvc;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import ru.tsurkanenko.vladimir.hscodes.*;

/**
 * Модель MVC (Model-View-ControllerTree)
 * Модель хранит исходные данные и предоставляет их Контроллеру, когда у него возникает в них необходимость
 * Для формирования дерева товарных позиций используется рекурсивный подход (getTreeRecursive и nestedChildRecursive) или итерационный 10-ти уровневый (getTreeIterable)
 * @author Vladimir Tsurkanenko
 * @version 0.5.5
 * @since 0.5.5
 * TODO Рекурсивный способ работает значительно дольше, нужно оптимизировать его логику
 */
class ModelTree extends ModelCommon{
    private String activeTreeItem;

    /**
     * Создание новой модели.
     */
    ModelTree() {
        super();
        activeTreeItem = "";
    }

    /**
     * Возвращает полное дерево ТНВЭД
     * @return Дерево элементов справочника ТНВЭД
     */
    TreeItem<String> getTreeRecursive() {
        //System.out.println("Start getTree");
        TreeItem<String> result = new TreeItem<>();
        result.setValue("Справочник ТН ВЭД");
        // Разделы
        for (Groups currSection : getSections().get()) {
            result.getChildren().add(new TreeItem<>(currSection.toString()));
            int s0 = result
                    .getChildren().size() - 1;

            // Товарные группы ХХ
            for (Groups currGroup : getGroups().startsWith(currSection.getCode())) {
                result.getChildren().get(s0).getChildren().add(new TreeItem<>(currGroup.toString().substring(2)));
                int s1 = result
                        .getChildren().get(s0)
                        .getChildren().size() - 1;
                // Товарные позиции ХХХХ
                for (Items l0 : getPositions().startsWith(currGroup.getCode().substring(2))) {
                    result
                            .getChildren().get(s0).getChildren().get(s1)
                            .getChildren().add(new TreeItem<>(l0.toString()));
                    int n0 = result
                            .getChildren().get(s0).getChildren().get(s1)
                            .getChildren().size() - 1;
                    // Товарные субпозиции, подсубпозиции итд -, - -, - - - итд
                    ScopeItems allItems = getItems();
                    for (Items l1 : allItems.startsWith(l0.getCode())) {
                        TreeItem<String> a = nestedChildRecursive(allItems,l1);
                        result.getChildren().get(s0).getChildren().get(s1).getChildren().get(n0).getChildren().add(a);
                    }
                }
            }
        }
        //System.out.println("End getTree");
        return result;
    }

    /**
     * Возвращает дерево сформированное из дочерних элементов справочника.
     * Использует итерационный способ обхода всех уровней вложенности справочника
     * Всего в товарных позициях найдено 10 уровней вложенности.
     * @return Дерево с корневым узлом parent и его дочерними элементами (и их дочерними элементами, вплоть до последнего листа)
     */
    TreeItem<String> getTreeIterable() {
        //System.out.println("Start getTreeIterable");
        TreeItem<String> result = new TreeItem<>();
        result.setValue("Справочник ТН ВЭД");
        // Разделы XX
        for (Groups currSection : getSections().get()) {
            result.getChildren().add(new TreeItem<>(currSection.toString()));
            int i0 = result
                    .getChildren().size() - 1;
            // Товарные группы ХХ ХХ
            for (Groups currGroup : getGroups().startsWith(currSection.getCode())) {
                result.getChildren().get(i0).getChildren().add(new TreeItem<>(currGroup.toString()));
                int i1 = result
                        .getChildren().get(i0)
                        .getChildren().size() - 1;
                // Товарные позиции ХХХХ
                for (Items currPosition : getPositions().startsWith(currGroup.getCode().substring(2))) {
                    result
                            .getChildren().get(i0)
                            .getChildren().get(i1)
                            .getChildren().add(new TreeItem<>(currPosition.toString()));
                    int i2 = result
                            .getChildren().get(i0)
                            .getChildren().get(i1)
                            .getChildren().size() - 1;

                    // Товарные подсубпозиции 1-го уровня вложенности
                    for (Items l1 : getItems().startsWith(currPosition.getCode(),1)) {
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
                        for (Items l2 : getItems().getChild(l1)) {
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
                            for (Items l3 : getItems().getChild(l2)) {
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
                                for (Items l4 : getItems().getChild(l3)) {
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
                                    for (Items l5 : getItems().getChild(l4)) {
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
                                        for (Items l6 : getItems().getChild(l5)) {
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
                                            for (Items l7 : getItems().getChild(l6)) {
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
                                                for (Items l8 : getItems().getChild(l7)) {
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
                                                    for (Items l9 : getItems().getChild(l8)) {
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
                                                        for (Items l10 : getItems().getChild(l9)) {
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
     * Возвращает дерево сформированное из дочерних элементов справочника.
     * Использует рекурсивный вызов для обхода всех уровней вложенности справочника
     * @param data Массив товарных позиций справочника, из которого производится выборка элементов
     * @param parent товарная позиция, для которой нужно построить дерево дочерних элементов
     * @return Дерево с корневым узлом parent и его дочерними элементами (и их дочерними элементами, вплоть до последнего листа)
     * TODO Нужна оптимизация
     */
    TreeItem<String> nestedChildRecursive(ScopeItems data, Items parent) {
        TreeItem<String> result = new TreeItem<>(parent.toString());
        Items[] nestedChild = data.getChild(parent);
        if (nestedChild.length == 0) {
            return result;
        }
        for (Items item : data.getChild(parent)){
            result.getChildren().add(nestedChildRecursive(data,item));
            result.getChildren().get(result.getChildren().size()-1).setValue(item.toString());
        }
        return result;
    }

    /**
     * Этот метод вызывается при взаимодейсивии с деревом ТНВЭД
     * @param selectedItem
     */
    void mouseClickOnTreeAction(TreeItem<String> selectedItem){
        String selection;
        if (selectedItem != null) {
            selection = selectedItem.getValue();
            if (!activeTreeItem.equals(selection)) {
                activeTreeItem = selection;

                int selectionCodeLength = selection.indexOf(" ");
                this.setActiveSection("");
                this.setActiveGroup("");

                if (selectionCodeLength == 4) {
                    this.setActiveSection("");
                    this.setActiveGroup(activeTreeItem);

                }
                if (selectionCodeLength == 2) {
                    this.setActiveSection(activeTreeItem);
                    this.setActiveGroup("");
                }

            }
        }
    }

    String getActiveTree(){
        return activeTreeItem;
    }
}