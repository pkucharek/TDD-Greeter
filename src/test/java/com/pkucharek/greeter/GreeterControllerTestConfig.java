package com.pkucharek.greeter;

import org.springframework.context.annotation.Bean;

class GreeterControllerTestConfig extends GreeterConfiguration {

    @Bean
    GreeterController greeterController() {
        return new GreeterController(greeter(() -> "Hello"));
    }

}
