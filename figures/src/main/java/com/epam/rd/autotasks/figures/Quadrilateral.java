package com.epam.rd.autotasks.figures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

class Quadrilateral extends Figure {
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        return 0.5 * (Math.abs(a.getX() * b.getY() + b.getX() * c.getY() + c.getX() * d.getY() + d.getX() * a.getY()
                - (a.getY() * b.getX() + b.getY() * c.getX() + c.getY() * d.getX() + d.getY() * a.getX()))
        );
    }

    @Override
    public String pointsToString() {
        return String.format(Locale.US,"(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)",
                a.getX(), a.getY(),
                b.getX(), b.getY(),
                c.getX(), c.getY(),
                d.getX(), d.getY()
        );
    }

    @Override
    public Point leftmostPoint() {
        Point[] points = {a, b, c, d};
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
                "Quadrilateral[(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)]",
                a.getX(), a.getY(),
                b.getX(), b.getY(),
                c.getX(), c.getY(),
                d.getX(), d.getY()
        );
    }
}
