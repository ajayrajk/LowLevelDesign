package org.solid.principle.behavioral.chainofresponsibility.withchainor;


public class FrontlineSupport extends SupportHandler {

    @Override
    public void handleRequest(String type) {
        if (type.equals("basic")){
            System.out.println("Frontline support is handling the ticket");
        }else {
            nextHandler.handleRequest(type);
        }

    }
}
