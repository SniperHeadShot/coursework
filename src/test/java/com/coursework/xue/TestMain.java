package com.coursework.xue;

import com.coursework.xue.entity.BinarySemaphore;
import com.coursework.xue.thread.ThreadPrintW;
import com.coursework.xue.thread.ThreadPrintX;
import com.coursework.xue.thread.ThreadPrintY;
import com.coursework.xue.thread.ThreadPrintZ;
import org.junit.Test;


public class TestMain {

    @Test
    public void testPrint() throws InterruptedException {
        BinarySemaphore b = new BinarySemaphore();

        BinarySemaphore bw = new BinarySemaphore(1);
        BinarySemaphore bx = new BinarySemaphore();
        Thread tw = new Thread(new ThreadPrintW(bw, bx, b));
        Thread tx = new Thread(new ThreadPrintX(bx, bw));

        BinarySemaphore by = new BinarySemaphore(1);
        BinarySemaphore bz = new BinarySemaphore();
        Thread ty = new Thread(new ThreadPrintY(by, bz, b));
        Thread tz = new Thread(new ThreadPrintZ(bz, by, b));

        tw.start();
        tx.start();
        Thread.sleep(500);
        ty.start();
        tz.start();

        // 执行10秒(10 * 1000)后程序退出
        Thread.sleep(10000);
        System.exit(0);
    }
}
