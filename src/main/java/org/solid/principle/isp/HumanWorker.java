package org.solid.principle.isp;

public class HumanWorker implements Worker{


    @Override
    public void work() {
        System.out.println("Human is working");
    }

    @Override
    public void eat() {
          System.out.println("Human is eating");
    }
}
