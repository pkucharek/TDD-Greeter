package com.pkucharek.greeter;

import java.time.LocalTime;

class NightGreetingSupplier implements TimeBasedGreetingSupplier {
    @Override
    public boolean test(LocalTime time) {
        return time.isAfter(LocalTime.parse("22:00:00"))
            || time.isBefore(LocalTime.parse("06:00:01"));
    }

    @Override
    public String get() {
        return "Good night";
    }
}
