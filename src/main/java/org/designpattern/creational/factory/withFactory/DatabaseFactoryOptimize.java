package org.designpattern.creational.factory.withFactory;

import org.designpattern.creational.factory.Database;
import org.designpattern.creational.factory.MySQLDatabase;
import org.designpattern.creational.factory.PostgresSQLDatabse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DatabaseFactoryOptimize {

    private static final Map<String, Supplier<Database>> registry=new HashMap<>();

    static {
        registry.put("mysql", MySQLDatabase::new);
        registry.put("psql", PostgresSQLDatabse::new);
    }

    public static void registerDatabase(String name, Supplier<Database> supplier){
        registry.put(name.toLowerCase(),supplier);
    }

    public static Database getDatabaseInstance(String dbType){
        Supplier<Database> supplier=registry.get(dbType.toLowerCase());

        if (supplier!=null)
            return supplier.get();

        else throw new IllegalArgumentException("unknown db type");
    }

}
