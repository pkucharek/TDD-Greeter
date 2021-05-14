package com.pkucharek.greeter;

import java.time.LocalTime;

interface TimeProvider {
    LocalTime provide();
}
