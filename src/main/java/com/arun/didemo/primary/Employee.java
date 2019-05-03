package com.arun.didemo.primary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private String name;

    public void display(){
        System.out.println(name);
    }
}
