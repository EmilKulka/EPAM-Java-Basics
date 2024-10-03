package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    public static final double PI = Math.PI;
    private final Point center;
    private final double radius;

    public Circle(Point center, double radius) {
        if (center == null) {
            throw new IllegalArgumentException("Center point cannot be null");
        }
        if (radius <= 0) {
            throw new IllegalArgumentException("Invalid radius");
        }
        this.center = center;
        this.radius = radius;
    }

    @Override
    public Point centroid() {
        return center;

    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (!(figure instanceof Circle)) return false;
        Circle other = (Circle) figure;
        return isSamePoint(center, other.center) && Math.abs(radius - other.radius) < 0.00001;
    }

    private boolean isSamePoint(Point p1, Point p2) {
        return Math.abs(p1.getX() - p2.getX()) < 0.00001 && Math.abs(p1.getY() - p2.getY()) < 0.00001;
    }
}
