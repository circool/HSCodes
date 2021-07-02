package ru.tsurkanenko.vladimir.hscodes.v53.mvc.model;

import javafx.scene.control.TreeItem;
import ru.tsurkanenko.vladimir.hscodes.v53.database.*;


/**
 * Модель MVC (Model-View-Controller)
 * Модель хранит исходные данные и предоставляет их Контроллеру, когда у него возникает в них необходимость
 * Для формирования дерева товарных позиций используется рекурсивный метод getChildrens
 * @author Vladimir Tsurkanenko
 * @version 0.5.4
 * @since 0.5.1
 */
public class Model {

    final ScopeGroups sG1, sG2;
    final ScopeItems sI3, sI4;

    /**
     * Создание новой модели.
     */
    public Model() {
        sG1 = new ScopeGroups("dic/TNVED1.TXT");
        sG2 = new ScopeGroups("dic/TNVED2.TXT");
        sI3 = new ScopeItems("dic/TNVED3.TXT");
        sI3.add("dic/TNVED3.ADD.TXT");
        sI4 = new ScopeItems("dic/TNVED4.TXT");
        sI4.add("dic/TNVED4.ADD.TXT");
/*
        // Список разделов
        Groups[] sections = sG1.get();

        // Список товарных групп
        Groups[] groups = sG2.get();

        // Список товарных позиций
        Items[] positions = sI3.get();

        // Список товарных подпозиций
        Items[] subPositions = sI4.get();

 */
    }


    @SuppressWarnings("CommentedOutCode")
    public TreeItem<String> getTree() {
        TreeItem<String> result = new TreeItem<>();
        result.setValue("Справочник ТН ВЭД");

        for (Groups currSection : sG1.get()) {
            result
                    .getChildren().add(new TreeItem<>(currSection.toString()));
            int s0 = result
                    .getChildren().size() - 1;
            //result.addEventHandler(javafx.event.EventType.ROOT, (javafx.event.Event event) ->
            //System.out.println(event.getEventType()););

            for (Groups currGroup : sG2.startsWith(currSection.getCode())) {
                result
                        .getChildren().get(s0)
                        .getChildren().add(new TreeItem<>(currGroup.toString().substring(2)));
                int s1 = result
                        .getChildren().get(s0)
                        .getChildren().size() - 1;


                for (Items l0 : sI3.startsWith(currGroup.getCode().substring(2))) {
                    result
                            .getChildren().get(s0)
                            .getChildren().get(s1)
                            .getChildren().add(new TreeItem<>(l0.toString()));
                    int n0 = result
                            .getChildren().get(s0)
                            .getChildren().get(s1)
                            .getChildren().size() - 1;

                    for (Items l1 : sI4.startsWith(l0.getCode(), 1)) {
                        TreeItem<String> a = getChildrens(sI4,l1);
                        result
                                .getChildren().get(s0)
                                .getChildren().get(s1)
                                .getChildren().get(n0)
                                .getChildren().add(a);
                    }
                }
            }
        }
        return result;
    }

    TreeItem<String> getChildrens(ScopeItems data, Items parent) {
        TreeItem<String> result = new TreeItem<>(parent.toString());

        Items[] childrens = data.getChild(parent);
        if (childrens.length == 0) {
            return result;
        }
        for (Items item : data.getChild(parent)){
            result.getChildren().add(getChildrens(data,item));
            result.getChildren().get(result.getChildren().size()-1).setValue(item.toString());
        }
        return result;
    }
}