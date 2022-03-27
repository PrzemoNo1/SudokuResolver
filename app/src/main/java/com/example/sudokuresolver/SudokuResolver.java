package com.example.sudokuresolver;

import androidx.annotation.VisibleForTesting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuResolver {
    private final boolean DEBUG = true;
    private final Board mBoard;
    private boolean mWasAnythingSet = false;

    public SudokuResolver(List<String> list) {
        if (list.size() != 81) {
            throw new RuntimeException("Wrong number of elements");
        }
        mBoard = new Board(list);
        do {
            mWasAnythingSet = false;
            analyzeSquares();
            fillMissingRow();
            analyzeSingleFields();
        } while (mWasAnythingSet);
    }

    private void analyzeSingleFields() {
        for (Integer element : mBoard.keySet()) {
            if (mBoard.getPossibleNumbers(element).size() == 1) {
                int newValue = mBoard.getPossibleNumbers(element).get(0);
                System.out.println("Single: coordinates: " + element + ", value: " + newValue);
                mWasAnythingSet = true;
                setOnBoard(element, newValue);
            }
        }
    }

    private void analyzeSquares() {
        for (int singleFieldValue = 1; singleFieldValue <= 9; ++singleFieldValue) {
            for (int squareNumber = 1; squareNumber <= 9; ++squareNumber) {
                for (Integer element : FieldsUtils.getFieldsFromSquare(squareNumber)) {
                    if (mBoard.isSet(element)) {
                        if (DEBUG) System.out.println("Not empty: " + mBoard.get(element));
                        continue;
                    }
                    int row = element / 10;
                    if (isValueInRow(singleFieldValue, row)) {
                        if (DEBUG) System.out.println("Already in row");
                        continue;
                    }
                    int column = element % 10;
                    if (isValueInColumn(singleFieldValue, column)) {
                        if (DEBUG) System.out.println("Already in column");
                        continue;
                    }
                    if (isInSquare(singleFieldValue, squareNumber)) {
                        if (DEBUG) System.out.println("Already in square");
                        continue;
                    }
                    if (!mBoard.getPossibleNumbers(element).contains(singleFieldValue)) {
                        mBoard.getPossibleNumbers(element).add(singleFieldValue);
                    }
                }
                int coordinates = isNumberPossibleOnlyInOnePlace(squareNumber, singleFieldValue);
                if (coordinates != 0) {
                    if (DEBUG) System.out.println("Square: " + coordinates + " : " + singleFieldValue);
                    mWasAnythingSet = true;
                    mBoard.set(coordinates, singleFieldValue);
                } else if (isMoreThenOnce(squareNumber, singleFieldValue)){
                    int rowCoordinate = isInOneRow(squareNumber, singleFieldValue);
                    if (rowCoordinate != 0) {
                        excludeValueFromRowExceptOneSquare(singleFieldValue, squareNumber, rowCoordinate);
                        for (int i = 1; i <= 9; ++i) {
                            coordinates = isNumberPossibleOnlyInOnePlace(i, singleFieldValue);
                            if (coordinates != 0) {
                                mWasAnythingSet = true;
                                System.out.println("After row's exclude, coordinates: " + coordinates + ", value: " + singleFieldValue);
                                setOnBoard(coordinates, singleFieldValue);
                            }
                        }
                    }
                    int columnCoordinate = isInOneColumn(squareNumber, singleFieldValue);
                    if (columnCoordinate != 0) {
                        excludeValueFromColumnExceptOneSquare(singleFieldValue, squareNumber, columnCoordinate);
                        for (int i = 1; i <= 9; ++i) {
                            coordinates = isNumberPossibleOnlyInOnePlace(i, singleFieldValue);
                            if (coordinates != 0) {
                                mWasAnythingSet = true;
                                System.out.println("After column's exclude, coordinates: " + coordinates + ", value: " + singleFieldValue);
                                setOnBoard(coordinates, singleFieldValue);
                            }
                        }
                    }
                }
            }
        }
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
                mBoard.getPossibleNumbers(element).remove((Object) singleFieldValue);
            }
    }

    private int isInOneColumn(int squareNumber, int singleFieldValue) {
        List<Integer> fields = FieldsUtils.getFieldsFromSquare(squareNumber);
        List<Integer> rememberedCoordinates = new ArrayList<>();
        int firstColumn = 0;
        for (Integer element : fields) {
            if (mBoard.isSet(element)) {
                continue;
            }
            if (mBoard.getPossibleNumbers(element).contains(singleFieldValue)) {
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
            mBoard.getPossibleNumbers(element).remove((Object) singleFieldValue);
        }
    }

    private int isInOneRow(int squareNumber, int singleFieldValue) {
        List<Integer> fields = FieldsUtils.getFieldsFromSquare(squareNumber);
        List<Integer> rememberedCoordinates = new ArrayList<>();
        int firstRow = 0;
        for (Integer element : fields) {
            if (mBoard.isSet(element)) {
                continue;
            }
            if (mBoard.getPossibleNumbers(element).contains(singleFieldValue)) {
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

    private int isNumberPossibleOnlyInOnePlace(int squareNumber, int singleFieldValue) {
        List<Integer> fields = FieldsUtils.getFieldsFromSquare(squareNumber);
        int coordinatesOfOnlyOne = 0;
        for (Integer element : fields) {
            if (mBoard.getPossibleNumbers(element).contains(singleFieldValue)) {
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
            if (mBoard.getPossibleNumbers(element).contains(singleFieldValue)) {
                if (once) {
                    return true;
                } else {
                    once = true;
                }
            }
        }
        return false;
    }

    private void fillMissingRow() {
        for (Integer element : mBoard.keySet()) {
            if (mBoard.isSet(element)) {
                continue;
            }
            int row = element / 10;
            int missingNumber = getMissingElementFromRow(row);
            if (missingNumber != 0) {
                mWasAnythingSet = true;
                if (DEBUG) System.out.println("Row: " + element + " : " + missingNumber);
                setOnBoard(element, missingNumber);
            }
        }
    }

    private int getMissingElementFromRow(int row) {
        boolean wasMissingSpot = false;
        Set<Integer> knownElements = new HashSet<>();
        for (int i = 1; i <= 9; ++i) { knownElements.add(i); }
        for (int i = 1; i <= 9; ++i) {
            if (mBoard.get(row * 10 + i) == 0) {
                if (wasMissingSpot) {
                    return 0;
                } else {
                    wasMissingSpot = true;
                }
            } else {
                knownElements.remove(mBoard.get(row * 10 + i));
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
            if (mBoard.get(fieldId) == singleFieldValue) {
                return true;
            }
        }
        return false;
    }

    private boolean isValueInRow(int value, int row) {
        for (int i = 1; i <= 9; ++i) {
            if (mBoard.get(row * 10 + i) == value) {
                return true;
            }
        }
        return false;
    }

    private boolean isValueInColumn(int value, int column) {
        for (int i = 1; i <= 9; ++i) {
            if (mBoard.get(10 * i + column) == value) {
                return true;
            }
        }
        return false;
    }

    public void setOnBoard(int coordinates, int value) {
        mBoard.set(coordinates, value);
    }

    @VisibleForTesting
    int getField(Integer coordinates) {
        return mBoard.get(coordinates);
    }
}
