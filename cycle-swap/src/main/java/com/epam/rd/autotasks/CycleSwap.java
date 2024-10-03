package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array.length == 0) return;

        int lastElement = array[array.length -1];

        for(int i = array.length -1; i > 0; i--) {
                array[i] = array[i-1];
        }
        array[0] = lastElement;
    }

    static void cycleSwap(int[] array, int shift) {
        if (array.length == 0 || shift == 0 || shift == array.length) return;

        shift = shift % array.length;

        int[] temp = new int[shift];

        for (int i = 0; i < shift; i++) {
            temp[i] = array[array.length - shift + i];
        }

        for (int i = array.length - 1; i >= shift; i--) {
            array[i] = array[i - shift];
        }

        for (int i = 0; i < shift; i++) {
            array[i] = temp[i];
        }
    }
}
