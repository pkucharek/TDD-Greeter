package com.pkucharek.greeter;

import java.time.LocalTime;

class EveningGreetingSupplier implements TimeBasedGreetingSupplier {
    @Override
    public boolean test(LocalTime time) {
        return time.isAfter(LocalTime.parse("18:00:00"))
                && time.isBefore(LocalTime.parse("22:00:01"));
    }

    @Override
    public String get() {
        return "Good evening";
    }
}
