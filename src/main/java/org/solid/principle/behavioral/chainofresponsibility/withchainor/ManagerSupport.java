package org.solid.principle.behavioral.chainofresponsibility.withchainor;

public class ManagerSupport extends SupportHandler{

    @Override
    public void handleRequest(String type) {
        if (type.equals("manager")) {
            System.out.println("Manager handled the request.");
        } else {
            System.out.println("No one could handle this request.");
        }
    }
}
