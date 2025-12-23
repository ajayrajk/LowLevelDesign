package org.solid.principle.creational.factory;

public class PostgresSQLDatabse implements Database{
    @Override
    public void connect() {
      System.out.println("PostgresSQL database connected");
    }
}
