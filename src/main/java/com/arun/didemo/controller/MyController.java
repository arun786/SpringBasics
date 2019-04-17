package com.arun.didemo.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String printHello() {

        String helloWorld = "Hello World";
        System.out.println(helloWorld);
        return helloWorld;
    }
}
