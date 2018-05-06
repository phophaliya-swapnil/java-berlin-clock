package com.ubs.opsit.interviews.entity;

import org.joda.time.LocalTime;

public class HourLampInFirstRow extends Lamp {

    public static final int HOURS_IN_FIRST_ROW = 5;

    private int index;

    public static HourLampInFirstRow hourLampInFirstRow(int index) {
        return new HourLampInFirstRow(RED, index);
    }

    public HourLampInFirstRow(String colour, int index) {
        super(colour);
        this.index = index;
    }

    @Override
    public void updateOnOff(LocalTime localTime) {
        this.setOn(localTime.getHourOfDay() >= (this.index + 1) * HOURS_IN_FIRST_ROW);
    }
}
