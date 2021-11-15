package com.example.demo.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author robert
 * @date 2021/3/31
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
        File file = new File(".");
        System.out.println(file.getCanonicalPath());
        File dir = new File(file, "demo");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File test = new File(dir, "test.txt");
        if (!test.exists()) {
            test.createNewFile();
        }
        File[] files = dir.listFiles();
        System.out.println(Arrays.toString(files));
        System.out.println(test.getCanonicalPath());
    }
}
