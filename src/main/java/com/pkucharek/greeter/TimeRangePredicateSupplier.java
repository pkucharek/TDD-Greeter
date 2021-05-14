package com.pkucharek.greeter;

import java.time.LocalTime;

interface TimeRangePredicateSupplier {
    boolean test(LocalTime time);
    String get();
}
