package ru.tsurkanenko.vladimir.hscodes.v51.database;

import java.util.Date;

/**
 * Интерфейс, описывыающий методы, которые должны реализовывать все элементы справочника
 * @author Vladimir Tsurkanenko
 * @version 0.5.1
 * @since 0.5.1
 */
public interface CommonCompatible {
    String getNaim();
    String toString();
    //TODO Удалить после исключения методов getStartData и getEndData
    @Deprecated
    boolean isActual();
    @Deprecated
    Date getStartData();
    @Deprecated
    Date getEndData();
}
