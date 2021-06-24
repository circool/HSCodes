package ru.tsurkanenko.vladimir.hscodes.database;

import java.util.ArrayList;

/**
 * Объект инкапсулирующий в себе все товарные позиции справочника ТНВЭД
 * @author Vladimir Tsurkanenko
 * @version 0.5
 * @since 0.5
 */
public class TovPozScope {
    TovPoz[] tovPosScope;
    public TovPozScope(String fileName) {
        String[] rawLines = new RawLines(fileName).getRawData();
        String regexTovPosCode = "^([0-9]{2})\\|([0-9]{2})\\|.*?\\|[0-9.]+\\|[0-9.]*\\|$";
        String prevTovPosCode = "0000";
        String curTovPosCode;
        ArrayList<TovPoz> result = new ArrayList<>();

        for (String rawLine : rawLines) {
            curTovPosCode = rawLine.replaceAll(regexTovPosCode, "$1$2");
            if (!curTovPosCode.equals(prevTovPosCode))
                prevTovPosCode = curTovPosCode;
            else
                result.remove(result.size() - 1);
            result.add(new TovPoz(rawLine));
        }
        tovPosScope = result.toArray(new TovPoz[0]);
    }
    public TovPoz[] getAll() {
        return tovPosScope;
    }
}


