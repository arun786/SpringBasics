package com.arun.didemo.service.primary;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("purple")
public class Purple implements Color {
    @Override
    public void color() {
        System.out.println("Purple");
    }
}
