package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static int max(int[] values) {
        int currentMax = values[0];

        for(int number : values) {
            if(number > currentMax) {
                currentMax = number;
            }
        }
        return currentMax;
    }

}
