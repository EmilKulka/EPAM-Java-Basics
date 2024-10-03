package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException("Triangle vertices cannot be null");
        }
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Invalid triangle: vertices must form a non-degenerate triangle");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private boolean isValidTriangle(Point a, Point b, Point c) {
        return Math.abs((a.getX() * (b.getY() - c.getY()) +
                b.getX() * (c.getY() - a.getY()) +
                c.getX() * (a.getY() - b.getY())) / 2) > 0.00001;
    }

    @Override
    public Point centroid() {
        double x = (a.getX() + b.getX() + c.getX()) / 3;
        double y = (a.getY() + b.getY() + c.getY()) / 3;
        return new Point(x, y);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (!(figure instanceof Triangle)) return false;
        Triangle other = (Triangle) figure;
        return (isSamePoint(a, other.a) || isSamePoint(a, other.b) || isSamePoint(a, other.c)) &&
                (isSamePoint(b, other.a) || isSamePoint(b, other.b) || isSamePoint(b, other.c)) &&
                (isSamePoint(c, other.a) || isSamePoint(c, other.b) || isSamePoint(c, other.c));
    }

    private boolean isSamePoint(Point p1, Point p2) {
        return Math.abs(p1.getX() - p2.getX()) < 0.00001 && Math.abs(p1.getY() - p2.getY()) < 0.00001;
    }
}
