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

