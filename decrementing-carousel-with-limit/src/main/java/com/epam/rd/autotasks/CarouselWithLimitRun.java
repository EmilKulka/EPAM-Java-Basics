package com.epam.rd.autotasks;

public class CarouselWithLimitRun extends CarouselRun {
    private final int actionLimit;
    private int actionCount = 0;

    public CarouselWithLimitRun(int[] elements, int accumulatedElements, int actionLimit) {
        super(elements, accumulatedElements);
        this.actionLimit = actionLimit;
    }

    @Override
    public int next() {
        if (isFinished()) {
            System.out.println("Returning -1, either finished or limit reached.");
            return -1;
        }

        while (elements[currentIndex] <= 0 && activeElements > 0) {
            currentIndex = (currentIndex + 1) % elements.length;
        }

        int currentValue = elements[currentIndex];
        elements[currentIndex]--;

        if (elements[currentIndex] == 0) {
            activeElements--;
        }

        currentIndex = (currentIndex + 1) % elements.length;

        actionCount++;

        return currentValue;
    }

    @Override
    public boolean isFinished() {
        return activeElements == 0 || actionCount >= actionLimit;
    }
}
