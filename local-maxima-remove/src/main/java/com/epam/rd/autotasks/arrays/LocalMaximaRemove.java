package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};
        System.out.println(Arrays.toString(removeLocalMaxima(array))); // Output: [1, 3, 6, -5]
    }

    public static int[] removeLocalMaxima(int[] array) {
        int[] temp = new int[array.length];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                if (array[i] <= array[i + 1]) {
                    temp[index++] = array[i];
                }
            } else if (i == array.length - 1) {
                if (array[i] <= array[i - 1]) {
                    temp[index++] = array[i];
                }
            } else {
                if (array[i] <= array[i - 1] || array[i] <= array[i + 1]) {
                    temp[index++] = array[i];
                }
            }
        }
        return Arrays.copyOf(temp, index);
    }
}
