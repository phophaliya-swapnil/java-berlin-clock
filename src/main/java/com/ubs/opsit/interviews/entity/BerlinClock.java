package com.ubs.opsit.interviews.entity;

import org.joda.time.LocalTime;

import java.util.Arrays;

public class BerlinClock {

    private TopLamp topLamp;
    private HourLampInFirstRow[] hourLampsInFirstRow = new HourLampInFirstRow[4];
    private HourLampInSecondRow[] hourLampsInSecondRow = new HourLampInSecondRow[4];
    private MinuteLampInFirstRow[] minuteLampsInFirstRow = new MinuteLampInFirstRow[11];
    private MinuteLampInSecondRow[] minuteLampsInSecondRow = new MinuteLampInSecondRow[4];

    public BerlinClock() {
    }

    public BerlinClock(LocalTime localTime) {

        this.topLamp = TopLamp.topLamp();
        this.topLamp.updateOnOff(localTime);

        for (int i = 0; i < hourLampsInFirstRow.length; i++) {
            hourLampsInFirstRow[i] = HourLampInFirstRow.hourLampInFirstRow(i);
            hourLampsInFirstRow[i].updateOnOff(localTime);
        }

        for (int i = 0; i < hourLampsInSecondRow.length; i++) {
            hourLampsInSecondRow[i] = HourLampInSecondRow.HourLampInSecondRow(i);
            hourLampsInSecondRow[i].updateOnOff(localTime);
        }

        for (int i = 0; i < minuteLampsInFirstRow.length; i++) {
            minuteLampsInFirstRow[i] = MinuteLampInFirstRow.minuteLampInFirstRow(i);
            minuteLampsInFirstRow[i].updateOnOff(localTime);
        }

        for (int i = 0; i < minuteLampsInSecondRow.length; i++) {
            minuteLampsInSecondRow[i] = MinuteLampInSecondRow.minuteLampInSecondRow(i);
            minuteLampsInSecondRow[i].updateOnOff(localTime);
        }
    }

    public static BerlinClock Midnight24BerlinClock() {
        BerlinClock midnightBerlinClock = new BerlinClock();

        midnightBerlinClock.topLamp = TopLamp.topLamp();
        midnightBerlinClock.topLamp.setOn(true);

        for (int i = 0; i < midnightBerlinClock.hourLampsInFirstRow.length; i++) {
            midnightBerlinClock.hourLampsInFirstRow[i] = HourLampInFirstRow.hourLampInFirstRow(i);
            midnightBerlinClock.hourLampsInFirstRow[i].setOn(true);
        }

        for (int i = 0; i < midnightBerlinClock.hourLampsInSecondRow.length; i++) {
            midnightBerlinClock.hourLampsInSecondRow[i] = HourLampInSecondRow.HourLampInSecondRow(i);
            midnightBerlinClock.hourLampsInSecondRow[i].setOn(true);
        }

        for (int i = 0; i < midnightBerlinClock.minuteLampsInFirstRow.length; i++) {
            midnightBerlinClock.minuteLampsInFirstRow[i] = MinuteLampInFirstRow.minuteLampInFirstRow(i);
            midnightBerlinClock.minuteLampsInFirstRow[i].setOn(false);
        }

        for (int i = 0; i < midnightBerlinClock.minuteLampsInSecondRow.length; i++) {
            midnightBerlinClock.minuteLampsInSecondRow[i] = MinuteLampInSecondRow.minuteLampInSecondRow(i);
            midnightBerlinClock.minuteLampsInSecondRow[i].setOn(false);
        }

        return midnightBerlinClock;
    }

    @Override
    public String toString() {

        StringBuilder berlinClockStringBuilder = new StringBuilder(topLamp.toString());
        berlinClockStringBuilder.append("\n");
        berlinClockStringBuilder.append(Arrays.toString(hourLampsInFirstRow)).append("\n");
        berlinClockStringBuilder.append(Arrays.toString(hourLampsInSecondRow)).append("\n");
        berlinClockStringBuilder.append(Arrays.toString(minuteLampsInFirstRow)).append("\n");
        berlinClockStringBuilder.append(Arrays.toString(minuteLampsInSecondRow));
        return berlinClockStringBuilder.toString().replaceAll(", ", "").replaceAll("\\[", "").replaceAll("]", "");
    }
}
