package com.example.sudokuresolver;

import androidx.annotation.VisibleForTesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class SudokuResolver {
    private HashMap<String, Field> mFields;

    public SudokuResolver(List<String> list) {
        if (list.size() != 81) {
            throw new RuntimeException("Wrong number of elements");
        }
        initializeFields(list);
        analyzeSquares();
    }

    private void initializeFields(List<String> list) {
        mFields = new HashMap<>(81);
        String initialKey = "11";
        int xCord = 1;
        int yCord = 1;
        for (String element : list) {
            Field field = new Field();
            if (!element.equals("")) {
                field.setNumber(Integer.parseInt(element));
            }
            int initialNumber = Integer.parseInt(initialKey);
            xCord = initialNumber % 10;
            yCord = initialNumber / 10;
            field.setXCord(xCord);
            field.setYCord(yCord);
            field.setSquareNumber(getSquareNumber(initialKey));
            mFields.put(initialKey, field);
            ++initialNumber;
            if (initialNumber % 10 == 0) {
                ++initialNumber;
            }
            initialKey = String.valueOf(initialNumber);
        }
    }

    private void analyzeSquares() {
        for (int singleFieldValue = 1; singleFieldValue <= 9; ++singleFieldValue) {
            for (int squareNumber = 1; squareNumber <= 9; ++squareNumber) {
                int timesSingleValueWasAddedAsPossible = 0;
                String remeberedCoordinates = "";
                for (String element : mFields.keySet()) {
                    if (squareNumber != getSquareNumber(element)) {
                        continue;
                    }
                    if (mFields.get(element).getNumber() != 0) {
                        continue;
                    }
                    int row = Integer.parseInt(element) % 10;
                    if (isValueInRow(singleFieldValue, row)) {
                        continue;
                    }
                    int column = Integer.parseInt(element) / 10;
                    if (isValueInColumn(singleFieldValue, column)) {
                        continue;
                    }
                    if (isInSquare(singleFieldValue, squareNumber)) {
                        continue;
                    }
                    ++timesSingleValueWasAddedAsPossible;
                    remeberedCoordinates = element;
                    mFields.get(element).addPossibleNumber(singleFieldValue);
                }
                if (timesSingleValueWasAddedAsPossible == 1) {
                    int newValue = mFields.get(remeberedCoordinates).getOnlyPossibleNumber();
                    mFields.get(remeberedCoordinates).setNumber(newValue);
                }
            }
        }
    }

    private boolean isInSquare(int singleFieldValue, int squareNumber) {
        return false;
    }

    private boolean isValueInRow(int value, int row) {
        List<String> elementInRow = Arrays.asList(
                String.valueOf(row) + "1",
                String.valueOf(row) + "2",
                String.valueOf(row) + "3",
                String.valueOf(row) + "4",
                String.valueOf(row) + "5",
                String.valueOf(row) + "6",
                String.valueOf(row) + "7",
                String.valueOf(row) + "8",
                String.valueOf(row) + "9"
        );

        for (String element : elementInRow) {
            if (mFields.get(element).getNumber() == value) {
                return true;
            }
        }

        return false;
    }

    private boolean isValueInColumn(int value, int column) {
        List<String> elementInColumn = Arrays.asList(
                "1" + String.valueOf(column),
                "2" + String.valueOf(column),
                "3" + String.valueOf(column),
                "4" + String.valueOf(column),
                "5" + String.valueOf(column),
                "6" + String.valueOf(column),
                "7" + String.valueOf(column),
                "8" + String.valueOf(column),
                "9" + String.valueOf(column)
        );

        for (String element : elementInColumn) {
            if (mFields.get(element).getNumber() == value) {
                return true;
            }
        }

        return false;
    }

    private int getSquareNumber(String key) {
        if (key.equals("11") || key.equals("12") || key.equals("13") ||
                key.equals("21") || key.equals("22") || key.equals("23") ||
                key.equals("31") || key.equals("32") || key.equals("33")) {
            return 1;
        }
        if (key.equals("14") || key.equals("15") || key.equals("16") ||
                key.equals("24") || key.equals("25") || key.equals("26") ||
                key.equals("34") || key.equals("35") || key.equals("36")) {
            return 2;
        }
        if (key.equals("17") || key.equals("18") || key.equals("19") ||
                key.equals("27") || key.equals("28") || key.equals("29") ||
                key.equals("37") || key.equals("38") || key.equals("39")) {
            return 3;
        }
        if (key.equals("41") || key.equals("42") || key.equals("43") ||
                key.equals("51") || key.equals("52") || key.equals("53") ||
                key.equals("61") || key.equals("62") || key.equals("63")) {
            return 4;
        }
        if (key.equals("44") || key.equals("45") || key.equals("46") ||
                key.equals("54") || key.equals("55") || key.equals("56") ||
                key.equals("64") || key.equals("65") || key.equals("66")) {
            return 5;
        }
        if (key.equals("47") || key.equals("48") || key.equals("49") ||
                key.equals("57") || key.equals("58") || key.equals("59") ||
                key.equals("67") || key.equals("68") || key.equals("69")) {
            return 6;
        }
        if (key.equals("71") || key.equals("72") || key.equals("73") ||
                key.equals("81") || key.equals("82") || key.equals("83") ||
                key.equals("91") || key.equals("92") || key.equals("93")) {
            return 7;
        }
        if (key.equals("74") || key.equals("75") || key.equals("76") ||
                key.equals("84") || key.equals("85") || key.equals("86") ||
                key.equals("94") || key.equals("95") || key.equals("96")) {
            return 8;
        }
        if (key.equals("77") || key.equals("78") || key.equals("79") ||
                key.equals("87") || key.equals("88") || key.equals("89") ||
                key.equals("97") || key.equals("98") || key.equals("99")) {
            return 9;
        }

        return 0;
    }

    @VisibleForTesting
    int getField(String coordinates) {
        return mFields.get(coordinates).getNumber();
    }

    private class Field {
        private int mNumber = 0;
        private int mXCord;
        private int mYCord;
        private int mSquareNumber;
        private List<Integer> mPossibleNumbers = new ArrayList<>();

        public void setXCord(int xCord) {
            mXCord = xCord;
        }

        public void setYCord(int yCord) {
            mYCord = yCord;
        }

        public int getNumber() {
            return mNumber;
        }

        public void setNumber(int number) {
            mNumber = number;
        }

        public void setSquareNumber(int number) { mSquareNumber = number;}

        public void addPossibleNumber(int singleFieldValue) {
            mPossibleNumbers.add(singleFieldValue);
        }

        public int getOnlyPossibleNumber() {
            if (mPossibleNumbers.size() != 1) {
                throw new RuntimeException("Wrong number of possible numbers: " + mPossibleNumbers);
            }
            return mPossibleNumbers.get(0);
        }
    }
}
