package com.pkucharek.greeter

import spock.lang.Specification

class ConsoleOutputGreeterSpec extends Specification {

    Greeter standardGreeter = new Greeter(() -> "Hello" )
    def buffer = new ByteArrayOutputStream()
    private String NEW_LINE  = System.getProperty("line.separator")

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
            printedMessageIs("1. Hello John$NEW_LINE")

        when:
            standardGreeter.greet("John")
        then:
            printedMessageIs(
                "1. Hello John$NEW_LINE" +
                "2. Hello John$NEW_LINE"
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
