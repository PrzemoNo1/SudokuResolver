package com.example.sudokuresolver;

import androidx.annotation.VisibleForTesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuResolver {
    private final boolean DEBUG = true;
    private HashMap<Integer, Field> mFields;

    private static class Field {
        public Field(Integer number) {
            mNumber = number;
        }
        public Integer mNumber;
        public List<Integer> mPossibleNumbers = new ArrayList<>();
    }

    public SudokuResolver(List<String> list) {
        if (list.size() != 81) {
            throw new RuntimeException("Wrong number of elements");
        }
        initializeFields(list);
        while(analyzeSquares() || fillMissingRow() || analyzeSingleFields()) {}
        for (Integer element : mFields.keySet()) {
/*            if (mFields.get(element).mNumber == 0) {
                throw new RuntimeException("Field " + element + " was not filled");
            }*/
           if (true) System.out.println(element + " " + mFields.get(element).mNumber + " " + mFields.get(element).mPossibleNumbers);
        }
    }

    private boolean analyzeSingleFields() {
        boolean wasAnythingSet = false;
        for (Integer element : mFields.keySet()) {
            if (mFields.get(element).mPossibleNumbers.size() == 1) {
                int newValue = mFields.get(element).mPossibleNumbers.get(0);
                System.out.println("Single: coordinates: " + element + ", value: " + newValue);
                wasAnythingSet = true;
                mFields.get(element).mNumber = newValue;
                mFields.get(element).mPossibleNumbers.clear();
                clearNumberFromRow(newValue, element / 10);
                clearNumberFromColumn(newValue, element % 10);
                clearNumberFromSquare(newValue, FieldsUtils.getSquareNumber(element));
            }
        }
        return wasAnythingSet;
    }

    private void initializeFields(List<String> list) {
        mFields = new HashMap<>(81);
        int initialNumber = 11;
        for (String element : list) {
            if (!element.equals("")) {
                mFields.put(initialNumber, new Field(Integer.parseInt(element)));
            } else {
                mFields.put(initialNumber, new Field(0));
            }
            ++initialNumber;
            if (initialNumber % 10 == 0) {
                ++initialNumber;
            }
        }
    }

    private boolean analyzeSquares() {
        boolean wasAnythingSet = false;
        for (int singleFieldValue = 1; singleFieldValue <= 9; ++singleFieldValue) {
            for (int squareNumber = 1; squareNumber <= 9; ++squareNumber) {
                for (Integer element : FieldsUtils.getFieldsFromSquare(squareNumber)) {
                    boolean localDebug = false;
                    if (0 != mFields.get(element).mNumber) {
                        if (localDebug) System.out.println("Not empty: " + mFields.get(element));
                        continue;
                    }
                    int row = element / 10;
                    if (isValueInRow(singleFieldValue, row)) {
                        if (localDebug) System.out.println("Already in row");
                        continue;
                    }
                    int column = element % 10;
                    if (isValueInColumn(singleFieldValue, column)) {
                        if (localDebug) System.out.println("Already in column");
                        continue;
                    }
                    if (isInSquare(singleFieldValue, squareNumber)) {
                        if (localDebug) System.out.println("Already in square");
                        continue;
                    }
                    if (!mFields.get(element).mPossibleNumbers.contains(singleFieldValue)) {
                        mFields.get(element).mPossibleNumbers.add(singleFieldValue);
                    }
                }
                int coordinates = isNumberPossibleOnlyInOnePlace(squareNumber, singleFieldValue);
                if (coordinates != 0) {
                    if (DEBUG) System.out.println("Square: " + coordinates + " : " + singleFieldValue);
                    wasAnythingSet = true;
                    mFields.get(coordinates).mNumber = singleFieldValue;
                    mFields.get(coordinates).mPossibleNumbers.clear();
                    clearNumberFromRow(singleFieldValue, coordinates / 10);
                    clearNumberFromColumn(singleFieldValue, coordinates % 10);
                    clearNumberFromSquare(singleFieldValue, squareNumber);
                } else if (isMoreThenOnce(squareNumber, singleFieldValue)){
                    int rowCoordinate = isInOneRow(squareNumber, singleFieldValue);
                    if (rowCoordinate != 0) {
                        excludeValueFromRowExceptOneSquare(singleFieldValue, squareNumber, rowCoordinate);
                        for (int i = 1; i <= 9; ++i) {
                            coordinates = isNumberPossibleOnlyInOnePlace(i, singleFieldValue);
                            if (coordinates != 0) {
                                wasAnythingSet = true;
                                System.out.println("After row's exclude, coordinates: " + coordinates + ", value: " + singleFieldValue);
                                mFields.get(coordinates).mNumber = singleFieldValue;
                                mFields.get(coordinates).mPossibleNumbers.clear();
                                clearNumberFromRow(singleFieldValue, coordinates / 10);
                                clearNumberFromColumn(singleFieldValue, coordinates % 10);
                                clearNumberFromSquare(singleFieldValue, i);
                            }
                        }
                    }
                    int columnCoordinate = isInOneColumn(squareNumber, singleFieldValue);
                    if (columnCoordinate != 0) {
                        excludeValueFromColumnExceptOneSquare(singleFieldValue, squareNumber, columnCoordinate);
                        for (int i = 1; i <= 9; ++i) {
                            coordinates = isNumberPossibleOnlyInOnePlace(i, singleFieldValue);
                            if (coordinates != 0) {
                                wasAnythingSet = true;
                                System.out.println("After column's exclude, coordinates: " + coordinates + ", value: " + singleFieldValue);
                                mFields.get(coordinates).mNumber = singleFieldValue;
                                mFields.get(coordinates).mPossibleNumbers.clear();
                                clearNumberFromRow(singleFieldValue, coordinates / 10);
                                clearNumberFromColumn(singleFieldValue, coordinates % 10);
                                clearNumberFromSquare(singleFieldValue, i);
                            }
                        }
                    }
                }
            }
        }
        return wasAnythingSet;
    }

    private void excludeValueFromColumnExceptOneSquare(int singleFieldValue, int squareNumber, int columnCoordinate) {
            List<Integer> fieldsFromSquare = FieldsUtils.getFieldsFromSquare(squareNumber);
            List<Integer> elements = new ArrayList<>();
            for (int i = 1; i <= 9; ++i) {
                int possibleElement = 10 * i + columnCoordinate;
                if (fieldsFromSquare.contains(possibleElement)) {
                    continue;
                }
                elements.add(possibleElement);
            }
            for (Integer element : elements) {
                mFields.get(element).mPossibleNumbers.remove((Object) singleFieldValue);
            }
    }

    private int isInOneColumn(int squareNumber, int singleFieldValue) {
        List<Integer> fields = FieldsUtils.getFieldsFromSquare(squareNumber);
        List<Integer> rememberedCoordinates = new ArrayList<>();
        int firstColumn = 0;
        for (Integer element : fields) {
            if (mFields.get(element).mNumber != 0) {
                continue;
            }
            if (mFields.get(element).mPossibleNumbers.contains(singleFieldValue)) {
                if (firstColumn == 0) {
                    firstColumn = element % 10;
                }
                rememberedCoordinates.add(element);
            }
        }
        for (Integer element : rememberedCoordinates) {
            if (element % 10 != firstColumn) {
                return 0;
            }
        }
        return firstColumn;
    }

    private void excludeValueFromRowExceptOneSquare(int singleFieldValue, int squareNumber, int row) {
        List<Integer> fieldsFromSquare = FieldsUtils.getFieldsFromSquare(squareNumber);
        List<Integer> elements = new ArrayList<>();
        for (int i = 1; i <= 9; ++i) {
            int possibleElement = 10 * row + i;
            if (fieldsFromSquare.contains(possibleElement)) {
                continue;
            }
            elements.add(possibleElement);
        }
        for (Integer element : elements) {
            mFields.get(element).mPossibleNumbers.remove((Object) singleFieldValue);
        }
    }

    private int isInOneRow(int squareNumber, int singleFieldValue) {
        List<Integer> fields = FieldsUtils.getFieldsFromSquare(squareNumber);
        List<Integer> rememberedCoordinates = new ArrayList<>();
        int firstRow = 0;
        for (Integer element : fields) {
            if (mFields.get(element).mNumber != 0) {
                continue;
            }
            if (mFields.get(element).mPossibleNumbers.contains(singleFieldValue)) {
                if (firstRow == 0) {
                    firstRow = element / 10;
                }
                rememberedCoordinates.add(element);
            }
        }
        for (Integer element : rememberedCoordinates) {
            if (element / 10 != firstRow) {
                return 0;
            }
        }
        return firstRow;
    }

    private void clearNumberFromSquare(int singleFieldValue, int squareNumber) {
        List<Integer> fields = FieldsUtils.getFieldsFromSquare(squareNumber);
        for (Integer element : fields) {
            if (mFields.get(element).mPossibleNumbers.contains(singleFieldValue)) {
                mFields.get(element).mPossibleNumbers.remove((Object) singleFieldValue);
            }
        }
    }

    private void clearNumberFromColumn(int singleFieldValue, int column) {
        for (int i = 1; i <= 9; ++i) {
            if (mFields.get(10 * i + column).mPossibleNumbers.contains(singleFieldValue)) {
                mFields.get(10 * i + column).mPossibleNumbers.remove((Object) singleFieldValue);
            }
        }
    }

    private void clearNumberFromRow(int singleFieldValue, int row) {
        for (int i = 1; i <= 9; ++i) {
            if (mFields.get(row * 10 + i).mPossibleNumbers.contains(singleFieldValue)) {
                mFields.get(row * 10 + i).mPossibleNumbers.remove((Object) singleFieldValue);
            }
        }
    }

    private int isNumberPossibleOnlyInOnePlace(int squareNumber, int singleFieldValue) {
        List<Integer> fields = FieldsUtils.getFieldsFromSquare(squareNumber);
        int coordinatesOfOnlyOne = 0;
        for (Integer element : fields) {
            if (mFields.get(element).mPossibleNumbers.contains(singleFieldValue)) {
                if (coordinatesOfOnlyOne != 0) {
                    return 0;
                } else {
                    coordinatesOfOnlyOne = element;
                }
            }
        }
        return coordinatesOfOnlyOne;
    }

    private boolean isMoreThenOnce(int squareNumber, int singleFieldValue) {
        List<Integer> fields = FieldsUtils.getFieldsFromSquare(squareNumber);
        boolean once = false;
        for (Integer element : fields) {
            if (mFields.get(element).mPossibleNumbers.contains(singleFieldValue)) {
                if (once) {
                    return true;
                } else {
                    once = true;
                }
            }
        }
        return false;
    }

    private boolean fillMissingRow() {
        boolean anythingWasSet = false;
        for (Integer element : mFields.keySet()) {
            if (mFields.get(element).mNumber != 0) {
                continue;
            }
            int row = element / 10;
            int missingNumber = getMissingElementFromRow(row);
            if (missingNumber == 0) {
                continue;
            } else {
                anythingWasSet = true;
                if (DEBUG) System.out.println("Row: " + element + " : " + missingNumber);
                mFields.get(element).mNumber = missingNumber;
                mFields.get(element).mPossibleNumbers.clear();
                clearNumberFromRow(missingNumber, element / 10);
                clearNumberFromColumn(missingNumber, element % 10);
                clearNumberFromSquare(missingNumber, FieldsUtils.getSquareNumber(element));
            }
        }
        return anythingWasSet;
    }

    private int getMissingElementFromRow(int row) {
        boolean wasMissingSpot = false;
        Set<Integer> knownElements = new HashSet<>();
        for (int i = 1; i <= 9; ++i) { knownElements.add(i); }
        for (int i = 1; i <= 9; ++i) {
            if (mFields.get(row * 10 + i).mNumber == 0) {
                if (wasMissingSpot) {
                    return 0;
                } else {
                    wasMissingSpot = true;
                }
            } else {
                knownElements.remove(mFields.get(row * 10 + i).mNumber);
            }
        }
        if (knownElements.size() != 1) {
            throw new RuntimeException("Wrong size! : " + knownElements);
        }
        return (int) knownElements.toArray()[0];
    }

    private boolean isInSquare(int singleFieldValue, int squareNumber) {
        List<Integer> fieldsId = FieldsUtils.getFieldsFromSquare(squareNumber);
        for (Integer fieldId : fieldsId) {
            if (mFields.get(fieldId).mNumber == singleFieldValue) {
                return true;
            }
        }
        return false;
    }

    private boolean isValueInRow(int value, int row) {
        for (int i = 1; i <= 9; ++i) {
            if (mFields.get(row * 10 + i).mNumber == value) {
                return true;
            }
        }
        return false;
    }

    private boolean isValueInColumn(int value, int column) {
        for (int i = 1; i <= 9; ++i) {
            if (mFields.get(10 * i + column).mNumber == value) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    int getField(Integer coordinates) {
        return mFields.get(coordinates).mNumber;
    }
}
