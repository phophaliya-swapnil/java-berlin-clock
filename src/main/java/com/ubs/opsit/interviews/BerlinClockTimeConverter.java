package com.ubs.opsit.interviews;


import com.ubs.opsit.interviews.entity.BerlinClock;
import org.joda.time.LocalTime;

public class BerlinClockTimeConverter implements TimeConverter {

    @Override
    public String convertTime(String aTime) {

        if (aTime.equalsIgnoreCase("24:00:00")) {
            return BerlinClock.Midnight24BerlinClock().toString();
        }

        LocalTime localTime = LocalTime.parse(aTime);
        BerlinClock berlinClock = new BerlinClock(localTime);
        return berlinClock.toString();
    }
}
