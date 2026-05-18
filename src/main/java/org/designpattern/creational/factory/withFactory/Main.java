package org.designpattern.creational.factory.withFactory;

import org.designpattern.creational.factory.Database;

public class Main {
    public static void main(String[] args) {
        // Open close still need to follow.
        Database db1=DatabaseFactory.getDataBaseFactory("msql");
        Database db2=DatabaseFactory.getDataBaseFactory("psql");

        // More optimized version with follow rhe open close principle as well.
        Database db3=DatabaseFactoryOptimize.getDatabaseInstance("msql");
        Database db4=DatabaseFactoryOptimize.getDatabaseInstance("psql");
    }
}
