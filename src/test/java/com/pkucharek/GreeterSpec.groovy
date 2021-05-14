package com.pkucharek

import spock.lang.Specification

class GreeterSpec extends Specification {

    Greeter greeter = new Greeter()

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
}
