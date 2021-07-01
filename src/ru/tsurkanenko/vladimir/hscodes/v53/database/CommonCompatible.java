package ru.tsurkanenko.vladimir.hscodes.v53.database;

/**
 * Интерфейс, описывыающий методы, которые должны реализовывать все элементы справочника
 * @author Vladimir Tsurkanenko
 * @version 0.5.3
 * @since 0.5.3
 */
@SuppressWarnings("unused")
public interface CommonCompatible {
    String getNaim();
    String toString();
    String getCode();
}