package com.coursework.xue;

import com.coursework.xue.entity.BinarySemaphore;
import com.coursework.xue.thread.ThreadPrintW;
import com.coursework.xue.thread.ThreadPrintX;
import com.coursework.xue.thread.ThreadPrintY;
import com.coursework.xue.thread.ThreadPrintZ;

public class MainClass {
    public static void main(String[] args) {
        BinarySemaphore bw = new BinarySemaphore(1);
        BinarySemaphore bx = new BinarySemaphore(0);
        Thread tw = new Thread(new ThreadPrintW(bw, bx));
        Thread tx = new Thread(new ThreadPrintX(bx, bw));

        BinarySemaphore by = new BinarySemaphore(1);
        BinarySemaphore bz = new BinarySemaphore(0);
        Thread ty = new Thread(new ThreadPrintY(by, bz));
        Thread tz = new Thread(new ThreadPrintZ(bz, by));

        tw.start();
        tx.start();
        ty.start();
        tz.start();

        try {
            // 执行10秒(10 * 1000)后结束打印
            Thread.sleep(10000);
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
