package org.solid.principle.creational.singleton;

import org.solid.principle.creational.singleton.Logger;

public class LoggerMain {
    Logger logger1=new Logger();
    logger1.setUrl("https://collectlogs");
    logger1.log("First Messages");

     Logger logger2=new Logger();
     logger2.log("Second Messages");
}
