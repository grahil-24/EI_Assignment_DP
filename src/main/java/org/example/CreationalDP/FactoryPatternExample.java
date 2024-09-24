package org.example.CreationalDP;

// Product interface
interface Vehicle {
    void drive();
}

// Concrete Products
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car.");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike.");
    }
}

// Factory
class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if (type.equalsIgnoreCase("car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("bike")) {
            return new Bike();
        }
        return null;
    }
}

// Main class to test the pattern
public class FactoryPatternExample {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getVehicle("car");
        car.drive();

        Vehicle bike = VehicleFactory.getVehicle("bike");
        bike.drive();
    }
}
