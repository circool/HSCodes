package ru.tsurkanenko.vladimir.hscodes.database.generic;

import ru.tsurkanenko.vladimir.hscodes.database.RawLines;

/**
 * Массив для разделов и групп справочника
 * @author Vladimir Tsurkanenko
 * @version 0.5.1
 * @since 0.5.1
 */
public class ScopeGroups extends ScopeCommon<Groups> {
    /**
     * Создает массив разделов или групп справочника
     *
     * @param fileName файл с данными
     */
    public ScopeGroups(String fileName) {
        searchResult = new Groups[0];
        String[] rawLines = new RawLines(fileName).getActualData();
        scope = new Groups[rawLines.length];
        for (int i = 0; i < scope.length; i++) {
            scope[i] = new Groups(rawLines[i]);
        }
        makeScopeIndex();
    }
}
