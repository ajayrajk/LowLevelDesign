package org.solid.principle.creational.factory;

public class Main {
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
