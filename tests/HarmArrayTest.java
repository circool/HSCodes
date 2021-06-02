import ru.tsurkanenko.vladimir.hscodes.HSBase;
import ru.tsurkanenko.vladimir.hscodes.HarmGroup;
import ru.tsurkanenko.vladimir.hscodes.HarmItem;

public class HarmArrayTest {
    public static void main(String[] args) {
        HSBase demo = new HSBase();
        System.out.println(demo.getSection().getList("01")[0]);
        //HarmGroup a = new HarmGroup(raw);
        //HarmItem b = new HarmGroup(raw);
        //HarmItem c = new HarmItem(raw);


        //String a1 = a.getNote();
        //String b1 = b.getDescription();
        //String c1 = c.getDescription();

        //System.out.println(a1);
        //System.out.println(b1);
        //System.out.println(c1);
    }
}
