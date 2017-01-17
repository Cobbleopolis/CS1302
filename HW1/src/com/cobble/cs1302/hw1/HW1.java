//Class:      CS1301/08
//Term:       Spring 2017
//Name:       Logan Thompson
//Instructor: Monisha Verma
//Assignment: HW 1
package com.cobble.cs1302.hw1;

public class HW1 {

    private static final int[][] data1 = {
            {0, 1, 0, 3, 1, 6, 1},
            {0, 1, 6, 8, 6, 0, 1},
            {5, 6, 2, 1, 8, 2, 9},
            {6, 5, 6, 1, 1, 9, 1},
            {1, 3, 6, 1, 4, 0, 7},
            {3, 3, 3, 3, 4, 0, 7}
    };

    private static final int[][] data2 = {
            {0, 1, 0, 3, 1, 6, 1},
            {0, 1, 6, 8, 6, 0, 1},
            {5, 5, 2, 1, 8, 2, 9},
            {6, 5, 6, 1, 1, 9, 1},
            {1, 5, 6, 1, 4, 0, 7},
            {3, 5, 3, 3, 4, 0, 7}
    };

    private static final int[][] data3 = {
            {0, 1, 0, 3, 1, 6, 1},
            {0, 1, 6, 8, 6, 0, 1},
            {5, 6, 2, 1, 6, 2, 9},
            {6, 5, 6, 6, 1, 9, 1},
            {1, 3, 6, 1, 4, 0, 7},
            {3, 6, 3, 3, 4, 0, 7}
    };

    private static final int[][] data4 = {
            {0, 1, 0, 3, 1, 6, 1},
            {0, 1, 6, 8, 6, 0, 1},
            {9, 6, 2, 1, 8, 2, 9},
            {6, 9, 6, 1, 1, 9, 1},
            {1, 3, 9, 1, 4, 0, 7},
            {3, 3, 3, 9, 4, 0, 7}
    };

    public static void main(String[] args) {
        System.out.println(isConsecutiveFour(data1));
        System.out.println(isConsecutiveFour(data2));
        System.out.println(isConsecutiveFour(data3));
        System.out.println(isConsecutiveFour(data4));
    }

    public static boolean isConsecutiveFour(int[][] values) {
        int rows = values.length;
        int cols = values[0].length;

        //Check rows
        for (int[] row: values)
            for (int j = 0; j <= row.length - 3; j++) {
                int checkNum = row[j];
                if (row[j + 1] == checkNum && row[j + 2] == checkNum && row[j + 3] == checkNum) {
                    System.out.println(checkNum);
                    return true;
                }
            }

        // Check cols
        for (int i = 0; i <= rows - 3; i++)
            for (int j = 0; j < cols; j++) {
                int checkNum = values[i][j];
                if (values[i + 1][j] == checkNum && values[i + 2][j] == checkNum && values[i + 3][j] == checkNum) {
                    System.out.println(checkNum);
                    return true;
                }
            }

        // Check major diagonal
        for (int i = 3; i < rows; i++)
            for (int j = 0; j <= cols - 3; j++) {
                int checkNum = values[i][j];
                if (values[i - 1][j + 1] == checkNum && values[i - 2][j + 2] == checkNum && values[i - 3][j + 3] == checkNum) {
                    System.out.println(checkNum);
                    return true;
                }
            }

        // Check minor diagonal
        for (int i = 0; i <= rows - 3; i++)
            for (int j = 0; j <= cols - 3; j++) {
                int checkNum = values[i][j];
                if (values[i + 1][j + 1] == checkNum && values[i + 2][j + 2] == checkNum && values[i + 3][j + 3] == checkNum) {
                    System.out.println(checkNum);
                    return true;
                }
            }
        return false;
    }
}
