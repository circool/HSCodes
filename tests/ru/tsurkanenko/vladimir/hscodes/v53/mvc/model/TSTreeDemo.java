package ru.tsurkanenko.vladimir.hscodes.v53.mvc.model;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeItem;
import ru.tsurkanenko.vladimir.hscodes.v53.*;
import ru.tsurkanenko.vladimir.hscodes.v53.database.*;
import ru.tsurkanenko.vladimir.hscodes.v53.mvc.*;
import ru.tsurkanenko.vladimir.hscodes.v53.mvc.tree.Controller;

import static org.junit.jupiter.api.Assertions.*;
//import static ru.tsurkanenko.vladimir.hscodes.v53.mvc.model.TSTree.getTree;

class TSTreeDemo {
    public static void main(String[] args) {

        ScopeItems parent = new ScopeItems("dic/TNVED3.TXT");
        parent.add("dic/TNVED3.ADD.TXT");

        ScopeItems data = new ScopeItems("dic/TNVED4.TXT");
        data.add("dic/TNVED4.ADD.TXT");

        Items[] x = parent.startsWith("0101");
        Items[] y = data.startsWith(x[0].getCode());

        for (Items z: y
             ) {
            System.out.println(z);
        }



        //Items parentItem = parent.get()[22];
        //TreeItem a = getTrees(data,y[0]);
        System.out.println("end");
    }
}