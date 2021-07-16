package ru.tsurkanenko.vladimir.hscodes.db;

import org.jetbrains.annotations.NotNull;

/**
 * Интерфейс контрактующий свойства элементов справочника
 * @version 0.6
 * @since 0.6
 * @author Vladimir Tsurkanenko
 */


public interface Operable extends Comparable<Operable>{
    String getCode();
    String getNaim();
    String toString();
    String getPrim();
    int getNestingLevel();
    int compareTo(@NotNull Operable o);
}
