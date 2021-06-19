package ru.tsurkanenko.vladimir.hscodes;
/**
 * Представляет объект, инкапсулирующий массивы с кодами и наименованиями товарных позиций или субпозиций ТНВЭД
 * @version 0.3
 * @author Vladimir Tsurkanenko
 */
class HarmonisationItem {
    final String[] code;
    final String[] description;
    final int[] indexFirstOne = new int[10];
    final int[] indexLastOne= new int[10];

    /**
     * Конструктор создает массивы с кодами и описаниями вычленяя их из файла fileName
     * @param fileName файл с сырыми данными 
     */
    HarmonisationItem(String fileName) {
        String[] dataLines = new RawLines(fileName).getRawData();
        String regexCode = "^([0-9]+)\\|([0-9]*)\\|*([0-9]*)\\|*.*$";
        String regexDescription = "^[0-9|]+(.*?)\\|.*";

        code = new String[dataLines.length];
        description = new String[dataLines.length];

        int currentIndex = 0;
        for (String singleLine:dataLines
             ) {
            code[currentIndex] = singleLine.replaceAll(regexCode,"$1$2$3");
            description[currentIndex] = singleLine.replaceAll(regexDescription,"$1");
            currentIndex++;
        }

        // Индексация
        String firstOneLetter;
        for(int n = 0; n < code.length; n++){
            firstOneLetter = code[n].substring(0,1);
            int curr = Integer.parseInt(firstOneLetter);
            if(curr > 0 && indexFirstOne[curr] == 0)
                indexFirstOne[curr] = n;
            indexLastOne[curr] = n;
        }
    }
    /**
     * Возвращает код раздела или товарной группы
     * @return Строка с кодом
     */
    String getCode(int index) {
        return code[index];
    }
    String[] getCode() {
        return code;
    }
    /**
     * Возвращает описание раздела или товарной группы
     * @return Строка с описанием
     */
    String getDescription(int index) {
        return description[index];
    }
    String[] getDescription() {
        return description;
    }
    /**
     * Возвращает строку с кодом и описанием раздела или товарной группы
     * @return Строка с кодом и описанием разделенными пробелом
     */
    String getCodeAndDescription(int index){
        return code[index] + " " + description[index];
    }
    /**
     * Возвращает массив состоящий из строк вида "код описание"
     * @return массив строк
     */
    String[] getCodesAndDescriptions(){
        String[] result = this.code.clone();
        for(int i=0; i<result.length; i++)
            result[i] = code[i] + " " + description[i];
        return result;
    }


    /**
     * Возвращает массив строк в формате "код описание" для кодов, начинающихся с аргумента
     */
    String[] startsWith(String prefix){
        int firstDigit = Integer.parseInt(prefix.substring(0,1));
        // сократить длину искомого значения до длины кода
        int thisCodeLength = code[0].length();
        if(thisCodeLength > prefix.length())
            thisCodeLength = prefix.length();
        // подсчет количества совпадений
        int totalFound = 0;
        for(int i=indexFirstOne[firstDigit]; i <= indexLastOne[firstDigit]; i++){
            if(code[i].startsWith(prefix.substring(0,thisCodeLength)))
                totalFound++;
        }
        String[] result = new String[totalFound];
        totalFound = 0;
        for(int i=indexFirstOne[firstDigit]; i <= indexLastOne[firstDigit]; i++){
            if(code[i].startsWith(prefix.substring(0,thisCodeLength))){
                result[totalFound] = code[i] + " " + description[i];
                totalFound++;
            }
        }
        return result;
    }


}
