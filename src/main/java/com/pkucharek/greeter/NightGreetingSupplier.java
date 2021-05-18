package com.pkucharek.greeter;

import java.time.LocalTime;

class NightGreetingSupplier implements TimeBasedGreetingSupplier {
    @Override
    public boolean test(LocalTime time) {
        boolean isAfterEvening = time.isAfter(LocalTime.parse("22:00:00"));
        boolean beforeMidnight = time.isBefore(LocalTime.parse("23:59:59"));
        boolean isJustBeforeMidnight = time.equals(LocalTime.parse("23:59:59"));
        boolean isMidnight = time.equals(LocalTime.parse("00:00:00"));
        boolean isAfterMidnight = time.isAfter(LocalTime.parse("00:00:00"));
        boolean beforeMorning = time.isBefore(LocalTime.parse("06:00:01"));
        return
                (isAfterEvening && beforeMidnight)
                        || isJustBeforeMidnight
                        || isMidnight
                        || (isAfterMidnight && beforeMorning);
    }

    @Override
    public String get() {
        return "Good night";
    }
}
