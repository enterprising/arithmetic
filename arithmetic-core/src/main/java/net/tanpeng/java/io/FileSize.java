package net.tanpeng.java.io;

import java.io.File;

/**
 * 文件大小
 * Created by peng.tan on 2018/10/2.
 */
public class FileSize {
    public static long getFileSize(String filename) {
        File file = new File(filename);
        if (!file.exists() || !file.isFile()) {
            System.out.println("文件不存在");
            return -1;
        }
        return file.length();
    }

    public static void main(String[] args) {
        long size = getFileSize("./arithmetic-core/src/main/java/net/tanpeng/java/io/machines.cfg");
        System.out.println("文件大小为: " + size);
    }
}
