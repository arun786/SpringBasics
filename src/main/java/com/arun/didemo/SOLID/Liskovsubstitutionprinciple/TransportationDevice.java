package com.arun.didemo.SOLID.Liskovsubstitutionprinciple;

import lombok.Getter;
import lombok.Setter;

/**
 * Liskov substitution principle when not applied properly
 */
@Getter
@Setter
public class TransportationDevice {
    private String name;
    private double speed;
    private Engine engine;

    public void startEngine() {
        System.out.println("Starting engine....");
    }

    public static void main(String[] args) {
        TransportationDevice car = new Car();
        car.startEngine();

        TransportationDevice bicyle = new Bicycle();
        bicyle.startEngine();
    }
}

class Car extends TransportationDevice {
    @Override
    public void startEngine() {
        System.out.println("Car engine starting...");
    }
}

/**
 * Violation of Liskov Substitution principle where we are overriding startEngine, when it method is not required at all
 */
class Bicycle extends TransportationDevice {
    @Override
    public void startEngine() {
        System.out.println("Do nothing");
    }
}




