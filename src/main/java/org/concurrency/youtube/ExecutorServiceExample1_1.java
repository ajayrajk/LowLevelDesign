package org.concurrency.youtube;

import java.util.concurrent.*;

public class ExecutorServiceExample1_1 {

    public static void main(String[] args) {
        int corePoolSize=10;
        int maxPoolSize=20;
        long keepALiveTime=3000;
        ExecutorService threadPoolExecutor=new ThreadPoolExecutor(corePoolSize,maxPoolSize,
                keepALiveTime, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(128));

        threadPoolExecutor=(ThreadPoolExecutor) Executors.newFixedThreadPool(3);

       //ExecutorService scheduledExecutorService=

    }
}
