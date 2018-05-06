package com.ubs.opsit.interviews.entity;

import org.joda.time.LocalTime;

public class MinuteLampInFirstRow extends Lamp {

    public static final int MINUTES_IN_FIRST_ROW = 5;

    private int index;

    public static MinuteLampInFirstRow minuteLampInFirstRow(int index) {
        String color = Lamp.YELLOW;
        if ((index + 1) % 3 == 0) {
            color = Lamp.RED;
        }
        return new MinuteLampInFirstRow(color, index);
    }

    public MinuteLampInFirstRow(String colour, int index) {
        super(colour);
        this.index = index;
    }

    @Override
    public void updateOnOff(LocalTime localTime) {
        this.setOn(localTime.getMinuteOfHour() >= (this.index + 1) * MINUTES_IN_FIRST_ROW);
    }
}
