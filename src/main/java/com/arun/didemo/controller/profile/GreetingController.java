package com.arun.didemo.controller.profile;

import com.arun.didemo.service.profile.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    private GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void englishGreeting() {
        greetingService.greeting();
    }
}
