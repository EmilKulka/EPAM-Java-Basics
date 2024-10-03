package com.epam.rd.autotasks;

public class HalvingCarouselRun extends CarouselRun {
    int currentNumber;
    int currentIndex = 0;
    public HalvingCarouselRun(int[] elements, int accumulatedElements) {
        super(elements, accumulatedElements);
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
        elements[currentIndex] = (int) Math.floor(currentNumber / 2);

        // Check if number is active after decrement
        if(elements[currentIndex] == 0) {
            activeElements--;
        }

        // Save next number index
        currentIndex = (currentIndex + 1) % elements.length;

        return currentNumber;
    }

}
