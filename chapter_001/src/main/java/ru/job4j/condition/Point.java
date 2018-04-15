package ru.job4j.condition;

/**
 * @author Andreas Horn (ahorn80@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Point {
    private int x;
    private int y;

    /**
     * Point ctor
     * @param x x value
     * @param y y value
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    /**
     * calculates vector from this point to another point
     * @param other another point
     * @return vector from this to other as a Point object
     */
    public Point getDiffVector(Point other) {
        return new Point(other.x - this.x, other.y - this.y);
    }

    /**
     * calculates distance to point
     * @param that another point
     * @return distance to point that
     */
    public double distanceTo(Point that) {
        Point diffV = getDiffVector(that);

        return Math.sqrt(
                Math.pow(diffV.x, 2) + Math.pow(diffV.y, 2)
        );

    }

    /**
     * main
     * @param args args
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        System.out.println("Distance between point 'a' and 'b' is " + a.distanceTo(b));
    }
}