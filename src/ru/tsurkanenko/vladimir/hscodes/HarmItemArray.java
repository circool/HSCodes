package ru.tsurkanenko.vladimir.hscodes;

public class HarmItemArray {
    private HarmItem[] itemArray;


    public HarmItemArray(String fileName) {
        String[] rawData = new RawLines(fileName).getRawData();
        itemArray = new HarmItem[rawData.length];
        int i = 0;
        for (String singleLine: rawData){
            itemArray[i] = (new HarmItem(singleLine));
            i++;
        }
    }

    public HarmItem[] getItemArray() {
        return itemArray;
    }
}
