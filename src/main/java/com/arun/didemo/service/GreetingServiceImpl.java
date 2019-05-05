package com.arun.didemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    private final static Logger logger = LoggerFactory.getLogger(GreetingServiceImpl.class);

    @Override
    public String sayGreeting() {
        String hello = "Say hello to world";
        logger.info(hello);

        return hello;
    }
}
