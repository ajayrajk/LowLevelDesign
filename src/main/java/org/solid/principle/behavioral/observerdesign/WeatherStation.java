package org.solid.principle.behavioral.observerdesign;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{

    private List<Observer> observers=new ArrayList<>();
    private int temperature;

    public void setTemperature(int temperature){
        this.temperature=temperature;
        notifyObserver();
    }
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
       for (Observer observer:observers){
           observer.update(temperature);
       }
    }
}
