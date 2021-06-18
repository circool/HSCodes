package ru.tsurkanenko.vladimir.hscodes.database.ver2;

import java.text.ParseException;

/**
 * Инкапсулирует массивы разделов, групп и товарных позиций в один объект
 * и предоставляет методы для работы с ними
 */

public class Dict {

        final String fileNameRazdelSource = "dic/TNVED1.TXT";
        final String fileNameGruppaSource = "dic/TNVED2.TXT";
        final String fileNameTovPosSource = "dic/TNVED3.TXT";
        final String fileNameTovSubPosSource = "dic/TNVED4.TXT";
        final String universalRegexSearch = "^([0-9]{2})\\|*([0-9]*)\\|(.*?)\\|(.*?)\\|([0-9.]*)\\|([0-9.]*)\\|$";
        final String regex_RAZDEL = "$1";
        final String regexRazdel_NAIM = "$3";
        final String regex_PRIM = "$4";
        final String regex_DATA = "$5";
        final String regex_DATA1 = "$6";
        final String regexGruppa_GRUPPA = "$2";
        final String regexGruppa_NAIM = "$3";
        final String regexTovPos_GRUPPA = "$1";
        final String regexTovPos_TOV_POZ = "$3";
        final String regexTovPos_NAIM = "$4";
        final String regexTovSubPos_GRUPPA = "$1";
        final String regexTovSubPos_TOV_POZ = "$2";
        final String regexTovSubPos_SUB_POZ = "$3";
        final String regexTovSubPos_KR_NAIM = "$4";
        private Razdel[] razdel;

    public Dict() {
        String[] dataLines;

        dataLines = new RawLines(fileNameRazdelSource).getRawData();
        razdel = new Razdel[dataLines.length];
        for (int i = 0; i < dataLines.length; i++) {
            razdel[i] = new Razdel(dataLines[i],universalRegexSearch,regex_RAZDEL,regexRazdel_NAIM,regex_PRIM,regex_DATA,regex_DATA1);
        }
    }

    public Razdel[] getRazdel() {
        return razdel;
    }
    public Razdel getRazdel(int index) {
        return razdel[index];
    }

}
