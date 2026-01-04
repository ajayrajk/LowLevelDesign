package org.solid.principle.behavioral.chainofresponsibility.withchainor;

public class TechnicalSupport extends SupportHandler{
    @Override
    public void handleRequest(String type) {
        if (type.equals("technical")) {
            System.out.println("Technical Support handled the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(type);
        }
    }
}
