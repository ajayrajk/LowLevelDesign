package org.designpattern.creational.singleton.withSingleton;

public class Logger {
     //volatile is use for visibility
     private static volatile Logger  logger;

     // Create a private constructor because from outside the class no once can create that object
     private Logger(){
     }

     // Double lock checking
     public static Logger getInstance(){
         if (logger==null)
             synchronized (Logger.class){
                if (logger==null){
                    logger=new Logger();
                }
             }
         return logger;
     }
}
