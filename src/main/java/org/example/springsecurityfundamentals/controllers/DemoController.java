package org.example.springsecurityfundamentals.controllers;


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
    public String demo() {
        return "Demo!";
    }

    @PostMapping("/demo")
    public String demoPost() {
        return "Demo post!";
    }
}
