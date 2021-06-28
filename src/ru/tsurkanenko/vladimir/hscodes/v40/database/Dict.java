package ru.tsurkanenko.vladimir.hscodes.v40.database;

import ru.tsurkanenko.vladimir.hscodes.RawLines;

import java.util.ArrayList;

/**
 * Инкапсулирует массивы разделов, групп и товарных позиций в один объект
 * и предоставляет методы для работы с ними
 * @version 0.4
 * @since 0.4
 * @author Vladimir Tsurkanenko
 */
public class Dict {

    private final Razdel[] razdel;
    private final Gruppa[] gruppa;
    private final TovPoz[] tovPoz;
    private final TovSubPoz[] tovSubPoz;

    public Dict() {
        String fileNameRazdelSource = "dic/TNVED1.TXT";
        String[] dataLines = new RawLines(fileNameRazdelSource).getActualData();
        razdel = new Razdel[dataLines.length];
        for (int i = 0; i < dataLines.length; i++) {
            razdel[i] = new Razdel(dataLines[i]);
        }
        String fileNameGruppaSource = "dic/TNVED2.TXT";
        dataLines = new RawLines(fileNameGruppaSource).getActualData();
        gruppa = new Gruppa[dataLines.length];
        for (int i = 0; i < dataLines.length; i++) {
            gruppa[i] = new Gruppa(dataLines[i]);
        }

        String fileNameTovPozSource = "dic/TNVED3.TXT";
        dataLines = new RawLines(fileNameTovPozSource).getActualData();
        tovPoz = new TovPoz[dataLines.length];
        for (int i = 0; i < dataLines.length; i++) {
            tovPoz[i] = new TovPoz(dataLines[i]);
        }

        String fileNameTovSubPozSource = "dic/TNVED4.TXT";
        dataLines = new RawLines(fileNameTovSubPozSource).getActualData();
        tovSubPoz = new TovSubPoz[dataLines.length];
        for (int i = 0; i < dataLines.length; i++) {
            tovSubPoz[i] = new TovSubPoz(dataLines[i]);
        }

        //tovSubPoz = new TovSubPozScope(fileNameTovSubPosSource).getAll();

    }

    /**
     * Возвращает массив с разделами справочника
     * @return Массив объектов инкапсулирующих свойства раздела
     */
    public Razdel[] getRazdel() {
        return razdel;
    }
    /**
     * Возвращает одиночный раздел справочника по его индексу в массиве
     * @param index Индекс массива разделов
     * @return Объект инкапсулирующий свойства раздела
     */
    public Razdel getRazdel(int index) {
        return razdel[index];
    }
    /**
     * Возвращает одиночный раздел с заданным кодом
     * @param code Код раздела
     * @return Объект инкапсулирующий свойства раздела или пустой объект
     */
    public Razdel getRazdel(String code) {
        for (Razdel value : razdel) {
            if (value.getRazdelCode().equals(code))
                return value;
        }
        return new Razdel("");
    }

    /**
     * Возвращает массив с группами справочника
     * @return Массив объектов инкапсулирующих свойства группы
     */
    public Gruppa[] getGruppa() {
        return gruppa;
    }
    /**
     * Возвращает одиночную группу справочника по ее индексу в массиве
     * @param index Индекс массива групп
     * @return Объект инкапсулирующий свойства группы
     */
    public Gruppa getGruppa(int index) {
        return gruppa[index];
    }
    /**
     * Возвращает одиночную группу с заданным кодом
     * @param code Код группы
     * @return Объект инкапсулирующий свойства группы или пустой объект
     */
    public Gruppa getGruppa(String code) {
        for (Gruppa value : gruppa) {
            if (value.getGruppaCode().equals(code))
                return value;
        }
        return new Gruppa("");
    }
    /**
     * Возвращает одиночную группу с заданным кодом
     * @param razdelCode Код родительского раздела
     * @param gruppaCode Код группы
     * @return Объект инкапсулирующий свойства группы или пустой объект
     */
    public Gruppa getGruppa(String razdelCode, String gruppaCode) {
        for (Gruppa value : gruppa) {
            if (value.getGruppaCode().equals(gruppaCode) & value.getParentRazdelCode().equals(razdelCode))
                return value;
        }
        return new Gruppa("");
    }
    /**
     * Возвращает массив с дочерними группами
     * @param parentRazdel Код раздела
     */
    public Gruppa[] getChildrenGruppa(String parentRazdel){
        ArrayList<Gruppa> totalFound = new ArrayList<>();
        for (Gruppa currGruppa:this.getGruppa()
             ) {
            if(currGruppa.getParentRazdelCode().equals(parentRazdel))
                totalFound.add(currGruppa);
        }
        Gruppa[] result = new Gruppa[totalFound.size()];
        result = totalFound.toArray(result);
        return result;
    }

