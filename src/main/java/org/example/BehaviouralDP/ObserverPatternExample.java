package org.example.BehaviouralDP;

import java.util.ArrayList;
import java.util.List;

// Subject interface
interface WeatherStation {
    void addObserver(Device observer);
    void removeObserver(Device observer);
    void notifyObservers();
}

// Concrete Subject
class WeatherStationImpl implements WeatherStation {
    private List<Device> observers = new ArrayList<>();
    private String weatherData;

    public void setWeatherData(String weatherData) {
        this.weatherData = weatherData;
        notifyObservers();
    }

    @Override
    public void addObserver(Device observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Device observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Device observer : observers) {
            observer.update(weatherData);
        }
    }
}

// Observer interface
interface Device {
    void update(String weatherData);
}

// Concrete Observers
class Phone implements Device {
    @Override
    public void update(String weatherData) {
        System.out.println("Phone: Weather updated to " + weatherData);
    }
}

class Computer implements Device {
    @Override
    public void update(String weatherData) {
        System.out.println("Computer: Weather updated to " + weatherData);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        WeatherStationImpl station = new WeatherStationImpl();

        Phone phone = new Phone();
        Computer computer = new Computer();

        station.addObserver(phone);
        station.addObserver(computer);

        station.setWeatherData("Sunny");
        station.setWeatherData("Rainy");
    }
}
