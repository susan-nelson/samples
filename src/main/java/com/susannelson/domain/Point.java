package com.susannelson.domain;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distanceFrom(Point another) {

        //square root of ((y2-y1) squared  + (x2-x1) squared)
        return Math.sqrt(Math.pow(this.getX() - another.getX(), 2) + Math.pow((this.getY() - another.getY()), 2));
    }
}
