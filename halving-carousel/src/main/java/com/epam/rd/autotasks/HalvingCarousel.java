package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {
    int[] elements;
    boolean isInRunningState;
    int accumulatedElements;

    public HalvingCarousel(final int capacity) {
        super(capacity);
        this.elements = new int[capacity];
        this.isInRunningState  = false;
        this.accumulatedElements = 0;
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

        return new HalvingCarouselRun(elements, accumulatedElements);
    }

}
