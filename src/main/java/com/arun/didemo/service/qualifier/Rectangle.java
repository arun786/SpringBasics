package com.arun.didemo.service.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("rectangle")
public class Rectangle implements Shape {
    @Override
    public void shape() {
        System.out.println("Rectangle");
    }
}
