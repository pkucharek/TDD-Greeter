package com.pkucharek;

import org.apache.commons.lang3.StringUtils;

public class Greeter {

    public String greet(String name) {
        String trimmed = name.trim();
        String capitalized = StringUtils.capitalize(trimmed);

        return String.format("Hello %s", capitalized);
    }

}
