package com.example.sudokuresolver;

import androidx.annotation.VisibleForTesting;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class SudokuResolver {
    private class Field {
        private int mNumber;
        private Vector<Integer> mPossibleNumbers;
        public void setNumber(int number) {
            mNumber = number;
        }
        public int getNumber() {
            return mNumber;
        }
    }

    public SudokuResolver(List<String> list) {
        if (list.size() != 81) {
            throw new RuntimeException("Wrong number of elements");
        }
        initializeFields(list);
    }

    private void initializeFields(List<String> list) {
        mFields = new HashMap<>(81);
        String initialKey = "11";
        for (String element : list) {
            Field field = new Field();
            if (!element.equals("")) {
                field.setNumber(Integer.parseInt(element));
            }
            mFields.put(initialKey, field);
            int initialNumber = Integer.parseInt(initialKey);
            ++initialNumber;
            if (initialNumber % 10 == 0) {
                ++initialNumber;
            }
            initialKey = String.valueOf(initialNumber);
        }
    }

    @VisibleForTesting
    int getField(String coordinates) {
        return mFields.get(coordinates).getNumber();
    }

    private HashMap<String, Field> mFields;
}
