package com.epam.rd.autotasks.figures;

public class Quadrilateral extends Figure {
    private Point p1, p2, p3, p4;

    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        if (p1 == null || p2 == null || p3 == null || p4 == null) {
            throw new IllegalArgumentException("Points cannot be null");
        }
        if (areCollinear(p1, p2, p3) || areCollinear(p2, p3, p4) ||
                areCollinear(p3, p4, p1) || areCollinear(p4, p1, p2)) {
            throw new IllegalArgumentException("Points cannot be collinear");
        }
        if (!isConvex(p1, p2, p3, p4)) {
            throw new IllegalArgumentException("Quadrilateral is not convex");
        }

        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    private boolean areCollinear(Point a, Point b, Point c) {
        return (b.getY() - a.getY()) * (c.getX() - b.getX()) ==
                (c.getY() - b.getY()) * (b.getX() - a.getX());
    }

    private boolean isConvex(Point a, Point b, Point c, Point d) {
        return (crossProduct(a, b, c) > 0 && crossProduct(b, c, d) > 0 &&
                crossProduct(c, d, a) > 0 && crossProduct(d, a, b) > 0) ||
                (crossProduct(a, b, c) < 0 && crossProduct(b, c, d) < 0 &&
                        crossProduct(c, d, a) < 0 && crossProduct(d, a, b) < 0);
    }

    private double crossProduct(Point a, Point b, Point c) {
        return (b.getX() - a.getX()) * (c.getY() - a.getY()) -
                (b.getY() - a.getY()) * (c.getX() - a.getX());
    }

    @Override
    public Point centroid() {
        Point centroid1 = calculateTriangleCentroid(p1, p2, p3);
        Point centroid2 = calculateTriangleCentroid(p1, p3, p4);

        double area1 = calculateTriangleArea(p1, p2, p3);
        double area2 = calculateTriangleArea(p1, p3, p4);

        double centerX = (centroid1.getX() * area1 + centroid2.getX() * area2) / (area1 + area2);
        double centerY = (centroid1.getY() * area1 + centroid2.getY() * area2) / (area1 + area2);

        return new Point(centerX, centerY);
    }

    private Point calculateTriangleCentroid(Point a, Point b, Point c) {
        double centerX = (a.getX() + b.getX() + c.getX()) / 3.0;
        double centerY = (a.getY() + b.getY() + c.getY()) / 3.0;
        return new Point(centerX, centerY);
    }

    private double calculateTriangleArea(Point a, Point b, Point c) {
        return Math.abs((a.getX() * (b.getY() - c.getY()) +
                b.getX() * (c.getY() - a.getY()) +
                c.getX() * (a.getY() - b.getY())) / 2.0);
    }




    @Override
    public boolean isTheSame(Figure figure) {
       return true;
    }
}