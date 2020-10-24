package com.ecar.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class IndexController {

    @GetMapping
    public String get(){
        return "get Spring Boot";
    }

    @GetMapping("/login")
    public String login(){
        return "API dos Carros";

    }

}
