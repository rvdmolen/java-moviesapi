package com.codingmill.moviesapi.web.controller;


import com.codingmill.moviesapi.web.model.MovieDTO;
import com.codingmill.moviesapi.web.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hello-world")
public class HelloWorldController {


    @GetMapping(path = "", produces = "application/json")
    public String helloWorld() {
        return "Hello World";
    }
}
