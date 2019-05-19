package com.arun.didemo;

import com.arun.didemo.datasource.DataSourceCall;
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
//        MyController myController = run.getBean("myController", MyController.class);
//        myController.printHello();
//
//        ConstructorInjectedController constructorInjectedController = run.getBean("constructorInjectedController", ConstructorInjectedController.class);
//        String s = constructorInjectedController.sayGreeting();
//        System.out.println(s);
//
//
//        PropertyInjectedController propertyInjectedController = run.getBean("propertyInjectedController", PropertyInjectedController.class);
//        logger.info(propertyInjectedController.sayHello());
//
//        logger.info("Qualifier Demo");
//
//        /**
//         * Demo of  Qualifier
//         */
//
//        ShapeController shapeController = run.getBean("shapeController", ShapeController.class);
//        shapeController.getShape();
//        shapeController.getRectangleShapeBasedOnType();
//        shapeController.getSquareBasedOnType();
//
//        logger.info("primary Demo");
//        /**
//         * Demo for primary
//         */
//        ColorController colorController = run.getBean("colorController", ColorController.class);
//        colorController.getColor();
//        colorController.getPurple(); //If Qualifier is not added to the Purple bean, becoz of @primary it will diplay red
//
//        /**
//         * Demo for Profile
//         */
//        GreetingController greetingController = run.getBean("greetingController", GreetingController.class);
//        greetingController.englishGreeting();
//
//        /**
//         * Open closed Principle
//         */
//
//        ClaimApprovalManager claimApprovalManager = run.getBean("claimApprovalManager", ClaimApprovalManager.class);
//        InsuranceClaimSurveyor healthInsuranceClaimSurveyor = run.getBean("healthInsuranceClaimSurveyor", InsuranceClaimSurveyor.class);
//        claimApprovalManager.processClaim(healthInsuranceClaimSurveyor);
//        System.out.println();
//        InsuranceClaimSurveyor vehicleInsuranceClaimSurveyor = run.getBean("vehicleInsuranceClaimSurveyor", InsuranceClaimSurveyor.class);
//        claimApprovalManager.processClaim(vehicleInsuranceClaimSurveyor);
//        System.out.println();

        /**
         * Use of @Primary
         */
//
//        EmployeeConfig employeeConfig = run.getBean("employeeConfig", EmployeeConfig.class);
//        Employee arunEmployee = employeeConfig.getArunEmployee();
//        arunEmployee.display();
//
//
//        ManagerService managerService = run.getBean("managerService", ManagerService.class);
//        managerService.getManagerName();


        DataSourceCall dataSourceCall = run.getBean("dataSourceCall", DataSourceCall.class);
        System.out.println(dataSourceCall.getAccounts());
    }


}
