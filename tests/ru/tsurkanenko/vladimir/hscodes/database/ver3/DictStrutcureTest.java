package ru.tsurkanenko.vladimir.hscodes.database.ver3;


/**
 * Тестирование классов TovSubPos, TovPos, Gruppa, Razdel и DictCommon
 * @version 0.3
 * @author Vladimir Tsurkanenko
 */
class DictStructureTest{
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
            System.out.println(demoRazdel.getCode());
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
            System.out.print(demoGruppa.getCode());
            System.out.print("-");
            System.out.println(demoGruppa.getGruppa());
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
            TovPos demoTovPos = new TovPos(rawLine);
            System.out.print(demoTovPos.getCode());
            System.out.print("-");
            System.out.println(demoTovPos.getTov_poz());
            System.out.println("Наименование: " + demoTovPos.getNaim());
            System.out.println(demoTovPos.getStartData() + " : " + demoTovPos.getEndData());

            System.out.println("--------");
        }

// Перебор товарных под-позиций
        dataLines = new RawLines("dic/TNVED4.TXT").getActualData();
        System.out.println("-------- Перебор всех товарных подпозиций --------");
        for (String rawLine:dataLines
        ) {
            TovSubPos demoTovSubPos = new TovSubPos(rawLine);
            System.out.print(demoTovSubPos.getCode());
            System.out.print("-");
            System.out.print(demoTovSubPos.getTov_poz());
            System.out.print("-");
            System.out.println(demoTovSubPos.getTov_SubPoz());
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

