package org.example;

public class Refrigerator implements Connectable{

    boolean state;

    public Refrigerator() {
        this.state = false;
    }

    @Override
    public void turnOn() {
        this.state = true;
    }

    @Override
    public void turnOff() {
        this.state = false;
    }

    @Override
    public boolean getState() {
        return this.state;
    }

    @Override
    public String getName() {
        return "HONEYWELL COOL FRIDGE";
    }

    @Override
    public String toString() {
        return "Refrigerator";
    }
}
