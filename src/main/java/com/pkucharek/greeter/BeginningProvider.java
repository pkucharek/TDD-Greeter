package com.pkucharek.greeter;

import java.time.LocalTime;
import java.util.List;

class BeginningProvider {
    private final TimeProvider timeProvider;
    private final List<TimeBasedGreetingSupplier> timeRanges;

    BeginningProvider(
        TimeProvider timeProvider,
        List<TimeBasedGreetingSupplier> timeRanges
    ) {
        this.timeProvider = timeProvider;
        this.timeRanges = timeRanges;
    }

    public String provide() {
        LocalTime time = timeProvider.provide();
        return timeRanges.stream()
                .filter(p -> p.test(time))
                .findFirst()
                .map(TimeBasedGreetingSupplier::get)
                .orElseThrow(() -> new RuntimeException("Invalid time"));
    }
}
