package com.pkucharek.greeter;

import org.springframework.context.annotation.Bean;

import java.time.LocalTime;

class GreeterControllerTestConfig extends GreeterConfiguration {

    @Bean
    GreeterController greeterController() {
        return new GreeterController(greeter(LocalTime::now));
    }

}
