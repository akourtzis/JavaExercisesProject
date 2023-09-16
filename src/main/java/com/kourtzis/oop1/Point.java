package com.kourtzis.oop1;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    public double distanceOfPointToCoordinateOrigin() {
        return Math.sqrt((x * x) + (y * y));
    }

    public Point flipPointOnXaxis() {
        return new Point(x, y * -1);
    }

    public Point flipPointOnYaxis() {
        return new Point(x * -1, y);
    }

    public Point flipPointOnOrigin() {
        return new Point(x * -1, y * -1);
    }

    public double distanceOfTwoPoints(final Point origin, final Point destination) {
        return Math.sqrt(Math.pow((destination.x - origin.x), 2) + Math.pow((destination.y - origin.y), 2));
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
