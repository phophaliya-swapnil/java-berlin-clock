package com.ubs.opsit.interviews.entity;

import org.joda.time.LocalTime;

public abstract class Lamp {

    public static final String YELLOW = "Y";
    public static final String RED = "R";

    private String colour;
    private boolean on;

    public Lamp(String colour) {
        this.colour = colour;
    }

    public abstract void updateOnOff(LocalTime localTime);

    public void setOn(boolean on) {
        this.on = on;
    }

    public String getColour() {
        return colour;
    }

    public boolean isOn() {
        return on;
    }

    @Override
    public String toString() {
        return isOn() ? colour : "O";
    }
}
