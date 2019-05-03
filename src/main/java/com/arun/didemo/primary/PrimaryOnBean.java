package com.arun.didemo.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

public class PrimaryOnBean {
}


interface Manager {
    String getManagerName();
}

@Service
class GeneralManager implements Manager {

    @Override
    public String getManagerName() {
        return "General Manager";
    }
}

@Service
@Primary
class ProductManager implements Manager {

    @Override
    public String getManagerName() {
        return "Product Manager";
    }
}

