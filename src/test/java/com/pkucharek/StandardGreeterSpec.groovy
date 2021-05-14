package com.pkucharek

import spock.lang.Specification

import java.time.LocalTime

class StandardGreeterSpec extends Specification {

    Greeter standardGreeter = new Greeter(() -> "Hello")

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

    def "logs into console each time greeted"() {
        given:
            def buffer = new ByteArrayOutputStream()
            System.out = new PrintStream(buffer)

        when:
            standardGreeter.greet("John")

        then:
            buffer.toString() == "1. Hello John\r\n"

        when:
            standardGreeter.greet("John")

        then:
            buffer.toString() ==
                    "1. Hello John\r\n" +
                    "2. Hello John\r\n"
    }
}
