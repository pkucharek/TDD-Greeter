package com.pkucharek

import spock.lang.Specification

class ConsoleOutputGreeterSpec extends Specification {

    Greeter standardGreeter = new Greeter(() -> "Hello" )
    def buffer = new ByteArrayOutputStream()

    def "logs into console each time greeted"() {
        given:
            setConsoleOutputStreamToMemoryStream()

        when:
            doNothing()
        then:
            printedMessageIs("")

        when:
            standardGreeter.greet("John")
        then:
            printedMessageIs("1. Hello John\r\n")

        when:
            standardGreeter.greet("John")
        then:
            printedMessageIs(
                "1. Hello John\r\n" +
                "2. Hello John\r\n"
            )
    }

    void doNothing() {}

    void printedMessageIs(String message) {
        assert buffer.toString() == message
    }

    void setConsoleOutputStreamToMemoryStream() {
        System.out = new PrintStream(buffer)
    }

}
