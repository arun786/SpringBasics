package com.arun.didemo;

import com.arun.didemo.controller.ConstructorInjectedController;
import com.arun.didemo.controller.MyController;
import com.arun.didemo.controller.PropertyInjectedController;
import com.arun.didemo.controller.Qualifier.ShapeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(DiDemoApplication.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(DiDemoApplication.class, args);
        MyController myController = run.getBean("myController", MyController.class);
        myController.printHello();

        ConstructorInjectedController constructorInjectedController = run.getBean("constructorInjectedController", ConstructorInjectedController.class);
        String s = constructorInjectedController.sayGreeting();
        System.out.println(s);


        PropertyInjectedController propertyInjectedController = run.getBean("propertyInjectedController", PropertyInjectedController.class);
        logger.info(propertyInjectedController.sayHello());

        /**
         * Demo of  Qualifier
         */

        ShapeController shapeController = run.getBean("shapeController", ShapeController.class);
        shapeController.getShape();
        shapeController.getRectangleShapeBasedOnType();
        shapeController.getSquareBasedOnType();
    }

}
