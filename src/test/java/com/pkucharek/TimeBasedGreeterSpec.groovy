package com.pkucharek

import spock.lang.Specification

import java.time.LocalTime

class TimeBasedGreeterSpec extends Specification {

    def "returns Good morning when time is between 06:00 and 12:00"() {
        expect:
            timeBasedGreeter(time).greet("John") == result

        where:
            time       | result
            "05:59:59" | "Hello John"
            "06:00:00" | "Good morning John"
            "08:00:00" | "Good morning John"
            "12:00:00" | "Good morning John"
            "12:00:01" | "Hello John"
    }

    def "returns Good evening when time is between 18:00 and 22:00"() {
        expect:
            timeBasedGreeter(time).greet("John") == result

        where:
            time       | result
            "17:59:59" | "Hello John"
            "18:00:00" | "Good evening John"
            "20:00:00" | "Good evening John"
            "22:00:00" | "Good evening John"
            "22:00:01" | "Hello John"
    }

    def "returns Good night when time is between 22:00:01 and 06:00"() {
        expect:
            timeBasedGreeter(time).greet("John") == result

        where:
            time       | result
            "22:00:00" | "Good evening John"
            "22:00:01" | "Good night John"
            "03:00:00" | "Good night John"
            "06:00:00" | "Good night John"
            "06:00:01" | "Good morning John"
    }

    def timeBasedGreeter(String time) {
        new Greeter(() -> LocalTime.parse(time))
    }

}
