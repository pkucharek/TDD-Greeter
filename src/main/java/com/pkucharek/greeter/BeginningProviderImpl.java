package com.pkucharek.greeter;

import java.time.LocalTime;
import java.util.List;

class BeginningProviderImpl implements BeginningProvider {
    private final TimeProvider timeProvider;
    private final List<TimeBasedGreetingSupplier> timeRanges = List.of(
        new MorningPredicateSupplier(),
        new EveningPredicateSupplier(),
        new NightPredicateSupplier(),
        new AfternoonPredicateSupplier()
    );

    BeginningProviderImpl() {
        timeProvider = LocalTime::now;
    }

    BeginningProviderImpl(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    @Override
    public String provide() {
        LocalTime time = timeProvider.provide();
        return timeRanges.stream()
                .filter(p -> p.test(time))
                .findFirst()
                .map(TimeBasedGreetingSupplier::get)
                .orElseThrow(() -> new RuntimeException("Invalid time"));
    }
}
