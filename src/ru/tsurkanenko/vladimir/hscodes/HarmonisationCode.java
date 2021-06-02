package ru.tsurkanenko.vladimir.hscodes;

/**
 * @deprecated
 */
public class HarmonisationCode {
    public String[] code;
    public String[] description;
    //private int[] index;
    final String regexCode = "^([0-9]+)\\|([0-9]*)\\|*([0-9]*)\\|*.*$";
    final String regexDescription = "^[0-9|]+(.*?)\\|.*";

    /**
     * deprecated
     * @param fileName file name
     */
    public HarmonisationCode(String fileName) {
        String[] rawData = new RawLines(fileName).getRawData();
        description = new String[rawData.length];
        code = new String[rawData.length];
        int i = 0;
        for (String currentLine: rawData
             ) {
            code[i] = currentLine.replaceAll(regexCode, "$1$2$3");
            description[i] = currentLine.replaceAll(regexDescription, "$1");
            i++;
        }
    }
}
