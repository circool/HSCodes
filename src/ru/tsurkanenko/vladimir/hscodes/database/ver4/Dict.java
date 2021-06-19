package ru.tsurkanenko.vladimir.hscodes.database.ver4;

import java.util.ArrayList;

/**
 * Инкапсулирует массивы разделов, групп и товарных позиций в один объект
 * и предоставляет методы для работы с ними
 * @version 0.4
 * @since 0.4
 * @author Vladimir Tsurkanenko
 */
class Dict {

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
        String fileNameTovPosSource = "dic/TNVED3.TXT";
        dataLines = new RawLines(fileNameTovPosSource).getActualData();
        tovPoz = new TovPoz[dataLines.length];
        for (int i = 0; i < dataLines.length; i++) {
            tovPoz[i] = new TovPoz(dataLines[i]);
        }
        String fileNameTovSubPosSource = "dic/TNVED4.TXT";
        dataLines = new RawLines(fileNameTovSubPosSource).getActualData();
        tovSubPoz = new TovSubPoz[dataLines.length];
        for (int i = 0; i < dataLines.length; i++) {
            tovSubPoz[i] = new TovSubPoz(dataLines[i]);
        }
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
        return new Razdel();
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
     * Возвращает одиночный раздел с заданным кодом
     * @param code Код группы
     * @return Объект инкапсулирующий свойства группы или пустой объект
     */
    public Gruppa getGruppa(String code) {
        for (Gruppa value : gruppa) {
            if (value.getGruppaCode().equals(code))
                return value;
        }
        return new Gruppa();
    }
    /**
     * Возвращает массив с дочерними группами
     * @param parentRazdel Код раздела
     */
    public Gruppa[] getChildrenGruppa(String parentRazdel){
        ArrayList<Gruppa> totalFound = new ArrayList<>();
        for (Gruppa currGruppa:this.getGruppa()
             ) {
            if(currGruppa.getGruppaCode().equals(parentRazdel))
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
            if (tovPos.ParentGruppaCode().equals(gruppa) & tovPos.getTovPozCode().equals(tovPoz))
                return tovPos;
        }
        return new TovPoz();
    }
    /**
     * Возвращает массив с дочерними позициями
     * @param parentGruppa Код родительской группы
     */
    public TovPoz[] getChildrenTovPos(String parentGruppa){
        ArrayList<TovPoz> totalFound = new ArrayList<>();
        for (TovPoz currTovPos:this.getTovPoz()
        ) {
            if(currTovPos.ParentGruppaCode().equals(parentGruppa))
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
    public TovSubPoz getTovSubPos(int index) {
        return tovSubPoz[index];
    }
    /**
     * Возвращает одиночную субпозицию с заданным кодом
     * @param tovPoz Код субпозиции
     * @return Объект инкапсулирующий свойства раздела или пустой объект
     */
    public TovSubPoz getTovSubPos(String gruppa, String tovPoz, String tovSubPoz) {
        for (TovSubPoz currTovSubPoz : this.tovSubPoz) {
            if (currTovSubPoz.ParentGruppaCode().equals(gruppa) & currTovSubPoz.getTovPozCode().equals(tovPoz) & currTovSubPoz.getTovSubPozCode().equals(tovSubPoz))
                return currTovSubPoz;
        }
        return new TovSubPoz();
    }
    /**
     * Возвращает массив с дочерними подпозициями
     * @param parentGruppa Код родительской товарной группы
     * @param parentTovPos Код родительской товарной позиции
     */
    public TovSubPoz[] getChildrenTovSubPos(String parentGruppa, String parentTovPos){
        ArrayList<TovSubPoz> totalFound = new ArrayList<>();
        for (TovSubPoz currTovSubPos:this.getTovSubPoz()
        ) {
            if(currTovSubPos.ParentGruppaCode().equals(parentGruppa) & currTovSubPos.getTovPozCode().equals(parentTovPos))
                totalFound.add(currTovSubPos);
        }
        TovSubPoz[] result = new TovSubPoz[totalFound.size()];
        result = totalFound.toArray(result);
        return result;
    }
}
