package com.coursework.xue.thread;

import com.coursework.xue.entity.BinarySemaphore;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPrintZ implements Runnable {

    private volatile BinarySemaphore currentSemaphore;

    private volatile BinarySemaphore nextSemaphore;

    private volatile BinarySemaphore semaphore;

    public static final AtomicInteger COUNTER = new AtomicInteger();

    public ThreadPrintZ(BinarySemaphore currentSemaphore, BinarySemaphore nextSemaphore, BinarySemaphore semaphore) {
        this.currentSemaphore = currentSemaphore;
        this.nextSemaphore = nextSemaphore;
        this.semaphore = semaphore;
    }

    public void run() {
        while (true) {
            if (ThreadPrintW.COUNTER.get() > ThreadPrintY.COUNTER.get() + ThreadPrintZ.COUNTER.get()) {
                try {
                    semaphore.P();
                    currentSemaphore.P();
                    System.out.print("z");
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
