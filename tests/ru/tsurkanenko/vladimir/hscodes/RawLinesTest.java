package ru.tsurkanenko.vladimir.hscodes;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RawLinesTest {


    @Test
    public void getSectionArray() {
        String[] rawLines = new RawLines("dic/TNVED1.TXT").get();
        Assert.assertEquals(22, rawLines.length);
    }


}