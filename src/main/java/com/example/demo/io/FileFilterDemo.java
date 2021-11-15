package com.example.demo.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * @author robert
 * @date 2021/3/31
 */
public class FileFilterDemo {
    public static void main(String[] args) throws IOException {
        File dir = new File("demo");
        File[] files = dir.listFiles(new MyFilter());
        for (File file : files) {
            System.out.println(file.getCanonicalPath());
        }
    }

    static class MyFilter implements FileFilter {

        @Override
        public boolean accept(File pathname) {
            return pathname.getName().endsWith(".java") && pathname.isFile();
        }
    }
}
