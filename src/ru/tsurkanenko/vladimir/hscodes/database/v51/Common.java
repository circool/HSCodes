package ru.tsurkanenko.vladimir.hscodes.database.v51;

import org.jetbrains.annotations.NotNull;
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
 * @version 0.5.1
 * @since 0.5
 * @author Vladimir Tsurkanenko
 */
public class Common implements CommonCompatible,Comparable<CommonCompatible> {
    final String code;
    final String naim;
    //TODO Удалить после исключения методов getStartData и getEndData
    private Date startData;
    private Date endData;
    private Date noData;

    public Common(){
        {
            //TODO Удалить после исключения методов getStartData и getEndData
            DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            try {
                noData = format.parse("01.01.0000");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            startData = noData;
            endData = noData;
        }
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

        {
            //TODO Удалить после исключения методов getStartData и getEndData
            DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            try {
                noData = format.parse("01.01.0000");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                startData = format.parse(rawLine.replaceAll(regexActual,"$6"));
            } catch (Exception e){
                startData = noData;
            }
            try {
                endData = format.parse(rawLine.replaceAll(regexActual,"$7"));
            } catch (Exception e){
                endData = noData;
            }
        }
    }

    /**
     * Возвращает дату, начиная с которой элемент был актуален
     * @return - Дата начала действия
     */
    //TODO Удалить после исключения методов getStartData и getEndData
    public Date getStartData() {
        return startData;
    }
    /**
     * Возвращает дату, начиная с которой элемент стал неактуален
     * @return - Дата окончания действия или 01.01.0000 для действующих
     */
    //TODO Удалить после исключения методов getStartData и getEndData
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
    //TODO Удалить после исключения методов getStartData и getEndData
    public boolean isActual() {
        return endData.equals(noData);
    }

    public String toString() {
        return code + " " + naim;
    }

    @Override
    public int compareTo(@NotNull CommonCompatible o) {
        return this.toString().compareTo(o.toString());
    }
}
