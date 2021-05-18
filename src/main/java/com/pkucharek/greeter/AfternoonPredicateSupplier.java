package com.pkucharek.greeter;

import java.time.LocalTime;

class AfternoonPredicateSupplier implements TimeBasedGreetingSupplier {
    @Override
    public boolean test(LocalTime time) {
        return time.isAfter(LocalTime.parse("12:00:00"))
                && time.isBefore(LocalTime.parse("18:00:01"));
    }

    @Override
    public String get() {
        return "Hello";
    }
}
