package com.example.sudokuresolver;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


//"", "", "", /* | */ "", "", "", /* | */ "", "", "",
//"", "", "", /* | */ "", "", "", /* | */ "", "", "",
//"", "", "", /* | */ "", "", "", /* | */ "", "", "",
///* --------------------------------------------- */
//"", "", "", /* | */ "", "", "", /* | */ "", "", "",
//"", "", "", /* | */ "", "", "", /* | */ "", "", "",
//"", "", "", /* | */ "", "", "", /* | */ "", "", "",
///* --------------------------------------------- */
//"", "", "", /* | */ "", "", "", /* | */ "", "", "",
//"", "", "", /* | */ "", "", "", /* | */ "", "", "",
//"", "", "", /* | */ "", "", "", /* | */ "", "", ""


/**
 * Example local unit test, which will execute on the development machine (host).
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SudokuResolverTest {
    @Test
    public void resolvedBySquareAndRowAlgorithmsOnly() {
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
        assertEquals(7, resolver.getField(69));
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

    @Test
    public void resolvedBySquareAndRowAlgorithmsOnly2() {
        SudokuResolver resolver = new SudokuResolver(Arrays.asList(
                "8", "2", "", "", "", "", "", "5", "6",
                "", "", "", "3", "", "8", "", "", "",
                "", "3", "", "9", "6", "5", "", "2", "",
                "", "", "7", "", "5", "", "8", "", "",
                "", "", "8", "", "9", "", "6", "", "",
                "", "", "6", "8", "", "4", "1", "", "",
                "", "6", "", "5", "4", "9", "", "8", "",
                "", "", "", "2", "", "7", "", "", "",
                "9", "1", "", "", "", "", "", "7", "4"
        ));
        assertEquals(8, resolver.getField(11));
        assertEquals(2, resolver.getField(12));
        assertEquals(9, resolver.getField(13));
        assertEquals(4, resolver.getField(14));
        assertEquals(7, resolver.getField(15));
        assertEquals(1, resolver.getField(16));
        assertEquals(3, resolver.getField(17));
        assertEquals(5, resolver.getField(18));
        assertEquals(6, resolver.getField(19));
        assertEquals(6, resolver.getField(21));
        assertEquals(7, resolver.getField(22));
        assertEquals(5, resolver.getField(23));
        assertEquals(3, resolver.getField(24));
        assertEquals(2, resolver.getField(25));
        assertEquals(8, resolver.getField(26));
        assertEquals(4, resolver.getField(27));
        assertEquals(1, resolver.getField(28));
        assertEquals(9, resolver.getField(29));
        assertEquals(4, resolver.getField(31));
        assertEquals(3, resolver.getField(32));
        assertEquals(1, resolver.getField(33));
        assertEquals(9, resolver.getField(34));
        assertEquals(6, resolver.getField(35));
        assertEquals(5, resolver.getField(36));
        assertEquals(7, resolver.getField(37));
        assertEquals(2, resolver.getField(38));
        assertEquals(8, resolver.getField(39));
        assertEquals(3, resolver.getField(41));
        assertEquals(9, resolver.getField(42));
        assertEquals(7, resolver.getField(43));
        assertEquals(1, resolver.getField(44));
        assertEquals(5, resolver.getField(45));
        assertEquals(6, resolver.getField(46));
        assertEquals(8, resolver.getField(47));
        assertEquals(4, resolver.getField(48));
        assertEquals(2, resolver.getField(49));
        assertEquals(1, resolver.getField(51));
        assertEquals(4, resolver.getField(52));
        assertEquals(8, resolver.getField(53));
        assertEquals(7, resolver.getField(54));
        assertEquals(9, resolver.getField(55));
        assertEquals(2, resolver.getField(56));
        assertEquals(6, resolver.getField(57));
        assertEquals(3, resolver.getField(58));
        assertEquals(5, resolver.getField(59));
        assertEquals(2, resolver.getField(61));
        assertEquals(5, resolver.getField(62));
        assertEquals(6, resolver.getField(63));
        assertEquals(8, resolver.getField(64));
        assertEquals(3, resolver.getField(65));
        assertEquals(4, resolver.getField(66));
        assertEquals(1, resolver.getField(67));
        assertEquals(9, resolver.getField(68));
        assertEquals(7, resolver.getField(69));
        assertEquals(7, resolver.getField(71));
        assertEquals(6, resolver.getField(72));
        assertEquals(3, resolver.getField(73));
        assertEquals(5, resolver.getField(74));
        assertEquals(4, resolver.getField(75));
        assertEquals(9, resolver.getField(76));
        assertEquals(2, resolver.getField(77));
        assertEquals(8, resolver.getField(78));
        assertEquals(1, resolver.getField(79));
        assertEquals(5, resolver.getField(81));
        assertEquals(8, resolver.getField(82));
        assertEquals(4, resolver.getField(83));
        assertEquals(2, resolver.getField(84));
        assertEquals(1, resolver.getField(85));
        assertEquals(7, resolver.getField(86));
        assertEquals(9, resolver.getField(87));
        assertEquals(6, resolver.getField(88));
        assertEquals(3, resolver.getField(89));
        assertEquals(9, resolver.getField(91));
        assertEquals(1, resolver.getField(92));
        assertEquals(2, resolver.getField(93));
        assertEquals(6, resolver.getField(94));
        assertEquals(8, resolver.getField(95));
        assertEquals(3, resolver.getField(96));
        assertEquals(5, resolver.getField(97));
        assertEquals(7, resolver.getField(98));
        assertEquals(4, resolver.getField(99));
    }

    @Test
    public void resolvedBySquareAndRowAlgorithmsOnly3() {
        SudokuResolver resolver = new SudokuResolver(Arrays.asList(
                "", "", "2", "7", "1", "", "6", "9", "",
                "4", "", "9", "", "", "", "", "", "",
                "", "", "7", "", "2", "9", "3", "", "1",
                "9", "6", "", "", "4", "", "5", "7", "",
                "", "", "4", "3", "", "5", "9", "", "",
                "", "5", "", "", "6", "", "4", "", "",
                "3", "", "8", "", "7", "", "", "", "",
                "2", "", "", "", "9", "", "", "8", "",
                "1", "", "", "8", "", "3", "2", "4", "9"
        ));
        assertEquals(5, resolver.getField(11));
        assertEquals(3, resolver.getField(12));
        assertEquals(2, resolver.getField(13));
        assertEquals(7, resolver.getField(14));
        assertEquals(1, resolver.getField(15));
        assertEquals(8, resolver.getField(16));
        assertEquals(6, resolver.getField(17));
        assertEquals(9, resolver.getField(18));
        assertEquals(4, resolver.getField(19));
        assertEquals(4, resolver.getField(21));
        assertEquals(1, resolver.getField(22));
        assertEquals(9, resolver.getField(23));
        assertEquals(5, resolver.getField(24));
        assertEquals(3, resolver.getField(25));
        assertEquals(6, resolver.getField(26));
        assertEquals(8, resolver.getField(27));
        assertEquals(2, resolver.getField(28));
        assertEquals(7, resolver.getField(29));
        assertEquals(6, resolver.getField(31));
        assertEquals(8, resolver.getField(32));
        assertEquals(7, resolver.getField(33));
        assertEquals(4, resolver.getField(34));
        assertEquals(2, resolver.getField(35));
        assertEquals(9, resolver.getField(36));
        assertEquals(3, resolver.getField(37));
        assertEquals(5, resolver.getField(38));
        assertEquals(1, resolver.getField(39));
        assertEquals(9, resolver.getField(41));
        assertEquals(6, resolver.getField(42));
        assertEquals(3, resolver.getField(43));
        assertEquals(1, resolver.getField(44));
        assertEquals(4, resolver.getField(45));
        assertEquals(2, resolver.getField(46));
        assertEquals(5, resolver.getField(47));
        assertEquals(7, resolver.getField(48));
        assertEquals(8, resolver.getField(49));
        assertEquals(7, resolver.getField(51));
        assertEquals(2, resolver.getField(52));
        assertEquals(4, resolver.getField(53));
        assertEquals(3, resolver.getField(54));
        assertEquals(8, resolver.getField(55));
        assertEquals(5, resolver.getField(56));
        assertEquals(9, resolver.getField(57));
        assertEquals(1, resolver.getField(58));
        assertEquals(6, resolver.getField(59));
        assertEquals(8, resolver.getField(61));
        assertEquals(5, resolver.getField(62));
        assertEquals(1, resolver.getField(63));
        assertEquals(9, resolver.getField(64));
        assertEquals(6, resolver.getField(65));
        assertEquals(7, resolver.getField(66));
        assertEquals(4, resolver.getField(67));
        assertEquals(3, resolver.getField(68));
        assertEquals(2, resolver.getField(69));
        assertEquals(3, resolver.getField(71));
        assertEquals(9, resolver.getField(72));
        assertEquals(8, resolver.getField(73));
        assertEquals(2, resolver.getField(74));
        assertEquals(7, resolver.getField(75));
        assertEquals(4, resolver.getField(76));
        assertEquals(1, resolver.getField(77));
        assertEquals(6, resolver.getField(78));
        assertEquals(5, resolver.getField(79));
        assertEquals(2, resolver.getField(81));
        assertEquals(4, resolver.getField(82));
        assertEquals(5, resolver.getField(83));
        assertEquals(6, resolver.getField(84));
        assertEquals(9, resolver.getField(85));
        assertEquals(1, resolver.getField(86));
        assertEquals(7, resolver.getField(87));
        assertEquals(8, resolver.getField(88));
        assertEquals(3, resolver.getField(89));
        assertEquals(1, resolver.getField(91));
        assertEquals(7, resolver.getField(92));
        assertEquals(6, resolver.getField(93));
        assertEquals(8, resolver.getField(94));
        assertEquals(5, resolver.getField(95));
        assertEquals(3, resolver.getField(96));
        assertEquals(2, resolver.getField(97));
        assertEquals(4, resolver.getField(98));
        assertEquals(9, resolver.getField(99));
    }

    @Test
    public void resolvedBySquareAndRowAlgorithmsOnly90() {
        SudokuResolver resolver = new SudokuResolver(Arrays.asList(
                "", "1", "", /* | */ "", "", "7", /* | */ "6", "", "9",
                "4", "8", "", /* | */ "9", "", "3", /* | */ "", "", "",
                "", "9", "7", /* | */ "", "", "", /* | */ "8", "", "",
                /* --------------------------------------------- */
                "", "", "", /* | */ "", "", "", /* | */ "", "", "",
                "", "7", "", /* | */ "", "", "5", /* | */ "2", "", "4",
                "9", "", "8", /* | */ "", "6", "", /* | */ "", "7", "",
                /* --------------------------------------------- */
                "1", "", "3", /* | */ "", "5", "", /* | */ "", "2", "",
                "", "", "", /* | */ "8", "4", "", /* | */ "", "9", "5",
                "", "", "9", /* | */ "", "", "", /* | */ "4", "6", ""
        ));
        assertEquals(2, resolver.getField(11));
        assertEquals(1, resolver.getField(12));
        assertEquals(5, resolver.getField(13));
        assertEquals(4, resolver.getField(14));
        assertEquals(8, resolver.getField(15));
        assertEquals(7, resolver.getField(16));
        assertEquals(6, resolver.getField(17));
        assertEquals(3, resolver.getField(18));
        assertEquals(9, resolver.getField(19));
        assertEquals(4, resolver.getField(21));
        assertEquals(8, resolver.getField(22));
        assertEquals(6, resolver.getField(23));
        assertEquals(9, resolver.getField(24));
        assertEquals(2, resolver.getField(25));
        assertEquals(3, resolver.getField(26));
        assertEquals(1, resolver.getField(27));
        assertEquals(5, resolver.getField(28));
        assertEquals(7, resolver.getField(29));
        assertEquals(3, resolver.getField(31));
        assertEquals(9, resolver.getField(32));
        assertEquals(7, resolver.getField(33));
        assertEquals(5, resolver.getField(34));
        assertEquals(1, resolver.getField(35));
        assertEquals(6, resolver.getField(36));
        assertEquals(8, resolver.getField(37));
        assertEquals(4, resolver.getField(38));
        assertEquals(2, resolver.getField(39));
        assertEquals(5, resolver.getField(41));
        assertEquals(3, resolver.getField(42));
        assertEquals(4, resolver.getField(43));
        assertEquals(2, resolver.getField(44));
        assertEquals(7, resolver.getField(45));
        assertEquals(8, resolver.getField(46));
        assertEquals(9, resolver.getField(47));
        assertEquals(1, resolver.getField(48));
        assertEquals(6, resolver.getField(49));
        assertEquals(6, resolver.getField(51));
        assertEquals(7, resolver.getField(52));
        assertEquals(1, resolver.getField(53));
        assertEquals(3, resolver.getField(54));
        assertEquals(9, resolver.getField(55));
        assertEquals(5, resolver.getField(56));
        assertEquals(2, resolver.getField(57));
        assertEquals(8, resolver.getField(58));
        assertEquals(4, resolver.getField(59));
        assertEquals(9, resolver.getField(61));
        assertEquals(2, resolver.getField(62));
        assertEquals(8, resolver.getField(63));
        assertEquals(1, resolver.getField(64));
        assertEquals(6, resolver.getField(65));
        assertEquals(4, resolver.getField(66));
        assertEquals(5, resolver.getField(67));
        assertEquals(7, resolver.getField(68));
        assertEquals(3, resolver.getField(69));
        assertEquals(1, resolver.getField(71));
        assertEquals(4, resolver.getField(72));
        assertEquals(3, resolver.getField(73));
        assertEquals(6, resolver.getField(74));
        assertEquals(5, resolver.getField(75));
        assertEquals(9, resolver.getField(76));
        assertEquals(7, resolver.getField(77));
        assertEquals(2, resolver.getField(78));
        assertEquals(8, resolver.getField(79));
        assertEquals(7, resolver.getField(81));
        assertEquals(6, resolver.getField(82));
        assertEquals(2, resolver.getField(83));
        assertEquals(8, resolver.getField(84));
        assertEquals(4, resolver.getField(85));
        assertEquals(1, resolver.getField(86));
        assertEquals(3, resolver.getField(87));
        assertEquals(9, resolver.getField(88));
        assertEquals(5, resolver.getField(89));
        assertEquals(8, resolver.getField(91));
        assertEquals(5, resolver.getField(92));
        assertEquals(9, resolver.getField(93));
        assertEquals(7, resolver.getField(94));
        assertEquals(3, resolver.getField(95));
        assertEquals(2, resolver.getField(96));
        assertEquals(4, resolver.getField(97));
        assertEquals(6, resolver.getField(98));
        assertEquals(1, resolver.getField(99));
    }

    @Test
    public void resolvedBySquareAndRowAlgorithmsOnly5() {
        SudokuResolver resolver = new SudokuResolver(Arrays.asList(
                "5", "", "", /* | */ "6", "", "", /* | */ "", "", "8",
                "", "8", "6", /* | */ "", "9", "5", /* | */ "2", "4", "",
                "", "", "7", /* | */ "8", "", "", /* | */ "6", "", "",
                /* --------------------------------------------- */
                "7", "", "8", /* | */ "", "", "", /* | */ "5", "", "2",
                "", "3", "", /* | */ "", "", "", /* | */ "", "9", "",
                "", "6", "", /* | */ "", "", "", /* | */ "", "7", "",
                /* --------------------------------------------- */
                "3", "", "", /* | */ "5", "", "", /* | */ "", "", "1",
                "", "1", "9", /* | */ "", "3", "7", /* | */ "4", "6", "",
                "", "", "4", /* | */ "9", "", "", /* | */ "3", "", ""
        ));
        assertEquals(5, resolver.getField(11));
        assertEquals(9, resolver.getField(12));
        assertEquals(3, resolver.getField(13));
        assertEquals(6, resolver.getField(14));
        assertEquals(2, resolver.getField(15));
        assertEquals(4, resolver.getField(16));
        assertEquals(7, resolver.getField(17));
        assertEquals(1, resolver.getField(18));
        assertEquals(8, resolver.getField(19));
        assertEquals(1, resolver.getField(21));
        assertEquals(8, resolver.getField(22));
        assertEquals(6, resolver.getField(23));
        assertEquals(7, resolver.getField(24));
        assertEquals(9, resolver.getField(25));
        assertEquals(5, resolver.getField(26));
        assertEquals(2, resolver.getField(27));
        assertEquals(4, resolver.getField(28));
        assertEquals(3, resolver.getField(29));
        assertEquals(4, resolver.getField(31));
        assertEquals(2, resolver.getField(32));
        assertEquals(7, resolver.getField(33));
        assertEquals(8, resolver.getField(34));
        assertEquals(1, resolver.getField(35));
        assertEquals(3, resolver.getField(36));
        assertEquals(6, resolver.getField(37));
        assertEquals(5, resolver.getField(38));
        assertEquals(9, resolver.getField(39));
        assertEquals(7, resolver.getField(41));
        assertEquals(4, resolver.getField(42));
        assertEquals(8, resolver.getField(43));
        assertEquals(1, resolver.getField(44));
        assertEquals(6, resolver.getField(45));
        assertEquals(9, resolver.getField(46));
        assertEquals(5, resolver.getField(47));
        assertEquals(3, resolver.getField(48));
        assertEquals(2, resolver.getField(49));
        assertEquals(2, resolver.getField(51));
        assertEquals(3, resolver.getField(52));
        assertEquals(5, resolver.getField(53));
        assertEquals(4, resolver.getField(54));
        assertEquals(7, resolver.getField(55));
        assertEquals(8, resolver.getField(56));
        assertEquals(1, resolver.getField(57));
        assertEquals(9, resolver.getField(58));
        assertEquals(6, resolver.getField(59));
        assertEquals(9, resolver.getField(61));
        assertEquals(6, resolver.getField(62));
        assertEquals(1, resolver.getField(63));
        assertEquals(3, resolver.getField(64));
        assertEquals(5, resolver.getField(65));
        assertEquals(2, resolver.getField(66));
        assertEquals(8, resolver.getField(67));
        assertEquals(7, resolver.getField(68));
        assertEquals(4, resolver.getField(69));
        assertEquals(3, resolver.getField(71));
        assertEquals(7, resolver.getField(72));
        assertEquals(2, resolver.getField(73));
        assertEquals(5, resolver.getField(74));
        assertEquals(4, resolver.getField(75));
        assertEquals(6, resolver.getField(76));
        assertEquals(9, resolver.getField(77));
        assertEquals(8, resolver.getField(78));
        assertEquals(1, resolver.getField(79));
        assertEquals(8, resolver.getField(81));
        assertEquals(1, resolver.getField(82));
        assertEquals(9, resolver.getField(83));
        assertEquals(2, resolver.getField(84));
        assertEquals(3, resolver.getField(85));
        assertEquals(7, resolver.getField(86));
        assertEquals(4, resolver.getField(87));
        assertEquals(6, resolver.getField(88));
        assertEquals(5, resolver.getField(89));
        assertEquals(6, resolver.getField(91));
        assertEquals(5, resolver.getField(92));
        assertEquals(4, resolver.getField(93));
        assertEquals(9, resolver.getField(94));
        assertEquals(8, resolver.getField(95));
        assertEquals(1, resolver.getField(96));
        assertEquals(3, resolver.getField(97));
        assertEquals(2, resolver.getField(98));
        assertEquals(7, resolver.getField(99));
    }

    @Test
    public void resolvedBySquareAndRowAlgorithmsOnly6() {
        SudokuResolver resolver = new SudokuResolver(Arrays.asList(
                "1", "9", "", /* | */ "", "", "6", /* | */ "", "8", "2",
                "", "2", "", /* | */ "8", "", "", /* | */ "5", "", "",
                "", "", "", /* | */ "", "3", "5", /* | */ "1", "", "7",
                /* --------------------------------------------- */
                "8", "3", "6", /* | */ "", "", "9", /* | */ "4", "", "",
                "", "", "", /* | */ "5", "", "2", /* | */ "", "", "",
                "", "", "", /* | */ "", "6", "", /* | */ "", "", "",
                /* --------------------------------------------- */
                "", "", "", /* | */ "9", "", "", /* | */ "6", "7", "8",
                "3", "1", "7", /* | */ "6", "2", "8", /* | */ "", "", "4",
                "", "", "9", /* | */ "", "", "", /* | */ "", "3", ""
        ));
        assertEquals(1, resolver.getField(11));
        assertEquals(9, resolver.getField(12));
        assertEquals(5, resolver.getField(13));
        assertEquals(7, resolver.getField(14));
        assertEquals(4, resolver.getField(15));
        assertEquals(6, resolver.getField(16));
        assertEquals(3, resolver.getField(17));
        assertEquals(8, resolver.getField(18));
        assertEquals(2, resolver.getField(19));
        assertEquals(7, resolver.getField(21));
        assertEquals(2, resolver.getField(22));
        assertEquals(3, resolver.getField(23));
        assertEquals(8, resolver.getField(24));
        assertEquals(9, resolver.getField(25));
        assertEquals(1, resolver.getField(26));
        assertEquals(5, resolver.getField(27));
        assertEquals(4, resolver.getField(28));
        assertEquals(6, resolver.getField(29));
        assertEquals(4, resolver.getField(31));
        assertEquals(6, resolver.getField(32));
        assertEquals(8, resolver.getField(33));
        assertEquals(2, resolver.getField(34));
        assertEquals(3, resolver.getField(35));
        assertEquals(5, resolver.getField(36));
        assertEquals(1, resolver.getField(37));
        assertEquals(9, resolver.getField(38));
        assertEquals(7, resolver.getField(39));
        assertEquals(8, resolver.getField(41));
        assertEquals(3, resolver.getField(42));
        assertEquals(6, resolver.getField(43));
        assertEquals(1, resolver.getField(44));
        assertEquals(7, resolver.getField(45));
        assertEquals(9, resolver.getField(46));
        assertEquals(4, resolver.getField(47));
        assertEquals(2, resolver.getField(48));
        assertEquals(5, resolver.getField(49));
        assertEquals(9, resolver.getField(51));
        assertEquals(4, resolver.getField(52));
        assertEquals(1, resolver.getField(53));
        assertEquals(5, resolver.getField(54));
        assertEquals(8, resolver.getField(55));
        assertEquals(2, resolver.getField(56));
        assertEquals(7, resolver.getField(57));
        assertEquals(6, resolver.getField(58));
        assertEquals(3, resolver.getField(59));
        assertEquals(5, resolver.getField(61));
        assertEquals(7, resolver.getField(62));
        assertEquals(2, resolver.getField(63));
        assertEquals(3, resolver.getField(64));
        assertEquals(6, resolver.getField(65));
        assertEquals(4, resolver.getField(66));
        assertEquals(8, resolver.getField(67));
        assertEquals(1, resolver.getField(68));
        assertEquals(9, resolver.getField(69));
        assertEquals(2, resolver.getField(71));
        assertEquals(5, resolver.getField(72));
        assertEquals(4, resolver.getField(73));
        assertEquals(9, resolver.getField(74));
        assertEquals(1, resolver.getField(75));
        assertEquals(3, resolver.getField(76));
        assertEquals(6, resolver.getField(77));
        assertEquals(7, resolver.getField(78));
        assertEquals(8, resolver.getField(79));
        assertEquals(3, resolver.getField(81));
        assertEquals(1, resolver.getField(82));
        assertEquals(7, resolver.getField(83));
        assertEquals(6, resolver.getField(84));
        assertEquals(2, resolver.getField(85));
        assertEquals(8, resolver.getField(86));
        assertEquals(9, resolver.getField(87));
        assertEquals(5, resolver.getField(88));
        assertEquals(4, resolver.getField(89));
        assertEquals(6, resolver.getField(91));
        assertEquals(8, resolver.getField(92));
        assertEquals(9, resolver.getField(93));
        assertEquals(4, resolver.getField(94));
        assertEquals(5, resolver.getField(95));
        assertEquals(7, resolver.getField(96));
        assertEquals(2, resolver.getField(97));
        assertEquals(3, resolver.getField(98));
        assertEquals(1, resolver.getField(99));
    }

    @Test
    public void resolvedBySomething() {
        SudokuResolver resolver = new SudokuResolver(Arrays.asList(
                "", "", "3", /* | */ "", "4", "8", /* | */ "", "", "",
                "", "", "", /* | */ "", "", "", /* | */ "2", "", "",
                "5", "9", "", /* | */ "1", "", "", /* | */ "", "8", "",
                /* --------------------------------------------- */
                "", "", "", /* | */ "7", "", "", /* | */ "", "9", "",
                "2", "", "", /* | */ "", "", "", /* | */ "", "", "",
                "", "8", "4", /* | */ "", "3", "", /* | */ "1", "", "6",
                /* --------------------------------------------- */
                "", "", "", /* | */ "", "6", "9", /* | */ "", "", "5",
                "7", "", "", /* | */ "2", "", "", /* | */ "4", "3", "",
                "", "1", "", /* | */ "", "", "", /* | */ "", "", ""
        ));
        assertEquals(1, resolver.getField(11));
        assertEquals(2, resolver.getField(12));
        assertEquals(3, resolver.getField(13));
        assertEquals(6, resolver.getField(14));
        assertEquals(4, resolver.getField(15));
        assertEquals(8, resolver.getField(16));
        assertEquals(9, resolver.getField(17));
        assertEquals(5, resolver.getField(18));
        assertEquals(7, resolver.getField(19));
        assertEquals(4, resolver.getField(21));
        assertEquals(7, resolver.getField(22));
        assertEquals(8, resolver.getField(23));
        assertEquals(3, resolver.getField(24));
        assertEquals(9, resolver.getField(25));
        assertEquals(5, resolver.getField(26));
        assertEquals(2, resolver.getField(27));
        assertEquals(6, resolver.getField(28));
        assertEquals(1, resolver.getField(29));
        assertEquals(5, resolver.getField(31));
        assertEquals(9, resolver.getField(32));
        assertEquals(6, resolver.getField(33));
        assertEquals(1, resolver.getField(34));
        assertEquals(2, resolver.getField(35));
        assertEquals(7, resolver.getField(36));
        assertEquals(3, resolver.getField(37));
        assertEquals(8, resolver.getField(38));
        assertEquals(4, resolver.getField(39));
        assertEquals(6, resolver.getField(41));
        assertEquals(3, resolver.getField(42));
        assertEquals(1, resolver.getField(43));
        assertEquals(7, resolver.getField(44));
        assertEquals(8, resolver.getField(45));
        assertEquals(4, resolver.getField(46));
        assertEquals(5, resolver.getField(47));
        assertEquals(9, resolver.getField(48));
        assertEquals(2, resolver.getField(49));
        assertEquals(2, resolver.getField(51));
        assertEquals(5, resolver.getField(52));
        assertEquals(7, resolver.getField(53));
        assertEquals(9, resolver.getField(54));
        assertEquals(1, resolver.getField(55));
        assertEquals(6, resolver.getField(56));
        assertEquals(8, resolver.getField(57));
        assertEquals(4, resolver.getField(58));
        assertEquals(3, resolver.getField(59));
        assertEquals(9, resolver.getField(61));
        assertEquals(8, resolver.getField(62));
        assertEquals(4, resolver.getField(63));
        assertEquals(5, resolver.getField(64));
        assertEquals(3, resolver.getField(65));
        assertEquals(2, resolver.getField(66));
        assertEquals(1, resolver.getField(67));
        assertEquals(7, resolver.getField(68));
        assertEquals(6, resolver.getField(69));
        assertEquals(3, resolver.getField(71));
        assertEquals(4, resolver.getField(72));
        assertEquals(2, resolver.getField(73));
        assertEquals(8, resolver.getField(74));
        assertEquals(6, resolver.getField(75));
        assertEquals(9, resolver.getField(76));
        assertEquals(7, resolver.getField(77));
        assertEquals(1, resolver.getField(78));
        assertEquals(5, resolver.getField(79));
        assertEquals(7, resolver.getField(81));
        assertEquals(6, resolver.getField(82));
        assertEquals(9, resolver.getField(83));
        assertEquals(2, resolver.getField(84));
        assertEquals(5, resolver.getField(85));
        assertEquals(1, resolver.getField(86));
        assertEquals(4, resolver.getField(87));
        assertEquals(3, resolver.getField(88));
        assertEquals(8, resolver.getField(89));
        assertEquals(8, resolver.getField(91));
        assertEquals(1, resolver.getField(92));
        assertEquals(5, resolver.getField(93));
        assertEquals(4, resolver.getField(94));
        assertEquals(7, resolver.getField(95));
        assertEquals(3, resolver.getField(96));
        assertEquals(6, resolver.getField(97));
        assertEquals(2, resolver.getField(98));
        assertEquals(9, resolver.getField(99));
    }
}