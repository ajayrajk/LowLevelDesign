package org.solidprinciple.dip.withdip;

public class MySQLConnection implements DBConnectionInterface{

    @Override
    public String connect() {
        return "Database connected";
    }

}
