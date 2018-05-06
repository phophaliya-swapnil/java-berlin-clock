package com.ubs.opsit.interviews;


import org.joda.time.LocalTime;

public class BerlinClockTimeConverter implements TimeConverter {

    @Override
    public String convertTime(String aTime) {

        LocalTime localTime = LocalTime.parse(aTime);
        BerlinClock berlinClock = new BerlinClock(localTime);
        return berlinClock.toString();
    }
}
