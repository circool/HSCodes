package ru.tsurkanenko.vladimir.hscodes;

/**
 * Объект, инкапсулирующий перечни разделов, групп, товарных позиций(субпозиций) и кодов справочника ТНВЭД
 * @version 0.3
 * @author Vladimir Tsurkanenko
 */
class HarmonisationBase {
    private final HarmonisationGroup sections;
    private final HarmonisationGroup groups;
    private final HarmonisationItem positions;
    private final HarmonisationItem items;

    HarmonisationBase() {
        sections = new HarmonisationGroup("dic/TNVED1.TXT");
        //Создание массива из файла с товарными группами
        groups = new HarmonisationGroup("dic/TNVED2.TXT");
        //Создание массива из файла с товарными позициями
        positions = new HarmonisationItem("dic/TNVED3.TXT");
        //Создание массива из файла с кодами
        items = new HarmonisationItem("dic/TNVED4.TXT");
    }

    /**
     * Возвращает массив элементов HarmonisationGroup, содержащих коды, описания и примечания к разделам справочника
     * @return массив с разделами справочника
     */
    public HarmonisationGroup getSections(){
        return sections;
    }
    /**
     * Возвращает массив элементов HarmonisationGroup, содержащих коды, описания и примечания к группам справочника
     * @return массив с группами справочника
     */
    public HarmonisationGroup getGroups() {
        return groups;
    }

    /**
     * Возвращает массив элементов HarmonisationItem, содержащих коды и описания к товарным позициям справочника
     * @return массив с группами справочника
     */
    public HarmonisationItem getPositions(){
        return positions;
    }

    /**
     * Возвращает массив элементов HarmonisationItem, содержащих коды и описания товарных субпозиций и элементов справочника
     * @return массив с элементами справочника
     */
    public HarmonisationItem getItems(){
        return items;
    }
}




