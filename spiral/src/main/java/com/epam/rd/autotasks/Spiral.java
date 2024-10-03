package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] result = new int[rows][columns];

        int number = 1;

        int topRow = 0;
        int bottomRow = rows-1;
        int leftSide = 0;
        int rightSide = columns -1;

        while(number <= rows * columns) {
            // Top row
            for(int i = leftSide; i <= rightSide && number <= rows * columns; i++) {
                result[topRow][i] = number++;
            }
            // Move down
            topRow++;

            // Right wall
            for(int i = topRow; i <= bottomRow && number <= rows * columns; i++ ) {
                result[i][rightSide] = number++;
            }
            // Move left
            rightSide--;

            // Bottom row
            for(int i = rightSide; i >= leftSide && number <= rows * columns; i--) {
                result[bottomRow][i] = number++;
            }

            // Move up
            bottomRow--;

            for(int i = bottomRow; i >= topRow && number <= rows * columns; i--) {
                result[i][leftSide] = number++;
            }

            // Move right
            leftSide++;

        }

        return result;
    }
}
