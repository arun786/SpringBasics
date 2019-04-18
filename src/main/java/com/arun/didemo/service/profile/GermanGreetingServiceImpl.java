package com.arun.didemo.service.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"eg", "default"})
public class GermanGreetingServiceImpl implements GreetingService {
    @Override
    public void greeting() {
        System.out.println("This greeting is in german");
    }
}
