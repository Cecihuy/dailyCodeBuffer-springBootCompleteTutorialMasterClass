package com.dailycodebuffer.springboottutorial.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value(value = "${welcome.message}")
    private String welcomeMessage;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String helloWorld(){
        return welcomeMessage;
    }
}