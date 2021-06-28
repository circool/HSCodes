package ru.tsurkanenko.vladimir.hscodes.v52.database;
/**
 * Интерфейс, описывыающий методы, которые должны реализовывать все массивы элементов справочника
 * @author Vladimir Tsurkanenko
 * @version 0.5.2
 * @since 0.5.1
 */
public interface ScopeCommonCompatible<T> {
    T[] get();
    T[] startsWith(String str);
    int lastIndexOf(String s);
    int firstIndexOf(String s);
    void makeScopeIndex();
}
