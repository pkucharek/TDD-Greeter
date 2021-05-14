package com.pkucharek;

class ConsolePrinter {
    private int counter = 0;

    void print(String message) {
        counter++;
        System.out.printf("%d. %s%n", counter, message);
    }

}
