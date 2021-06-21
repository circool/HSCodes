package ru.tsurkanenko.vladimir.hscodes.database;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс инкапсулирующий общие для всех элементов справочника параметры
 * Правила формирования элементов справочника описаны в {@link /dic/README.MD}
 * naim: наименование элемента
 * startData: для всех элементов DATA (Дата начала действия)
 * endData: для всех элементов DATA1 (Дата окончания действия)
 * @version 0.4
 * @since 0.4
 * @author Vladimir Tsurkanenko
 */
class DictCommon {
    private final String naim;
    private Date startData;
    private Date endData;
    private Date noData;

    /**
     * Конструктор для создания объекта из строки с сырыми данными
     * @param rawLine - строка с данными
     */
    public DictCommon(String rawLine)  {
        String regexSearch = "^(\\d{2})[0-9|]*(.*?)\\|.*?\\|([0-9.]+)\\|([0-9.]*)\\|$";
        naim = rawLine.replaceAll("^[0-9|]+([^|]+).*\n*","$1");
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            noData = format.parse("01.01.0000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            startData = format.parse(rawLine.replaceAll(regexSearch,"$3"));
        } catch (Exception e){
            startData = noData;
        }
        try {
            endData = format.parse(rawLine.replaceAll(regexSearch,"$4"));
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
     * Возвращает наименование элемента ТНВЭД
     * @return Строка с наименованием
     */
    public String getNaim() {
            return naim;
    }
    /**
     * Возвращает результат проверки на актуальность записи
     * @return true для действующих записей, false - для устаревших
     */
    public boolean isActual() {
        return endData.equals(noData);
    }
}