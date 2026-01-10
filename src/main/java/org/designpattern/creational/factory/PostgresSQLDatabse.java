package org.designpattern.creational.factory;

public class PostgresSQLDatabse implements Database{
    @Override
    public void connect() {
      System.out.println("PostgresSQL database connected");
    }
}
