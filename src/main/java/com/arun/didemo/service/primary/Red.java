package com.arun.didemo.service.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class Red implements Color {
    @Override
    public void color() {
        System.out.println("Red");
    }
}
