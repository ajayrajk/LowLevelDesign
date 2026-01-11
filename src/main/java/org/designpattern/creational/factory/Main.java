package org.designpattern.creational.factory;

public class Main {

    /*The Factory pattern provides an interface for creating objects without specifying the
    exact class of the object that will be created. It encapsulates the object creation logic,
    allowing the client to create objects of different types without being aware of their
    specific implementations. This promotes loose coupling and enhances flexibility.*/
    public static void main(String[] args) {
        String dbType="mysql";
        Database db;
        if (dbType.equals("mysql")){
            db=new MySQLDatabase();
        } else if (dbType.equals("psql")){
            db=new PostgresSQLDatabse();
        }else {
            throw  new IllegalArgumentException("Unknown db type");
        }
    }
}
