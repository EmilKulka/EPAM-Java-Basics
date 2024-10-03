package com.epam.rd.autotasks.figures;

import java.util.Locale;

class Circle extends Figure {

    public static final double PI = Math.PI;
    private final Point center;
    private final double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI * Math.pow(radius, 2);
    }

    @Override
    public String pointsToString() {
        return String.format(Locale.US,"(%.1f,%.1f)", center.getX(), center.getY());
    }

    @Override
    public Point leftmostPoint() {
        double leftmostX = center.getX() - radius; // Calculate leftmost x-coordinate
        double leftmostY = center.getY(); // Y-coordinate remains the same
        return new Point(leftmostX, leftmostY); // Return a new Point representing the leftmost point
    }

    @Override
    public String toString() {
        if (radius % 1 == 0) {
            return String.format(Locale.US, "Circle[(%.1f,%.1f)%.1f]", center.getX(), center.getY(), radius);
        } else if (radius < 1.0) {
            return String.format(Locale.US, "Circle[(%.1f,%.1f)%.3f]", center.getX(), center.getY(), radius);
        } else {
            return String.format(Locale.US, "Circle[(%.1f,%.1f)%.4f]", center.getX(), center.getY(), radius);
        }
    }
}
