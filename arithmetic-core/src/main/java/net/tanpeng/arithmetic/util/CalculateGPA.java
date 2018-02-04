package net.tanpeng.arithmetic.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by peng.tan on 18/1/13.
 */
public class CalculateGPA {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/enterprising/Desktop/test.txt");

        double fenzi = 0;

        double zongxuefen = 0;

        double avg = 0;

        int count = 0;

        for (String x : Files.readAllLines(path)) {
            String[] list = x.split("\t");

//            if (list[4].equals("选修课")) {
//                continue;
//            }

            fenzi += Double.parseDouble(list[6]) * Double.parseDouble(list[7]);

            zongxuefen += Double.parseDouble(list[6]);


            if (list[8].equals("优秀"))
                list[8] = String.valueOf(95);
            else if (list[8].equals("良好"))
                list[8] = String.valueOf(85);
            else if (list[8].equals("中等"))
                list[8] = String.valueOf(75);
            avg += Double.parseDouble(list[8]);
            count++;

            System.out.println(x);
        }

        System.out.println(fenzi);
        System.out.println(zongxuefen);
        System.out.println(fenzi / zongxuefen);

        System.out.println(count);

        System.out.println(avg / count);
    }


}
