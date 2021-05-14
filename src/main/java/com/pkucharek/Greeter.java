package com.pkucharek;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;

public class Greeter {

    private final TimeProvider timeProvider;

    public Greeter() {
        timeProvider = LocalTime::now;
    }

    public Greeter(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public String greet(String name) {
        String beginning = getGreetingBeginning();
        String correctedName = getCorrectedName(name);

        return String.format("%s %s", beginning, correctedName);
    }

    private String getGreetingBeginning() {
        if (isMorning())
            return "Good morning";
        if (isEvening())
            return "Good evening";
        return "Hello";
    }

    private boolean isMorning() {
        LocalTime actualTime = timeProvider.provide();
        return actualTime.isAfter(LocalTime.parse("05:59:59"))
                && actualTime.isBefore(LocalTime.parse("12:00:01"));
    }

    private boolean isEvening() {
        LocalTime actualTime = timeProvider.provide();
        return actualTime.isAfter(LocalTime.parse("17:59:59"))
                && actualTime.isBefore(LocalTime.parse("22:00:01"));
    }

    private String getCorrectedName(String name) {
        String trimmedName = name.trim();
        return StringUtils.capitalize(trimmedName);
    }

}
