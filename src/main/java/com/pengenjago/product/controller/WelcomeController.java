package com.pengenjago.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Application";
    }
}
