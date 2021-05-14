package com.pkucharek;

import org.apache.commons.lang3.StringUtils;

public class Greeter {
    private final BeginningProvider beginningProvider;

    public Greeter(BeginningProvider beginningProvider) {
        this.beginningProvider = beginningProvider;
    }

    public String greet(String name) {
        String beginning = beginningProvider.provide();
        String correctedName = getCorrectedName(name);

        return String.format("%s %s", beginning, correctedName);
    }

    private String getCorrectedName(String name) {
        String trimmedName = name.trim();
        return StringUtils.capitalize(trimmedName);
    }
}
