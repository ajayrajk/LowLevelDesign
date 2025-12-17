package org.solid.principle.isp.withisp;


public class RobotWorker implements Workable,Chargable {


    @Override
    public void charge() {
    System.out.println("Robot is charging");
    }

    @Override
    public void work() {
        System.out.println("Robot is working");
    }
}
