package com.pkucharek.greeter;

import java.time.LocalTime;

class MorningGreetingSupplier implements TimeBasedGreetingSupplier {
    private final LocalTime TIME_06_00_00 = LocalTime.parse("06:00:00");
    private final LocalTime TIME_12_00_01 = LocalTime.parse("12:00:01");

    @Override
    public boolean test(LocalTime time) {
        return time.isAfter(TIME_06_00_00) && time.isBefore(TIME_12_00_01);
    }

    @Override
    public String get() {
        return "Good morning";
    }
}
