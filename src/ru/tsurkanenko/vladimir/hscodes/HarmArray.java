package ru.tsurkanenko.vladimir.hscodes;
public class HarmArray {
    HarmItem[] itemsArray;
    private final int indexFirstOne[] = { 0,0,0,0,0,0,0,0,0,0 };
    private int indexLastOne[] = { 0,0,0,0,0,0,0,0,0,0 };

    /**
     * Создание нового массива с разделами, подразделами, товарными группы или товарными позициями.
     *
     * @param fileName имя файла, из которого нужно получить данные
     */
    public HarmArray(String fileName) {
        String[] rawData = new RawLines(fileName).getRawData();
        itemsArray = new HarmItem[rawData.length];
        int i = 0;
        for (String singleLine: rawData){
            itemsArray[i] = (new HarmItem(singleLine));
            i++;
        }
        // Индексация
        String firstOneLetter;
        for(int n = 0; n < itemsArray.length; n++){
            firstOneLetter = itemsArray[n].getCode().substring(0,1);
            int curr = Integer.parseInt(firstOneLetter);
            if(curr > 0 && indexFirstOne[curr] == 0)
                indexFirstOne[curr] = n;
            indexLastOne[curr] = n;
        }
    }

    /**
     * Возвращает весь массив элементов
     *
     * @return массив
     */
    public HarmItem[] getArray() {
        return itemsArray;
    }

    /**
     * Возвращает массив элементов, начинающихся на определенный код
     *
     * @param code Строка, с которой должен начинаться искомый код
     * @return Массив элементов
     */
    public HarmItem[] getArray(String code) {

        String x = code.substring(0,1);
        int thisCodeLength = itemsArray[0].getCode().length();
        if(thisCodeLength > code.length())
            thisCodeLength = code.length();
        int totalFound = 0;
        for(int i=this.getFirstIndex(x); i <= this.getLastIndex(x); i++){
            String debug = this.itemsArray[i].getCode();
            if(this.itemsArray[i].getCode().startsWith(code.substring(0,thisCodeLength)))
                totalFound++;
        }
        HarmItem[] result = new HarmItem[totalFound];
        totalFound = 0;
        int firstIndex = this.getFirstIndex(x);
        int lastIndex = this.getLastIndex(x);
        for(int i=firstIndex; i <= lastIndex; i++){
            if(this.itemsArray[i].getCode().startsWith(code.substring(0,thisCodeLength))){
                result[totalFound] = this.itemsArray[i];
                totalFound++;
            }
        }
        return result;
    }

    /**
     * Возвращает отдельный элемент массива по его индексу
     *
     * @param index индекс элемента
     * @return отдельный элемент массива
     * @deprecated
     */
    public HarmItem getItem(int index){
        return this.itemsArray[index];
    }

    /**
     * Возвращает индекс первого элемента массива, начинающегося с определенного символа
     * @param code Строка, с которой должен начинаться искомый код
     * @return Индекс в массиве кодов
     */
    int getFirstIndex(String code){
        return indexFirstOne[Integer.parseInt(code.substring(0,1))];
    }

    /**
     * Возвращает индекс последнего элемента массива, начинающегося с определенного символа
     *
     * @param code Строка, с которой должен начинаться искомый код
     * @return Индекс в массиве кодов
     */
    private int getLastIndex(String code){
        return indexLastOne[Integer.parseInt(code.substring(0,1))];
    }

    public String[] getItemsView(){
        int totalFound = this.itemsArray.length;
        String[] result = new String[totalFound];
        for(int i = 0; i < totalFound; i++)
            result[i] = itemsArray[i].getCode() + " " + itemsArray[i].getDescription();
        return result;
    }

    public String[] getItemsView(String code){
        HarmItem[] subItems = this.getArray(code);
        int totalFound = subItems.length;
        String[] result = new String[totalFound];
        for(int i = 0; i < totalFound; i++)
            result[i]=subItems[i].getCode() + " " + subItems[i].getDescription();
        return result;
    }
}