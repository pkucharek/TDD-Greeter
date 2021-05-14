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
        String trimmed = name.trim();
        String capitalized = StringUtils.capitalize(trimmed);

        String greeting;

        LocalTime actualTime = timeProvider.provide();
        if (actualTime.isAfter(LocalTime.of(5, 59, 59))
                && actualTime.isBefore(LocalTime.of(12, 0, 1)))
            greeting = "Good morning";
        else
            greeting = "Hello";

        return String.format("%s %s", greeting, capitalized);
    }

}
