package org.example.springsecurityfundamentals.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/demo")
    @PreAuthorize("hasRole('USER')")
    public String demo() {
        return "Demo!";
    }

    @PostMapping("/demo")
    @PreAuthorize("hasRole('ADMIN')")
    public String demoPost() {
        return "Demo post!";
    }
}
