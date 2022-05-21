package com.pkucharek.greeter

import spock.lang.Specification

import java.time.LocalTime

class StandardGreeterSpec extends Specification {

    Greeter standardGreeter = new GreeterConfiguration().greeter {
        LocalTime.parse("16:00:00")
    }

    def "returns Hello #name"() {
        expect:
            standardGreeter.greet(name) == result

        where:
            name   | result
            "Jack" | "Hello Jack"
            "Bob"  | "Hello Bob"
    }

    def "input name is trimmed"() {
        expect:
            standardGreeter.greet(name) == result

        where:
            name         | result
            "  James  "  | "Hello James"
            "\nEvelyn\t" | "Hello Evelyn"
    }

    def "input name #name is capitalized"() {
        expect:
            standardGreeter.greet(name) == result

        where:
            name     | result
            "harper" | "Hello Harper"
            "mason"  | "Hello Mason"
    }

}
