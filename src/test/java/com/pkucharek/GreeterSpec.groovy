package com.pkucharek

import spock.lang.Specification

import java.time.LocalTime

class GreeterSpec extends Specification {

    Greeter greeter = new Greeter(() -> LocalTime.parse("05:00:00"))

    def "returns Hello #name"() {
        expect:
            greeter.greet(name) == result

        where:
            name   | result
            "Jack" | "Hello Jack"
            "Bob"  | "Hello Bob"
    }

    def "input name is trimmed"() {
        expect:
            greeter.greet(name) == result

        where:
            name         | result
            "  James  "  | "Hello James"
            "\nEvelyn\t" | "Hello Evelyn"
    }

    def "input name #name is capitalized"() {
        expect:
            greeter.greet(name) == result

        where:
            name     | result
            "harper" | "Hello Harper"
            "mason"  | "Hello Mason"
    }

    def "returns Good morning when time is between 06:00 and 12:00"() {
        expect:
            new Greeter(() -> LocalTime.parse(time)).greet("John") == result

        where:
            time       | result
            "05:59:59" | "Hello John"
            "06:00:00" | "Good morning John"
            "08:00:00" | "Good morning John"
            "12:00:00" | "Good morning John"
            "12:00:01" | "Hello John"
    }
}
