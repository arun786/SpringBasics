package com.arun.didemo;

import com.arun.didemo.controller.ConstructorInjectedController;
import com.arun.didemo.controller.MyController;
import com.arun.didemo.controller.PropertyInjectedController;
import com.arun.didemo.controller.Qualifier.ShapeController;
import com.arun.didemo.controller.primary.ColorController;
import com.arun.didemo.controller.profile.GreetingController;
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

        logger.info("Qualifier Demo");

        /**
         * Demo of  Qualifier
         */

        ShapeController shapeController = run.getBean("shapeController", ShapeController.class);
        shapeController.getShape();
        shapeController.getRectangleShapeBasedOnType();
        shapeController.getSquareBasedOnType();

        logger.info("Primary Demo");
        /**
         * Demo for Primary
         */
        ColorController colorController = run.getBean("colorController", ColorController.class);
        colorController.getColor();
        colorController.getPurple(); //If Qualifier is not added to the Purple bean, becoz of @Primary it will diplay red

        /**
         * Demo for Profile
         */
        GreetingController greetingController = run.getBean("greetingController", GreetingController.class);
        greetingController.englishGreeting();
    }

}
