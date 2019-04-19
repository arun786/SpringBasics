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


## @Qualifier

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

## @Primary

    
    public interface Color {
        void color();
    }
    
    
    @Service
    @Qualifier("purple")
    public class Purple implements Color {
        @Override
        public void color() {
            System.out.println("Purple");
        }
    }


    @Service
    @Primary
    public class Red implements Color {
        @Override
        public void color() {
            System.out.println("Red");
        }
    }


    @Controller
    public class ColorController {
        private Color color;
        private Color purple;
    
        @Autowired
        public ColorController(Color color, @Qualifier("purple") Color purple) {
            this.color = color;
            this.purple = purple;
        }
    
        public void getColor() {
            color.color();
        }
    
        public void getPurple() {
            purple.color();
        }
    }

## @Profile

    It provides a way to segregate parts of your application configuration and make it available for certain environments

    
    public interface GreetingService {
        void greeting();
    }


    @Service
    @Primary
    @Profile("en")
    public class EnglishGreetingServiceImpl implements GreetingService {
        @Override
        public void greeting() {
            System.out.println("This is English greeting");
        }
    }

    
    @Service
    @Primary
    @Profile("es")
    public class SpanishGreetingServiceImpl implements GreetingService {
        @Override
        public void greeting() {
            System.out.println("This is spanish greeting...");
        }
    }


    @Controller
    public class GreetingController {
    
        private GreetingService greetingService;
    
        @Autowired
        public GreetingController(GreetingService greetingService) {
            this.greetingService = greetingService;
        }
    
        public void englishGreeting() {
            greetingService.greeting();
        }
    }

    spring.profiles.active=es

## Default in Profile

    
    @Service
    @Profile({"eg", "default"})
    public class GermanGreetingServiceImpl implements GreetingService {
        @Override
        public void greeting() {
            System.out.println("This greeting is in german");
        }
    }


    If the properties file doesnt have active profiles, we can use default, this will call the default.
  
  
# Life Cycle of Bean

    @Component
    public class LifeCycleDemoBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    
        public LifeCycleDemoBean() {
            System.out.println("## 1. Constructor called ");
            System.out.println();
        }
    
        @Override
        public void setBeanName(String s) {
            System.out.println("## 2. Bean Name is " + s);
            System.out.println();
        }
    
        @Override
        public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
            System.out.println("## 3. Bean factory aware called");
            System.out.println();
        }
    
        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            System.out.println("## 4. Application context called");
            System.out.println();
        }
    
        public void beforeInit() {
            System.out.println("## 5. Before Init called by Bean Post Processor");
            System.out.println();
        }
    
        @PostConstruct
        public void postConstruct() {
            System.out.println("## 6. Post construct method called");
            System.out.println();
        }
    
        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("## 7. Life cycle bean has its properties set");
            System.out.println();
        }
    
        public void afterInit() {
            System.out.println("## 8. After Init called by Bean Post Processor");
            System.out.println();
        }
    
        //after this the bean is ready to use
    
        @PreDestroy
        public void preDestroy() {
            System.out.println("## 9. Pre destroy method called");
            System.out.println();
        }
    
        @Override
        public void destroy() throws Exception {
            System.out.println("## 10. Destroy method called");
            System.out.println();
        }
    }


    @Component
    public class CustomBeanPostProcessor implements BeanPostProcessor {
    
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            if (bean instanceof LifeCycleDemoBean) {
                ((LifeCycleDemoBean) bean).beforeInit();
            }
            return bean;
        }
    
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            if (bean instanceof LifeCycleDemoBean) {
                ((LifeCycleDemoBean) bean).afterInit();
            }
            return bean;
        }
    }

# Open Closed Principal

    Open for Extension but closed for modification

    
    public interface InsuranceClaimSurveyor {
        boolean isValidClaim();
    }

    @Service
    @Qualifier("health")
    public class HealthInsuranceClaimSurveyor implements InsuranceClaimSurveyor {
        @Override
        public boolean isValidClaim() {
            System.out.println("Health Insurance claim valid");
            return true;
        }
    }

    @Service
    @Qualifier("vehicle")
    public class VehicleInsuranceClaimSurveyor implements InsuranceClaimSurveyor {
        @Override
        public boolean isValidClaim() {
            System.out.println("Vehicle claim validated");
            return true;
        }
    }


    @Component
    public class ClaimApprovalManager {
    
        public void processClaim(InsuranceClaimSurveyor insuranceClaimSurveyor) {
            boolean validClaim = insuranceClaimSurveyor.isValidClaim();
            if (validClaim) {
                System.out.println("Approved claim");
            }
        }
    }

