package org.concurrency.ch3;

public class NoVisibility {

    static boolean ready;
    static int number;

   static class Reader extends Thread{

        @Override
        public void run() {
             while (!ready){

             }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new Reader().start();
        ready=false;
        number=42;
    }
}
