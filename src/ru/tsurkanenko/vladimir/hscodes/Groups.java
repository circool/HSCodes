package ru.tsurkanenko.vladimir.hscodes;

/**
 * Объект инкапсулирующий данные о товарной позиции, субпозиции, подсубпозиции или полного кода ТНВЭД
 * @author Vladimir Tsurkanenko
 * @version 0.5.3
 * @since 0.5
 */
public class Groups extends Common {
    final private String prim;

    /**
     * Конструктор для создания объекта из строки с сырыми данными
     *
     * @param rawLine - строка с данными
     */
    Groups(String rawLine) {
        super(rawLine);

        String regexPrim  = "^[0-9|]*\\|.*?\\|(.*?)\\|([0-9.|]+)$";
        String tmp = rawLine.replaceAll(regexPrim,"$1");
        tmp = tmp.replaceAll("(\\s)([0-9]+\\.\\s)([А-Яа-я]+)", "\n$2$3");
        prim = tmp.replaceAll("([:;]\\s*и*)\\s+(\\([а-я]\\))", "$1\n\t$2");

    }

    /**
     * Возвращает примечание к разелу или группе
     * @return Строка с примечанием к разделу или группе
     */
    public String getPrim() {
        return prim;
    }
}
