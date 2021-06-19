package ru.tsurkanenko.vladimir.hscodes.database.ver2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс инкапсулирующий общие для всех элементов справочника параметры
 * Правила формирования элементов справочника описаны в {@link /dic/README.MD}
 * mainCode: для разделов и групп - RAZDEL, для товарных позиций и под-позиций - GRUPPA
 * startData: для всех элементов DATA (Дата начала действия)
 * endData: для всех элементов DATA1 (Дата окончания действия)
 * @version 0.2
 * @author Vladimir Tsurkanenko
 */
class DictCommon {
    char[] mainCode;
    Date startData;
    Date endData;
    Date noData;
    final DateFormat format;

    /**
     * Конструктор
     * @param rawLine - строка с данными
     * @param regexSearch - regex последовательность для поиска полей
     * @param regexCode - regex последовательность указывающая на RAZDEL или GRUPPA
     * @param regexStartDate - regex последовательность указывающая на DATE
     * @param regexEndDate - regex последовательность указывающая на DATE
     */
    public DictCommon(
            String rawLine,
            String regexSearch,
            String regexCode,
            String regexStartDate,
            String regexEndDate
    )  {
        format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            noData = format.parse("01.01.0000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mainCode = new char[2];
        mainCode = rawLine.replaceAll(regexSearch,regexCode).toCharArray();
        try {
            startData = format.parse(rawLine.replaceAll(regexSearch,regexStartDate));
        } catch (Exception e){
            startData = noData;
        }
        try {
            endData = format.parse(rawLine.replaceAll(regexSearch,regexEndDate));
        } catch (Exception e){
            endData = noData;
        }
    }

    /**
     * Возвращает дату, начиная с которой элемент был актуален
     * @return - Дата начала действия
     */
    public Date getStartData() {
        return startData;
    }
    /**
     * Возвращает дату, начиная с которой элемент стал неактуален
     * @return - Дата окончания действия или 01.01.0000 для действующих
     */
    public Date getEndData() {
        return endData;
    }

    /**
     * Возвращает корневой код RAZDEL или GRUPPA в зависимости от того, что находится в объекте - раздел, группа, товарная позиция или под-позиция
     * @return RAZDEL для разделов и групп, GRUPPA для позиций и под-позиций
     */
    public char[] getCode() {
        return mainCode;
    }

    /**
     * Возвращает результат проверки на актуальность записи
     * @return true для действующих записей, false - для устаревших
     */
    public boolean isActual() {
        return endData.equals(noData);
    }

    <T extends Comparable<T>> boolean haveItem(T x) {
        for (char c : mainCode) {
            if (x.equals(c)) return true;
        }
        return false;
    }
}