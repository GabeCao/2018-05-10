package com.lv;

import java.util.ArrayList;
import java.util.Date;

public class Point {

    private double x;
    private double y;

    private Date date;

    ArrayList<HotSpot> belongedHotSpots = new ArrayList<>();


    public Point(double x, double y, Date date) {
        this.x = x;
        this.y = y;
        this.date = date;
    }

    public ArrayList<HotSpot> getBelongedHotSpots() {
        return belongedHotSpots;
    }

    public void setBelongedHotSpots(ArrayList<HotSpot> belongedHotSpots) {
        this.belongedHotSpots = belongedHotSpots;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Point{" +
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
