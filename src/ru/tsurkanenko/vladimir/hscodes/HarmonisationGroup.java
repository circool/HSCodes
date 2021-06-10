package ru.tsurkanenko.vladimir.hscodes;

/**
 * Представляет объект, инкапсулирующий массивы с кодами и наименованиями и примечаниями для разделов или товарных групп справочника ТНВЭД
 * расширяет класс HarmonisationItem, дополняя его примечанием note
 * @see ru.tsurkanenko.vladimir.hscodes.HarmonisationItem
 * @version 0.3
 * @author Vladimir Tsurkanenko
 */
class HarmonisationGroup extends HarmonisationItem {
    String[] note;

    /**
     * Конструктор создает новый обьект из строки сырых данных, вычленяя из них код, описание и примечание
     * @param fileName файл с сырыми данными
     */
    HarmonisationGroup(String fileName) {
        super(fileName);
        String regexNote = "^[0-9\\|]*.*?\\|(.*?)\\|.*$";
        String regexFormattingWhat = "([;:])";
        String regexFormattingReplace = "$1\n";
        String[] dataLines = new RawLines(fileName).getRawData();
        note = new String[dataLines.length];
        int currentIndex = 0;
        for (String singleLine:dataLines
        ) {
            note[currentIndex] = singleLine.replaceAll(regexNote,"$1");
            note[currentIndex] = note[currentIndex].replaceAll(regexFormattingWhat,regexFormattingReplace);
            currentIndex++;
        }
    }

    /**
     * Возвращает примечание к разделу или товарной группе
     * @return Строка с примечанием
     */
    String getNote(int index) {
        return note[index];
    }

    /**
     * Возвращаем массив с примечаниями для разделов или товарных позиций, начинающихся на код
     * полученный в качестве параметра
     * @param codeStartFrom Первые символы кода
     * @return массив с примечаниями
     */
    String[] getNotes(String codeStartFrom){
        int firstDigit = Integer.parseInt(codeStartFrom.substring(0,1));
        // сократить длину искомого значения до длины кода
        int thisCodeLength = code[0].length();
        if(thisCodeLength > codeStartFrom.length())
            thisCodeLength = codeStartFrom.length();
        // подсчет количества совпадений
        int totalFound = 0;
        for(int i=indexFirstOne[firstDigit]; i <= indexLastOne[firstDigit]; i++){
            if(code[i].startsWith(codeStartFrom.substring(0,thisCodeLength)))
                totalFound++;
        }
        String[] result = new String[totalFound];
        totalFound = 0;
        for(int i=indexFirstOne[firstDigit]; i <= indexLastOne[firstDigit]; i++){
            if(code[i].startsWith(codeStartFrom.substring(0,thisCodeLength))){
                result[totalFound] = note[i];
                totalFound++;
            }
        }
        return result;
    }
}
