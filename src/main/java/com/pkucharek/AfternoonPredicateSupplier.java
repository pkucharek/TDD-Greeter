package com.pkucharek;

import java.time.LocalTime;

class AfternoonPredicateSupplier implements TimeRangePredicateSupplier {
    @Override
    public boolean test(LocalTime time) {
        throw new AfternoonCheckException("Afternoon is default case, shouldn't be checked");
    }

    @Override
    public String get() {
        return "Hello";
    }
}
