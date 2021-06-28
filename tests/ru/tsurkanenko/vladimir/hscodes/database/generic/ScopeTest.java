package ru.tsurkanenko.vladimir.hscodes.database.generic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ScopeTest {

    @Test
    void ScopeGroupsCreate(){
        ScopeGroups scopeGroupsSection = new ScopeGroups("dic/TNVED1.TXT");
        Groups[] allSectionArray = scopeGroupsSection.get();
        Assertions.assertEquals(22, allSectionArray.length);
        Assertions.assertEquals("01 ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ",allSectionArray[0].toString());
        Assertions.assertEquals("ЖИВЫЕ ЖИВОТНЫЕ; ПРОДУКТЫ ЖИВОТНОГО ПРОИСХОЖДЕНИЯ",allSectionArray[0].getNaim());

        Assertions.assertEquals("22 FIFA2018",scopeGroupsSection.startsWith("22")[0].toString());
        Assertions.assertEquals("товары для FIFA",scopeGroupsSection.startsWith("22")[0].getPrim());
        Assertions.assertEquals("22 FIFA2018",allSectionArray[allSectionArray.length-1].toString());
        Assertions.assertEquals(0, allSectionArray[allSectionArray.length-1].compareTo(scopeGroupsSection.startsWith("22")[0]));

        Groups[] selectedSectionArray = scopeGroupsSection.startsWith("0");
        Assertions.assertEquals(9,selectedSectionArray.length);
        selectedSectionArray = scopeGroupsSection.startsWith("01");
        Assertions.assertEquals(1,selectedSectionArray.length);
        selectedSectionArray = scopeGroupsSection.startsWith("011");
        Assertions.assertEquals(0,selectedSectionArray.length);
    }

    @Test
    void ScopeItemsCreate(){
        ScopeItems scopeItemsPosition = new ScopeItems("dic/TNVED4.TXT");
        Items[] allPositionArray = scopeItemsPosition.get();
        //Assertions.assertEquals(943,allPositionArray.length);
        Assertions.assertEquals("0101210000 - - чистопородные племенные животные",allPositionArray[0].toString());
        Assertions.assertEquals("- - чистопородные племенные животные",allPositionArray[0].getNaim());

        Assertions.assertEquals("9999999999 FIFA2018",scopeItemsPosition.startsWith("9999")[0].toString());
        Assertions.assertEquals(0,scopeItemsPosition.startsWith("9999999999")[0].getNestlingLevel());
        Assertions.assertEquals("9999999999 FIFA2018",allPositionArray[allPositionArray.length-1].toString());
        Assertions.assertEquals(0, allPositionArray[allPositionArray.length-1].compareTo((Items) scopeItemsPosition.startsWith("9999")[0]));

        Items[] selectedPositionArray = scopeItemsPosition.startsWith("0");
        //Assertions.assertEquals(74,selectedPositionArray.length);
        //selectedPositionArray = scopeItemsPosition.startsWith("01");
        //Assertions.assertEquals(6,selectedPositionArray.length);
        //selectedPositionArray = scopeItemsPosition.startsWith("010");
        //Assertions.assertEquals(6,selectedPositionArray.length);
        selectedPositionArray = scopeItemsPosition.startsWith("9999999999");
        Assertions.assertEquals(1,selectedPositionArray.length);
        selectedPositionArray = scopeItemsPosition.startsWith("0109");
        Assertions.assertEquals(0,selectedPositionArray.length);
        System.out.println(scopeItemsPosition.get()[0].toString());
        System.out.println(scopeItemsPosition.get().length);
        scopeItemsPosition.add("dic/TNVED4.ADD.TXT");
        System.out.println(scopeItemsPosition.get().length);
        System.out.println(scopeItemsPosition.get()[0].toString());
    }

}