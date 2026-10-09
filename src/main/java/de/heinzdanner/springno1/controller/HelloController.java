package de.heinzdanner.springno1.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {
    @GetMapping
    public String basisPfad() {
        return "Hallo Spring Boot";
    }
}
