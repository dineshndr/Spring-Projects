package com.example.OAuth.demo;

//import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String greet()
    {
        return "Welcome to Foreign";
    }
}
