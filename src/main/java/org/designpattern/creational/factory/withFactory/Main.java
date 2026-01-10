package org.designpattern.creational.factory.withFactory;

import org.designpattern.creational.factory.Database;

public class Main {
    public static void main(String[] args) {
        Database db1=DatabaseFactory.getDataBaseFactory("msql");
        Database db2=DatabaseFactory.getDataBaseFactory("psql");

        Database db3=DatabaseFactoryOptimize.getDatabaseInstance("msql");
        Database db4=DatabaseFactoryOptimize.getDatabaseInstance("psql");
    }
}
