//Class:      CS1301/08
//Term:       Spring 2017
//Name:       Logan Thompson
//Instructor: Monisha Verma
//Assignment: Lab 1_1
package com.cobble.cs1302.lab1_1;

import java.util.Scanner;

public class Lab1_1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double[][] a = getMatrixFromUser("a");
        double[][] b = getMatrixFromUser("b");
        if (a[0].length == b.length) { // Checks if the two matrices are able to be multiplied.
            double[][] c = multiplyMatrix(a, b);
            printMatrices(a, b, c);
        } else {
            System.out.println("The number of columns in matrix a and the number of rows in matrix b must be the same.");
            System.out.println("Unable to do matrix multiplication.");
        }
    }

    /**
     * Prompts the user for a 3 x 3 matrix.
     * @param label The label to use when prompting the user for the matrix.
     * @return The 3 x 3 matrix that the user inputted.
     */
    private static double[][] getMatrixFromUser(String label) {
        System.out.printf("Number of rows in matrix %s: ", label);
        int rows = scanner.nextInt();
        System.out.printf("Number of columns in matrix %s: ", label);
        double[][] mat = new double[rows][scanner.nextInt()];
        System.out.printf("Enter matrix %s:%n", label);
        for (double[] arr : mat)
            for (int i = 0; i < arr.length; i++)
                arr[i] = scanner.nextDouble();
        return mat;
    }

    /**
     * Multiplies two double matrices.
     * @param a The first matrix to multiply.
     * @param b The second matrix to multiply.
     * @return The product of the two provided matrices.
     */
    private static double[][] multiplyMatrix(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < c.length; i++)
            for (int j = 0; j < c[0].length; j++)
                for (int k = 0; k < b.length; k++)
                    c[i][j] += a[i][k] * b[k][j];
        return c;
    }

    /**
     * Properly prints all 3 matrices to the console.
     * @param a The first matrix in the multiplication.
     * @param b The second matrix in the multiplication.
     * @param c The product of the multiplication.
     */
    private static void printMatrices(double[][] a, double[][] b, double[][] c) {
        int maxNumLength = 0; // Stores the maximum amount of digits in the integer part of any number in arrays a, b, and c
        int maxRowCount = Math.max(Math.max(a.length, b.length), c.length); // Gets the largest row count from arrays a, b, and c.
        int operatorIndex = maxRowCount / 2; // Finds the middle row we're printing so we know where to print the operator and equal sign.
        // Gets the longest String length in all the matrices.
        for (double[] arr : a)
            for (double i : arr)
                maxNumLength = Math.max(maxNumLength, Integer.toString((int) i).length());
        for (double[] arr : b)
            for (double i : arr)
                maxNumLength = Math.max(maxNumLength, Integer.toString((int) i).length());
        for (double[] arr : c)
            for (double i : arr)
                maxNumLength = Math.max(maxNumLength, Integer.toString((int) i).length());

        for (int i = 0; i < maxRowCount; i++) {
            printMatrixRow(a, i, maxNumLength); // Prints the row for matrix a.
            System.out.printf("  %s  ", (i == operatorIndex) ? "*" : " "); // Prints either the gap or the operator between matrix a and b.
            printMatrixRow(b, i, maxNumLength); // Prints the row for matrix b.
            System.out.printf("  %s  ", (i == operatorIndex) ? "=" : " "); // Prints either the gap or the equal sign between matrix b and c.
            printMatrixRow(c, i, maxNumLength); // Prints the row for matrix c.
            System.out.println();
        }
    }

    /**
     * Prints a specific row of a matrix to the console.
     * @param mat          The matrix to print.
     * @param row          The row of the matrix to print.
     * @param maxNumLength The maximum amount of numbers in the integer part of any number.
     */
    private static void printMatrixRow(double[][] mat, int row, int maxNumLength) {
        String printFormat = "%" + (maxNumLength + 2) + ".1f";
        String emptyNum = new String(new char[maxNumLength + 2]).replace("\0", " ");
        for (int i = 0; i < mat[0].length; i++)
            System.out.print(((row < mat.length) ? String.format(printFormat, mat[row][i]) : emptyNum) + " ");
    }
}
