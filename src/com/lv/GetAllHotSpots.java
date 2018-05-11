package com.lv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class GetAllHotSpots {

    public static ArrayList<HotSpot> getAllHotSpots() throws Exception{
        File file = new File("C:\\E\\dataSet\\2018-05-10\\selectedHotSpots.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;

        ArrayList<HotSpot> hotSpots = new ArrayList<HotSpot>();
        while ((line = bufferedReader.readLine()) != null ) {
            String[] data = line.split(",");
            double x = Double.parseDouble(data[0]);
            double y = Double.parseDouble(data[1]);
            HotSpot hotSpot = new HotSpot(x, y);
            hotSpots.add(hotSpot);
        }
        return hotSpots;
    }
}
