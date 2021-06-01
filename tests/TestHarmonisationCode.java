
import ru.tsurkanenko.vladimir.hscodes.HarmonisationCode;


public class TestHarmonisationCode {
    public static void main(String[] args) {

        HarmonisationCode codes = new HarmonisationCode("dic/TNVED1.TXT");
        for (String line:codes.description
             ) {
            System.out.println(line);
        }
    }
}
