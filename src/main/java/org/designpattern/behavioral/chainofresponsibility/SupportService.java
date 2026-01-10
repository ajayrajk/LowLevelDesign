package org.designpattern.behavioral.chainofresponsibility;

public class SupportService {

    void handleRequest(String type){
        if (type.equals("basic")){
            System.out.println("Handled by frontline support");
        }else if (type.equals("technical")){
            System.out.println("Technical support will handle this");
        }else if (type.equals("manager")){
            System.out.println("Manager support will handle this");
        }else {
            System.out.println("Invalid request");
        }
    }
}
