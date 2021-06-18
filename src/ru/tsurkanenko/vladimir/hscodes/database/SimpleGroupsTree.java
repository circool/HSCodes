package ru.tsurkanenko.vladimir.hscodes.database;

import ru.tsurkanenko.vladimir.hscodes.RawLines;
import java.util.TreeSet;
/**
 * Коллекция элементов и примечаний справочника организванная в виде древа
 * @see SimpleItemsTree
 * Расширяет класс SimpleItemsTree добавляя древо с примечаниями
 * @author Vladimir Tsurkanenko
 * @version 0.4
 */
public class SimpleGroupsTree extends SimpleItemsTree{
    private final TreeSet<SimpleItem> notesTree;

    public SimpleGroupsTree(String fileName) {
        super(fileName);
        String[] dataLines = new RawLines(fileName).getRawData();
        notesTree = new TreeSet<>();
        for (String dataLine : dataLines) {
            notesTree.add(new SimpleItem(dataLine));
        }
    }
    public TreeSet<SimpleItem> getNotesStartsWith(String prefix){
        TreeSet<SimpleItem> result = new TreeSet<>();
        for (SimpleItem singleElement: notesTree
        ) {
            if (singleElement.getCode().startsWith(prefix))
                result.add(singleElement);
        }
        return result;
    }
    public TreeSet<SimpleItem> getAllNotes() {
        return notesTree;
    }
}
