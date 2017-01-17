//Class:      CS1301/08
//Term:       Spring 2017
//Name:       Logan Thompson
//Instructor: Monisha Verma
//Assignment: Homework 1
package com.cobble.cs1302.hw1;

import java.util.Scanner;

public class HW1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the number of rows: ");
        int numberOfRows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int numberOfColumns = scanner.nextInt();

        int[][] data = new int[numberOfRows][numberOfColumns];

        System.out.println("Enter the array values: ");
        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[i].length; j++)
                data[i][j] = scanner.nextInt();

        System.out.println(isConsecutiveFour(data));
    }

    public static boolean isConsecutiveFour(int[][] values) {
        int rows = values.length;
        int cols = values[0].length;

        //Check rows
        for (int[] row: values)
            for (int j = 0; j <= row.length - 3; j++) {
                int checkNum = row[j];
                if (row[j + 1] == checkNum && row[j + 2] == checkNum && row[j + 3] == checkNum) {
                    return true;
                }
            }

        // Check cols
        for (int i = 0; i <= rows - 3; i++)
            for (int j = 0; j < cols; j++) {
                int checkNum = values[i][j];
                if (values[i + 1][j] == checkNum && values[i + 2][j] == checkNum && values[i + 3][j] == checkNum) {
                    return true;
                }
            }

        // Check major diagonal
        for (int i = 3; i < rows; i++)
            for (int j = 0; j <= cols - 3; j++) {
                int checkNum = values[i][j];
                if (values[i - 1][j + 1] == checkNum && values[i - 2][j + 2] == checkNum && values[i - 3][j + 3] == checkNum) {
                    return true;
                }
            }

        // Check minor diagonal
        for (int i = 0; i <= rows - 3; i++)
            for (int j = 0; j <= cols - 3; j++) {
                int checkNum = values[i][j];
                if (values[i + 1][j + 1] == checkNum && values[i + 2][j + 2] == checkNum && values[i + 3][j + 3] == checkNum) {
                    return true;
                }
            }
        return false;
    }
}
