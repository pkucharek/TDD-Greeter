package com.pkucharek;

import java.time.LocalTime;

interface TimeProvider {
    LocalTime provide();
}
