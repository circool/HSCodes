package ru.tsurkanenko.vladimir.hscodes.database.v50;

/**
 * Объект инкапсулирующий данные о товарной позиции, субпозиции, подсубпозиции или полного кода ТНВЭД
 * @author Vladimir Tsurkanenko
 * @version 0.5
 * @since 0.5
 */
public class Groups extends DictCommon implements DictGroupsInterface {
    final private String prim;
    public Groups(){
        super();
        prim = "";
    }
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
