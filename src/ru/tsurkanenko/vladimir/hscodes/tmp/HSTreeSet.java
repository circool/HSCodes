package ru.tsurkanenko.vladimir.hscodes.tmp;


import ru.tsurkanenko.vladimir.hscodes.RawLines;

import java.util.TreeSet;

/**
 * The type Hs tree set.
 */
public class HSTreeSet {
    private TreeSet<SimpleItem> hsTree;

    /**
     * Instantiates a new Hs tree set.
     *
     * @param fileName the file name
     */
    public HSTreeSet(String fileName) {
        hsTree = new TreeSet<>();
        String[] dataLines = new RawLines(fileName).getRawData();
        String regexCode = "^([0-9]+)\\|([0-9]*)\\|*([0-9]*)\\|*.*$";
        String regexDescription = "^[0-9|]+(.*?)\\|.*";
        for (String singleLine:dataLines
        ) {
            hsTree.add(new SimpleItem(singleLine.replaceAll(regexCode,"$1$2$3"),singleLine.replaceAll(regexDescription,"$1")));
        }
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public TreeSet<SimpleItem> getAll() {
        return hsTree;
    }

    /**
     * Starts with tree set.
     *
     * @param prefix the prefix
     * @return the tree set
     */
    public TreeSet<SimpleItem> startsWith(String prefix){
        TreeSet<SimpleItem> result = new TreeSet<>();
        for (SimpleItem singleElement: hsTree
             ) {
            if (singleElement.code.startsWith(prefix))
                result.add(singleElement);
        }
        return result;
    }
}
