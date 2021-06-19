package ru.tsurkanenko.vladimir.hscodes.database.ver4;


/**
 * Проверка работоспособности класса Gruppa
 */
class GruppaDemo {
    public static void main(String[] args) {
        Dict test = new Dict();
        String code = "01";
        for (Gruppa testGruppa: test.getGruppa()
             ) {
            testGruppa.isActual();

        }
        System.out.println(test.getGruppa(0).getParentRazdelCode());
        System.out.println(test.getGruppa(code).getParentRazdelCode());

    }
}