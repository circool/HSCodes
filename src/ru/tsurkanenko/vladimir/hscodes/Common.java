package ru.tsurkanenko.vladimir.hscodes;

import org.jetbrains.annotations.NotNull;

/**
 * Класс инкапсулирующий общие для всех элементов справочника параметры
 * Правила формирования элементов справочника описаны в {@link /dic/README.MD}
 * naim: наименование элемента
 * @version 0.5.3
 * @since 0.5.3
 * @author Vladimir Tsurkanenko
 */
public class Common implements CommonCompatible,Comparable<CommonCompatible> {
    private final String code;
    private final String naim;

    /**
     * Конструктор для создания объекта из строки с сырыми данными
     * @param rawLine - строка с данными
     */
    public Common(String rawLine)  {
        String regexActual = "^([0-9]+)\\|*([0-9]*)\\|*([0-9 ]*)\\|(.+?)\\|(.*?)\\|*([0-9.]+)\\|\\|$";
        naim = rawLine.replaceAll(regexActual,"$4");
        code = rawLine.replaceAll(regexActual,"$1$2$3");
    }

    /**
     * Возвращает код элемента ТНВЭД
     * @since 1.5.3
     * @return Строка с кодом
     */
    public String getCode() {return code;}

    /**
     * Возвращает наименование элемента ТНВЭД
     * @return Строка с наименованием
     */
    public String getNaim() {
            return naim;
    }

    /**
     * Возвращает  код и наименование элемента ТНВЭД одной строкой
     * @return Строка с наименованием
     */
    public String toString() {
        return code + " " + naim;
    }

    @Override
    public int compareTo(@NotNull CommonCompatible o) {
        return this.toString().compareTo(o.toString());
    }

}
