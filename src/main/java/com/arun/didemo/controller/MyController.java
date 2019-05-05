package com.arun.didemo.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String printHello() {

        String helloWorld = "Hello World this is my controller";
        System.out.println(helloWorld);
        return helloWorld;
    }
}
