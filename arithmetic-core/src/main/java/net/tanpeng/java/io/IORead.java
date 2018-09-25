package net.tanpeng.java.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by peng.tan on 2018/9/25.
 */
public class IORead {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/enterprising/Git/IdeaProjects/arithmetic/arithmetic-core/src/main/java/net/tanpeng/java/io/machines.cfg");
        for (String x : Files.readAllLines(path)) {
            // 匹配空格
            String[] list = x.split("\\s+");
            System.out.println(String.format("INSERT INTO host_ip (host,ip) VALUES ('%s','%s');\n", list[0], list[2]));
        }
    }
}
