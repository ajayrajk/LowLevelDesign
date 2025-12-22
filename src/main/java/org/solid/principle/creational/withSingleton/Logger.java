package org.solid.principle.creational.withSingleton;

public class Logger {
     private static Logger  logger;

     // Create a private constructor because from outside the class no once can create that object
     private Logger(){

     }

     public static Logger getInstance(){
         if (logger==null)
             logger=new Logger();

         return logger;
     }
}
