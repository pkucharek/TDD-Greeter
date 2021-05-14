package com.pkucharek;

import org.apache.commons.lang3.StringUtils;

public class Greeter {
    private final BeginningProvider beginningProvider;
    private int counter = 0;

    public Greeter(BeginningProvider beginningProvider) {
        this.beginningProvider = beginningProvider;
    }

    public String greet(String name) {
        String beginning = beginningProvider.provide();
        String correctedName = getCorrectedName(name);

        String result = String.format("%s %s", beginning, correctedName);
        print(result);

        return result;
    }

    private void print(String result) {
        counter++;
        System.out.printf("%d. %s%n", counter, result);
    }

    private String getCorrectedName(String name) {
        String trimmedName = name.trim();
        return StringUtils.capitalize(trimmedName);
    }
}
