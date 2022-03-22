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
        assertEquals(1, resolver.getField(11));
        assertEquals(3, resolver.getField(12));
        assertEquals(6, resolver.getField(13));
        assertEquals(4, resolver.getField(14));
        assertEquals(8, resolver.getField(15));
        assertEquals(5, resolver.getField(16));
        assertEquals(7, resolver.getField(17));
        assertEquals(2, resolver.getField(18));
        assertEquals(9, resolver.getField(19));
        assertEquals(9, resolver.getField(21));
        assertEquals(8, resolver.getField(22));
        assertEquals(4, resolver.getField(23));
        assertEquals(2, resolver.getField(24));
        assertEquals(1, resolver.getField(25));
        assertEquals(7, resolver.getField(26));
        assertEquals(6, resolver.getField(27));
        assertEquals(5, resolver.getField(28));
        assertEquals(3, resolver.getField(29));
        assertEquals(7, resolver.getField(31));
        assertEquals(2, resolver.getField(32));
        assertEquals(5, resolver.getField(33));
        assertEquals(9, resolver.getField(34));
        assertEquals(3, resolver.getField(35));
        assertEquals(6, resolver.getField(36));
        assertEquals(1, resolver.getField(37));
        assertEquals(8, resolver.getField(38));
        assertEquals(4, resolver.getField(39));
        assertEquals(5, resolver.getField(41));
        assertEquals(4, resolver.getField(42));
        assertEquals(7, resolver.getField(43));
        assertEquals(1, resolver.getField(44));
        assertEquals(2, resolver.getField(45));
        assertEquals(9, resolver.getField(46));
        assertEquals(3, resolver.getField(47));
        assertEquals(6, resolver.getField(48));
        assertEquals(8, resolver.getField(49));
        assertEquals(2, resolver.getField(51));
        assertEquals(6, resolver.getField(52));
        assertEquals(1, resolver.getField(53));
        assertEquals(8, resolver.getField(54));
        assertEquals(7, resolver.getField(55));
        assertEquals(3, resolver.getField(56));
        assertEquals(4, resolver.getField(57));
        assertEquals(9, resolver.getField(58));
        assertEquals(5, resolver.getField(59));
        assertEquals(8, resolver.getField(61));
        assertEquals(9, resolver.getField(62));
        assertEquals(3, resolver.getField(63));
        assertEquals(5, resolver.getField(64));
        assertEquals(6, resolver.getField(65));
        assertEquals(4, resolver.getField(66));
        assertEquals(2, resolver.getField(67));
        assertEquals(1, resolver.getField(68));
        assertEquals(6, resolver.getField(71));
        assertEquals(5, resolver.getField(72));
        assertEquals(9, resolver.getField(73));
        assertEquals(3, resolver.getField(74));
        assertEquals(4, resolver.getField(75));
        assertEquals(1, resolver.getField(76));
        assertEquals(8, resolver.getField(77));
        assertEquals(7, resolver.getField(78));
        assertEquals(2, resolver.getField(79));
        assertEquals(3, resolver.getField(81));
        assertEquals(1, resolver.getField(82));
        assertEquals(2, resolver.getField(83));
        assertEquals(7, resolver.getField(84));
        assertEquals(9, resolver.getField(85));
        assertEquals(8, resolver.getField(86));
        assertEquals(5, resolver.getField(87));
        assertEquals(4, resolver.getField(88));
        assertEquals(6, resolver.getField(89));
        assertEquals(4, resolver.getField(91));
        assertEquals(7, resolver.getField(92));
        assertEquals(8, resolver.getField(93));
        assertEquals(6, resolver.getField(94));
        assertEquals(5, resolver.getField(95));
        assertEquals(2, resolver.getField(96));
        assertEquals(9, resolver.getField(97));
        assertEquals(3, resolver.getField(98));
        assertEquals(1, resolver.getField(99));

    }
}