package com.example.demo.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * @author robert
 * @date 2021/3/31
 */
public class RandomAccessFileTest {
    public static void read() {
        try {
            RandomAccessFile rf = new RandomAccessFile("a.txt", "rw");
            System.out.println(rf.getFilePointer());
            rf.write('A');
            System.out.println(rf.getFilePointer());
            rf.write('B');
            String s = "中";
            byte[] gbk = s.getBytes("gbk");
            rf.write(gbk);
            System.out.println(rf.getFilePointer());
            rf.seek(0);
            byte[] buf = new byte[(int) rf.length()];
            rf.read(buf);
            System.out.println(Arrays.toString(buf));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        read();
    }
}
