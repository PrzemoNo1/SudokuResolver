package com.example.sudokuresolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Board {
    private HashMap<Integer, Field> mFields;

    public Board(List<String> list) {
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

    private static class Field {
        public Field(Integer number) {
            mNumber = number;
        }
        public Integer mNumber;
        public List<Integer> mPossibleNumbers = new ArrayList<>();
    }

    public boolean isSet(int coordinates) {
        Field value = mFields.get(coordinates);
        return (value != null ? value.mNumber : 0) != 0;
    }

    public int get(int coordinates) {
        Field value = mFields.get(coordinates);
        return value != null ? value.mNumber : 0;
    }

    public void set(int coordinates, int value) {
        mFields.get(coordinates).mNumber = value;
    }

    public List<Integer> getPossibleNumbers(int coordinates) {
        return mFields.get(coordinates).mPossibleNumbers;
    }

    public Set<Integer> keySet() {
        return mFields.keySet();
    }
}
