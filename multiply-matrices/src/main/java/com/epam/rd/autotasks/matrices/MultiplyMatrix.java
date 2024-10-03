package com.epam.rd.autotasks.matrices;

import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {

        int rowsA = matrix1.length;
        int colsA = matrix1[0].length;
        int colsB = matrix2[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                int sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = sum;
            }
        }
    return result;
}

public static void main(String[] args) {

    System.out.println("Test your code here!\n");

    // Get a result of your code

    int[][] a = {
            {0, 12345},
            {4509, 0},
            {3, 567}};

    int[][] b = {
            {653, 0, 25353},
            {0, 61, 6}};

    int[][] result = multiply(a, b);
    System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
}
}
