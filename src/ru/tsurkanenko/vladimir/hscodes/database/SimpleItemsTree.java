package ru.tsurkanenko.vladimir.hscodes.database;


import ru.tsurkanenko.vladimir.hscodes.RawLines;

import java.util.TreeSet;

/**
 * Коллекция элементов справочника организванная в виде древа
 * @author Vladimir Tsurkanenko
 * @version 0.4
 */
public class SimpleItemsTree {
    private final TreeSet<SimpleItem> itemsTree;

    public SimpleItemsTree(String fileName) {
        String[] dataLines = new RawLines(fileName).getRawData();
        itemsTree = new TreeSet<>();
        for (String dataLine : dataLines) {
            itemsTree.add(new SimpleItem(dataLine));
        }
    }

    public TreeSet<SimpleItem> getItemsStartsWith(String prefix){
        TreeSet<SimpleItem> result = new TreeSet<>();
        for (SimpleItem singleElement: itemsTree
             ) {
            if (singleElement.getCode().startsWith(prefix))
                result.add(singleElement);
        }
        return result;
    }

    public TreeSet<SimpleItem> getAllItems() {
        return itemsTree;
    }
}
