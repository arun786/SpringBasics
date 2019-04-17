package controller;

import com.arun.didemo.controller.ConstructorInjectedController;
import com.arun.didemo.service.GreetingService;
import com.arun.didemo.service.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstructorInjectedControllerTest {

    private ConstructorInjectedController constructorInjectedController;

    @Before
    public void setUp() {
        GreetingService greetingService = new GreetingServiceImpl();
        constructorInjectedController = new ConstructorInjectedController(greetingService);
    }

    @Test
    public void testGreeting() {
        String hello = constructorInjectedController.sayGreeting();
        assertEquals("Say hello", hello);
    }
}
