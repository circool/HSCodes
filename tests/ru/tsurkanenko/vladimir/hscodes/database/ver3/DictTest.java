package ru.tsurkanenko.vladimir.hscodes.database.ver3;

class DictTest {
    public static void main(String[] args) {
        Dict demo = new Dict();
        for (int i = 0; i < demo.getRazdel().length; i++) {
            //System.out.println(demo.getGruppa()[i].getGruppa() + " " + demo.getGruppa()[i].getNaim());
            //if (demo.getGruppa()[i].getGruppa().startsWith("28")) {
                //System.out.println(demo.getRazdel()[i].getCode() + " " + demo.getRazdel()[i].getNaim());
                //System.out.println(demo.getRazdel()[i].getPrim());
           // }
        }
        //System.out.println(demo.getTovSubPos()[0].getTov_SubPoz());

        System.out.println(demo.getRazdel("100").getCode() + " " + demo.getRazdel("100").getNaim());
    }

}