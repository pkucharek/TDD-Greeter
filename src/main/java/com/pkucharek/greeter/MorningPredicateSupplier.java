package com.pkucharek.greeter;

import java.time.LocalTime;

class MorningPredicateSupplier implements TimeBasedGreetingSupplier {
    @Override
    public boolean test(LocalTime time) {
        return time.isAfter(LocalTime.parse("06:00:00"))
                && time.isBefore(LocalTime.parse("12:00:01"));
    }

    @Override
    public String get() {
        return "Good morning";
    }
}
