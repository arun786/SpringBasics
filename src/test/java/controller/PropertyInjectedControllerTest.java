package controller;

import com.arun.didemo.controller.PropertyInjectedController;
import com.arun.didemo.service.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PropertyInjectedControllerTest {

    private PropertyInjectedController propertyInjectedController;

    @Before
    public void setUp() {
        propertyInjectedController = new PropertyInjectedController();
        propertyInjectedController.greetingService = new GreetingServiceImpl();

    }


    @Test
    public void testGreeting() {

        String hello = propertyInjectedController.sayHello();
        assertEquals("Say hello", hello);

    }
}
