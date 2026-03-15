package org.concurrency.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Running");
    }

    public static void main(String[] args) {
        MyThread th=new MyThread();
        th.start();

        AtomicInteger atomicInteger=new AtomicInteger();
        atomicInteger.addAndGet(10);
        System.out.println(atomicInteger);
        atomicInteger.getAndAdd(10);
        System.out.println(atomicInteger);

    }

    private void request1K(){
        Semaphore semaphore = new Semaphore(1000); // 1000 permits per second
        if (semaphore.tryAcquire()) {
            // process request
            semaphore.release();
        } else {
            // reject or queue request
        }

    }

    private void rateLimiter(){
//        RateLimiter limiter = RateLimiter.create(1000.0); // 1000 permits per second
//        limiter.acquire(); // blocks until a permit is available

    }

    private void locking(){
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
           // work();  //it can we any API or any worker
        } finally {
            lock.unlock();
        }
    }
}
