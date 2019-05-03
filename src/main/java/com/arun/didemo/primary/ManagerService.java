package com.arun.didemo.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    private Manager manager;

    @Autowired
    public ManagerService(Manager manager) {
        this.manager = manager;
    }

    public void getManagerName() {

        System.out.println(manager.getManagerName());
    }

}
