package org.designpattern.behavioral.observerdesign;

public class ObserverDemo {

    /*
    * When something gets changes , everyone interested gets notified - just like YouTube subscribers
    * or weather updates.
    * */

    /*
    ❓ Interview Question
      “Design a notification system (Email, SMS, Push)”
      💡 Problem
      When one event happens → notify multiple listeners
    * */

    /*
    * 🧠 Real Use
      Kafka consumers
      Event-driven systems
      UI updates
    * */


    public static void main(String[] args) {
        WeatherStation weatherStation=new WeatherStation();
        Observer mobile=new MobileDisplay();
        Observer led=new LedDisplay();

        weatherStation.addObserver(mobile);
        weatherStation.addObserver(led);

        weatherStation.setTemperature(25);
        weatherStation.setTemperature(40);

    }
}
