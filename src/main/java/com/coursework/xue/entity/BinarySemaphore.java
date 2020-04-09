package com.coursework.xue.entity;

public class BinarySemaphore extends Semaphore {

    public BinarySemaphore() {
    }

    public BinarySemaphore(int initial) {
        super(initial);
    }

    @Override
    public synchronized void V() {
        value++;
        notifyAll();
    }
}
