package com.ubs.opsit.interviews;

import org.joda.time.Duration;
import org.joda.time.LocalTime;

import java.util.Arrays;

public class BerlinClock {

    public static final int HOURS_IN_FIRST_ROW = 5;
    public static final int HOURS_IN_SECOND_ROW = 1;
    public static final int MINUTES_IN_FIRST_ROW = 5;
    public static final int MINUTES_IN_SECOND_ROW = 1;

    public static final String YELLOW = "Y";
    public static final String RED = "R";

    private Lamp topLamp;
    private Lamp[] hourLampsInFirstRow = new Lamp[4];
    private Lamp[] hourLampsInSecondRow = new Lamp[4];
    private Lamp[] minuteLampsInFirstRow = new Lamp[11];
    private Lamp[] minuteLampsInSecondRow = new Lamp[4];

    public BerlinClock(LocalTime localTime) {

        this.topLamp = createTopLamp();
        this.topLamp.setOn(localTime.getSecondOfMinute() % this.topLamp.getBlinksAtInSeconds() == 0);

        for (int i = 0; i < hourLampsInFirstRow.length; i++) {
            hourLampsInFirstRow[i] = createHourLampInFirstRow();
            hourLampsInFirstRow[i].setOn(localTime.getHourOfDay() >= (i + 1) * hourLampsInFirstRow[i].getRepresentsDuration().getStandardHours());
        }

        for (int i = 0; i < hourLampsInSecondRow.length; i++) {
            hourLampsInSecondRow[i] = createHourLampInSecondRow();
            hourLampsInSecondRow[i].setOn((localTime.getHourOfDay() % HOURS_IN_FIRST_ROW) >= (i + 1) * hourLampsInSecondRow[i].getRepresentsDuration().getStandardHours());
        }

        for (int i = 0; i < minuteLampsInFirstRow.length; i++) {
            String color = YELLOW;
            if ((i + 1) % 3 == 0) {
                color = RED;
            }
            minuteLampsInFirstRow[i] = createMinuteLampInFirstRow(color);
            minuteLampsInFirstRow[i].setOn(localTime.getMinuteOfHour() >= (i + 1) * minuteLampsInFirstRow[i].getRepresentsDuration().getStandardMinutes());
        }

        for (int i = 0; i < minuteLampsInSecondRow.length; i++) {
            minuteLampsInSecondRow[i] = createMinuteLampInSecondRow();
            minuteLampsInSecondRow[i].setOn((localTime.getMinuteOfHour() % MINUTES_IN_FIRST_ROW) >= (i + 1) * minuteLampsInSecondRow[i].getRepresentsDuration().getStandardMinutes());
        }
    }

    private Lamp createMinuteLampInFirstRow(String color) {
        return createMinuteLamp(color, Duration.standardMinutes(MINUTES_IN_FIRST_ROW));
    }

    private Lamp createMinuteLampInSecondRow() {
        return createMinuteLamp(YELLOW, Duration.standardMinutes(MINUTES_IN_SECOND_ROW));
    }

    private Lamp createMinuteLamp(String color, Duration representsDuration) {
        return createLamp(color, -1, representsDuration);
    }

    private Lamp createHourLampInFirstRow() {
        return createHourLamp(Duration.standardHours(HOURS_IN_FIRST_ROW));
    }

    private Lamp createHourLampInSecondRow() {
        return createHourLamp(Duration.standardHours(HOURS_IN_SECOND_ROW));
    }

    private Lamp createHourLamp(Duration representsDuration) {
        return createLamp(RED, -1, representsDuration);
    }

    private Lamp createTopLamp() {
        return createLamp(YELLOW, 2, null);
    }

    private Lamp createLamp(String color, int blinksAtInSeconds, Duration representsDuration) {
        return new Lamp(color, blinksAtInSeconds, representsDuration);
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
