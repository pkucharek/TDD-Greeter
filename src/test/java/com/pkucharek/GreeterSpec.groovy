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
}
