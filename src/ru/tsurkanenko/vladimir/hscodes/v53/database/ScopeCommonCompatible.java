package ru.tsurkanenko.vladimir.hscodes.v53.database;
/**
 * Интерфейс, описывыающий методы, которые должны реализовывать все массивы элементов справочника
 * @author Vladimir Tsurkanenko
 * @version 0.5.3
 * @since 0.5.3
 */
@SuppressWarnings("ALL")
public interface ScopeCommonCompatible<T> {
    T[] get();
    T[] startsWith(String str);
    int lastIndexOf(String s);
    int firstIndexOf(String s);
    void makeScopeIndex();
    String[] toArray();
}
