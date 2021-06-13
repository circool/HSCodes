package ru.tsurkanenko.vladimir.hscodes.tmp;


import ru.tsurkanenko.vladimir.hscodes.RawLines;

import java.util.TreeSet;

/**
 * The type Hs tree set.
 */
public class HSTreeSet {
    private TreeSet<HItem> hsTree;

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
            hsTree.add(new HItem(singleLine.replaceAll(regexCode,"$1$2$3"),singleLine.replaceAll(regexDescription,"$1")));
        }
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public TreeSet<HItem> getAll() {
        return hsTree;
    }

    /**
     * Starts with tree set.
     *
     * @param prefix the prefix
     * @return the tree set
     */
    public TreeSet<HItem> startsWith(String prefix){
        TreeSet<HItem> result = new TreeSet<>();
        for (HItem singleElement: hsTree
             ) {
            if (singleElement.code.startsWith(prefix))
                result.add(singleElement);
        }
        return result;
    }
}
