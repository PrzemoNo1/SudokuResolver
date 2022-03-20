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
        mFields = new HashMap<>(81);
        String initialKey = "11";
        for (String element : list) {
            Field field = new Field();
            if (!element.equals("")) {
                field.setNumber(Integer.parseInt(element));
            }
            mFields.put(initialKey, field);
            StringBuilder sb = new StringBuilder(initialKey);
            int initialNumber = Integer.parseInt(sb.reverse().toString());
            ++initialNumber;
            if (initialNumber % 10 == 0) {
                ++ initialNumber;
            }
            initialKey = String.valueOf(initialNumber);
            sb = new StringBuilder(initialKey);
            initialKey = sb.reverse().toString();
        }
    }

    @VisibleForTesting
    int getField(String coordinates) {
        return mFields.get(coordinates).getNumber();
    }

    private HashMap<String, Field> mFields;
}
