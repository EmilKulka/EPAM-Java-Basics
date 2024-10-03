package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    Point start;
    Point end;

    public Segment(Point start, Point end) {
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new IllegalStateException();
        }
        this.start = start;
        this.end = end;
    }

    double length() {
        return sqrt((pow(end.getX() - start.getX(), 2)) + pow(end.getY() - start.getY(), 2));
    }

    Point middle() {
        return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }

    Point intersection(Segment another) {
        double x1 = start.getX(), y1 = start.getY();
        double x2 = end.getX(), y2 = end.getY();
        double x3 = another.start.getX(), y3 = another.start.getY();
        double x4 = another.end.getX(), y4 = another.end.getY();

        double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (denominator == 0) {
            return null;
        }

        double intersectX = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / denominator;
        double intersectY = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / denominator;

        Point intersectionPoint = new Point(intersectX, intersectY);

        if (isPointOnSegment(intersectionPoint, this) && isPointOnSegment(intersectionPoint, another)) {
            return intersectionPoint;
        } else {
            return null;
        }
    }

    private boolean isPointOnSegment(Point p, Segment s) {
        return Math.min(s.start.getX(), s.end.getX()) <= p.getX() &&
                p.getX() <= Math.max(s.start.getX(), s.end.getX()) &&
                Math.min(s.start.getY(), s.end.getY()) <= p.getY() &&
                p.getY() <= Math.max(s.start.getY(), s.end.getY());


    }
}
