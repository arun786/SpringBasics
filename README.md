# Spring basics

## Types of Injection

    1. Constructor Injection
    2. Setter Injection
    3. Property Injection
    
    
### Constructor Injection

    package com.arun.didemo.controller;
    
    import com.arun.didemo.service.GreetingService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    
    @Controller
    public class ConstructorInjectedController {
    
        private GreetingService greetingService;
    
        @Autowired
        public ConstructorInjectedController(GreetingService greetingService) {
            this.greetingService = greetingService;
        }
    
        public String sayGreeting() {
            return greetingService.sayGreeting();
        }
    }

### Setter Injection

    package com.arun.didemo.controller;
    
    import com.arun.didemo.service.GreetingService;
    import lombok.Setter;
    
    @Setter
    public class SetterInjectedController {
    
        private GreetingService greetingService;
    
        public String sayGreeting() {
            return greetingService.sayGreeting();
        }
    }

### Property Injection (Not Recommended)

    package com.arun.didemo.controller;
    
    import com.arun.didemo.service.GreetingServiceImpl;
    import org.springframework.stereotype.Controller;
    
    @Controller
    public class PropertyInjectedController {
    
        public GreetingServiceImpl greetingService;
    
        public PropertyInjectedController() {
            greetingService = new GreetingServiceImpl();
        }
    
        public String sayHello() {
            return greetingService.sayGreeting();
        }
    }


## Qualifier

    package com.arun.didemo.service.qualifier;
    
    public interface Shape {
        void shape();
    }

    Interface has 3 implemtations 
    
    1. Circle
    2. Rectangle
    3. Square
    
    
    @Service
    @Qualifier("circle")
    public class Circle implements Shape {
        @Override
        public void shape() {
            System.out.println("Circle");
        }
    }

    
    @Service
    @Qualifier("rectangle")
    public class Rectangle implements Shape {
        @Override
        public void shape() {
            System.out.println("Rectangle");
        }
    }

    
    @Service
    @Qualifier("square")
    public class Square implements Shape {
        @Override
        public void shape() {
            System.out.println("Shape");
        }
    }


    @Controller
    public class ShapeController {
    
        private Shape shape;
        private Shape rectangle;
        private Shape square;
        
        @Autowired
        public ShapeController(@Qualifier("circle") Shape shape, Shape rectangle, Shape square) {
            this.shape = shape;
            this.rectangle = rectangle;
            this.square = square;
        }
        
        public void getShape() {
            shape.shape();
        }
        
        public void getRectangleShapeBasedOnType() {
            rectangle.shape();
        }
        
        public void getSquareBasedOnType() {
            square.shape();
        }
    }
