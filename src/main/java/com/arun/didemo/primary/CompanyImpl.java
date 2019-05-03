package com.arun.didemo.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyImpl implements Company {

    private Employee employee;

    @Autowired
    public CompanyImpl(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void display() {
        employee.display();
    }
}
