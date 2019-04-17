package com.arun.didemo.service.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("square")
public class Square implements Shape {
    @Override
    public void shape() {
        System.out.println("Shape");
    }
}
