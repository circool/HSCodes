package ru.tsurkanenko.vladimir.hscodes.database.ver4;

class DictDemo {
    public static void main(String[] args) {
        Dict demo = new Dict();
        String parent = "01";

        Gruppa[] result1 = demo.getChildrenGruppa(parent);

        for (Gruppa curGruppa:result1
        ) {

            if(curGruppa.isActual()) {
                System.out.println("Группа:");
                System.out.println(curGruppa.getGruppaCode() + "" + curGruppa.getGruppaCode() + " " + curGruppa.getNaim());
                TovPoz[] result2 = demo.getChildrenTovPos(curGruppa.getGruppaCode());
                System.out.println("\tТоварные позиции:");
                for (TovPoz curTovPos:result2
                ) {
                    if(curTovPos.isActual()) {

                        System.out.println("\t" + curTovPos.ParentGruppaCode() + "" + curTovPos.getTovPozCode() + " " + curTovPos.getNaim());

                        TovSubPoz[] result3 = demo.getChildrenTovSubPos(curTovPos.ParentGruppaCode(),curTovPos.getTovPozCode());
                        System.out.println("\t\tТоварные субпозиции:");
                        for(TovSubPoz curTovSubPos:result3){
                            if(curTovSubPos.isActual() )
                                System.out.println("\t\t" + curTovSubPos.ParentGruppaCode()+ "" + curTovSubPos.getTovPozCode()+ " " + curTovSubPos.getTovSubPozCode().charAt(0) + " " + curTovSubPos.getTovSubPozCode().substring(1) + ": " + curTovSubPos.getNaim());
                        }
                    }
                }
                System.out.println();
            }


        }






    }

}