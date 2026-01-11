package org.solidprinciple.dip.withdip;

public class PostgresSQLConnection implements DBConnectionInterface{

    @Override
    public String connect() {
        return "Database connected";
    }

}
