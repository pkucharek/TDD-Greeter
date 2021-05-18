package com.pkucharek.greeter;

import java.time.LocalTime;

interface TimeBasedGreetingSupplier {
    boolean test(LocalTime time);
    String get();
}
