package ru.tsurkanenko.vladimir.hscodes.database;

import java.util.ArrayList;

/**
 * Объект инкапсулирующий в себе все товарные позиции справочника ТНВЭД
 * @author Vladimir Tsurkanenko
 * @version 0.5
 * @since 0.5
 */
public class TovPozScope {
    public TovPoz[] tovPosScope;
    public TovPozScope(String fileName) {
        String[] rawLines = new RawLines(fileName).getRawData();
        String regexTovPosCode = "^([0-9]{2})\\|([0-9]{2})\\|.*?\\|[0-9.]+\\|[0-9.]*\\|$";
        String prevTovPosCode = "0000";
        String curTovPosCode = "";
        ArrayList<TovPoz> result = new ArrayList();
        int totalfound = 0;
        for (int i = 0; i < rawLines.length; i++) {
            curTovPosCode = rawLines[i].replaceAll(regexTovPosCode, "$1$2");
            if (!curTovPosCode.equals(prevTovPosCode)) {
                prevTovPosCode = curTovPosCode;
                result.add(new TovPoz(rawLines[i]));
            } else {
                result.remove(result.size()-1);
                result.add(new TovPoz(rawLines[i]));
            }
        }
        tovPosScope = result.toArray(new TovPoz[0]);
    }
    public TovPoz[] getAll() {
        return tovPosScope;
    }
}

class TovPozScopeDemo{
    public static void main(String[] args) {
        TovPozScope demo = new TovPozScope("dic/TNVED3.TXT");
        for (TovPoz currTovPos:demo.tovPosScope
             ) {
            if(!currTovPos.isActual())
                System.out.println(currTovPos.toString() + " is " + currTovPos.isActual());
        }
    }
}
