package org.solid.principle.isp.withisp;

public class HumanWorker implements Workable,Eatable{


    @Override
    public void eat() {
        System.out.println("Human is eating");
    }

    @Override
    public void work() {
        System.out.println("Human is working");
    }
}
