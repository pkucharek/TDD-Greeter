package com.pkucharek;

import java.time.LocalTime;

interface TimeRangePredicateSupplier {
    boolean test(LocalTime time);
    String get();
}
