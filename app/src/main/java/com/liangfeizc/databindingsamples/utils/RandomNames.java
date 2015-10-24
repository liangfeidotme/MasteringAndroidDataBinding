package com.liangfeizc.databindingsamples.utils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by liangfeizc on 10/24/15.
 */
public class RandomNames {
    public static final String[] FIRST_NAMES = {"Zhao", "Qian", "Sun", "Li", "Zhou", "Wu"};
    public static final String[] LAST_NAMES = {"Tiedan", "Ritian", "LiangChen"};

    private static final Random sRandomGenerator = new Random();

    public static String nextFirstName() {
        return FIRST_NAMES[sRandomGenerator.nextInt(FIRST_NAMES.length)];
    }

    public static String nextLastName() {
        return LAST_NAMES[sRandomGenerator.nextInt(LAST_NAMES.length)];
    }
}
