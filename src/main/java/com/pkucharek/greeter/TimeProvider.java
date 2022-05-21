package com.pkucharek.greeter;

import java.time.LocalTime;

interface TimeProvider {
    LocalTime provide();
}

class DefaultTimeProvider implements TimeProvider {
    @Override
    public LocalTime provide() {
        return LocalTime.now();
    }
}