    /**
     * Возвращает массив с товарными позициями справочника
     * @return Массив объектов инкапсулирующих свойства товарной позиции
     */
    public TovPoz[] getTovPoz() {
        return tovPoz;
    }
    /**
     * Возвращает одиночную товарную позицию справочника по ее индексу в массиве
     * @param index Индекс массива товарных позиций
     * @return Объект инкапсулирующий свойства товарной позиции
     */
    public TovPoz getTovPoz(int index) {
        return tovPoz[index];
    }
    /**
     * Возвращает одиночную товарную позицию справочника по ее коду
     * @param gruppa Код группы
     * @param tovPoz Код товарной позиции
     * @return Объект инкапсулирующий свойства товарной позиции
     */
    public TovPoz getTovPoz(String gruppa, String tovPoz) {
        for (TovPoz tovPos : this.tovPoz) {
            if (tovPos.getGruppaCode().equals(gruppa) & tovPos.getTovPozCode().equals(tovPoz))
                return tovPos;
        }
        return new TovPoz("");
    }
    /**
     * Возвращает массив с дочерними позициями
     * @param parentGruppa Код родительской группы
     */
    public TovPoz[] getChildrenTovPoz(String parentGruppa){
        ArrayList<TovPoz> totalFound = new ArrayList<>();
        for (TovPoz currTovPos:this.getTovPoz()
        ) {
            if(currTovPos.getGruppaCode().equals(parentGruppa))
                totalFound.add(currTovPos);
        }
        TovPoz[] result = new TovPoz[totalFound.size()];
        result = totalFound.toArray(result);
        return result;
    }

    /**
     * Возвращает массив с товарными подпозициями справочника
     * @return Массив объектов инкапсулирующих свойства подпозиции
     */
    public TovSubPoz[] getTovSubPoz() {
        return tovSubPoz;
    }
    /**
     * Возвращает одиночный элемент подпозиции по его индексу
     * @param index индекс элемента в массиве
     * @return элемент массива
     */
    public TovSubPoz getTovSubPoz(int index) {
        return tovSubPoz[index];
    }
    /**
     * Возвращает одиночную субпозицию с заданным кодом
     * @param tovPoz Код субпозиции
     * @return Объект инкапсулирующий свойства раздела или пустой объект
     */
    public TovSubPoz getTovSubPoz(String gruppa, String tovPoz, String tovSubPoz) {
        for (TovSubPoz currTovSubPoz : this.tovSubPoz) {
            if (currTovSubPoz.getGruppaCode().equals(gruppa) & currTovSubPoz.getTovPozCode().equals(tovPoz) & currTovSubPoz.getTovSubPozCode().equals(tovSubPoz))
                return currTovSubPoz;
        }
        return new TovSubPoz("");
    }
    /**
     * Возвращает массив с дочерними подпозициями
     * @param parentGruppa Код родительской товарной группы
     * @param parentTovPoz Код родительской товарной позиции
     */
    //TODO Список товарных подпозиций формируется без учета вложенности. Нужно разобраться, как это исправить
    public TovSubPoz[] getChildrenTovSubPoz(String parentGruppa, String parentTovPoz){
        ArrayList<TovSubPoz> totalFound = new ArrayList<>();
        for (TovSubPoz currTovSubPos:this.getTovSubPoz()
        ) {
            if(currTovSubPos.getGruppaCode().equals(parentGruppa) & currTovSubPos.getTovPozCode().equals(parentTovPoz))
                totalFound.add(currTovSubPos);
        }
        TovSubPoz[] result = new TovSubPoz[totalFound.size()];
        result = totalFound.toArray(result);
        return result;
    }

    /**
     * Возвращает список товарных позиций или подпозиций справочника с учетом их уровня вложенности
     * Пример уровня вложенности:
     * 0-й уровень:
     *  - коды состоящие из 6-ти нулей:                                     9604 00 000 0    Сита и решета ручные
     *  1-й уровень:
     *  - коды с 5-ю нулями и имеющие один дефис в описании:                0101 20 000 0    - лошади:
     *  2-й уровень:
     *  - коды с 4-мя замыкающими нулями и двумя дефисами в наименовании:   0101 21 000 0   - - чистопородные племенные животные
     * итд
     * @param gruppaCode первые две цифры 10-значного кода НТВЭД (товарная группа)
     * @param TovPosCode 2-4я цифры 10-значного кода НТВЭД (товарная позиция)
     * @param nestlingLevel уровень вложенности
     * @return Массив элементов
     */
    public TovSubPoz[] getNestledTovSubPoz(String gruppaCode, String TovPosCode, int nestlingLevel){
        String regexNestling = "000000";
        switch (nestlingLevel){
            case 0:
                regexNestling = "000000";
                break;
            case 1:
                regexNestling = "[1-9]00000";
                break;
            case 2:
                regexNestling = "[1-9]{2}0000";
                break;
            case 3:
                regexNestling = "[1-9]{3}000";
                break;
            case 4:
                regexNestling = "[1-9]{4}00";
                break;
            case 5:
                regexNestling = "[1-9]{5}00";
                break;
        }
        ArrayList<TovSubPoz> result = new ArrayList<>();
        for(TovSubPoz currItem:tovSubPoz)

            if(currItem.getGruppaCode().equals(gruppaCode) &
                    currItem.getTovPozCode().equals(TovPosCode) &
                    currItem.getTovSubPozCode().matches(regexNestling)){
                result.add(currItem);
            }

        return result.toArray(new TovSubPoz[0]);

    }
}
