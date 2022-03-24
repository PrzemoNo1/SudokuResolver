package com.example.sudokuresolver;

import java.util.Arrays;
import java.util.List;

public class FieldsUtils {
    public static List<Integer> getFieldsFromSquare(int squareNumber) {
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

    public static int getSquareNumber(Integer key) {
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
}
