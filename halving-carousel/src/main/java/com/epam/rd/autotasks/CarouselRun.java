package com.epam.rd.autotasks;

public class CarouselRun {
    int currentNumber;
    int currentIndex = 0;
    int[] elements;
    int activeElements;

    public CarouselRun(int[] elements, int activeElements) {
        this.elements  = elements;
        this.activeElements = activeElements;
    }

    public int next() {
        if(isFinished()) {
            return -1;
        }

        // Find index of next active number
        while(elements[currentIndex] == 0) {
            currentIndex = (currentIndex + 1) % elements.length;
        }
        // Save active number value
        currentNumber = elements[currentIndex];

        // Decrement numbers value
        elements[currentIndex]--;

        // Check if number is active after decrement
        if(elements[currentIndex] == 0) {
            activeElements--;
        }

        // Save next number index
        currentIndex = (currentIndex + 1) % elements.length;

        return currentNumber;
    }

    public boolean isFinished() {
        if(activeElements == 0) {
            return true;
        }
        return false;
    }


}
