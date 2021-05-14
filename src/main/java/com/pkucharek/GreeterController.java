package com.pkucharek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreeterController {

    private final Greeter greeter;

    @Autowired
    public GreeterController(Greeter greeter) {
        this.greeter = greeter;
    }

    @GetMapping("/greet/{name}")
    String greet(@PathVariable("name") String name) {
        return greeter.greet(name);
    }

}
