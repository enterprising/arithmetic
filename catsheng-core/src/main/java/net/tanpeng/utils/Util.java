package net.tanpeng.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

/**
 * Created by peng.tan on 2019/5/8.
 */
public class Util {
    public static void main(String[] args) {
        System.out.println(Arrays.asList("dalGroup", "ezone"));

        LocalDateTime end = LocalDateTime.of(2019, 5, 8,11,20);
        System.out.println(end.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(1557307518853L-end.toInstant(ZoneOffset.of("+8")).toEpochMilli());
    }
}