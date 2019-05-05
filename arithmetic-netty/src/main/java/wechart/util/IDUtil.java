package wechart.util;

import java.util.UUID;

/**
 * Created by peng.tan on 2019/5/5.
 */
public class IDUtil {
    public static String randomId() {
        return UUID.randomUUID().toString().split("-")[0];
    }
}
