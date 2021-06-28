package ru.tsurkanenko.vladimir.hscodes.database.v50;

import java.util.Date;

/**
 * Интерфейс, описывыающий методы, которые должны реализовывать все элементы справочника
 */
public interface DictCommonInterface {
    Date getStartData();
    Date getEndData();
    String getNaim();
    String toString();
    boolean isActual();
}
