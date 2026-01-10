package org.designpattern.behavioral.chainofresponsibility.withchainor;

public class ChainOfResponsibilityDemo {
    public static void
    main(String[] args) {
        // Build the chain
        SupportHandler frontline = new FrontlineSupport();
        SupportHandler technical = new TechnicalSupport();
        SupportHandler manager = new ManagerSupport();

        frontline.setNextHandler(technical);
        technical.setNextHandler(manager);
       // Test
         frontline.handleRequest("basic");
         frontline.handleRequest("technical");
        frontline.handleRequest("manager");
        frontline.handleRequest("unknown");
    }
}
