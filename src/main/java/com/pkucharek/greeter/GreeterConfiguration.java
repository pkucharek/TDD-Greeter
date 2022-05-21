package com.pkucharek.greeter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
class GreeterConfiguration {

    @Bean
    Greeter greeter(TimeProvider timeProvider) {
        BeginningProvider beginningProvider = new BeginningProviderImpl(
            timeProvider,
            List.of(
                new MorningGreetingSupplier(),
                new AfternoonGreetingSupplier(),
                new EveningGreetingSupplier(),
                new NightGreetingSupplier()
            )
        );
        return new Greeter(beginningProvider);
    }

    @Bean
    TimeProvider defaultTimeProvider() {
        return new DefaultTimeProvider();
    }
}
