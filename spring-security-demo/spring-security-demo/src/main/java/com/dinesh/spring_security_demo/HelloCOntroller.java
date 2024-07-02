package com.dinesh.spring_security_demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCOntroller {
    @RequestMapping("hello")
    public String Hi()
    {
        return "Hello World";
    }
}
