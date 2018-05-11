package com.lv;

import com.lv.Utils.Points;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception{
        //获得所有的HotSpots
        ArrayList<HotSpot> hotSpots = GetAllHotSpots.getAllHotSpots();
        //所有的Trajectory
        ArrayList<Trajectory> trajectories = new ArrayList<>();
        String fileName = "179.txt";
        Integer times = 4;
        String filePath = "C:\\E\\dataSet\\2018-05-10\\source-data(星期一)\\" + fileName;
        File file = new File(filePath);

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;

        line = bufferedReader.readLine();
        if (line != null) {
            String[] data_first = line.split(",");
            String date_string = data_first[4] + " " + data_first[5];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date_first = simpleDateFormat.parse(date_string);
            Point point_first = new Point(Double.parseDouble(data_first[6]), Double.parseDouble(data_first[7]),date_first);
            Trajectory trajectory_first  = new Trajectory(hotSpots);
            ArrayList<HotSpot> hotSpots_first = Points.getNearHotSpot(point_first,hotSpots);
            point_first.setBelongedHotSpots(hotSpots_first);
            for (HotSpot hotSpot : hotSpots_first) {
                trajectory_first.getVisitInfo().put(hotSpot,1);
            }
            trajectories.add(trajectory_first);

            Point prePoint = point_first;
            Trajectory preTrajectory = trajectory_first;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                String date_string_ = data[4] + " " + data[5];
                SimpleDateFormat simpleDateFormat_ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date_first_ = simpleDateFormat_.parse(date_string_);
                Point point = new Point(Double.parseDouble(data[6]), Double.parseDouble(data[7]),date_first_);

                long timeDiff = point.getDate().getTime() - prePoint.getDate().getTime();
                if (timeDiff < 300000) {
                    //如果小于五分钟,找到当前point 属于的附近的HotSpot
                    ArrayList<HotSpot> hotSpotArrayList = Points.getNearHotSpot(point,hotSpots);
                    point.setBelongedHotSpots(hotSpotArrayList);
                    //遍历所有的 HotSpot,如果当前的 hotspot 没有在上一个 轨迹点中，则认为这个hotspot 被访问一次
                    for (HotSpot hotSpot : hotSpotArrayList) {
                        if (!prePoint.getBelongedHotSpots().contains(hotSpot)) {
                            preTrajectory.getVisitInfo().put(hotSpot,preTrajectory.getVisitInfo().get(hotSpot) + 1);
                        }
                    }

                    prePoint = point;
                } else {
                    System.out.println("...........");
                    //如果时间大于五分钟，则 建立新的Trajectory，并添加到 Trajectorys 中
                    Trajectory newTrajectory = new Trajectory(hotSpots);
                    trajectories.add(newTrajectory);
                    //找到 Point 附近的所有HotSpot
                    ArrayList<HotSpot> hotSpotArrayList = Points.getNearHotSpot(point,hotSpots);
                    point.setBelongedHotSpots(hotSpotArrayList);
                    //对所有的 HotSpot Trajectory 都算访问一次
                    for (HotSpot hotSpot : hotSpotArrayList) {
                        newTrajectory.getVisitInfo().put(hotSpot,1);
                    }
                    prePoint = point;
                    preTrajectory = newTrajectory;
                }

            }
        }
        Map<HotSpot,Integer> result = new HashMap<>();

        for (HotSpot hotSpot : hotSpots) {
            result.put(hotSpot,0);
            int counter = 0;
            for (Trajectory trajectory : trajectories) {
                counter += trajectory.getVisitInfo().get(hotSpot);
            }
            result.put(hotSpot,counter);
        }

        File outFile = new File("C:\\E\\dataSet\\2018-05-10\\访问hotSpot的频率\\" + fileName);
        if (!outFile.exists()) {
            outFile.createNewFile();
        }
        FileWriter outFileWriter = new FileWriter(outFile,true);

        for (Map.Entry<HotSpot,Integer> entry : result.entrySet()) {
            outFileWriter.write(entry.getKey().getX() + "," + entry.getKey().getY() + "," + entry.getValue() + "," + (float)entry.getValue()/times +"\n");
        }
        outFileWriter.close();
    }
}
