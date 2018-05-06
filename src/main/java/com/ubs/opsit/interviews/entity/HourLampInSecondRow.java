package com.ubs.opsit.interviews.entity;

import org.joda.time.LocalTime;

public class HourLampInSecondRow extends Lamp {

    public static final int HOURS_IN_SECOND_ROW = 1;

    private int index;

    public static HourLampInSecondRow HourLampInSecondRow(int index) {
        return new HourLampInSecondRow(RED, index);
    }

    public HourLampInSecondRow(String colour, int index) {
        super(colour);
        this.index = index;
    }

    @Override
    public void updateOnOff(LocalTime localTime) {
        this.setOn(localTime.getHourOfDay() % HourLampInFirstRow.HOURS_IN_FIRST_ROW >= (this.index + 1) * HOURS_IN_SECOND_ROW);
    }
}
