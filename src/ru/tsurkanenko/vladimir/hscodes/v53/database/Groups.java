package ru.tsurkanenko.vladimir.hscodes.v53.database;

/**
 * Объект инкапсулирующий данные о товарной позиции, субпозиции, подсубпозиции или полного кода ТНВЭД
 * @author Vladimir Tsurkanenko
 * @version 0.5.2
 * @since 0.5
 */
public class Groups extends Common {
    final private String prim;

    /**
     * Конструктор для создания объекта из строки с сырыми данными
     *
     * @param rawLine - строка с данными
     */
    public Groups(String rawLine) {
        super(rawLine);

        String regexPrim  = "^[0-9|]*\\|.*?\\|(.*?)\\|([0-9.|]+)$";
        prim = rawLine.replaceAll(regexPrim,"$1");
    }

    /**
     * Возвращает примечание к разелу или группе
     * @return Строка с примечанием к разделу или группе
     */
    public String getPrim() {
        return prim;
    }
}
