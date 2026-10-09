package de.heinzdanner.springno1.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

    @GetMapping
    public String basisPfad() {
        return "Hallo Spring Boot";
    }

    @GetMapping("/{name}")
    public String sayHelloTo(@PathVariable String name) {
        return "Hallo " + name;
    }

    @GetMapping("/greet/{name}")   //http://localhost:8080/api/v1/hello/greet/mark?lang=de
    public String sayHelloToLang(@PathVariable String name, @RequestParam(defaultValue = "de") String lang) {
        return switch (lang) {
            case "de" -> "Hallo " + name;
            case "en" -> "Hello " + name;
            case "fr" -> "Bonjour " + name;
            default -> "Hallo " + name;
        };
    }

    @GetMapping("/hi")   // http://localhost:8080/api/v1/hello/hi?name=Heinz&lang=fr
    public String sayHelloToLang2(@RequestParam String name, @RequestParam(defaultValue = "de") String lang) {
        return switch (lang) {
            case "de" -> "Hallo " + name;
            case "en" -> "Hello " + name;
            case "fr" -> "Bonjour " + name;
            default -> "Hallo " + name;
        };
    }

}
