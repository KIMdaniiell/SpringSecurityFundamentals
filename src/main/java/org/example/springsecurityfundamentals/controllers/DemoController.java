package org.example.springsecurityfundamentals.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping("/admin")
    public String admin() {
        return "Admin!";
    }

    @RequestMapping("/demo")
    public String demo() {
        return "Demo!";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello!";
    }

}
