package com.coursework.xue.thread;

import com.coursework.xue.entity.BinarySemaphore;

public class ThreadPrintX implements Runnable {

    private volatile BinarySemaphore currentSemaphore;

    private volatile BinarySemaphore nextSemaphore;

    public ThreadPrintX(BinarySemaphore currentSemaphore, BinarySemaphore nextSemaphore) {
        this.currentSemaphore = currentSemaphore;
        this.nextSemaphore = nextSemaphore;
    }

    public void run() {
        while (true) {
            try {
                currentSemaphore.P();
                System.out.print("X");
                Thread.sleep(Math.round(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                nextSemaphore.V();
            }
        }
    }
}
