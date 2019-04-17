package com.arun.didemo.controller;

import com.arun.didemo.service.GreetingService;
import lombok.Setter;

@Setter
public class SetterInjectedController {

    private GreetingService greetingService;

    public String sayGreeting() {
        return greetingService.sayGreeting();
    }
}
