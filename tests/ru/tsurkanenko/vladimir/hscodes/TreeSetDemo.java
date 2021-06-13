package ru.tsurkanenko.vladimir.hscodes;

import java.util.TreeSet;
import ru.tsurkanenko.vladimir.hscodes.RawLines;
class HarmTreeSet {
    private TreeSet<HarmoItem> hsTree;


    public HarmTreeSet(String fileName) {
        hsTree = new TreeSet<>();
        String[] dataLines = new RawLines(fileName).getRawData();
        String regexCode = "^([0-9]+)\\|([0-9]*)\\|*([0-9]*)\\|*.*$";
        String regexDescription = "^[0-9|]+(.*?)\\|.*";

        for (String singleLine:dataLines
             ) {
            //hsTree.add(new HSGroup((singleLine.replaceAll(regexCode,"$1$2$3"),singleLine.replaceAll(regexDescription,"$1"), singleLine.replaceAll(regexNote,"$1")));
        }

    }

    public TreeSet<HarmoItem> getHsTree() {
        return hsTree;
    }


}

class HarmoItem implements Comparable<HarmoItem> {
    private String code,description;

    public HarmoItem(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(HarmoItem o) {
        if(o.equals(this))
            return 0;
        int result = this.code.compareTo(o.code);
        if (result == 0) {
            result = this.description.compareTo(o.description);
        }
        return result;
    }


}

public class TreeSetDemo {
    public static void main(String[] args) {
        HarmTreeSet demo = new HarmTreeSet("DIC/TNVED1.TXT");

        System.out.println(demo.getHsTree().first().getDescription());
        System.out.println(demo.getHsTree().last().getDescription());
        System.out.println(demo.getHsTree().size());
    }
}