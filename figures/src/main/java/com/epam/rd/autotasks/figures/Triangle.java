package com.epam.rd.autotasks.figures;

import java.util.Locale;

class Triangle extends Figure {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        return 0.5 * Math.abs(
                a.getX() * (b.getY() - c.getY()) +
                        b.getX() * (c.getY() - a.getY()) +
                        c.getX() * (a.getY() - b.getY())
        );
    }

    @Override
    public String pointsToString() {
        return String.format(Locale.US,"(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)",
                a.getX(),
                a.getY(),
                b.getX(),
                b.getY(),
                c.getX(),
                c.getY()
        );
    }

    @Override
    public Point leftmostPoint() {
        Point[] points = {a, b, c};
        Point currentLeftomostPoint = points[0];

        for (int i = 1; i < points.length; i++) {
            if (points[i].getX() < currentLeftomostPoint.getX()) {
                currentLeftomostPoint = points[i];
            }
        }
        return currentLeftomostPoint;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "Triangle[(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)]",
                a.getX(), a.getY(),
                b.getX(), b.getY(),
                c.getX(), c.getY()
        );
    }
}
