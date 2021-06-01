package ru.tsurkanenko.vladimir.hscodes;

public class HarmGroupArray {
    private HarmGroup[] groupArray;
    private final String regexNote = "";

    public HarmGroupArray(String fileName) {
        String[] source = new RawLines(fileName).getRawData();
        groupArray = new HarmGroup[source.length];
        int i = 0;
        for (String singleLine: source){
            groupArray[i] = (new HarmGroup(singleLine));
            i++;
        }

    }

    public HarmGroup[] getGroupArray() {
        return groupArray;
    }

    public HarmGroup getGroup(int index){
        return this.groupArray[index];
    }

}