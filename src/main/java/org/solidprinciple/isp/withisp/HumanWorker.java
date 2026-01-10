package org.solidprinciple.isp.withisp;

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
