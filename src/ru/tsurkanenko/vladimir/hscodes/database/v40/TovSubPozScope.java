package ru.tsurkanenko.vladimir.hscodes.database.v40;

import ru.tsurkanenko.vladimir.hscodes.database.RawLines;
import java.util.ArrayList;


/**
 * Объект инкапсулирующий в себе все товарные позиции справочника ТНВЭД
 * @author Vladimir Tsurkanenko
 * @version 0.4
 * @since 0.4
 */
/*
2 первые цифры – товарная группа ТН ВЭД:    (84 - Реакторы ядерные, котлы, оборудование и механические устройства; их части);
4 первые цифры – товарная позиция ТН ВЭД:   (8458 - Станки токарные (включая станки токарные многоцелевые) металлорежущие);
6 первых цифр – субпозиция ТН ВЭД:          (845811 - С числовым программным управлением);
8 первых цифр – подсубпозиция ТН ВЭД:       (84581141 - Одношпиндельные);
10 цифр, полный код товара – подсубпозиция ТН ВЭД:
 */

public class TovSubPozScope {
    final TovSubPoz[] tovSubPozScope;
    public TovSubPozScope(String fileName) {
        String[] rawLines = new RawLines(fileName).getRawData();
        String regexTovSubPozCode = "^([0-9]{2})\\|([0-9]{2})\\|(\\d{6})\\|.*?\\|[0-9.]+\\|[0-9.]*\\|$";
        String prevTovSubPozCode = "00000000";
        String curTovSubPozCode;
        ArrayList<TovSubPoz> result = new ArrayList<>();

        for (String rawLine : rawLines) {
            curTovSubPozCode = rawLine.replaceAll(regexTovSubPozCode, "$1$2$3");
            if(curTovSubPozCode.matches("\\d{5}00000")){
                if (!curTovSubPozCode.equals(prevTovSubPozCode))
                    prevTovSubPozCode = curTovSubPozCode;
                else
                    result.remove(result.size() - 1);
                result.add(new TovSubPoz(rawLine));
            }
        }
        tovSubPozScope = result.toArray(new TovSubPoz[0]);
    }
    public TovSubPoz[] getAll() {
        return tovSubPozScope;
    }
}


