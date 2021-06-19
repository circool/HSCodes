package ru.tsurkanenko.vladimir.hscodes.database.ver4;


/**
 * Проверка работоспособности класса Gruppa
 */
class GruppaDemo {
    public static void main(String[] args) {
        Dict test = new Dict();
        //Gruppa testGruppa = test.getGruppa(1);
        for (Gruppa testGruppa: test.getGruppa()
             ) {
            if(testGruppa.isActual()){
                //System.out.print("Раздел: " + testGruppa.getParentRazdelCode());
                //System.out.print(", Группа: " + testGruppa.getGruppaCode());
                //System.out.println(", Наименование: " + testGruppa.getNaim());
                //System.out.println("Примечание: " + testGruppa.getPrim());
            }

        }
        System.out.println(test.getGruppa(0).getParentRazdelCode());
        System.out.println(test.getGruppa("01").getParentRazdelCode());

    }
}