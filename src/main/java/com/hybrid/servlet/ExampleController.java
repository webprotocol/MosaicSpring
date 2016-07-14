package com.hybrid.servlet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
 
    @RequestMapping("/example")
    public String index() {
        return "Hello World & Spring Loaded!@@@@";
    }
}

