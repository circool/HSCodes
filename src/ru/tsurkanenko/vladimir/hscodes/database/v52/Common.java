package ru.tsurkanenko.vladimir.hscodes.database.v52;

import org.jetbrains.annotations.NotNull;


/**
 * Класс инкапсулирующий общие для всех элементов справочника параметры
 * Правила формирования элементов справочника описаны в {@link /dic/README.MD}
 * naim: наименование элемента
 * @version 0.5.2
 * @since 0.5
 * @author Vladimir Tsurkanenko
 */
public class Common implements CommonCompatible,Comparable<CommonCompatible> {
    final String code;
    final String naim;


    public Common(){
        naim = "";
        code = "";
    }
    /**
     * Конструктор для создания объекта из строки с сырыми данными
     * @param rawLine - строка с данными
     */
    public Common(String rawLine)  {
        String regexActual = "^([0-9]+)\\|*([0-9]*)\\|*([0-9]*)\\|(.+?)\\|(.*?)\\|*([0-9.]+)\\|([0-9.]*)\\|$";
        naim = rawLine.replaceAll(regexActual,"$4");
        code = rawLine.replaceAll(regexActual,"$1$2$3");


    }



    /**
     * Возвращает наименование элемента ТНВЭД
     * @return Строка с наименованием
     */
    public String getNaim() {
            return naim;
    }


    public String toString() {
        return code + " " + naim;
    }

    @Override
    public int compareTo(@NotNull CommonCompatible o) {
        return this.toString().compareTo(o.toString());
    }
}
