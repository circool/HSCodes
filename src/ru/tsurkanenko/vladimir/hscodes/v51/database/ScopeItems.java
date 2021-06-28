package ru.tsurkanenko.vladimir.hscodes.v51.database;

import ru.tsurkanenko.vladimir.hscodes.database.RawLines;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Массив для товарных позиций, субпозиций и подсубпозиций
 * @author Vladimir Tsurkanenko
 * @version 0.5.1
 * @since 0.5.1
 */
public class ScopeItems extends ScopeCommon<Items> {
    public ScopeItems(String fileName) {
        super();
        searchResult = new Items[0];
        String[] rawLines = new RawLines(fileName).getActualData();
        scope = new Items[rawLines.length];
        for (int i = 0; i < scope.length; i++) {
            scope[i] = new Items(rawLines[i]);
        }
        makeScopeIndex();
    }
    public void add(String fileName){

        ArrayList<Items> result = new ArrayList<>(Arrays.asList(scope));
        String[] rawLines = new RawLines(fileName).getActualData();
        for (String currNew:rawLines
        ) {
            result.add(new Items(currNew));
        }
        Collections.sort(result);
        scope = new Items[result.size()];
        scope = result.toArray(new Items[0]);
    }
}
