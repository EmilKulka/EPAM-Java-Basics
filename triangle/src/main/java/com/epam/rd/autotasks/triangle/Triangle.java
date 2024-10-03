package com.epam.rd.autotasks.triangle;

public class Triangle {
    final Point a;
    final Point b;
    final Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;

        if (this.area() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        return Math.abs((a.getX() * (b.getY() - c.getY()) +
                b.getX() * (c.getY() - a.getY()) +
                c.getX() * (a.getY() - b.getY())) / 2.0);
    }

    public Point centroid() {
        return new Point(
                (a.getX() + b.getX() + c.getX()) / 3,
                (a.getY() + b.getY() + c.getY()) / 3
        );
    }
}

