package com.lv;

public class HotSpot {
    private double x;
    private double y;

    public HotSpot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "HotSpot{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
