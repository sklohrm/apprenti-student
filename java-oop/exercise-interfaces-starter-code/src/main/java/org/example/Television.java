package org.example;

public class Television implements Connectable{

    boolean state;

    public Television() {
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
        return "LG4500-5X55OLED-4K";
    }

    @Override
    public String toString() {
        return "Television";
    }
}
