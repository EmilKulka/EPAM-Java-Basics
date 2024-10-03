package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;



    public static Direction ofDegrees(int degrees) {
        degrees = degreesInRange(degrees);
        for(Direction direction : Direction.values()) {
            if(direction.degrees == degrees ) {
                return direction;
            }
        } return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = degreesInRange(degrees);
        Direction currentClosest = Direction.N;
        int currentMinDifference = Math.abs(currentClosest.degrees - degrees) ;
        for(Direction direction : Direction.values()) {
            if(Math.abs(direction.degrees - degrees) < currentMinDifference) {
                currentClosest = direction;
                currentMinDifference = Math.abs(direction.degrees - degrees);
            }
        }
        return currentClosest;
    }

    public Direction opposite() {
        switch (this) {
            case W:
                return E;
            case S:
                return N;
            case E:
                return W;
            case N:
                return S;
            case SW:
                return NE;
            case SE:
                return NW;
            case NW:
                return SE;
            case NE:
                return SW;
            default:
                return null;
        }
    }

    public int differenceDegreesTo(Direction direction) {
        int difference =  Math.abs(this.degrees - direction.degrees);
        return Math.min(difference, 360 - difference);
    }

    public static int degreesInRange(int deg) {
        deg += 36000;
        return deg % 360;
    }
}
