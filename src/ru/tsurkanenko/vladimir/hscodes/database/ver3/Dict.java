package ru.tsurkanenko.vladimir.hscodes.database.ver3;

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
    private final TovPos[] tovPos;
    private final TovSubPos[] tovSubPos;

    public Dict() {
        String fileNameRazdelSource = "dic/TNVED1.TXT";
        String[] dataLines = new RawLines(fileNameRazdelSource).getActualData();
        razdel = new Razdel[dataLines.length];
        for (int i = 0; i < dataLines.length; i++) {
            razdel[i] = new Razdel(dataLines[i]);
        }
        String fileNameGruppaSource = "dic/TNVED2.TXT";
        dataLines = new RawLines(fileNameGruppaSource).getRawData();
        gruppa = new Gruppa[dataLines.length];
        for (int i = 0; i < dataLines.length; i++) {
            gruppa[i] = new Gruppa(dataLines[i]);
        }
        String fileNameTovPosSource = "dic/TNVED3.TXT";
        dataLines = new RawLines(fileNameTovPosSource).getRawData();
        tovPos = new TovPos[dataLines.length];
        for (int i = 0; i < dataLines.length; i++) {
            tovPos[i] = new TovPos(dataLines[i]);
        }
        String fileNameTovSubPosSource = "dic/TNVED4.TXT";
        dataLines = new RawLines(fileNameTovSubPosSource).getRawData();
        tovSubPos = new TovSubPos[dataLines.length];
        for (int i = 0; i < dataLines.length; i++) {
            tovSubPos[i] = new TovSubPos(dataLines[i]);
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
     * Возвращает одиночный раздел справочника
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
            if (value.getCode().equals(code))
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
            if (value.getCode().equals(code))
                return value;
        }
        return new Gruppa();
    }
    /**
     * Возвращает массив с дочерними группами
     */
    public Gruppa[] getChildren(String parent){
        //TODO Сделать метод getChildren
        Gruppa[] result = new Gruppa[0];

        return result;
    }

    /**
     * Возвращает массив с товарными позициями справочника
     * @return Массив объектов инкапсулирующих свойства товарной позиции
     */
    public TovPos[] getTovPos() {
        return tovPos;
    }
    public TovPos getTovPos(int index) {
        return tovPos[index];
    }
    public TovPos getTovPos(String code) {
        for (TovPos tovPo : tovPos) {
            if (tovPo.getCode().equals(code))
                return tovPo;
        }
        return new TovPos();
    }

    /**
     * Возвращает массив с товарными подпозициями справочника
     * @return Массив объектов инкапсулирующих свойства подпозиции
     */
    public TovSubPos[] getTovSubPos() {
        return tovSubPos;
    }
    public TovSubPos getTovSubPos(int index) {
        return tovSubPos[index];
    }
    /**
     * Возвращает одиночную субпозицию с заданным кодом
     * @param code Код субпозиции
     * @return Объект инкапсулирующий свойства раздела или пустой объект
     */
    public TovSubPos getTovSubPos(String code) {
        for (TovSubPos tovSubPo : tovSubPos) {
            if (tovSubPo.getCode().equals(code))
                return tovSubPo;
        }
        return new TovSubPos();
    }
}
