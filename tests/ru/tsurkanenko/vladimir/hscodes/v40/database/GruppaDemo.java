package ru.tsurkanenko.vladimir.hscodes.v40.database;



/**
 * Демонстрация класса Gruppa
 *
 */
class GruppaDemo {
    public static void main(String[] args) {
        Dict test = new Dict();
        String code = "96";
        Gruppa scope = test.getGruppa(code);
        System.out.println(scope.toString());
        for (Gruppa x: test.getGruppa()
             ) {
            System.out.println(x.toString());
        }


    }
}