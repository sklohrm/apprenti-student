package org.example;

public class Toaster implements Connectable{

    boolean state;

    public Toaster() {
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
        return "toast-time-gogo-toaster";
    }

    @Override
    public String toString() {
        return "Toaster";
    }
}
