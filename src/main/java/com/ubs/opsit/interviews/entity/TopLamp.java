package com.ubs.opsit.interviews.entity;

import org.joda.time.LocalTime;

public class TopLamp extends Lamp {

    public static final int BLINKS_AT_IN_SECONDS = 2;

    public static TopLamp topLamp() {
        return new TopLamp(YELLOW);
    }

    public TopLamp(String colour) {
        super(colour);
    }

    @Override
    public void updateOnOff(LocalTime localTime) {
        this.setOn(localTime.getSecondOfMinute() % BLINKS_AT_IN_SECONDS == 0);
    }
}
