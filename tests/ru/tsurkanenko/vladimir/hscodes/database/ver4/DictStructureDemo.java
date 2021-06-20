package ru.tsurkanenko.vladimir.hscodes.database.ver4;


/**
 * Тестирование классов TovSubPos, TovPos, Gruppa, Razdel и DictCommon
 * @version 0.3
 * @author Vladimir Tsurkanenko
 */
class DictStructureDemo {
    public static void main(String[] args) {
        String universalRegexSearch = "^([0-9]{2})\\|*([0-9]*)\\|(.*?)\\|(.*?)\\|([0-9.]*)\\|([0-9.]*)\\|$";
        String regexMainCode = "$1";
        String regexSubCode = "$2";
        String regexNaim = "$3";
        String regexPrim = "$4";
        String regexStartDate = "$5";
        String regexEndDate = "$6";

        String[] dataLines;
        Razdel demoRazdel;
        Gruppa demoGruppa;
// Перебор всех разделов
        dataLines = new RawLines("dic/TNVED1.TXT").getActualData();
        System.out.println("-------- Перебор всех разделов --------");
        for (String rawLine:dataLines
             ) {
            demoRazdel = new Razdel(rawLine);
            System.out.println(demoRazdel.getRazdelCode());
            System.out.println("Наименование: " + demoRazdel.getNaim());
            System.out.println("Примечание: " + demoRazdel.getPrim());
            System.out.println(demoRazdel.getStartData() + " : " + demoRazdel.getEndData());
            System.out.println("--------");
        }

// Перебор всех групп
        dataLines = new RawLines("dic/TNVED2.TXT").getActualData();
        System.out.println("-------- Перебор всех разделов --------");
        for (String rawLine:dataLines
        ) {
            demoGruppa = new Gruppa(rawLine);
            System.out.print(demoGruppa.getGruppaCode());
            System.out.print("-");
            System.out.println(demoGruppa.getGruppaCode());
            System.out.println("Наименование: " + demoGruppa.getNaim());
            System.out.println("Примечание: " + demoGruppa.getPrim());
            System.out.println(demoGruppa.getStartData() + " : " + demoGruppa.getEndData());
            System.out.println("--------");
        }
// Перебор товарных позиций

        dataLines = new RawLines("dic/TNVED3.TXT").getActualData();
        System.out.println("-------- Перебор всех товарных позиций --------");
        for (String rawLine:dataLines
        ) {
            TovPoz demoTovPos = new TovPoz(rawLine);
            System.out.print(demoTovPos.getParentGruppaCode());
            System.out.print("-");
            System.out.println(demoTovPos.getTovPozCode());
            System.out.println("Наименование: " + demoTovPos.getNaim());
            System.out.println(demoTovPos.getStartData() + " : " + demoTovPos.getEndData());

            System.out.println("--------");
        }

// Перебор товарных под-позиций
        dataLines = new RawLines("dic/TNVED4.TXT").getActualData();
        System.out.println("-------- Перебор всех товарных подпозиций --------");
        for (String rawLine:dataLines
        ) {
            TovSubPoz demoTovSubPos = new TovSubPoz(rawLine);
            System.out.print(demoTovSubPos.getParentGruppaCode());
            System.out.print("-");
            System.out.print(demoTovSubPos.getTovPozCode());
            System.out.print("-");
            System.out.println(demoTovSubPos.getTovSubPozCode());
            System.out.println("Наименование: " + demoTovSubPos.getNaim());
            System.out.println(demoTovSubPos.getStartData() + " : " + demoTovSubPos.getEndData());
            if(demoTovSubPos.isActual())
                System.out.println("Действующий");
            else
                System.out.println("Устаревший");

            System.out.println("--------");
        }
    }
}

