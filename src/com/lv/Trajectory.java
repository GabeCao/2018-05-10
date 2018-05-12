package com.lv;

import sun.management.HotspotClassLoadingMBean;

import javax.net.ssl.HostnameVerifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Trajectory {

    private Map<HotSpot,Integer> visitInfo;
    private Date initTime;

    public Date getInitTime() {
        return initTime;
    }

    public void setInitTime(Date initTime) {
        this.initTime = initTime;
    }

    public Trajectory(ArrayList<HotSpot> hotSpots) {
        this.visitInfo = new HashMap<>();
        for (HotSpot hotSpot : hotSpots) {
            this.visitInfo.put(hotSpot,0);
        }
    }

    public Map<HotSpot, Integer> getVisitInfo() {
        return visitInfo;
    }

    public void setVisitInfo(Map<HotSpot, Integer> visitInfo) {
        this.visitInfo = visitInfo;
    }

    @Override
    public String toString() {
        return "Trajectory{" +
                "visitInfo=" + visitInfo +
                '}';
    }
}
