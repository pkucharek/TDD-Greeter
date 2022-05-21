package com.pkucharek.greeter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<String> greet(@PathVariable("name") String name) {
        return ResponseEntity.ok(greeter.greet(name));
    }

}
