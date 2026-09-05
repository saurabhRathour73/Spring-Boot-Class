package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // ---- >/hello

    @GetMapping("/hello")
    public String hello(){
        return "<h1> Hello world !! </h1>";
    }
    @GetMapping("/login")
    public String login(){
        return "<h1> User login Successfull !! </h1> " ;
    }

}
