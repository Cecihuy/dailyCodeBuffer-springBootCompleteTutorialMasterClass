package com.dailycodebuffer.springboottutorial.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String helloWorld(){
        return "Welcome to Daily Code Buffer!!!";
    }
}