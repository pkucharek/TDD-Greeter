package com.pkucharek.greeter;

import java.time.LocalTime;

class AfternoonGreetingSupplier implements TimeBasedGreetingSupplier {
    private final LocalTime TIME_12_00_00 = LocalTime.parse("12:00:00");
    private final LocalTime TIME_18_00_01 = LocalTime.parse("18:00:01");

    @Override
    public boolean test(LocalTime time) {
        return time.isAfter(TIME_12_00_00) && time.isBefore(TIME_18_00_01);
    }

    @Override
    public String get() {
        return "Hello";
    }
}
