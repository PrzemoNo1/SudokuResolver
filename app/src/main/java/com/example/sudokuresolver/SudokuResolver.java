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
        while(analyzeSquares() || fillMissingRow()) {}
        for (Integer element : mFields.keySet()) {
            if (mFields.get(element).mNumber == 0) {
                throw new RuntimeException("Field " + element + " was not filled");
            }
        }
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
                for (Integer element : getFieldsFromSquare(squareNumber)) {
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
                    int a = isInOneRow(squareNumber, singleFieldValue);
                    if (a != 0) {
                        excludeValueFromRowExceptOneSquare(singleFieldValue, squareNumber, a);
                        for (int i = 1; i <= 9; ++i) {
                            coordinates = isNumberPossibleOnlyInOnePlace(i, singleFieldValue);
                            if (coordinates != 0) {
                                wasAnythingSet = true;
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

    private void excludeValueFromRowExceptOneSquare(int singleFieldValue, int squareNumber, int row) {
        List<Integer> fieldsFromSquare = getFieldsFromSquare(squareNumber);
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
        List<Integer> fields = getFieldsFromSquare(squareNumber);
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
        List<Integer> fields = getFieldsFromSquare(squareNumber);
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
        List<Integer> fields = getFieldsFromSquare(squareNumber);
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
        List<Integer> fields = getFieldsFromSquare(squareNumber);
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
                clearNumberFromSquare(missingNumber, getSquareNumber(element));
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
        List<Integer> fieldsId = getFieldsFromSquare(squareNumber);
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

    private int getSquareNumber(Integer key) {
        switch (key) {
            case 11:
            case 12:
            case 13:
            case 21:
            case 22:
            case 23:
            case 31:
            case 32:
            case 33:
                return 1;
            case 14:
            case 15:
            case 16:
            case 24:
            case 25:
            case 26:
            case 34:
            case 35:
            case 36:
                return 2;
            case 17:
            case 18:
            case 19:
            case 27:
            case 28:
            case 29:
            case 37:
            case 38:
            case 39:
                return 3;
            case 41:
            case 42:
            case 43:
            case 51:
            case 52:
            case 53:
            case 61:
            case 62:
            case 63:
                return 4;
            case 44:
            case 45:
            case 46:
            case 54:
            case 55:
            case 56:
            case 64:
            case 65:
            case 66:
                return 5;
            case 47:
            case 48:
            case 49:
            case 57:
            case 58:
            case 59:
            case 67:
            case 68:
            case 69:
                return 6;
            case 71:
            case 72:
            case 73:
            case 81:
            case 82:
            case 83:
            case 91:
            case 92:
            case 93:
                return 7;
            case 74:
            case 75:
            case 76:
            case 84:
            case 85:
            case 86:
            case 94:
            case 95:
            case 96:
                return 8;
            case 77:
            case 78:
            case 79:
            case 87:
            case 88:
            case 89:
            case 97:
            case 98:
            case 99:
                return 9;
        }
        return 0;
    }

    private List<Integer> getFieldsFromSquare(int squareNumber) {
        switch(squareNumber) {
            case 1:
                return Arrays.asList(11, 12, 13, 21, 22, 23, 31, 32, 33);
            case 2:
                return Arrays.asList(14, 15, 16, 24, 25, 26, 34, 35, 36);
            case 3:
                return Arrays.asList(17, 18, 19, 27, 28, 29, 37, 38, 39);
            case 4:
                return Arrays.asList(41, 42, 43, 51, 52, 53, 61, 62, 63);
            case 5:
                return Arrays.asList(44, 45, 46, 54, 55, 56, 64, 65, 66);
            case 6:
                return Arrays.asList(47, 48, 49, 57, 58, 59, 67, 68, 69);
            case 7:
                return Arrays.asList(71, 72, 73, 81, 82, 83, 91, 92, 93);
            case 8:
                return Arrays.asList(74, 75, 76, 84, 85, 86, 94, 95, 96);
            case 9:
                return Arrays.asList(77, 78, 79, 87, 88, 89, 97, 98, 99);
        }
        throw new RuntimeException("Not supported number of square: " + squareNumber);
    }

    @VisibleForTesting
    int getField(Integer coordinates) {
        return mFields.get(coordinates).mNumber;
    }
}
