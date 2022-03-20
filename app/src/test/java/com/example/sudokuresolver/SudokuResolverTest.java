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
        assertEquals(3, resolver.getField("21"));
        assertEquals(5, resolver.getField("61"));
        assertEquals(2, resolver.getField("81"));
        assertEquals(9, resolver.getField("12"));
        assertEquals(1, resolver.getField("52"));
        assertEquals(5, resolver.getField("33"));
        assertEquals(9, resolver.getField("43"));
        assertEquals(3, resolver.getField("53"));
        assertEquals(6, resolver.getField("63"));
        assertEquals(1, resolver.getField("73"));
        assertEquals(4, resolver.getField("24"));
        assertEquals(9, resolver.getField("64"));
        assertEquals(3, resolver.getField("74"));
        assertEquals(6, resolver.getField("84"));
        assertEquals(2, resolver.getField("15"));
        assertEquals(1, resolver.getField("35"));
        assertEquals(8, resolver.getField("45"));
        assertEquals(5, resolver.getField("95"));
        assertEquals(4, resolver.getField("57"));
        assertEquals(8, resolver.getField("77"));
        assertEquals(3, resolver.getField("18"));
        assertEquals(7, resolver.getField("48"));
        assertEquals(9, resolver.getField("58"));
        assertEquals(8, resolver.getField("68"));
        assertEquals(4, resolver.getField("88"));
        assertEquals(8, resolver.getField("39"));
        assertEquals(6, resolver.getField("49"));
        assertEquals(1, resolver.getField("99"));

    }
}