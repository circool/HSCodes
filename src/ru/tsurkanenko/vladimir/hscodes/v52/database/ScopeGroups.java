package ru.tsurkanenko.vladimir.hscodes.v52.database;

import ru.tsurkanenko.vladimir.hscodes.RawLines;

/**
 * Массив для разделов и групп справочника
 * @author Vladimir Tsurkanenko
 * @version 0.5.2
 * @since 0.5.1
 */
public class ScopeGroups extends ScopeCommon<Groups> {
    /**
     * Создает новый массив объектов Groups из файла
     * @param fileName Имя файла с данными
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
