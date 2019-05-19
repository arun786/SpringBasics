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

## @Autowired

   It enables to inject beans automatically
   There are 3 types of autowiring
   
   1. byType
   2. byName
   3. Constructor, which is byType
   
   
### byType

    package com.arun.didemo.Autowiring;
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Component;
    
    @Component
    public class ByTypeAutowired {
        /**
         * ByType, here we have only one bean which qualifies to be autowired
         */
        @Autowired
        private SortAlgorithm sortAlgorithm;
    }
    
    
    interface SortAlgorithm {
        void sort(int[] numbers);
    }
    
    @Component
    class QuickSortAlgortihm implements SortAlgorithm {
        @Override
        public void sort(int[] numbers) {
    
        }
    }
    
### byName

    package com.arun.didemo.Autowiring;
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Component;
    
    @Component
    public class ByNameAutowired {
    
        /**
         * Autowired by Name
         */
        @Autowired
        private Sort bubbleSort;
    }
    
    interface Sort {
        void sort(int[] numbers);
    }
    
    @Component
    class BubbleSort implements Sort {
    
        @Override
        public void sort(int[] numbers) {
    
        }
    }
    
    @Component
    class QuickSort implements Sort {
    
        @Override
        public void sort(int[] numbers) {
    
        }
    }

## Exceptions in Bean

    NoSuchBeanDefinitionFound - either the @Component or componentscan is not defined properly.
    NoUniqueBeanDefinitionFound - two beans of same type qualify for autowiring, there are ways to resolve this issue
    
    1. autowire by name
    2. mark one of the beans as @Primary
    3. use @Qualifier along with the @Autowired

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
### we use @Primary to give higher preference to a bean when there are multiple beans of the same type.

    Case 1 : When @Primary is used along with @Bean. we cannot use @Qualifier at the configuration phase.
    
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

    
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.Primary;
        
        @Configuration
        public class EmployeeConfig {
        
            @Bean
            @Primary
            public Employee getArunEmployee() {
                return new Employee("Arun");
            }
        
            @Bean
            public Employee getPushpaEmployee() {
                return new Employee("Pushpa");
            }
        }

        
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
        
    
    Case 2 : When Used directly on the bean.
    
        import org.springframework.context.annotation.Primary;
        import org.springframework.stereotype.Component;
        
        public class PrimaryOnBean {
        }
        
        
        interface Manager {
            String getManagerName();
        }
        
        @Component
        class GeneralManager implements Manager {
        
            @Override
            public String getManagerName() {
                return "General Manager";
            }
        }
        
        @Component
        @Primary
        class ProductManager implements Manager {
        
            @Override
            public String getManagerName() {
                return "Product Manager";
            }
        }
    
    
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

    When you specify the below in application.properties.
    
    spring.profiles.active=es
    
    the output of the controller will be as "This is spanish greeting...". 

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

# SOLID principle of Spring framework

    1. Single Responsibility Principle
    2. Open Closed Principle
    3. Liskov Substitution Principle
    4. Interface Segregation Principle
    5. Dependency Inversion Principle
   
# Single Responsibility Principle

    A class should be doing a particular type of work, avoid using god class.
    
# Open Closed Principal

    Open for Extension but closed for modification, this can be achieved using interface.

    
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

## Liskov Substitution Principle
    
    Object of Parent class can be replaced with Object of Child class without any negative affects.
    
### Not following Liskov Substitution principle

    
    import lombok.Getter;
    import lombok.Setter;
    
    /**
     * Liskov substitution principle when not applied properly
     */
    @Getter
    @Setter
    public class TransportationDevice {
        private String name;
        private double speed;
        private Engine engine;
    
        public void startEngine() {
            System.out.println("Starting engine....");
        }
    
        public static void main(String[] args) {
            TransportationDevice car = new Car();
            car.startEngine();
    
            TransportationDevice bicyle = new Bicycle();
            bicyle.startEngine();
        }
    }
    
    class Car extends TransportationDevice {
        @Override
        public void startEngine() {
            System.out.println("Car engine starting...");
        }
    }
    
    /**
     * Violation of Liskov Substitution principle where we are overriding startEngine, when it method is not required at all
     */
    class Bicycle extends TransportationDevice {
        @Override
        public void startEngine() {
            System.out.println("Do nothing");
        }
    }
    

### Proper adhering to Liskov Substitution principle

    
    import lombok.Getter;
    import lombok.Setter;
    
    @Getter
    @Setter
    public class TransportationDevice_v1 {
        private String name;
        private double speed;
    
        public static void main(String[] args) {
    
            DeviceWithEngine hondaCar = new HondaCar("HondaCar");
            hondaCar.startEngine();
    
            DeviceWithoutEngine triCycle = new Tricycle("TriCycle");
            triCycle.startMoving();
        }
    }
    
    class DeviceWithoutEngine extends TransportationDevice_v1 {
        public void startMoving() {
            System.out.println(this.getName() + " Start Moving");
        }
    }
    
    @Getter
    @Setter
    class DeviceWithEngine extends TransportationDevice_v1 {
        private Engine engine;
    
        public void startEngine() {
            System.out.println(this.getName() + " Start Engine..");
        }
    }
    
    class HondaCar extends DeviceWithEngine {
    
        public HondaCar(String name) {
            this.setName(name);
        }
    }
    
    class Tricycle extends DeviceWithoutEngine {
    
        public Tricycle(String name) {
            this.setName(name);
        }
    }
    


## Datasource Configuration

### Set the properties

    mysql.datasource.username=root
    mysql.datasource.password=root
    mysql.datasource.driver-class-name=com.mysql.jdbc.Driver
    mysql.datasource.jdbc-url=jdbc:mysql://localhost/tcrmd00
    
    
### set the config

    package com.arun.didemo;
    
    import org.springframework.beans.factory.annotation.Qualifier;
    import org.springframework.boot.context.properties.ConfigurationProperties;
    import org.springframework.boot.jdbc.DataSourceBuilder;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.PropertySource;
    import org.springframework.jdbc.core.JdbcTemplate;
    
    import javax.sql.DataSource;
    
    @Configuration
    @PropertySource("classpath:database.properties")
    public class dbConfig {
    
        @Bean(name = "mysqlDataSource")
        @ConfigurationProperties(prefix = "mysql.datasource")
        public DataSource getMySqlDataSource() {
            return DataSourceBuilder.create().build();
        }
    
        @Bean(name = "mysqlJdbcTemplate")
        public JdbcTemplate getJdbcTemplate(@Qualifier("mysqlDataSource") DataSource dataSource) {
            return new JdbcTemplate(dataSource);
        }
    }


### Call using repository

    package com.arun.didemo.datasource;
    
    import lombok.Getter;
    import lombok.Setter;
    import lombok.ToString;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.jdbc.core.JdbcTemplate;
    import org.springframework.stereotype.Repository;
    
    import java.util.List;
    
    @Repository
    public class DataSourceCall {
    
        @Autowired
        private JdbcTemplate mysqlJdbcTemplate;
    
        public List<Account> getAccounts() {
    
            String sqlQuery = "select id, name, capital, currency from country";
    
            return mysqlJdbcTemplate.query(sqlQuery, (rs, rn) -> {
                Account account = new Account();
                account.setId(rs.getString("id"));
                account.setCapital(rs.getString("capital"));
                account.setCurrency(rs.getString("currency"));
                account.setName(rs.getString("name"));
                return account;
            });
        }
    }
    
    @Getter
    @Setter
    @ToString
    class Account {
        private String id;
        private String name;
        private String capital;
        private String currency;
    }
