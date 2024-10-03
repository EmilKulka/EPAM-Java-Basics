package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    int[] elements;
    boolean isInRunningState;
    int accumulatedElements;

    int actionLimit;
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.elements = new int[capacity];
        this.isInRunningState  = false;
        this.accumulatedElements = 0;
        this.actionLimit = actionLimit;
    }

    public boolean addElement(int element){
        if(isInRunningState || accumulatedElements >= capacity || element <= 0) {
            return false;
        }

        elements[accumulatedElements++] = element;
        return true;
    }

    public CarouselRun run(){
        if(isInRunningState) {
            return null;
        }
        isInRunningState = true;

        return new CarouselWithLimitRun(elements, accumulatedElements, actionLimit);
    }
}
