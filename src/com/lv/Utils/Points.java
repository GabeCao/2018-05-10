package com.lv.Utils;

import com.lv.HotSpot;
import com.lv.Point;

import java.util.ArrayList;

public class Points {
    //判断 Point 和 HotSpot 点之间的距离
    private static double getDistanceBetweenAndPontAndHotSpot(Point p1, HotSpot p2) {
        return Math.sqrt(Math.abs((p1.getX() - p2.getX())* (p1.getX() - p2.getX())+(p1.getY() - p2.getY())* (p1.getY() - p2.getY())));
    }

    //找到 Point 周围 半径小于 10 米的 HotSpot
    public  static ArrayList<HotSpot> getNearHotSpot(Point point, ArrayList<HotSpot> hotSpots) {
        ArrayList<HotSpot> hotSpotArrayList = new ArrayList<>();
        for (HotSpot hotSpot : hotSpots) {
            if (getDistanceBetweenAndPontAndHotSpot(point,hotSpot) < 10) {
                hotSpotArrayList.add(hotSpot);
            }
        }
        return hotSpotArrayList;
    }
}
