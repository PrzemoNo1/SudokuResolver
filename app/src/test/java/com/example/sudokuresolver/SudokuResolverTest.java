package com.example.sudokuresolver;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SudokuResolverTest {
    @Test
    public void addition_isCorrect() {
        SudokuResolver resolver = new SudokuResolver(Arrays.asList(
                "", "3", "", "", "", "5", "", "2", "",
                "9", "", "", "", "1", "", "", "", "",
                "", "", "5", "9", "3", "6", "1", "", "",
                "", "4", "", "", "", "9", "3", "6", "",
                "2", "", "1", "8", "", "", "", "", "5",
                "", "", "", "", "", "", "", "", "",
                "", "", "", "", "4", "", "8", "", "",
                "3", "", "", "7", "9", "8", "", "4", "",
                "", "", "8", "6", "", "", "", "", "1"
        ));
        assertEquals(3, resolver.getField("12"));
        assertEquals(5, resolver.getField("16"));
        assertEquals(2, resolver.getField("18"));
        assertEquals(9, resolver.getField("21"));
        assertEquals(1, resolver.getField("25"));
        assertEquals(5, resolver.getField("33"));
        assertEquals(9, resolver.getField("34"));
        assertEquals(3, resolver.getField("35"));
        assertEquals(6, resolver.getField("36"));
        assertEquals(1, resolver.getField("37"));
        assertEquals(4, resolver.getField("42"));
        assertEquals(9, resolver.getField("46"));
        assertEquals(3, resolver.getField("47"));
        assertEquals(6, resolver.getField("48"));
        assertEquals(2, resolver.getField("51"));
        assertEquals(1, resolver.getField("53"));
        assertEquals(8, resolver.getField("54"));
        assertEquals(5, resolver.getField("59"));
        assertEquals(4, resolver.getField("75"));
        assertEquals(8, resolver.getField("77"));
        assertEquals(3, resolver.getField("81"));
        assertEquals(7, resolver.getField("84"));
        assertEquals(9, resolver.getField("85"));
        assertEquals(8, resolver.getField("86"));
        assertEquals(4, resolver.getField("88"));
        assertEquals(8, resolver.getField("93"));
        assertEquals(6, resolver.getField("94"));
        assertEquals(1, resolver.getField("99"));

    }
}