package com.ubs.opsit.interviews.entity;

import org.joda.time.LocalTime;

public class MinuteLampInSecondRow extends Lamp {

    public static final int MINUTES_IN_SECOND_ROW = 1;

    private int index;

    public static MinuteLampInSecondRow minuteLampInSecondRow(int index) {
        return new MinuteLampInSecondRow(YELLOW, index);
    }

    public MinuteLampInSecondRow(String colour, int index) {
        super(colour);
        this.index = index;
    }

    @Override
    public void updateOnOff(LocalTime localTime) {
        this.setOn(localTime.getMinuteOfHour() % MinuteLampInFirstRow.MINUTES_IN_FIRST_ROW >= (this.index + 1) * MINUTES_IN_SECOND_ROW);
    }
}
