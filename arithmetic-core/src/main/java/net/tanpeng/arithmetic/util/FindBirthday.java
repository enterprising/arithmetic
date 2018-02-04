package net.tanpeng.arithmetic.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 在做表的时候，需要班上同学的生日，现在已经有身份证了。所以我决定从身份证中截取
 * Created by peng.tan on 17/10/8.
 */
public class FindBirthday {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./src/main/java/net/peng/arithmetic/util/a.txt");
        Files.readAllLines(path).forEach(e->{
            System.out.println(e.substring(6,14));
        });
    }
}
