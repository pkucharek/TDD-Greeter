package com.pkucharek.greeter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
class GreeterConfiguration {

    @Bean
    Greeter greeter(BeginningProvider beginningProvider) {
        return new Greeter(beginningProvider);
    }

    @Bean
    BeginningProvider beginningProvider(TimeProvider timeProvider) {
        return new BeginningProviderImpl(
            timeProvider, List.of(
                new MorningGreetingSupplier(),
                new AfternoonGreetingSupplier(),
                new EveningGreetingSupplier(),
                new NightGreetingSupplier()
            )
        );
    }

    @Bean
    TimeProvider defaultTimeProvider() {
        return new DefaultTimeProvider();
    }
}
