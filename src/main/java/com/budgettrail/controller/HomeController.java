package com.budgettrail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/api")
    public String api() {
        return "index";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
} 