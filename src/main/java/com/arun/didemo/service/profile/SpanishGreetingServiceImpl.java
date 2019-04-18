package com.arun.didemo.service.profile;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("es")
public class SpanishGreetingServiceImpl implements GreetingService {
    @Override
    public void greeting() {
        System.out.println("This is spanish greeting...");
    }
}
