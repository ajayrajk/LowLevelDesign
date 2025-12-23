package org.solid.principle.creational.factory.withFactory;

import org.solid.principle.creational.factory.Database;
import org.solid.principle.creational.factory.MySQLDatabase;
import org.solid.principle.creational.factory.PostgresSQLDatabse;

public class DatabaseFactory {

      // but still open close principle violate
      public static Database getDataBaseFactory(String dbType){
             if (dbType.equalsIgnoreCase("mysql")){
                   return new MySQLDatabase();
             } else if (dbType.equalsIgnoreCase("psql")){
                   return new PostgresSQLDatabse();
             }else {
                   throw new IllegalArgumentException("unknown db type");
             }
      }
}
