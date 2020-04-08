package com.coursework.xue.thread;

import com.coursework.xue.entity.BinarySemaphore;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPrintY implements Runnable {

    private volatile BinarySemaphore currentSemaphore;

    private volatile BinarySemaphore nextSemaphore;

    public static final AtomicInteger COUNTER = new AtomicInteger();

    public ThreadPrintY(BinarySemaphore currentSemaphore, BinarySemaphore nextSemaphore) {
        this.currentSemaphore = currentSemaphore;
        this.nextSemaphore = nextSemaphore;
    }

    public void run() {
        while (true) {
            if (ThreadPrintW.COUNTER.get() > ThreadPrintY.COUNTER.get() + ThreadPrintZ.COUNTER.get()) {
                try {
                    currentSemaphore.P();
                    System.out.print("y");
                    Thread.sleep(Math.round(Math.random() * 1000));
                    COUNTER.incrementAndGet();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    nextSemaphore.V();
                }
            }
        }
    }
}
