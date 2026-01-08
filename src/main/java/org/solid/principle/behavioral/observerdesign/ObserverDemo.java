package org.solid.principle.behavioral.observerdesign;

public class ObserverDemo {
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
