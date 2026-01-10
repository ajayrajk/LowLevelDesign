package org.designpattern.creational.factory;

public class MySQLDatabase implements Database{

    @Override
    public void connect() {
        System.out.println("Connect to mysql DB");
    }
}
