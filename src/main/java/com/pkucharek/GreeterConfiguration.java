package com.pkucharek;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GreeterConfiguration {

    @Bean
    Greeter greeter() {
        return new Greeter(beginningProvider());
    }

    @Bean
    BeginningProvider beginningProvider() {
        return new BeginningProviderImpl();
    }
}
