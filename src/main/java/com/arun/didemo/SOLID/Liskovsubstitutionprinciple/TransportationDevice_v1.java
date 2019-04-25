package com.arun.didemo.SOLID.Liskovsubstitutionprinciple;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransportationDevice_v1 {
    private String name;
    private double speed;

    public static void main(String[] args) {

        DeviceWithEngine hondaCar = new HondaCar("HondaCar");
        hondaCar.startEngine();

        DeviceWithoutEngine triCycle = new Tricycle("TriCycle");
        triCycle.startMoving();
    }
}

class DeviceWithoutEngine extends TransportationDevice_v1 {
    public void startMoving() {
        System.out.println(this.getName() + " Start Moving");
    }
}

@Getter
@Setter
class DeviceWithEngine extends TransportationDevice_v1 {
    private Engine engine;

    public void startEngine() {
        System.out.println(this.getName() + " Start Engine..");
    }
}

class HondaCar extends DeviceWithEngine {

    public HondaCar(String name) {
        this.setName(name);
    }
}

class Tricycle extends DeviceWithoutEngine {

    public Tricycle(String name) {
        this.setName(name);
    }
}