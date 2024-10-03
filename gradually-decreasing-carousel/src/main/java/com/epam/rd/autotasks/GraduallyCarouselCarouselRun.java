package com.epam.rd.autotasks;

public class GraduallyCarouselCarouselRun extends CarouselRun {
    private int currentIndex = 0;
    private int decrementValue = 1;

    public GraduallyCarouselCarouselRun(int[] elements, int accumulatedElements) {
        super(elements, accumulatedElements);
    }

    @Override
    public int next() {
        if (isFinished()) {
            return -1;
        }

        // Find next non-zero element
        int startingIndex = currentIndex;
        do {
            if (elements[currentIndex] > 0) {
                int currentValue = elements[currentIndex];
                elements[currentIndex] -= decrementValue;

                if (elements[currentIndex] <= 0) {
                    activeElements--;
                }

                currentIndex = (currentIndex + 1) % elements.length;

                // If we've completed a full cycle, increase decrementValue
                if (currentIndex == 0) {
                    decrementValue++;
                }

                return currentValue;
            }

            currentIndex = (currentIndex + 1) % elements.length;

            // If we have looped through all elements, increase decrement value
            if (currentIndex == 0 && startingIndex != 0) {
                decrementValue++;
            }

        } while (currentIndex != startingIndex);

        return -1;
    }
}
