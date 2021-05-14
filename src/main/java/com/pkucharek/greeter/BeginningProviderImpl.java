package com.pkucharek.greeter;

import java.time.LocalTime;
import java.util.List;

class BeginningProviderImpl implements BeginningProvider {
    private final TimeProvider timeProvider;
    private final List<TimeRangePredicateSupplier> timeRanges = List.of(
        new MorningPredicateSupplier(),
        new EveningPredicateSupplier(),
        new NightPredicateSupplier()
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
        for (TimeRangePredicateSupplier predicateSupplier : timeRanges)
            if (predicateSupplier.test(time))
                return predicateSupplier.get();

        return new AfternoonPredicateSupplier().get();
    }
}
