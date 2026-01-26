package org.java8.features;

public class RunnableFeature {
    public static void main(String[] args) {

       // ❌ Before Java 8
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running");
            }
        };

        //Now
       /* 📌 Why

        Less boilerplate

        Enables functional programming*/
        Runnable r1 = () -> System.out.println("Running");
        r1.run();
    }
}
