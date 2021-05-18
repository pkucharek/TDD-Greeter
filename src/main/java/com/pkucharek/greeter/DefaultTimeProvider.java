package com.pkucharek.greeter;

import java.time.LocalTime;

class DefaultTimeProvider implements TimeProvider {
    @Override
    public LocalTime provide() {
        return LocalTime.now();
    }
}
