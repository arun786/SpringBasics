package com.arun.didemo.service.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("circle")
public class Circle implements Shape {
    @Override
    public void shape() {
        System.out.println("Circle");
    }
}
