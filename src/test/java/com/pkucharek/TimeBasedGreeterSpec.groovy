package com.pkucharek

import spock.lang.Specification

import java.time.LocalTime

class TimeBasedGreeterSpec extends Specification {

    def "returns Good morning when #time is in (06:00, 12:00]"() {
        expect:
            timeBasedGreeter(time).greet("John") == result

        where:
            time       | result
            "06:00:01" | "Good morning John"
            "08:00:00" | "Good morning John"
            "12:00:00" | "Good morning John"
    }

    def "returns Hello when #time is in (12:00, 18:00]"() {
        expect:
            timeBasedGreeter(time).greet("John") == result

        where:
            time       | result
            "12:00:01" | "Hello John"
            "15:00:00" | "Hello John"
            "18:00:00" | "Hello John"
    }

    def "returns Good evening when #time is in (18:00, 22:00]"() {
        expect:
            timeBasedGreeter(time).greet("John") == result

        where:
            time       | result
            "18:00:01" | "Good evening John"
            "20:00:00" | "Good evening John"
            "22:00:00" | "Good evening John"
    }

    def "returns Good night when #time is in (22:00, 06:00]"() {
        expect:
            timeBasedGreeter(time).greet("John") == result

        where:
            time       | result
            "22:00:01" | "Good night John"
            "03:00:00" | "Good night John"
            "23:59:59" | "Good night John"
            "00:00:00" | "Good night John"
            "06:00:00" | "Good night John"
    }

    def timeBasedGreeter(String time) {
        def timeProvider = () -> LocalTime.parse(time)
        def beginningProviderImpl = new BeginningProviderImpl(timeProvider)
        new Greeter(beginningProviderImpl)
    }

}
