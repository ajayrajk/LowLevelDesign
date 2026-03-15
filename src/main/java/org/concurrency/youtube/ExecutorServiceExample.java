package org.concurrency.youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    public static void main(String[] args) {

        ExecutorService executorService=Executors.newSingleThreadExecutor();
        //ExecutorService executorService= Executors.newFixedThreadPool(10);

        executorService.execute(newRunnable("Thread 1"));
        executorService.execute(newRunnable("Thread 2"));
        executorService.execute(newRunnable("Thread 3"));

        executorService.execute(newRunnable("Thread 4"));
        executorService.execute(newRunnable("Thread 5"));
        executorService.execute(newRunnable("Thread 6"));

        executorService.execute(newRunnable("Thread 7"));
        executorService.execute(newRunnable("Thread 8"));
        executorService.execute(newRunnable("Thread 9"));

        executorService.execute(newRunnable("Thread 10"));
        executorService.execute(newRunnable("Thread 11"));
        executorService.execute(newRunnable("Thread 12"));

        executorService.shutdown();


    }

    private static Runnable newRunnable(String msg){
       return new Runnable(){
           @Override
           public void run() {
               String completeMsg=Thread.currentThread().getName()+": "+msg;
               System.out.println(completeMsg);
           }
       };
    }
}
