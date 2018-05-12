package com.lv.Utils;

import java.util.Random;

public class RandomResidualEnergy {

    public static double getResidualEnergy() {
        Random random = new Random();
        return (double) (random.nextInt(10) + 1)/10;
    }
}
