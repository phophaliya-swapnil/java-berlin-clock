package com.ubs.opsit.interviews;

import org.joda.time.Duration;

public class Lamp {

    private String colour;
    private int blinksAtInSeconds;
    private Duration representsDuration;
    private boolean on;

    public Lamp(String colour, int blinksAtInSeconds, Duration representsDuration) {
        this.colour = colour;
        this.blinksAtInSeconds = blinksAtInSeconds;
        this.representsDuration = representsDuration;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public String getColour() {
        return colour;
    }

    public int getBlinksAtInSeconds() {
        return blinksAtInSeconds;
    }

    public Duration getRepresentsDuration() {
        return representsDuration;
    }

    public boolean isOn() {
        return on;
    }

    @Override
    public String toString() {
        return isOn() ? colour : "O";
    }
}
