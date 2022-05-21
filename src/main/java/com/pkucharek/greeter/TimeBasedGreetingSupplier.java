package com.pkucharek.greeter;

import java.time.LocalTime;

interface TimeBasedGreetingSupplier {
    boolean test(LocalTime time);
    String get();
}

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
class EveningGreetingSupplier implements TimeBasedGreetingSupplier {
    private final LocalTime TIME_18_00_00 = LocalTime.parse("18:00:00");
    private final LocalTime TIME_22_00_01 = LocalTime.parse("22:00:01");

    @Override
    public boolean test(LocalTime time) {
        return time.isAfter(TIME_18_00_00) && time.isBefore(TIME_22_00_01);
    }

    @Override
    public String get() {
        return "Good evening";
    }
}

class NightGreetingSupplier implements TimeBasedGreetingSupplier {
    private final LocalTime TIME_22_00_00 = LocalTime.parse("22:00:00");
    private final LocalTime TIME_06_00_01 = LocalTime.parse("06:00:01");

    @Override
    public boolean test(LocalTime time) {
        return time.isAfter(TIME_22_00_00) || time.isBefore(TIME_06_00_01);
    }

    @Override
    public String get() {
        return "Good night";
    }
}
