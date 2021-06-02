import ru.tsurkanenko.vladimir.hscodes.*;
public class TestHarmGroup {
    public static void main(String[] args) {
        HarmBase demo = new HarmBase();
        //HarmGroup demoGroup = new HarmGroup("01|01|ЖИВЫЕ ЖИВОТНЫЕ|1. В данную группу включаются все живые животные, Н кроме: (а) рыб, ракообразных, моллюсков и прочих водных Н беспозвоночных товарной позиции 0301, 0306, 0307 или Н 0308; (б) культур микроорганизмов и других продуктов Н товарной позиции 3002; и (в) животных товарной позиции Н 9508.|01.01.2017||");


        System.out.println(demo.getSubSections().getGroupArray()[0].getCode());
        System.out.println(demo.getSubSections().getGroupArray()[0].getDescription());
        System.out.println(demo.getSubSections().getGroupArray()[0].getNote());
    }
}
